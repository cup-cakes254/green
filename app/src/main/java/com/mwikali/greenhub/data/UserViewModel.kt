package com.mwikali.greenhub.data


import android.app.AlertDialog
import android.content.Context
import android.net.Uri
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.google.firebase.database.*
import com.mwikali.greenhub.ui.theme.Navigation.ROUTE_PROFILE
import com.mwikali.greenhub.network.ImgurService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.OkHttpClient
import okhttp3.RequestBody.Companion.asRequestBody
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File

class UserViewModel : ViewModel() {
    private val usersRef = FirebaseDatabase.getInstance().getReference("Users")

    private fun getImgurService(): ImgurService {
        val logging = HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY }
        val client = OkHttpClient.Builder().addInterceptor(logging).build()
        return Retrofit.Builder()
            .baseUrl("https://api.imgur.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
            .create(ImgurService::class.java)
    }

    private fun getFileFromUri(context: Context, uri: Uri): File? = try {
        context.contentResolver.openInputStream(uri)?.use { input ->
            File.createTempFile("temp_profile", ".jpg", context.cacheDir).apply {
                outputStream().use { output -> input.copyTo(output) }
            }
        }
    } catch (e: Exception) {
        e.printStackTrace()
        null
    }

    /** Uploads a new user profile along with their image */
    fun addUserWithImage(
        uri: Uri,
        context: Context,
        firstname: String,
        lastname: String,
        email: String,
        bio: String,
        navController: NavController
    ) {
        viewModelScope.launch(Dispatchers.IO) {
            val file = getFileFromUri(context, uri)
            if (file == null) return@launch withContext(Dispatchers.Main) {
                Toast.makeText(context, "Failed to process image", Toast.LENGTH_SHORT).show()
            }

            val body = MultipartBody.Part.createFormData(
                "image", file.name, file.asRequestBody("image/*".toMediaTypeOrNull())
            )

            val response = getImgurService().uploadImage(body, "Client-ID your-client-id")
            if (!response.isSuccessful) return@launch withContext(Dispatchers.Main) {
                Toast.makeText(context, "Image upload failed", Toast.LENGTH_SHORT).show()
            }

            val imageUrl = response.body()?.data?.link.orEmpty()
            val userId = usersRef.push().key.orEmpty()
            val user = UserModel(firstname, lastname, email, bio, imageUrl, userId)

            usersRef.child(userId).setValue(user)
                .addOnSuccessListener {
                    viewModelScope.launch(Dispatchers.Main) {
                        Toast.makeText(context, "User added", Toast.LENGTH_SHORT).show()
                        navController.navigate(ROUTE_PROFILE)
                    }
                }
                .addOnFailureListener {
                    viewModelScope.launch(Dispatchers.Main) {
                        Toast.makeText(context, "Failed to save user", Toast.LENGTH_SHORT).show()
                    }
                }
        }
    }

    /** Returns a StateFlow of all users (for listing) */
    private val _users = MutableStateFlow<List<UserModel>>(emptyList())
    val users: StateFlow<List<UserModel>> = _users

    fun fetchUsers() {
        usersRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val list = snapshot.children.mapNotNull { it.getValue(UserModel::class.java) }
                viewModelScope.launch(Dispatchers.Main) { _users.value = list }
            }
            override fun onCancelled(error: DatabaseError) { /* log or toast if you like */ }
        })
    }

    /** Updates an existing user’s data (without changing image) */
    fun updateUser(
        context: Context,
        navController: NavController,
        userId: String,
        firstname: String,
        lastname: String,
        email: String,
        bio: String,
        password: String
    ) {
        val updated = UserModel(firstname, lastname, email, bio, "", userId)
        usersRef.child(userId).setValue(updated)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    Toast.makeText(context, "User updated", Toast.LENGTH_SHORT).show()
                    navController.navigate(ROUTE_PROFILE)
                } else {
                    Toast.makeText(context, "Update failed", Toast.LENGTH_SHORT).show()
                }
            }
    }

    /** Deletes a user after confirmation dialog */
    fun deleteUser(
        context: Context,
        userId: String,
        navController: NavController
    ) {
        AlertDialog.Builder(context)
            .setTitle("Delete User")
            .setMessage("Are you sure you want to delete this user?")
            .setPositiveButton("Yes") { _, _ ->
                usersRef.child(userId).removeValue()
                    .addOnCompleteListener { task ->
                        Toast.makeText(
                            context,
                            if (task.isSuccessful) "User deleted" else "Deletion failed",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
            }
            .setNegativeButton("No", null)
            .show()
    }
}

package com.mwikali.greenhub.data



import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import com.mwikali.greenhub.ui.theme.Navigation.ROUTE_LOGIN
import com.mwikali.greenhub.ui.theme.Screens.home.TruckRequest
import com.mwikali.greenhub.ui.theme.models.UserModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class AuthViewModel : ViewModel() {

    private val mAuth: FirebaseAuth = FirebaseAuth.getInstance()

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> get() = _isLoading

    private val _errorMessage = MutableStateFlow<String?>(null)
    val errorMessage: StateFlow<String?> get() = _errorMessage

    // Define _truckRequests to hold the list of truck requests
    private val _truckRequests = MutableStateFlow<List<TruckRequest>>(emptyList())
    val TruckRequest: StateFlow<List<TruckRequest>> get() = _truckRequests

    fun signup(
        firstname: String,
        lastname: String,
        email: String,
        password: String,
        navController: NavController,
        context: Context
    ) {
        if (firstname.isBlank() || lastname.isBlank() || email.isBlank() || password.isBlank()) {
            Toast.makeText(context, "Please fill all the fields", Toast.LENGTH_LONG).show()
            return
        }

        _isLoading.value = true

        mAuth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                _isLoading.value = false
                if (task.isSuccessful) {
                    val userId = mAuth.currentUser?.uid ?: ""
                    val userData = UserModel(
                        firstname = firstname,
                        lastname = lastname,
                        email = email,
                        password = password,
                        userId = userId
                    )
                    saveUserToDatabase(userId, userData, navController, context)
                } else {
                    _errorMessage.value = task.exception?.message
                    Toast.makeText(context, "Registration failed", Toast.LENGTH_LONG).show()
                }
            }
    }

    fun login(
        email: String,
        password: String,
        navController: NavController,
        context: Context
    ) {
        if (email.isBlank() || password.isBlank()) {
            Toast.makeText(context, "Email and password required", Toast.LENGTH_LONG).show()
            return
        }

        _isLoading.value = true

        mAuth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                _isLoading.value = false
                if (task.isSuccessful) {
                    Toast.makeText(context, "User Successfully logged in", Toast.LENGTH_LONG).show()
                    navController.navigate("main") {
                        popUpTo("login") { inclusive = true }
                    }

                } else {
                    _errorMessage.value = task.exception?.message
                    Toast.makeText(context, "Login failed", Toast.LENGTH_LONG).show()
                }

            }
    }


    private fun saveUserToDatabase(
        userId: String,
        userData: UserModel,
        navController: NavController,
        context: Context
    ) {
        val regRef = FirebaseDatabase.getInstance().getReference("Users/$userId")
        regRef.setValue(userData).addOnCompleteListener { regTask ->
            if (regTask.isSuccessful) {
                Toast.makeText(context, "User Successfully Registered", Toast.LENGTH_LONG).show()
                navController.navigate(ROUTE_LOGIN)
            } else {
                _errorMessage.value = regTask.exception?.message
                Toast.makeText(context, "Database error", Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun fetchRequests() {
        val userId = mAuth.currentUser?.uid ?: return
        val database = FirebaseDatabase.getInstance()
        val reference = database.getReference("users").child(userId).child("truckRequests")

        reference.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val list = snapshot.children.mapNotNull {
                    it.getValue(TruckRequest::class.java)
                }
//                _truckRequests.value = list.sortedByDescending { it.timestamp }
            }

            override fun onCancelled(error: DatabaseError) {
                Log.e("TruckRequestVM", "Failed to load requests: ${error.message}")
            }
        })
    }
//    fun fetchTruckRequestsFromProfile() {
//        fetchRequests() // Fetch the truck requests from Firebase and update _truckRequests
//    }

    // Call this function where you need to update truckRequests list in the Profile Screen

}

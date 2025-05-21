//package com.mwikali.greenhub.ui.theme.Screens.Users
//
//import android.content.Context
//import android.net.Uri
//import android.widget.Toast
//import androidx.activity.compose.rememberLauncherForActivityResult
//import androidx.activity.result.contract.ActivityResultContracts
//import androidx.compose.foundation.background
//import androidx.compose.foundation.layout.*
//import androidx.compose.foundation.shape.CircleShape
//import androidx.compose.material3.*
//import androidx.compose.runtime.*
//import androidx.compose.runtime.saveable.rememberSaveable
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.platform.LocalContext
//import androidx.compose.ui.text.font.FontStyle
//import androidx.compose.ui.text.font.FontWeight
//import androidx.compose.ui.text.style.TextAlign
//import androidx.compose.ui.tooling.preview.Preview
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.unit.sp
//import androidx.lifecycle.viewmodel.compose.viewModel
//import androidx.navigation.NavController
//import androidx.navigation.compose.rememberNavController
//import com.mwikali.greenhub.data.UserModel
//import com.mwikali.greenhub.data.UserViewModel
//import com.google.firebase.database.*
//
//@Composable
//fun UpdateUserScreen(navController: NavController, userId: String) {
//    val imageUri = rememberSaveable { mutableStateOf<Uri?>(null) }
//    val launcher = rememberLauncherForActivityResult(ActivityResultContracts.GetContent()) {
//            uri -> uri?.let { imageUri.value = it }
//    }
//
//    var firstName by remember { mutableStateOf("") }
//    var lastName by remember { mutableStateOf("") }
//    var email by remember { mutableStateOf("") }
//    var password by remember { mutableStateOf("") }
//
//    val userViewModel: UserViewModel = viewModel()
//    val context = LocalContext.current
//
//    val currentDataRef = FirebaseDatabase.getInstance()
//        .getReference("Users/$userId")
//
//    // Load current user data
//    DisposableEffect(Unit) {
//        val listener = object : ValueEventListener {
//            override fun onDataChange(snapshot: DataSnapshot) {
//                val user = snapshot.getValue(UserModel::class.java)
//                user?.let {
//                    firstName = it.firstname
//                    lastName = it.lastname
//                    email = it.email
//                    password = it.password
//                }
//            }
//
//            override fun onCancelled(error: DatabaseError) {
//                Toast.makeText(context, error.message, Toast.LENGTH_LONG).show()
//            }
//        }
//
//        currentDataRef.addValueEventListener(listener)
//        onDispose { currentDataRef.removeEventListener(listener) }
//    }
//
//    // UI
//    Column(
//        modifier = Modifier
//            .padding(10.dp)
//            .fillMaxSize(),
//        horizontalAlignment = Alignment.CenterHorizontally
//    ) {
//        Box(
//            modifier = Modifier
//                .fillMaxWidth()
//                .background(Color(0xFF388E3C))
//                .padding(16.dp)
//        ) {
//            Text(
//                text = "Update User",
//                fontStyle = FontStyle.Normal,
//                fontWeight = FontWeight.Bold,
//                fontSize = 26.sp,
//                textAlign = TextAlign.Center,
//                color = Color.White,
//                modifier = Modifier.fillMaxWidth()
//            )
//        }
//
//        Card(
//            shape = CircleShape,
//            modifier = Modifier
//                .padding(10.dp)
//                .size(200.dp)
//        ) {
//            val imageUrl = ""
//            AsyncImage(
//                "User Image", Modifier
//                    .fillMaxWidth()
//                    .height(120.dp), imageUrl, coil.compose.AsyncImageContentScale.FillWidth
//            )
//        }
//
//        Text("Tap to Upload New Profile Image")
//
//        OutlinedTextField(
//            value = firstName,
//            onValueChange = { firstName = it },
//            label = { Text("First Name") },
//            modifier = Modifier.fillMaxWidth()
//        )
//
//        OutlinedTextField(
//            value = lastName,
//            onValueChange = { lastName = it },
//            label = { Text("Last Name") },
//            modifier = Modifier.fillMaxWidth()
//        )
//
//        OutlinedTextField(
//            value = email,
//            onValueChange = { email = it },
//            label = { Text("Email") },
//            modifier = Modifier.fillMaxWidth()
//        )
//
//        OutlinedTextField(
//            value = password,
//            onValueChange = { password = it },
//            label = { Text("Password") },
//            modifier = Modifier.fillMaxWidth()
//        )
//
//        Spacer(modifier = Modifier.height(10.dp))
//
//        Row(
//            modifier = Modifier.fillMaxWidth(),
//            horizontalArrangement = Arrangement.SpaceBetween
//        ) {
//            Button(onClick = { navController.popBackStack() }) {
//                Text("CANCEL")
//            }
//
//            Spacer(modifier = Modifier.width(20.dp))
//
//            Button(onClick = {
//                userViewModel.updateUser(
//                    context = context,
//                    navController = navController,
//                    userId = userId,
//                    firstname = firstName,
//                    lastname = lastName,
//                    email = email,
//                    password = password
//                )
//            }) {
//                Text("UPDATE")
//            }
//        }
//    }
//}
//
//private fun UserViewModel.updateUser(
//    context: Context,
//    navController: NavController,
//    userId: String,
//    firstname: String,
//    lastname: String,
//    email: String,
//    password: String
//) {
//}
//
//@Composable
//fun AsyncImage(contentDescription: String, modifier: Modifier, model: String, contentScale: Any) {
//    TODO("Not yet implemented")
//}
//
//@Preview(showBackground = true)
//@Composable
//fun UpdateUserScreenPreview() {
//    UpdateUserScreen(rememberNavController(), userId = "preview_user_id")
//}
//
//
//
//
//package com.mwikali.greenhub.ui.theme.screens.users
//
//import android.net.Uri
//import android.widget.Toast
//import androidx.activity.compose.rememberLauncherForActivityResult
//import androidx.activity.result.contract.ActivityResultContracts
//import androidx.compose.foundation.background
//import androidx.compose.foundation.clickable
//import androidx.compose.foundation.layout.*
//import androidx.compose.foundation.shape.CircleShape
//import androidx.compose.material3.*
//import androidx.compose.runtime.*
//import androidx.compose.runtime.saveable.rememberSaveable
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.layout.ContentScale
//import androidx.compose.ui.platform.LocalContext
//import androidx.compose.ui.text.font.FontWeight
//import androidx.compose.ui.text.style.TextAlign
//import androidx.compose.ui.tooling.preview.Preview
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.unit.sp
//import androidx.lifecycle.viewmodel.compose.viewModel
//import androidx.navigation.NavController
//import androidx.navigation.compose.rememberNavController
//import coil.compose.AsyncImage
//import com.google.firebase.database.*
//import com.mwikali.greenhub.data.UserModel
//import com.mwikali.greenhub.data.UserViewModel
//
//@Composable
//fun UpdateUserScreen(
//    navController: NavController,
//    userId: String,
//    userViewModel: UserViewModel = viewModel()
//) {
//    val imageUri = rememberSaveable { mutableStateOf<Uri?>(null) }
//    val launcher = rememberLauncherForActivityResult(ActivityResultContracts.GetContent()) { uri ->
//        uri?.let { imageUri.value = it }
//    }
//
//    var firstName by rememberSaveable { mutableStateOf("") }
//    var lastName by rememberSaveable { mutableStateOf("") }
//    var email by rememberSaveable { mutableStateOf("") }
//    var password by rememberSaveable { mutableStateOf("") }
//    var imageUrl by rememberSaveable { mutableStateOf("") }
//
//    val context = LocalContext.current
//    val dbRef = FirebaseDatabase.getInstance().getReference("Users").child(userId)
//
//    // Load existing user data
//    DisposableEffect(userId) {
//        val listener = object : ValueEventListener {
//            override fun onDataChange(snapshot: DataSnapshot) {
//                snapshot.getValue(UserModel::class.java)?.let { user ->
//                    firstName = user.firstname
//                    lastName = user.lastname
//                    email = user.email
//                    password = user.password
//                    imageUrl = user.imageUrl
//                }
//            }
//
//            override fun onCancelled(error: DatabaseError) {
//                Toast.makeText(context, error.message, Toast.LENGTH_LONG).show()
//            }
//        }
//        dbRef.addValueEventListener(listener)
//        onDispose { dbRef.removeEventListener(listener) }
//    }
//
//    Column(
//        modifier = Modifier
//            .fillMaxSize()
//            .padding(16.dp),
//        horizontalAlignment = Alignment.CenterHorizontally
//    ) {
//        // Header
//        Box(
//            modifier = Modifier
//                .fillMaxWidth()
//                .background(Color(0xFF388E3C))
//                .padding(12.dp)
//        ) {
//            Text(
//                text = "Update User",
//                fontSize = 26.sp,
//                fontWeight = FontWeight.Bold,
//                color = Color.White,
//                textAlign = TextAlign.Center,
//                modifier = Modifier.fillMaxWidth()
//            )
//        }
//
//        Spacer(modifier = Modifier.height(16.dp))
//
//        // Profile Image
//        Card(
//            shape = CircleShape,
//            modifier = Modifier
//                .size(150.dp)
//                .clickable { launcher.launch("image/*") }
//        ) {
//            AsyncImage(
//                model = imageUri.value ?: imageUrl,
//                contentDescription = "User profile image",
//                modifier = Modifier.fillMaxSize(),
//                contentScale = ContentScale.Crop
//            )
//        }
//
//        Spacer(modifier = Modifier.height(8.dp))
//        Text(text = "Tap image to change", color = Color.Gray, fontSize = 12.sp)
//
//        Spacer(modifier = Modifier.height(16.dp))
//
//        // Form fields
//        OutlinedTextField(
//            value = firstName,
//            onValueChange = { firstName = it },
//            label = { Text("First Name") },
//            modifier = Modifier.fillMaxWidth()
//        )
//
//        OutlinedTextField(
//            value = lastName,
//            onValueChange = { lastName = it },
//            label = { Text("Last Name") },
//            modifier = Modifier.fillMaxWidth()
//        )
//
//        OutlinedTextField(
//            value = email,
//            onValueChange = { email = it },
//            label = { Text("Email") },
//            modifier = Modifier.fillMaxWidth()
//        )
//
//        OutlinedTextField(
//            value = password,
//            onValueChange = { password = it },
//            label = { Text("Password") },
//            modifier = Modifier.fillMaxWidth()
//        )
//
//        Spacer(modifier = Modifier.height(16.dp))
//
//        // Buttons
//        Row(
//            modifier = Modifier.fillMaxWidth(),
//            horizontalArrangement = Arrangement.SpaceBetween
//        ) {
//            Button(onClick = { navController.popBackStack() }) {
//                Text("CANCEL")
//            }
//            Button(onClick = {
//                if (imageUri.value != null) {
//                    userViewModel.updateUserWithImage(
//                        imageUri = imageUri.value!!,
//                        context = context,
//                        userId = userId,
//                        firstname = firstName,
//                        lastname = lastName,
//                        email = email,
//                        password = password,
//                        navController = navController
//                    )
//                } else {
//                    userViewModel.updateUser(
//                        context = context,
//                        navController = navController,
//                        userId = userId,
//                        firstname = firstName,
//                        lastname = lastName,
//                        email = email,
//                        password = password
//                    )
//                }
//            }) {
//                Text("UPDATE")
//            }
//        }
//    }
//}
//
//@Preview(showBackground = true)
//@Composable
//fun UpdateUserScreenPreview() {
//    UpdateUserScreen(navController = rememberNavController(), userId = "preview_id")
//}


package com.mwikali.greenhub.ui.theme.Screens.Users
import androidx.compose.ui.res.painterResource

import android.net.Uri
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.google.firebase.database.*
import com.mwikali.greenhub.data.UserModel
import com.mwikali.greenhub.data.UserViewModel

@Composable
fun UpdateUserScreen(navController: NavController, userId: String) {
    val imageUri = rememberSaveable { mutableStateOf<Uri?>(null) }
    val launcher = rememberLauncherForActivityResult(ActivityResultContracts.GetContent()) { uri ->
        uri?.let { imageUri.value = it }
    }

    var firstName by remember { mutableStateOf("") }
    var lastName by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var bio by remember { mutableStateOf("") }
    var imageUrl by remember { mutableStateOf("") }

    val userViewModel: UserViewModel = viewModel()
    val context = LocalContext.current

    val currentDataRef = FirebaseDatabase.getInstance().getReference("Users/$userId")

    // Load current user data
    DisposableEffect(Unit) {
        val listener = object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val user = snapshot.getValue(UserModel::class.java)
                user?.let {
                    firstName = it.firstname
                    lastName = it.lastname
                    email = it.email
                    password = it.password
                    bio = it.bio ?: ""
                    imageUrl = it.imageUrl ?: ""
                }
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(context, error.message, Toast.LENGTH_LONG).show()
            }
        }

        currentDataRef.addValueEventListener(listener)
        onDispose { currentDataRef.removeEventListener(listener) }
    }

    // UI
    Column(
        modifier = Modifier
            .padding(10.dp)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFF388E3C))
                .padding(16.dp)
        ) {
            Text(
                text = "Update User",
                fontStyle = FontStyle.Normal,
                fontWeight = FontWeight.Bold,
                fontSize = 26.sp,
                textAlign = TextAlign.Center,
                color = Color.White,
                modifier = Modifier.fillMaxWidth()
            )
        }

        Card(
            shape = CircleShape,
            modifier = Modifier
                .padding(10.dp)
                .size(200.dp)
                .clickable { launcher.launch("image/*") }
        ) {
            AsyncImage(
                model = imageUri.value ?: imageUrl,
                contentDescription = "User Image",
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )

            Text("Tap to Upload New Profile Image", color = Color.Gray)

            OutlinedTextField(
                value = firstName,
                onValueChange = { firstName = it },
                label = { Text("First Name") },
                modifier = Modifier.fillMaxWidth()
            )

            OutlinedTextField(
                value = lastName,
                onValueChange = { lastName = it },
                label = { Text("Last Name") },
                modifier = Modifier.fillMaxWidth()
            )

            OutlinedTextField(
                value = email,
                onValueChange = { email = it },
                label = { Text("Email") },
                modifier = Modifier.fillMaxWidth()
            )

            OutlinedTextField(
                value = password,
                onValueChange = { password = it },
                label = { Text("Password") },
                modifier = Modifier.fillMaxWidth()
            )

            OutlinedTextField(
                value = bio,
                onValueChange = { bio = it },
                label = { Text("Bio") },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(120.dp)
            )

            Spacer(modifier = Modifier.height(10.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Button(onClick = { navController.popBackStack() }) {
                    Text("CANCEL")
                }

                Button(onClick = {
                    if (imageUri.value != null) {
                        userViewModel.updateUserWithImage(
                            imageUri = imageUri.value!!,
                            context = context,
                            userId = userId,
                            firstname = firstName,
                            lastname = lastName,
                            email = email,
                            password = password,
                            bio = bio,
                            navController = navController
                        )
                    } else {
                        userViewModel.updateUser(
                            context = context,
                            navController = navController,
                            userId = userId,
                            firstname = firstName,
                            lastname = lastName,
                            email = email,
                            password = password,
                            bio = bio,
                            imageUrl = imageUrl
                        )
                    }
                }) {
                    Text("UPDATE")
                }
            }
        }
    }
}

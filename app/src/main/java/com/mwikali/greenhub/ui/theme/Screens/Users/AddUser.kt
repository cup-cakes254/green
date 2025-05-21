package com.mwikali.greenhub.ui.theme.Screens.Users
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.mwikali.greenhub.data.UserViewModel
import com.mwikali.greenhub.ui.theme.Navigation.ROUTE_DASHBOARD

@Composable
fun AddUserScreen(navController: NavController) {
    val imageUri = rememberSaveable { mutableStateOf<Uri?>(null) }
    val launcher = rememberLauncherForActivityResult(ActivityResultContracts.GetContent()) { uri ->
        uri?.let { imageUri.value = it }
    }

    var firstname by remember { mutableStateOf("") }
    var lastname by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var bio by remember { mutableStateOf("") }

    val userViewModel: UserViewModel = viewModel()
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Add New User",
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            fontStyle = FontStyle.Normal,
            color = Color.White,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .background(Color(0xFF388E3C)) // dark green
                .fillMaxWidth()
                .padding(12.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        Card(
            shape = CircleShape,
            modifier = Modifier
                .size(150.dp)
                .clickable { launcher.launch("image/*") }
        ) {
            AsyncImage(
            )
        }

        Text("Tap image to upload", color = Color.Gray, fontSize = 12.sp)

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = firstname,
            onValueChange = { firstname = it },
            label = { Text("First Name") },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = lastname,
            onValueChange = { lastname = it },
            label = { Text("Last Name") },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Email Address") },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = bio,
            onValueChange = { bio = it },
            label = { Text("Short Bio / About") },
            modifier = Modifier
                .fillMaxWidth()
                .height(120.dp),
            singleLine = false,
            maxLines = 5
        )

        Spacer(modifier = Modifier.height(16.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Button(onClick = { navController.navigate(ROUTE_DASHBOARD) }) {
                Text("Go Back")
            }

            Button(
                onClick = {
                    imageUri.value?.let {
                        userViewModel.addUserWithImage(
                            it, context, firstname, lastname, email, bio, navController
                        )
                    } ?: Toast.makeText(context, "Please pick a profile picture", Toast.LENGTH_LONG).show()
                }
            ) {
                Text("Save")
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun AddUserScreenPreview() {
    AddUserScreen(navController = rememberNavController())
}

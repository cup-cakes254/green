
//
//
//
//package com.mwikali.greenhub.ui.theme.screens.users
//
//import androidx.compose.foundation.layout.*
//import androidx.compose.foundation.lazy.LazyColumn
//import androidx.compose.foundation.lazy.items
//import androidx.compose.foundation.shape.RoundedCornerShape
//import androidx.compose.material3.*
//import androidx.compose.runtime.*
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.platform.LocalContext
//import androidx.compose.ui.text.font.FontFamily
//import androidx.compose.ui.text.font.FontWeight
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.unit.sp
//import androidx.lifecycle.viewmodel.compose.viewModel
//import androidx.navigation.NavHostController
//import coil.compose.AsyncImage
//import com.mwikali.greenhub.data.UserViewModel
//import com.mwikali.greenhub.ui.theme.Navigation.ROUTE_UPDATE_USER
//
//@Composable
//fun ViewUsers(
//    navController: NavHostController,
//    userViewModel: UserViewModel = viewModel()
//
//) {
//
//    val context = LocalContext.current
//
//
//    val users by userViewModel.users.collectAsState(initial = emptyList())
//
//    Column(
//        modifier = Modifier
//            .fillMaxSize()
//            .padding(horizontal = 16.dp, vertical = 8.dp),
//        horizontalAlignment = Alignment.CenterHorizontally
//    ) {
//        Text(
//            text = "All Users",
//            fontSize = 30.sp,
//            fontFamily = FontFamily.SansSerif,
//            color = Color.Black
//        )
//
//        Spacer(modifier = Modifier.height(20.dp))
//
//        LazyColumn(
//            modifier = Modifier.fillMaxSize(),
//            verticalArrangement = Arrangement.spacedBy(12.dp)
//        ) {
//            items(users) { user ->
//                UserItem(
//                    name = "${user.firstname} ${user.lastname}",
//                    email = user.email,
//                    userId = user.userId,
//                    imageUrl = user.imageUrl,
//                    onDelete = {
//                        userViewModel.deleteUser(user.userId, context)
//                    },
//                    onUpdate = {
//                        navController.navigate("$ROUTE_UPDATE_USER/${user.userId}")
//                    }
//                )
//            }
//        }
//    }
//}
//
//@Composable
//fun UserItem(
//    name: String,
//    email: String,
//    userId: String,
//    imageUrl: String,
//    onDelete: () -> Unit,
//    onUpdate: () -> Unit
//) {
//    Card(
//        modifier = Modifier
//            .fillMaxWidth(),
//        shape = RoundedCornerShape(8.dp),
//        colors = CardDefaults.cardColors(containerColor = Color(0xFFF0F0F0))
//    ) {
//        Row(
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(16.dp),
//            verticalAlignment = Alignment.CenterVertically
//        ) {
//            AsyncImage(
//                model = imageUrl,
//                contentDescription = "Profile image of $name",
//                modifier = Modifier
//                    .size(80.dp)
//            )
//
//            Spacer(modifier = Modifier.width(16.dp))
//
//            Column(
//                modifier = Modifier.weight(1f)
//            ) {
//                Text(text = name, fontSize = 20.sp, fontWeight = FontWeight.Bold)
//                Text(text = email, fontSize = 16.sp, color = Color.Gray)
//            }
//
//            Column(
//                verticalArrangement = Arrangement.spacedBy(8.dp),
//                horizontalAlignment = Alignment.End
//            ) {
//                Button(
//                    onClick = onDelete,
//                    colors = ButtonDefaults.buttonColors(containerColor = Color.Red)
//                ) {
//                    Text("REMOVE", color = Color.White, fontWeight = FontWeight.Bold)
//                }
//
//                Button(
//                    onClick = onUpdate,
//                    colors = ButtonDefaults.buttonColors(containerColor = Color.Green)
//                ) {
//                    Text("UPDATE", color = Color.White, fontWeight = FontWeight.Bold)
//                }
//            }
//        }
//    }
//}


package com.mwikali.greenhub.ui.theme.screens.users

import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.mwikali.greenhub.data.UserModel
import com.mwikali.greenhub.data.UserViewModel
import com.mwikali.greenhub.ui.theme.Navigation.ROUTE_UPDATE_USER

@Composable
fun ViewUsers(
    navController: NavHostController
) {
    val context = LocalContext.current
    // Obtain ViewModel via default factory
    val userViewModel: UserViewModel = viewModel()
    // Collect the list of users from your ViewModel's Flow or LiveData
    val users by userViewModel.users.collectAsState(initial = emptyList())

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp, vertical = 8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "All Users",
            fontSize = 30.sp,
            fontFamily = FontFamily.SansSerif,
            color = Color.Black
        )

        Spacer(modifier = Modifier.height(20.dp))

        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(users) { user ->
                UserItem(
                    name = "${user.firstname} ${user.lastname}",
                    email = user.email,
                    onDelete = {
                        // Pass context, userId, and navController in correct order
                        userViewModel.deleteUser(context, user.userId, navController)
                    },
                    onUpdate = {
                        navController.navigate("$ROUTE_UPDATE_USER/${user.userId}")
                    }
                )
            }
        }
    }
}

@Composable
fun UserItem(
    name: String,
    email: String,
    onDelete: () -> Unit,
    onUpdate: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth(),
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFF0F0F0))
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Placeholder for user image; replace with proper Image() when ready
            Box(
                modifier = Modifier
                    .size(80.dp)
                    .background(Color.Gray)
            )

            Spacer(modifier = Modifier.width(16.dp))

            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(text = name, fontSize = 20.sp, fontWeight = FontWeight.Bold)
                Text(text = email, fontSize = 16.sp, color = Color.Gray)
            }

            Column(
                verticalArrangement = Arrangement.spacedBy(8.dp),
                horizontalAlignment = Alignment.End
            ) {
                Button(
                    onClick = onDelete,
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Red)
                ) {
                    Text("REMOVE", color = Color.White, fontWeight = FontWeight.Bold)
                }

                Button(
                    onClick = onUpdate,
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Green)
                ) {
                    Text("UPDATE", color = Color.White, fontWeight = FontWeight.Bold)
                }
            }
        }
    }
}

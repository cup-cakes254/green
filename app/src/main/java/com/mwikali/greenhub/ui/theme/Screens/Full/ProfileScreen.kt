package com.mwikali.greenhub.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.google.firebase.auth.FirebaseAuth
import com.mwikali.greenhub.data.TruckRequestViewModel
import com.mwikali.greenhub.ui.theme.Screens.Full.TruckRequest

@Composable
fun ProfileScreen(
    navController: NavController,
    viewModel: TruckRequestViewModel = viewModel(),
    onSignOut: () -> Unit
) {
    val user = FirebaseAuth.getInstance().currentUser
    val truckRequests = viewModel.truckRequests.collectAsState().value

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "User Profile",
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        Card(
            modifier = Modifier.fillMaxWidth(),
            elevation = CardDefaults.cardElevation(4.dp)
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text(text = "Name: ${user?.displayName ?: "N/A"}")
                Spacer(modifier = Modifier.height(8.dp))
                Text(text = "Email: ${user?.email ?: "N/A"}")
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Your Truck Requests",
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.SemiBold
        )

        if (truckRequests.isEmpty()) {
            Text(text = "No truck requests found.", modifier = Modifier.padding(top = 8.dp))
        } else {
            LazyColumn(
                modifier = Modifier.fillMaxWidth()
            ) {
                items(truckRequests) { request ->
                    TruckRequestItem(request)
                    Spacer(modifier = Modifier.height(8.dp))
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = onSignOut, modifier = Modifier.fillMaxWidth()) {
            Text("Sign Out")
        }
    }
}

@Composable
fun TruckRequestItem(request: TruckRequest) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(2.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            // Use field names exactly from TruckRequest class (case-sensitive)
            Text(text = "Pickup Date: ${request.pickupDate}", style = MaterialTheme.typography.titleMedium)
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = "Truck Name: ${request.truckName}", style = MaterialTheme.typography.bodyMedium)
        }
    }
}






















































































































































//package com.mwikali.greenhub.ui.screens
//
//import android.annotation.SuppressLint
//import androidx.compose.foundation.layout.*
//import androidx.compose.foundation.lazy.LazyColumn
//import androidx.compose.material3.*
//import androidx.compose.runtime.Composable
//import androidx.compose.foundation.lazy.items
//import androidx.compose.runtime.collectAsState
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.text.font.FontWeight
//import androidx.compose.ui.unit.dp
//import androidx.lifecycle.viewmodel.compose.viewModel
//import androidx.navigation.NavController
//import com.google.firebase.auth.FirebaseAuth
//import com.mwikali.greenhub.data.TruckRequestViewModel
//import com.mwikali.greenhub.ui.theme.Screens.Full.TruckRequest
//import kotlinx.coroutines.flow.StateFlow
//
//@SuppressLint("SuspiciousIndentation")
//@Composable
//fun ProfileScreen(navController: NavController,
//    viewModel: TruckRequestViewModel = viewModel(),
//    onSignOut: () -> Unit
//) {
//    val user = FirebaseAuth.getInstance().currentUser
//    val truckRequests = viewModel.truckRequests.collectAsState()
//        .value
//
//
//                          Column(
//        modifier = Modifier
//            .fillMaxSize()
//            .padding(16.dp)
//    ) {
//        // Profile Header
//        Text(
//            text = "User Profile",
//            style = MaterialTheme.typography.headlineMedium,
//            fontWeight = FontWeight.Bold,
//            modifier = Modifier.padding(bottom = 16.dp)
//        )
//
//        // User Information
//        Card(
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(bottom = 16.dp),
//            elevation = CardDefaults.cardElevation(4.dp)
//        ) {
//            Column(
//                modifier = Modifier.padding(16.dp)
//            ) {
//                Text(
//                    text = "Name: ${user?.displayName ?: "N/A"}",
//                    style = MaterialTheme.typography.bodyLarge
//                )
//                Spacer(modifier = Modifier.height(8.dp))
//                Text(
//                    text = "Email: ${user?.email ?: "N/A"}",
//                    style = MaterialTheme.typography.bodyLarge
//                )
//            }
//        }
//
//        // Truck Requests Section
//        Text(
//            text = "Your Truck Requests",
//            style = MaterialTheme.typography.titleLarge,
//            fontWeight = FontWeight.SemiBold,
//            modifier = Modifier.padding(vertical = 8.dp)
//        )
//
//        if (truckRequests.isEmpty()) {
//            Text(
//                text = "No truck requests found.",
//                style = MaterialTheme.typography.bodyMedium,
//                modifier = Modifier.align(Alignment.CenterHorizontally)
//            )
//        } else {
//            LazyColumn(
//                modifier = Modifier.weight(1f)
//            ) {
//                items(truckRequests) { request ->
//                    TruckRequestItem(request)
//                    Spacer(modifier = Modifier.height(8.dp))
//                }
//            }
//        }
//
//        // Sign Out Button
//        Button(
//            onClick = onSignOut,
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(top = 16.dp)
//        ) {
//            Text(text = "Sign Out")
//        }
//    }
//}
//
//fun TruckRequest.Companion.collectAsState() {
//    TODO("Not yet implemented")
//}
//
//@Composable
//fun TruckRequestItem(request: TruckRequest) {
//    Card(
//        modifier = Modifier.fillMaxWidth(),
//        elevation = CardDefaults.cardElevation(2.dp)
//    ) {
//        Column(
//            modifier = Modifier.padding(16.dp)
//        ) {
//            Text(
//                text = "Pickup Date: ${request.pickupDate}",
//                style = MaterialTheme.typography.titleMedium,
//                fontWeight = FontWeight.Medium
//            )
//            Spacer(modifier = Modifier.height(4.dp))
//            Spacer(modifier = Modifier.height(4.dp))
//            Text(
//                text = "Status: ${request.truckName}",
//                style = MaterialTheme.typography.bodyMedium
//            )
//            Spacer(modifier = Modifier.height(4.dp))
//            Text(text = "Truck Type: ${request.truckName}",
//                style = MaterialTheme.typography.bodyMedium)
//
//            Spacer(modifier = Modifier.height(4.dp))
//        }
//    }
//}
//////
//////
//////
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//








































//import android.view.PixelCopy.request
//import androidx.compose.foundation.layout.*
//import androidx.compose.foundation.lazy.LazyColumn
//import androidx.compose.material3.*
//import androidx.compose.runtime.*
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.unit.dp
//import androidx.lifecycle.viewmodel.compose.viewModel
//import androidx.navigation.NavController
//import com.mwikali.greenhub.data.TruckRequestViewModel
//
//@Composable
//fun ProfileScreen(viewModel: TruckRequestViewModel = viewModel()) {
//    val requests by viewModel.truckRequests.collectAsState()
//
//    Column(modifier = Modifier.padding(16.dp)) {
//        Text("Your Pickup Requests", style = MaterialTheme.typography.titleLarge)
//        Spacer(modifier = Modifier.height(16.dp))
//
//        if (requests.isEmpty()) {
//            Text("No requests yet.")
//        } else {
//            LazyColumn {
//                items(requests, key = { request -> request.id }) { request ->
//                    // ... your item content
//                }
////            LazyColumn {
////                items(requests) { request ->
//                    Card(
//                        modifier = Modifier
//                            .fillMaxWidth()
//                            .padding(vertical = 4.dp),
//                        elevation = CardDefaults.cardElevation(4.dp)
//                    ) {
//                        Column(modifier = Modifier.padding(12.dp)) {
//                            Text("Truck: ${request.truck}", style = MaterialTheme.typography.bodyLarge)
//                            Text(text="Date: ${request.date}", style = MaterialTheme.typography.bodyMedium)
//                        }
//                    }
//                }
//            }
//        }
//    }
//}

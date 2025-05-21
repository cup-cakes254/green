package com.mwikali.greenhub.ui.theme.Screens.Dashboard
//
//import androidx.compose.foundation.layout.Arrangement
//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.fillMaxSize
//import androidx.compose.foundation.layout.fillMaxWidth
//import androidx.compose.foundation.layout.padding
//import androidx.compose.foundation.rememberScrollState
//import androidx.compose.foundation.shape.RoundedCornerShape
//import androidx.compose.foundation.verticalScroll
//import androidx.compose.material3.Button
//import androidx.compose.material3.Card
//import androidx.compose.material3.CardDefaults
//import androidx.compose.material3.MaterialTheme
//import androidx.compose.material3.OutlinedButton
//import androidx.compose.material3.Text
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.tooling.preview.Preview
//import androidx.compose.ui.unit.dp
//import androidx.navigation.NavHostController
//import androidx.navigation.compose.rememberNavController
//import com.mwikali.greenhub.ui.theme.Screens.Full.TruckRequest
//import com.mwikali.greenhub.ui.theme.Screens.RegisterScreen.RegisterScreen
//import kotlin.collections.take
//
//@Composable
//fun DashboardScreen(
//    userName: String,
//    truckRequests: List<TruckRequest>,
//    onSchedulePickupClick: () -> Unit,
//    onViewProfileClick: () -> Unit,
//    navController: NavHostController
//) {
//    Column(
//        modifier = Modifier
//            .fillMaxSize()
//            .padding(16.dp)
//            .verticalScroll(rememberScrollState()),
//        verticalArrangement = Arrangement.spacedBy(16.dp)
//    ) {
//        Text(
//            text = "Welcome, $userName 👋",
//            style = MaterialTheme.typography.headlineSmall
//        )
//
//        // Summary Card
//        Card(
//            shape = RoundedCornerShape(16.dp),
//            elevation =CardDefaults.cardElevation(4.dp),
//            modifier = Modifier.fillMaxWidth()
//        ) {
//            Column(modifier = Modifier.padding(16.dp)) {
//                Text("Recent Pickup Requests", style = MaterialTheme.typography.titleMedium)
//
//                if (truckRequests.isEmpty()) {
//                    Text("No pickup requests yet.")
//                } else {
//                    truckRequests.take(3).forEach { request ->
//                        Text(
//                            text = "• ${request.truckName} on ${request.pickupDate}\n        ",
//                            style = MaterialTheme.typography.bodyMedium
//                        )
//                    }
//                }
//            }
//        }
//
//        // Action Buttons
//        Button(
//            onClick = onSchedulePickupClick,
//            modifier = Modifier.fillMaxWidth()
//        ) {
//            Text("Request New Pickup")
//        }
//
//        OutlinedButton(
//            onClick = onViewProfileClick,
//            modifier = Modifier.fillMaxWidth()
//        ) {
//            Text("View Profile")
//        }
//    }
//}
//
//@Preview(showBackground = true)
//@Composable
//fun DashboardScreenPreview() {
//    DashboardScreen(
//        navController=rememberNavController(),
//        userName=TODO(),
//        truckRequests=TODO(),
//        onSchedulePickupClick=TODO(),
//        onViewProfileClick=TODO()
//    )
//}

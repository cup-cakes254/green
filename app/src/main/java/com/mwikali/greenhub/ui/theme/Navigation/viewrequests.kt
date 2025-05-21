package com.mwikali.greenhub.ui.theme.Navigation

import android.content.Context
import androidx.compose.animation.core.snap
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.mwikali.greenhub.data.TruckRequest
import com.mwikali.greenhub.data.TruckRequestViewModel
import java.util.Collections.list

@Composable
fun ViewRequestsScreen(
    truckRequestViewModel: TruckRequestViewModel = viewModel()
) {
    val context = LocalContext.current
    val selectedRequest = remember { mutableStateOf<TruckRequest?>(null) }
    val requests = remember { mutableStateListOf<TruckRequest>() }

    LaunchedEffect(Unit) {
        truckRequestViewModel.viewRequests(
            selected = selectedRequest,
            list = requests,
            context = context
        )
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "My Truck Pickup Requests",
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        if (requests.isEmpty()) {
            Text("No requests found.")
        } else {
            LazyColumn {
                items(requests) { request ->
                    RequestCard(
                        request = request,
                        context = context,
                        viewModel = truckRequestViewModel
                    )
                }
            }
        }
    }
}

private fun TruckRequestViewModel.viewRequests(
    selected: MutableState<TruckRequest?>,
    list: SnapshotStateList<TruckRequest>,
    context: Context
) {
}

@Composable
fun RequestCard(
    request: TruckRequest,
    context: Context,
    viewModel: TruckRequestViewModel
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp)
            .clickable {
                // Optional: Show dialog or navigate to an update screen
            },
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = "Truck: ${request.truckname}",
                style = MaterialTheme.typography.titleMedium
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = "Pickup Date: ${request.pickupdate}",
                style = MaterialTheme.typography.bodyMedium
            )
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            horizontalArrangement = Arrangement.End
        ) {
            TextButton(onClick = {
                // Use the actual request ID if you have one; here we use timestamp as placeholder
                viewModel.deleteRequest(
                    context = context,
                    requestId = request.timestamp.toString()
                )
            }) {
                Text("Delete")
            }
        }
    }
}
//
//
//import android.content.Context
//import androidx.compose.foundation.clickable
//import androidx.compose.foundation.layout.*
//import androidx.compose.foundation.lazy.LazyColumn
//import androidx.compose.material3.*
//import androidx.compose.runtime.*
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.platform.LocalContext
//import androidx.compose.ui.unit.dp
//import androidx.lifecycle.viewmodel.compose.viewModel
//import com.mwikali.greenhub.data.TruckRequest
//import com.mwikali.greenhub.data.TruckRequestViewModel
//
//@Composable
//fun ViewRequestsScreen(
//    truckRequestViewModel: TruckRequestViewModel = viewModel()
//) {
//    val context = LocalContext.current
//    val selectedRequest = remember { mutableStateOf<TruckRequest?>(null) }
//    val requests = remember { mutableStateListOf<TruckRequest>() }
//
//
//    LaunchedEffect(Unit) {
//        truckRequestViewModel.viewRequests(
//            selected= selectedRequest,
//            list= requests,
//            context= context
//        )
//    }
//
//    Column(modifier = Modifier
//        .fillMaxSize()
//        .padding(16.dp)) {
//        Text(
//            text = "My Truck Pickup Requests",
//            style = MaterialTheme.typography.titleLarge,
//            modifier = Modifier.padding(bottom = 16.dp)
//        )
//
//        if (requests.isEmpty()) {
//            Text(text = "No requests found.")
//        } else {
//            LazyColumn {
//                items(requests) { request ->
//                    RequestCard(request= request, context= context, viewModel= truckRequestViewModel)
//                }
//            }
//        }
//    }
//}
//
//@Composable
//fun RequestCard(
//    request: Int,
//    context: Context,
//    viewModel: TruckRequestViewModel
//) {
//    Card(
//        modifier = Modifier
//            .fillMaxWidth()
//            .padding(vertical = 4.dp)
//            .clickable {
//                // Optional: Show dialog, or navigate to update screen
//            },
//        elevation = CardDefaults.cardElevation(4.dp)
//    ) {
//        Column(modifier = Modifier.padding(16.dp)) {
//            Text(text = "Truck: ${request.truckname}", style = MaterialTheme.typography.titleMedium)
//            Text(text = "Pickup Date: ${request.pickupdate}")
//        }
//
//        Row(
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(8.dp),
//            horizontalArrangement = Arrangement.End
//        ) {
//            TextButton(onClick = {
//                viewModel.deleteRequest(context, requestId = request.timestamp.toString()) // replace with real ID
//            }) {
//                Text("Delete")
//            }
//        }
//    }
//}

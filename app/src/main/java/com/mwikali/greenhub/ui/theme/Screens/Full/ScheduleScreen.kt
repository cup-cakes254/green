package com.mwikali.greenhub.ui.theme.Screens.Full

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.mwikali.greenhub.R
import com.mwikali.greenhub.data.TruckRequestViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScheduleScreen(navController: NavController,
    viewModel: TruckRequestViewModel = viewModel()
) {
    val context = LocalContext.current
    val truckOptions = listOf("Green Truck", "Blue Truck", "Orange Truck")
    val truckImages = listOf(
        R.drawable.truck1,
        R.drawable.truck2,
        R.drawable.truck3
    )

    var selectedTruck by remember { mutableStateOf(truckOptions.first()) }
    var selectedDate by remember { mutableStateOf("") }
    var showTruckSelectionSheet by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Our Trash Collection Vehicles",
            style = MaterialTheme.typography.headlineSmall
        )

        Spacer(modifier = Modifier.height(16.dp))

        Image(
            painter = painterResource(id = R.drawable.taka1),
            contentDescription = "Green Collection Truck",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .height(200.dp)
                .fillMaxWidth()
                .clip(RoundedCornerShape(16.dp))
        )

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = "More Trucks in Our Fleet",
            style = MaterialTheme.typography.titleMedium
        )

        Spacer(modifier = Modifier.height(12.dp))

        LazyRow(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
            items(truckImages) { imageRes ->
                Image(
                    painter = painterResource(id = imageRes),
                    contentDescription = "Truck",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(180.dp)
                        .clip(RoundedCornerShape(12.dp))
                )
            }
        }

        Spacer(modifier = Modifier.height(32.dp))

        Text(
            text = "Request a Pickup",
            style = MaterialTheme.typography.titleMedium
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Truck selection field
        OutlinedTextField(
            value = selectedTruck,
            onValueChange = { /* Read-only, clicking opens sheet */ },
            label = { Text("Select Truck") },
            modifier = Modifier
                .fillMaxWidth()
                .clickable { showTruckSelectionSheet = true },
            enabled = false, // Makes it look like a display field
            trailingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.truck1), // Replace with your dropdown icon
                    contentDescription = "Select Truck",
                    modifier = Modifier.clickable { showTruckSelectionSheet = true }
                )
            }
        )

        // ModalBottomSheet for truck selection
        if (showTruckSelectionSheet) {
            ModalBottomSheet(
                onDismissRequest = { showTruckSelectionSheet = false },
                sheetState = rememberModalBottomSheetState()
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                ) {
                    Text(
                        text = "Select a Truck",
                        style = MaterialTheme.typography.titleLarge,
                        modifier = Modifier.padding(bottom = 16.dp)
                    )
                    truckOptions.forEach { truck ->
                        Text(
                            text = truck,
                            style = MaterialTheme.typography.bodyLarge,
                            modifier = Modifier
                                .fillMaxWidth()
                                .clickable {
                                    selectedTruck = truck
                                    showTruckSelectionSheet = false
                                }
                                .padding(vertical = 12.dp)
                        )
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = selectedDate,
            onValueChange = { selectedDate = it },
            label = { Text("Enter Preferred Date (e.g., 2025-05-20)") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

//        Button(
//            onClick = {
//                if (selectedDate.isNotBlank()) {
//                    viewModel.truckRequests(selectedTruck, selectedDate)
//                    Toast.makeText(
//                        context,
//                        "Request sent for $selectedTruck on $selectedDate",
//                        Toast.LENGTH_LONG
//                    ).show()
//                    selectedDate = "" // Reset after submission
//                } else {
//                    Toast.makeText(
//                        context,
//                        "Please enter a valid date",
//                        Toast.LENGTH_SHORT
//                    ).show()
//                }
//            },
//            modifier = Modifier.fillMaxWidth()
//        ) {
            Text("Request Pickup")
        }
    }




















































































//package com.mwikali.greenhub.ui.theme.Screens.home
//
//import android.widget.Toast
//import androidx.compose.foundation.Image
//import androidx.compose.foundation.clickable
//import androidx.compose.foundation.layout.*
//import androidx.compose.foundation.lazy.LazyRow
//import androidx.compose.foundation.lazy.items
//import androidx.compose.foundation.shape.RoundedCornerShape
//import androidx.compose.material3.*
//import androidx.compose.runtime.*
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.draw.clip
//import androidx.compose.ui.layout.ContentScale
//import androidx.compose.ui.platform.LocalContext
//import androidx.compose.ui.res.painterResource
//import androidx.compose.ui.unit.dp
//import androidx.lifecycle.viewmodel.compose.viewModel
//import com.mwikali.greenhub.R
//import com.mwikali.greenhub.data.TruckRequestViewModel
//
//@Composable
//fun ScheduleScreen(
//    viewModel: TruckRequestViewModel = viewModel() // Use your actual ViewModel
//) {
//    val context = LocalContext.current
//    val truckOptions = listOf("Green Truck", "Blue Truck", "Orange Truck")
//    val truckImages = listOf(
//        R.drawable.truck1,
//        R.drawable.truck2,
//        R.drawable.truck3
//    )
//
//    var selectedTruck by remember { mutableStateOf(truckOptions.first()) }
//    var selectedDate by remember { mutableStateOf("") }
//
//    Column(
//        modifier = Modifier
//            .fillMaxSize()
//            .padding(16.dp),
//        horizontalAlignment = Alignment.CenterHorizontally
//    ) {
//        Text(
//            text = "Our Trash Collection Vehicles",
//            style = MaterialTheme.typography.headlineSmall
//        )
//
//        Spacer(modifier = Modifier.height(16.dp))
//
//        Image(
//            painter = painterResource(id = R.drawable.taka1),
//            contentDescription = "Green Collection Truck",
//            contentScale = ContentScale.Crop,
//            modifier = Modifier
//                .height(200.dp)
//                .fillMaxWidth()
//                .clip(RoundedCornerShape(16.dp))
//        )
//
//        Spacer(modifier = Modifier.height(24.dp))
//
//        Text(
//            text = "More Trucks in Our Fleet",
//            style = MaterialTheme.typography.titleMedium
//        )
//
//        Spacer(modifier = Modifier.height(12.dp))
//
//        LazyRow(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
//            items(truckImages) { imageRes ->
//                Image(
//                    painter = painterResource(id = imageRes),
//                    contentDescription = "Truck",
//                    contentScale = ContentScale.Crop,
//                    modifier = Modifier
//                        .size(180.dp)
//                        .clip(RoundedCornerShape(12.dp))
//                )
//            }
//        }
//
//        Spacer(modifier = Modifier.height(32.dp))
//
//        Text(
//            text = "Request a Pickup",
//            style = MaterialTheme.typography.titleMedium
//        )
//
//        Spacer(modifier = Modifier.height(16.dp))
//
//        DropdownMenuBox(
//            label = "Select Truck",
//            options = truckOptions,
//            selected = selectedTruck,
//            onSelected = { selectedTruck = it }
//        )
//
//        Spacer(modifier = Modifier.height(16.dp))
//
//        OutlinedTextField(
//            value = selectedDate,
//            onValueChange = { selectedDate = it },
//            label = { Text("Enter Preferred Date (e.g., 2025-05-20)") },
//            modifier = Modifier.fillMaxWidth()
//        )
//
//        Spacer(modifier = Modifier.height(16.dp))
//
//        Button(
//            onClick = {
//                if (selectedDate.isNotBlank()) {
//                    viewModel.submitTruckRequest(selectedTruck, selectedDate)
//                    Toast.makeText(
//                        context,
//                        "Request sent for $selectedTruck on $selectedDate",
//                        Toast.LENGTH_LONG
//                    ).show()
//                    selectedDate = "" // reset after submission
//                } else {
//                    Toast.makeText(
//                        context,
//                        "Please enter a valid date",
//                        Toast.LENGTH_SHORT
//                    ).show()
//                }
//            },
//            modifier = Modifier.fillMaxWidth()
//        ) {
//            Text("Request Pickup")
//        }
//    }
//}

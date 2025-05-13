package com.mwikali.greenhub.network

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun DashboardScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Top
    ) {
        Text(
            text = "Welcome to GreenHub!",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(modifier = Modifier.height(32.dp))

        Button(
            onClick = { navController.navigate("rewards") },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("View Rewards")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = { navController.navigate("dateCollected") },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("View Date Collected")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = { navController.navigate("payment") },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("View Payment")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = { navController.navigate("location") },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("View Location")
        }
    }
}

// LocationScreen.kt
package com.mwikali.greenhub.ui.theme.location

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.location.Location
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.RequiresPermission
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalContext
import androidx.core.content.ContextCompat
import com.google.android.gms.location.LocationServices

@Composable
fun LocationScreen() {
    val context = LocalContext.current
    var locationText by remember { mutableStateOf("Fetching location...") }

    val locationPermissionLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestPermission()
    ) { isGranted ->
        if (isGranted) {
            getLastLocation(context) { location ->
                locationText = location
            }
        } else {
            locationText = "Permission denied"
        }
    }

    LaunchedEffect(Unit) {
        val permissionStatus = ContextCompat.checkSelfPermission(
            context,
            Manifest.permission.ACCESS_FINE_LOCATION
        )

        if (permissionStatus == PackageManager.PERMISSION_GRANTED) {
            getLastLocation(context) { location ->
                locationText = location
            }
        } else {
            locationPermissionLauncher.launch(Manifest.permission.ACCESS_FINE_LOCATION)
        }
    }

    Text(text = locationText)
}

@RequiresPermission(allOf=[Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION])
fun getLastLocation(context: Context, onResult: (String) -> Unit) {
    val fusedLocationClient = LocationServices.getFusedLocationProviderClient(context)
    fusedLocationClient.lastLocation
        .addOnSuccessListener { location: Location? ->
            location?.let {
                val lat = it.latitude
                val lon = it.longitude
                onResult("Lat: $lat, Lng: $lon")
            } ?: onResult("Location unavailable")
        }
}

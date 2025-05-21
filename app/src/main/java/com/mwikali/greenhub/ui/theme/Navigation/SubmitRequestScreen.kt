package com.mwikali.greenhub.ui.theme.Navigation

import android.app.DatePickerDialog
import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.mwikali.greenhub.data.TruckRequestViewModel
import java.util.*

@Composable
fun SubmitRequestScreen(
    viewModel: TruckRequestViewModel = viewModel()
) {
    val context = LocalContext.current

    var truckName by remember { mutableStateOf("") }
    var pickupDate by remember { mutableStateOf("") }

    val calendar = Calendar.getInstance()
    val year = calendar.get(Calendar.YEAR)
    val month = calendar.get(Calendar.MONTH)
    val day = calendar.get(Calendar.DAY_OF_MONTH)

    val datePickerDialog = DatePickerDialog(
        context,
        { _, selectedYear, selectedMonth, selectedDay ->
            pickupDate = "$selectedDay/${selectedMonth + 1}/$selectedYear"
        },
        year, month, day
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "Submit Truck Pickup Request",
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.padding(bottom = 24.dp)
        )

        OutlinedTextField(
            value = truckName,
            onValueChange = { truckName = it },
            label = { Text("Truck Name") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = pickupDate,
            onValueChange = {},
            readOnly = true,
            label = { Text("Pickup Date") },
            modifier = Modifier
                .fillMaxWidth()
                .clickable { datePickerDialog.show() }
        )

        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = {
                if (truckName.isNotBlank() && pickupDate.isNotBlank()) {
                    viewModel.submitTruckRequest(
                        truckName = truckName,
                        pickupDate = pickupDate,
                        context = context
                    )
                    truckName = ""
                    pickupDate = ""
                } else {
                    Toast.makeText(context, "Please fill all fields", Toast.LENGTH_SHORT).show()
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Submit Request")
        }
    }
}

private fun TruckRequestViewModel.submitTruckRequest(
    truckName: String,
    pickupDate: String,
    context: Context
) {
}

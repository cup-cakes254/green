package com.mwikali.greenhub.ui.theme.Screens.LoginScreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.mwikali.greenhub.data.AuthViewModel
import com.mwikali.greenhub.ui.theme.Navigation.ROUTE_DASHBOARD
import com.mwikali.greenhub.ui.theme.Navigation.ROUTE_HOME
import com.mwikali.greenhub.ui.theme.Navigation.ROUTE_PROFILE

@Composable
fun LoginScreen(navController: NavController, authViewModel: AuthViewModel = viewModel()) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    val context=LocalContext.current

    val isLoading by authViewModel.isLoading.collectAsState()
    val errorMessage by authViewModel.errorMessage.collectAsState()

    Column(
        modifier=Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment=Alignment.CenterHorizontally,
        verticalArrangement=Arrangement.Center
    ) {
        Text("Login", fontSize=28.sp, fontWeight=FontWeight.Bold)

        Spacer(modifier=Modifier.height(24.dp))

        TextField(
            value=email,
            onValueChange={ email=it },
            label={ Text("Email") },
            modifier=Modifier.fillMaxWidth()
        )

        Spacer(modifier=Modifier.height(16.dp))

        TextField(
            value=password,
            onValueChange={ password=it },
            label={ Text("Password") },
            visualTransformation=PasswordVisualTransformation(),
            modifier=Modifier.fillMaxWidth()
        )

        Spacer(modifier=Modifier.height(24.dp))

        Button(
            onClick={
                authViewModel.login(email, password, navController, context)
            },
            modifier=Modifier.fillMaxWidth(),
            enabled=!isLoading
        ) {
            Text(if (isLoading) "Logging in..." else "Login")
        }

        if (!errorMessage.isNullOrEmpty()) {
            Text(
                text = errorMessage.orEmpty(),
                color = MaterialTheme.colorScheme.error
            )
        }
        {
                navController.navigate(ROUTE_DASHBOARD)
            }
        }
    }



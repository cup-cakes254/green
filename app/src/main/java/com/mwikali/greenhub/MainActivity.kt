package com.mwikali.greenhub
import AppNavHost
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.mwikali.greenhub.ui.theme.GreenHubTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GreenHubTheme {

                val navController = rememberNavController()


                AppNavHost(navController = navController)
            }
        }
    }
}

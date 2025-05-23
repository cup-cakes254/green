//import androidx.compose.foundation.layout.Arrangement
//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.Spacer
//import androidx.compose.foundation.layout.fillMaxSize
//import androidx.compose.foundation.layout.height
//import androidx.compose.foundation.layout.padding
//import androidx.compose.material3.Text
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.LaunchedEffect
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.unit.sp
//import kotlinx.coroutines.delay
//
//@Composable
//fun SplashScreen(navController: () -> Unit) {
//    LaunchedEffect(Unit) {
//        delay(30)
//        navController.navigate("register") {
//            popUpTo("splash") { inclusive = true }
//        }
//    }
//
//    Column(
//        modifier = Modifier
//            .fillMaxSize()
//            .padding(16.dp),
//        horizontalAlignment = Alignment.CenterHorizontally,
//        verticalArrangement = Arrangement.Center
//    ) {
//        Text(
//            text = "🌿 Green Hub",
//            fontSize = 24.sp
//        )
//        Spacer(modifier = Modifier.height(16.dp))
//        Text(
//            text = "Let us make Earth green again!",
//            fontSize = 16.sp,
//
//        )
//    }
//
//
//}
//
//private fun (() -> Unit).navigate(string: String, function: Any) {}


import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: () -> Unit) {
    LaunchedEffect(Unit) {
        delay(2000) 
        navController.navigate("register") {
           }

    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "🌿 Green Hub",
            fontSize = 32.sp
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "Let us make Earth green again!",
            fontSize = 18.sp
        )
    }
}

private fun (() -> Unit).navigate(string: String, function: Any) {}

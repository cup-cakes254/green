import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.mwikali.greenhub.data.AuthViewModel
import androidx.navigation.NavController

@Composable
fun ProfileScreen(navController: NavController, authViewModel: AuthViewModel = viewModel()) {


    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "Hello",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {
            navController.navigate("rewards")
        }) {
            Text("View Rewards")
        }
    }
}

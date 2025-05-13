import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.mwikali.greenhub.network.DashboardScreen
import com.mwikali.greenhub.ui.theme.Navigation.ROUTE_SPLASH
import com.mwikali.greenhub.ui.theme.Screens.LoginScreen.LoginScreen
import com.mwikali.greenhub.ui.theme.Screens.RegisterScreen.RegisterScreen
import com.mwikali.greenhub.ui.theme.Screens.home.HomeScreen

@Composable
fun AppNavHost(navController: NavHostController) {
    NavHost(navController = navController, startDestination = ROUTE_SPLASH ) {
        composable(ROUTE_SPLASH ) {
            SplashScreen(navController)
        }
        composable("register") {
            RegisterScreen(navController = navController)
        }
        composable("login") {
            LoginScreen(navController = navController)
        }
        composable("dashboard") {
            DashboardScreen(navController = navController)
        }
        composable("profile") {
            ProfileScreen(navController = navController)
        }
        composable("home") {
            HomeScreen(navController = navController)
        }

        }
    }


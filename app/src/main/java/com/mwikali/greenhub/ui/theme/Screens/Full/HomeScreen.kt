package com.mwikali.greenhub.ui.theme.Screens.Full


import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.mwikali.greenhub.ui.screens.ProfileScreen
import com.mwikali.greenhub.ui.theme.location.LocationScreen

data class BottomNavItem(val name: String, val route: String, val icon: ImageVector)

@Composable
fun HomeMainScreen(navController: NavHostController) {
    val navController = rememberNavController()
    val items = listOf(
        BottomNavItem("Home", "home_main", Icons.Default.Home),
        BottomNavItem("Rewards", "rewards", Icons.Default.Star),
        BottomNavItem("Profile", "profile", Icons.Default.Person)
    )

    var selectedItemIndex by remember { mutableIntStateOf(0) }

    Scaffold(
        bottomBar = {
            NavigationBar {
                items.forEachIndexed { index, item ->
                    NavigationBarItem(
                        icon = { Icon(item.icon, contentDescription = item.name) },
                        label = { Text(item.name) },
                        selected = selectedItemIndex == index,
                        onClick = {
                            selectedItemIndex = index
                            navController.navigate(item.route) {
                                launchSingleTop = true
                                restoreState = true
                            }
                        }
                    )
                }
            }
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = "home_main",
            modifier = Modifier.padding(innerPadding)
        ) {
            composable("home_main") {HomeMainScreen(navController) }
            composable("location") { LocationScreen() }
            composable("profile") { ProfileScreen(
                navController=navController,
                viewModel=TODO(),
                onSignOut=TODO()
            ) }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    val dummyNavController = rememberNavController()
    HomeMainScreen(navController = dummyNavController)
}

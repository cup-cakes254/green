package com.mwikali.greenhub.ui.theme.Navigation

import SplashScreen
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.morningmvvm.ui.theme.screens.register.RegisterScreen
import com.mwikali.greenhub.ui.screens.ProfileScreen
import com.mwikali.greenhub.ui.theme.Screens.Full.HomeMainScreen
import com.mwikali.greenhub.ui.theme.Screens.Full.ScheduleScreen
import com.mwikali.greenhub.ui.theme.Screens.LoginScreen.LoginScreen

@Composable
fun AppNavHost(navController: NavHostController) {
    NavHost(navController = navController, startDestination = ROUTE_SPLASH) {

        composable(ROUTE_SPLASH) {
            SplashScreen(navController)
        }

        composable(ROUTE_REGISTER) {
            RegisterScreen(navController = navController)
        }

        composable(ROUTE_LOGIN) {
            LoginScreen(navController = navController)
        }
//
//        composable(ROUTE_DASHBOARD) {
//            DashboardScreen(
//                navController = navController,
//                userName = TODO(),
//                truckRequests = TODO(),
//                onSchedulePickupClick = TODO(),
//                onViewProfileClick = TODO())
////            )
//        }

        composable(ROUTE_HOME) {
            HomeMainScreen(navController = navController)
        }

        composable(ROUTE_PROFILE) {
            ProfileScreen(
                navController = navController,
                viewModel = TODO(),
                onSignOut = TODO()
            )
        }

        composable(ROUTE_SCHEDULE) {
            ScheduleScreen(navController = navController)
        }


    }
}









































































//package com.mwikali.greenhub.ui.theme.Navigation
//
//import SplashScreen
//import androidx.compose.runtime.Composable
//import androidx.navigation.NavHostController
//import androidx.navigation.compose.NavHost
//import com.mwikali.greenhub.ui.screens.ProfileScreen
//import com.mwikali.greenhub.ui.theme.Screens.Dashboard.DashboardScreen
//import com.mwikali.greenhub.ui.theme.Screens.LoginScreen.LoginScreen
//import com.mwikali.greenhub.ui.theme.Screens.RegisterScreen.RegisterScreen
//import com.mwikali.greenhub.ui.theme.Screens.Full.HomeMainScreen
//import com.mwikali.greenhub.ui.theme.Screens.Full.ScheduleScreen
//
//@Composable
//fun AppNavHost(navController: NavHostController) {
//    NavHost(navController=navController, startDestination=ROUTE_SPLASH) {
//        composable(ROUTE_SPLASH) {
//            SplashScreen(navController)
//        }
//
//        composable(ROUTE_DASHBOARD) {
//            DashboardScreen(
//                navController=navController,
//                userName=TODO(),
//                truckRequests=TODO(),
//                onSchedulePickupClick=TODO(),
//                onViewProfileClick=TODO()
//            )
//        }
//
//
//    composable(ROUTE_LOGIN) {
//        LoginScreen(navController=navController)
//    }
//
//    composable(ROUTE_HOME) {
//        HomeMainScreen(navController=navController)
//    }
//
//    composable(ROUTE_PROFILE) {
//        ProfileScreen(
//            navController=navController,
//            viewModel=TODO(),
//            onSignOut=TODO()
//        )
//    }
//    composable(ROUTE_SCHEDULE) {
//        ScheduleScreen(navController=navController)
//    }
//}
//
//    composable(ROUTE_REGISTER) {
//        RegisterScreen(navController=navController)
//    }
//}
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//////package com.mwikali.greenhub.ui.theme.Navigation
//////
//////
//////
//////import SplashScreen
//////import androidx.compose.runtime.Composable
//////import androidx.navigation.NavHostController
//////import androidx.navigation.compose.NavHost
//////import androidx.navigation.compose.composable
//////import com.mwikali.greenhub.ui.screens.ProfileScreen
//////import com.mwikali.greenhub.ui.theme.Screens.Dashboard.DashboardScreen
//////import com.mwikali.greenhub.ui.theme.Screens.LoginScreen.LoginScreen
//////import com.mwikali.greenhub.ui.theme.Screens.RegisterScreen.RegisterScreen
//////import com.mwikali.greenhub.ui.theme.Screens.Full.HomeMainScreen
//////import com.mwikali.greenhub.ui.theme.Screens.Full.ScheduleScreen
//////
//////@Composable
//////fun AppNavHost(navController: NavHostController) {
//////    NavHost(navController=navController, startDestination=ROUTE_SPLASH) {
//////        composable(ROUTE_SPLASH) {
//////            SplashScreen(navController)
//////        }
//////
//////        composable(ROUTE_DASHBOARD) {
//////            DashboardScreen(
//////                navController=navController,
//////                userName=TODO(),
//////                truckRequests=TODO(),
//////                onSchedulePickupClick=TODO(),
//////                onViewProfileClick=TODO()
//////            )
//////
//////            composable(ROUTE_LOGIN) {
//////                LoginScreen(navController=navController)
//////            }
//////
//////            composable(ROUTE_HOME) {
//////                HomeMainScreen(navController=navController)
//////            }
//////
//////            composable(ROUTE_PROFILE) {
//////                ProfileScreen(
//////                    navController=navController,
//////                    viewModel=TODO(),
//////                    onSignOut=TODO()
//////                )
//////            }
//////            composable(ROUTE_SCHEDULE) {
//////                ScheduleScreen(navController=navController)
//////            }
//////
//////
//////        }
//////    }
//////}
//////
////package com.mwikali.greenhub.ui.theme.Navigation
////
////import SplashScreen
////import androidx.compose.runtime.Composable
////import androidx.navigation.NavHostController
////import androidx.navigation.compose.NavHost
////import androidx.navigation.compose.composable
////import com.mwikali.greenhub.ui.screens.ProfileScreen
////import com.mwikali.greenhub.ui.theme.Screens.Dashboard.DashboardScreen
////import com.mwikali.greenhub.ui.theme.Screens.LoginScreen.LoginScreen
////import com.mwikali.greenhub.ui.theme.Screens.RegisterScreen.RegisterScreen
////import com.mwikali.greenhub.ui.theme.Screens.Full.HomeMainScreen
////import com.mwikali.greenhub.ui.theme.Screens.Full.ScheduleScreen
////
////@Composable
////fun AppNavHost(navController: NavHostController) {
////    NavHost(navController = navController, startDestination = ROUTE_SPLASH) {
////        composable(ROUTE_SPLASH) {
////            SplashScreen(navController)
////        }
////
////        composable(ROUTE_DASHBOARD) {
////            DashboardScreen(
////                navController = navController,
////                userName = TODO(),
////                truckRequests = TODO(),
////                onSchedulePickupClick = TODO(),
////                onViewProfileClick = TODO()
////            )
////        }
////
////        // These should be at the same level as ROUTE_SPLASH and ROUTE_DASHBOARD
////        composable(ROUTE_LOGIN) {
////            LoginScreen(navController = navController)
////        }
////
////        composable(ROUTE_HOME) {
////            HomeMainScreen(navController = navController)
////        }
////
////        composable(ROUTE_PROFILE) {
////            ProfileScreen(
////                navController = navController,
////                viewModel = TODO(),
////                onSignOut = TODO()
////            )
////        }
////        composable(ROUTE_SCHEDULE) {
////            ScheduleScreen(navController = navController)
////        }
////
////        // You might want to add ROUTE_REGISTER here as well
////         composable(ROUTE_REGISTER) {
////             RegisterScreen(navController = navController) // Assuming RegisterScreen doesn't need userId based on previous discussion
////         }
////    }
////}
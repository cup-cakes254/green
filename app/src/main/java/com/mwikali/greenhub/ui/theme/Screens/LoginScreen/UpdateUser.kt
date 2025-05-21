package com.mwikali.greenhub.ui.theme.Screens.LoginScreen


import android.content.Context
import android.os.Build
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.navigation.NavController
import com.google.firebase.database.FirebaseDatabase
import com.mwikali.greenhub.data.UserModel
import com.mwikali.greenhub.ui.theme.Navigation.ROUTE_PROFILE

@RequiresApi(Build.VERSION_CODES.O)
fun updateUser(
    context: Context,
    navController: NavController,
    userId: String,
    firstname: String,
    lastname: String,
    email: String,
    password: String
) {
    val databaseReference = FirebaseDatabase.getInstance()
        .getReference("Users/$userId")

    val updatedUser = UserModel(
        firstname = firstname,
        lastname = lastname,
        email = email,
        password = password,
        userId = userId
    )

    databaseReference.setValue(updatedUser)
        .addOnCompleteListener { task ->
            if (task.isSuccessful) {
                Toast.makeText(context, "User Updated Successfully", Toast.LENGTH_LONG).show()
                navController.navigate(ROUTE_PROFILE)
            } else {
                Toast.makeText(context, "User update failed", Toast.LENGTH_LONG).show()
            }
        }
}






























//package com.mwikali.greenhub.ui.theme.Screens.LoginScreen

//
//import android.content.Context
//import android.os.Build
//import android.widget.Toast
//import androidx.annotation.RequiresApi
//import androidx.navigation.NavController
//import com.google.firebase.database.FirebaseDatabase
//import com.mwikali.greenhub.ui.theme.Navigation.ROUTE_PROFILE
//
//
//@RequiresApi(Build.VERSION_CODES.O)
//fun updateUser(
//    context: Context,
//    navController: NavController,
//    userId: String,
//    firstname: String,
//    lastname: String,
//    email: String,
//    password: String
//) {
//    val databaseReference = FirebaseDatabase.getInstance()
//        .getReference("Users/$userId")
//
//    val updatedUser = UserModel(
//        firstname= firstname,
//        lastname= lastname,
//        email= email,
//        password= password,
////        userData=userData,
//        navController=navController,
//        context=context
//    )
//
//    databaseReference.setValue(updatedUser)
//        .addOnCompleteListener { task ->
//            if (task.isSuccessful) {
//                Toast.makeText(context, "User Updated Successfully", Toast.LENGTH_LONG).show()
//                navController.navigate(ROUTE_PROFILE)
//            } else {
//                Toast.makeText(context, "User update failed", Toast.LENGTH_LONG).show()
//            }
//        }
//}
//
//fun UserModel(
//    firstname: String,
//    lastname: String,
//    email: String,
//    password: String,
//    navController: NavController,
//    context: Context
//) {
//}

package com.mwikali.greenhub.ui.theme.Screens.Users
import android.content.Context
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.mwikali.greenhub.data.UserModel
import com.mwikali.greenhub.data.UserViewModel
import com.mwikali.greenhub.ui.theme.Navigation.ROUTE_UPDATE_USER
@Composable
fun ViewUsers(navController: NavHostController) {
    val context = LocalContext.current
    // It's generally better to provide the ViewModel via ViewModelProvider or Hilt
    val userViewModel = UserViewModel() // Assuming UserViewModel is a @Composable or correctly instantiated
    val emptyUser = remember {
        mutableStateOf(
            UserModel(
                "", "", "", "", "",
                userId1 = "" // Assuming userId1 is a String, ensure it's initialized appropriately
            )
        )
    }
    val userList = remember { mutableStateListOf<UserModel>() }


    val users = userViewModel.viewUsers(emptyUser, userList, context)

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "All Users",
            fontSize = 30.sp,
            fontFamily = FontFamily.SansSerif,
            color = Color.Black
        )
        Spacer(modifier = Modifier.height(20.dp))

        LazyColumn {
            items(users) { user -> // Give the item a clear name like 'user'
                UserItem(
                    , // Pass firstname
                    email = user.email,   // Pass lastname
                    userId = user.userId,
                    imageUrl = user.imageUrl,
                    navController = navController,
                    userViewModel = userViewModel,
                    lastname = user.lastname,
                    firstname = user.firstname,
                    name = TODO()
                )
            }
        }
    }
}




//fun ViewUsers(navController: NavHostController) {
//    val context = LocalContext.current
//    val userViewModel = UserViewModel()
//    val emptyUser = remember { mutableStateOf(UserModel(
//        "", "", "", "", "",
//        userId1 = TODO()
//    )) }
//    val userList = remember { mutableStateListOf<UserModel>() }
//
//    val users = userViewModel.viewUsers(emptyUser, userList, context)
//
//    Column(
//        modifier = Modifier.fillMaxSize(),
//        horizontalAlignment = Alignment.CenterHorizontally
//    ) {
//        Text(
//            text = "All Users",
//            fontSize = 30.sp,
//            fontFamily = FontFamily.SansSerif,
//            color = Color.Black
//        )
//        Spacer(modifier = Modifier.height(20.dp))
////
////        LazyColumn {
////            items(users) {
////                UserItem(
////                    name = it.firstname,
////                    name = it.lastname,
////                    email = it.email,
////                    userId = it.userId,
////                    imageUrl = it.imageUrl,
////                    navController = navController,
////                    userViewModel = userViewModel
////                )
////            }
////        }
////    }
////}
//
//  

private fun Unit.viewUsers(
    state: MutableState<UserModel>,
    models: SnapshotStateList<UserModel>,
    context: Context
) {
}

@Composable
fun UserViewModel() {
    TODO("Not yet implemented")
}

@Composable
fun UserItem(
    name: String,
    email: String,
    userId: String,
    imageUrl: String,
    navController: NavHostController,
    userViewModel: UserViewModel,
    lastname: Any,
    firstname: Any
) {
    val context = LocalContext.current

    Card(
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth()
            .height(220.dp),
        shape = MaterialTheme.shapes.medium,
        colors = CardDefaults.cardColors(containerColor = Color.LightGray)
    ) {
        Row {
            Column(modifier = Modifier.padding(10.dp)) {
                AsyncImage(
                )

                Row(horizontalArrangement = Arrangement.SpaceBetween) {
                    Button(
                        onClick = { userViewModel.deleteUser(context, userId, navController) },
                        shape = RoundedCornerShape(10.dp),
                        colors = ButtonDefaults.buttonColors(Color.Red)
                    ) {
                        Text("REMOVE", color = Color.White, fontWeight = FontWeight.Bold)
                    }

                    Spacer(modifier = Modifier.width(10.dp))

                    Button(
                        onClick = { navController.navigate("$ROUTE_UPDATE_USER/$userId") },
                        shape = RoundedCornerShape(10.dp),
                        colors = ButtonDefaults.buttonColors(Color.Green)
                    ) {
                        Text("UPDATE", color = Color.White, fontWeight = FontWeight.Bold)
                    }
                }
            }

            Column(
                modifier = Modifier
                    .padding(vertical = 10.dp, horizontal = 10.dp)
                    .verticalScroll(rememberScrollState())
            ) {
                Text("USER NAME", fontSize = 16.sp, fontWeight = FontWeight.Bold)
                Text(name, fontSize = 20.sp)

                Spacer(modifier = Modifier.height(8.dp))

                Text("EMAIL", fontSize = 16.sp, fontWeight = FontWeight.Bold)
                Text(email, fontSize = 20.sp)
            }
        }
    }
}

private fun UserViewModel.deleteUser(
    context: Context,
    string: String,
    controller: NavHostController
) {
}


//
//
//package com.example.morningmvvm.ui.theme.screens.students
//
//
//import android.R.attr.summary
//import androidx.compose.foundation.layout.Arrangement
//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.Row
//import androidx.compose.foundation.layout.Spacer
//import androidx.compose.foundation.layout.fillMaxSize
//import androidx.compose.foundation.layout.fillMaxWidth
//import androidx.compose.foundation.layout.height
//import androidx.compose.foundation.layout.padding
//import androidx.compose.foundation.layout.width
//import androidx.compose.foundation.lazy.LazyColumn
//import androidx.compose.foundation.rememberScrollState
//import androidx.compose.foundation.shape.RoundedCornerShape
//import androidx.compose.foundation.verticalScroll
//import androidx.compose.material3.Button
//import androidx.compose.material3.ButtonDefaults
//import androidx.compose.material3.Card
//import androidx.compose.material3.CardDefaults
//import androidx.compose.material3.MaterialTheme
//import androidx.compose.material3.Text
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.mutableStateListOf
//import androidx.compose.runtime.mutableStateOf
//import androidx.compose.runtime.remember
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.layout.ContentScale
//import androidx.compose.ui.platform.LocalContext
//import androidx.compose.ui.text.font.FontFamily
//import androidx.compose.ui.text.font.FontWeight
//import androidx.compose.ui.tooling.preview.Preview
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.unit.sp
//import androidx.navigation.NavHostController
//import androidx.navigation.compose.rememberNavController
//import coil.compose.AsyncImage
//import com.example.morningmvvm.navigation.ROUTE_UPDATE_STUDENT
//import com.mwikali.greenhub.data.UserModel
//import com.mwikali.greenhub.data.UserViewModel
//
//
//@Composable
//fun ViewStudents(navController: NavHostController){
//    val context = LocalContext.current
//    val studentRepository = UserViewModel()
//    val emptyUploadState = remember {
//        mutableStateOf(
//            UserModel("","","","","",""))
//    }
//    val emptyUploadListState = remember {
//        mutableStateListOf<UserModel>()
//    }
//    val user = userRepository.viewuser(
//        emptyUploadState,emptyUploadListState, context)
//    Column (modifier = Modifier.fillMaxSize(),
//        horizontalAlignment = Alignment.CenterHorizontally){
//        Column(
//            modifier = Modifier.fillMaxSize(),
//            horizontalAlignment = Alignment.CenterHorizontally
//        ) {
//            Text(text = "All Students",
//                fontSize = 30.sp,
//                fontFamily = FontFamily.SansSerif,
//                color= Color.Black)
//            Spacer(modifier = Modifier.height(20.dp))
//
//            LazyColumn(){
//                items(user){
//                    UserItem(
//                        firstname = it.name,
//                        lastname = it.name,
//                        email = it.email,
//                        password = it.password,
//                        summary= it.summary,
//                        
//                      
//                        
//              
//                       
//                        navController = navController,
//                        studentRepository = studentRepository
//
//                    )
//                }
//
//            }
//        }
//    }
//}
//@Composable
//fun StudentItem(name:String,gender:String,course:String,
//                summary: String,studentId:String,imageUrl: String,navController: NavHostController,
//                studentRepository: StudentViewModel
//){
//    val context = LocalContext.current
//    Column (modifier = Modifier.fillMaxWidth()){
//        Card (modifier = Modifier
//            .padding(10.dp)
//            .height(210.dp),
//            shape = MaterialTheme.shapes.medium,
//            colors = CardDefaults.cardColors
//                (containerColor = Color.Gray))
//        {
//            Row {
//                Column {
//                    AsyncImage(
//                        model = imageUrl,
//                        contentDescription = null,
//                        contentScale = ContentScale.Crop,
//                        modifier = Modifier
//                            .width(200.dp)
//                            .height(150.dp)
//                            .padding(10.dp)
//                    )
//
//                    Row(horizontalArrangement = Arrangement.SpaceBetween) {
//                        Button(onClick = {
//                            studentRepository.deleteStudent(context,studentId,navController)
//
//                        },
//                            shape = RoundedCornerShape(10.dp),
//                            colors = ButtonDefaults.buttonColors(Color.Red)
//                        ) {
//                            Text(text = "REMOVE",
//                                color = Color.Black,
//                                fontWeight = FontWeight.Bold,
//                                fontSize = 16.sp)
//                        }
//                        Button(onClick = {
//                            navController.navigate("$ROUTE_UPDATE_STUDENT/$studentId")
//                        },
//                            shape = RoundedCornerShape(10.dp),
//                            colors = ButtonDefaults.buttonColors(Color.Green)
//                        ) {
//                            Text(text = "UPDATE",
//                                color = Color.Black,
//                                fontWeight = FontWeight.Bold,
//                                fontSize = 16.sp)
//                        }
//                    }
//
//                }
//                Column (modifier = Modifier
//                    .padding(vertical = 10.dp, horizontal = 10.dp)
//                    .verticalScroll(rememberScrollState())){
//                    Text(text = "STUDENT NAME",
//                        color = Color.Black,
//                        fontSize = 16.sp,
//                        fontWeight = FontWeight.Bold)
//                    Text(text = name,
//                        color = Color.White,
//                        fontSize = 28.sp,
//                        fontWeight = FontWeight.Bold)
//                    Text(text = "STUDENT GENDER",
//                        color = Color.Black,
//                        fontSize = 16.sp,
//                        fontWeight = FontWeight.Bold)
//                    Text(text = gender,
//                        color = Color.White,
//                        fontSize = 28.sp,
//                        fontWeight = FontWeight.Bold)
//                    Text(text = "STUDENT COURSE",
//                        color = Color.Black,
//                        fontSize = 16.sp,
//                        fontWeight = FontWeight.Bold)
//                    Text(text = course,
//                        color = Color.White,
//                        fontSize = 28.sp,
//                        fontWeight = FontWeight.Bold)
//                    Text(text = "SUMMARY",
//                        color = Color.Black,
//                        fontSize = 16.sp,
//                        fontWeight = FontWeight.Bold)
//                    Text(text = summary,
//                        color = Color.White,
//                        fontSize = 28.sp,
//                        fontWeight = FontWeight.Bold)
//                }
//            }
//        }
//    }
//}
//@Preview
//@Composable
//fun ViewStudentsPreview(){
//    ViewStudents(rememberNavController())
}
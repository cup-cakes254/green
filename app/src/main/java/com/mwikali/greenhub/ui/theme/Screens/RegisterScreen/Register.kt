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
//import androidx.compose.foundation.Image
//import androidx.compose.foundation.background
//import androidx.compose.foundation.clickable
//import androidx.compose.foundation.layout.*
//import androidx.compose.material.icons.Icons
//import androidx.compose.material.icons.filled.*
//import androidx.compose.material3.*
//import androidx.compose.runtime.*
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.platform.LocalContext
//import androidx.compose.ui.res.painterResource
//import androidx.compose.ui.text.buildAnnotatedString
//import androidx.compose.ui.text.font.FontFamily
//import androidx.compose.ui.text.font.FontStyle
//import androidx.compose.ui.text.input.PasswordVisualTransformation
//import androidx.compose.ui.text.input.VisualTransformation
//import androidx.compose.ui.text.style.TextAlign
//import androidx.compose.ui.tooling.preview.Preview
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.unit.sp
//import androidx.lifecycle.viewmodel.compose.viewModel
//import androidx.navigation.NavController
//import androidx.navigation.compose.rememberNavController
//import com.mwikali.greenhub.R
//import com.mwikali.greenhub.data.AuthViewModel
//import com.mwikali.greenhub.ui.theme.Navigation.ROUTE_LOGIN
//import androidx.compose.material.icons.filled.Visibility
//import androidx.compose.material.icons.filled.VisibilityOff
//
//@Composable
//fun RegisterScreen(navController: NavController) {
//    val authViewModel: AuthViewModel = viewModel()
//    var firstname by remember { mutableStateOf("") }
//    var lastname by remember { mutableStateOf("") }
//    var email by remember { mutableStateOf("") }
//    var password by remember { mutableStateOf("") }
//    var passwordVisible by remember { mutableStateOf(false) }
//    val context = LocalContext.current
//
//    Column(
//        modifier = Modifier
//            .fillMaxSize()
//            .padding(16.dp),
//        verticalArrangement = Arrangement.Center
//    ) {
//        Text(
//            text = "Register Here",
//            fontSize = 32.sp,
//            fontFamily = FontFamily.SansSerif,
//            fontStyle = FontStyle.Normal,
//            color = Color.White,
//            textAlign = TextAlign.Center,
//            modifier = Modifier
//                .background(Color(0xFF4CAF50))
//                .fillMaxWidth()
//                .padding(20.dp)
//        )
//
//        Spacer(modifier = Modifier.height(10.dp))
//
//        Image(
//            painter = painterResource(id = R.drawable.green),
//            contentDescription = "logo",
//            modifier = Modifier
//                .height(100.dp)
//                .align(Alignment.CenterHorizontally)
//        )
//
//        Spacer(modifier = Modifier.height(20.dp))
//
//        OutlinedTextField(
//            value = firstname,
//            onValueChange = { firstname = it },
//            label = { Text("Enter First Name") },
//            leadingIcon = { Icon(Icons.Default.Person, contentDescription = null) },
//            modifier = Modifier.fillMaxWidth()
//        )
//
//        Spacer(modifier = Modifier.height(10.dp))
//
//        OutlinedTextField(
//            value = lastname,
//            onValueChange = { lastname = it },
//            label = { Text("Enter Last Name") },
//            leadingIcon = { Icon(Icons.Default.Person, contentDescription = null) },
//            modifier = Modifier.fillMaxWidth()
//        )
//
//        Spacer(modifier = Modifier.height(10.dp))
//
//        OutlinedTextField(
//            value = email,
//            onValueChange = { email = it },
//            label = { Text("Enter Email") },
//            leadingIcon = { Icon(Icons.Default.Email, contentDescription = null) },
//            modifier = Modifier.fillMaxWidth()
//        )
//
//        Spacer(modifier = Modifier.height(10.dp))
//
//        OutlinedTextField(
//            value = password,
//            onValueChange = { password = it },
//            label = { Text("Enter Password") },
//            leadingIcon = { Icon(Icons.Default.Lock, contentDescription = null) },
//            trailingIcon = {
//                val icon = if (passwordVisible) Icons.Default.VisibilityOff else Icons.Default.Visibility
//                IconButton(onClick = { passwordVisible = !passwordVisible }) {
//                    Icon(icon, contentDescription = if (passwordVisible) "Hide password" else "Show password")
//                }
//            },
//            visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
//            modifier = Modifier.fillMaxWidth()
//        )
//
//        Spacer(modifier = Modifier.height(20.dp))
//
//        Button(
//            onClick = {
//                authViewModel.signup(firstname, lastname, email, password, navController, context)
//            },
//            modifier = Modifier.align(Alignment.CenterHorizontally),
//            colors = ButtonDefaults.buttonColors(Color.Black)
//        ) {
//            Text("Register")
//        }
//
//        Spacer(modifier = Modifier.height(10.dp))
//
//        Text(
//            text = buildAnnotatedString { append("Already registered? Login here") },
//            color = Color.Blue,
//            modifier = Modifier
//                .align(Alignment.CenterHorizontally)
//                .clickable { navController.navigate(ROUTE_LOGIN) }
//        )
//    }
//}
//
//@Preview(showBackground = true, showSystemUi = true)
//@Composable
//fun RegisterScreenPreview() {
//    RegisterScreen(rememberNavController())
//}















import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.mwikali.greenhub.R
import com.mwikali.greenhub.ui.theme.Navigation.ROUTE_LOGIN

@Composable
fun RegisterScreen(navController: NavController){
    val authViewModel: AuthViewModel = viewModel()
    var firstname by remember { mutableStateOf(value = "") }
    var lastname by remember { mutableStateOf(value = "") }
    var email by remember { mutableStateOf(value = "") }
    var password by remember { mutableStateOf(value = "") }
    val context = LocalContext.current
    val passwordVisible by remember { mutableStateOf(false) }
    Column(modifier = Modifier.fillMaxWidth().fillMaxHeight(), verticalArrangement = Arrangement.Center) {
        Text(text = "Register Here",
            fontSize = 40.sp,
            fontFamily = FontFamily.SansSerif,
            fontStyle = FontStyle.Normal,
            color = Color.Black,
            textAlign = TextAlign.Center,
            modifier = Modifier.background(Color.Gray).fillMaxWidth().padding(20.dp)

        )
        Spacer(modifier = Modifier.height(10.dp))
        Image(painter = painterResource(id = R.drawable.green), contentDescription = "logo", modifier = Modifier.wrapContentHeight().fillMaxWidth().height(40.dp))
        OutlinedTextField(value = firstname, onValueChange = {newFirstName -> firstname = newFirstName}, label = { Text(text = "Enter first name") }, placeholder = { Text(text = "Please enter first name") }, modifier = Modifier.wrapContentWidth().align(
            Alignment.CenterHorizontally),leadingIcon = { Icon(imageVector = Icons.Default.Person, contentDescription = "Person Icon") })
        OutlinedTextField(value = lastname, onValueChange = {newLastName->lastname=newLastName}, label = { Text(text = "Enter Last Name") }, placeholder = { Text(text = "Please enter last name") }, modifier = Modifier.wrapContentWidth().align(
            Alignment.CenterHorizontally),leadingIcon = { Icon(imageVector = Icons.Default.Person, contentDescription = "Person Icon") })
        OutlinedTextField(value = email, onValueChange = {newEmail->email=newEmail}, label = { Text(text = "Enter Email") }, placeholder = { Text(text = "Please enter email") }, modifier = Modifier.wrapContentWidth().align(
            Alignment.CenterHorizontally), leadingIcon = { Icon(imageVector = Icons.Default.Email, contentDescription = "Email Icon") })
        OutlinedTextField(value = password, onValueChange = {newPassword->password=newPassword}, label = { Text(text = "Enter Password") }, placeholder = { Text(text = "Please enter Password") }, modifier = Modifier.wrapContentWidth().align(
            Alignment.CenterHorizontally), leadingIcon = { Icon(imageVector = Icons.Default.Lock, contentDescription = "Password Icon") }, visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation())
        Button(onClick = {
            authViewModel.signup(firstname,lastname,email,password,navController,context)
        }, modifier = Modifier.wrapContentWidth().align(Alignment.CenterHorizontally), colors = ButtonDefaults.buttonColors(
            Color.Black)) { Text(text = "Register") }
        Text(text = buildAnnotatedString { append("If already registered, Login here") }, modifier = Modifier.wrapContentWidth().align(
            Alignment.CenterHorizontally).clickable {
            navController.navigate(ROUTE_LOGIN)
        })
    }

}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun RegisterScreenPreview(){
    RegisterScreen(rememberNavController())
}
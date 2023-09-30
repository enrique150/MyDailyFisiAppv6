package com.pruebita.mydailyfisiapp.ui.screens.login

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.OutlinedIconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.pruebita.mydailyfisiapp.R
import com.pruebita.mydailyfisiapp.ui.components.login.HeaderLogin
import com.pruebita.mydailyfisiapp.ui.navigation.AppScreens
import com.pruebita.mydailyfisiapp.ui.theme.poppins
import com.pruebita.mydailyfisiapp.viewmodel.LoginViewModel
import kotlinx.coroutines.launch


@Composable
fun LoginScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        Login(Modifier.padding(0.dp), LoginViewModel(),navController)
    }
}

@Composable
fun Login(modifier: Modifier, viewModel: LoginViewModel, navController: NavController) {
    val email: String by viewModel.email.observeAsState(initial = "")
    val password: String by viewModel.password.observeAsState(initial = "")
    val loginEnable: Boolean by viewModel.loginEnable.observeAsState(initial = false)
    val isLoading: Boolean by viewModel.isLoading.observeAsState(initial = false)
    val coroutineScope = rememberCoroutineScope()


    if (isLoading) {
        Box(Modifier.fillMaxSize()) {
            CircularProgressIndicator(Modifier.align(Alignment.Center))
        }
    } else {
        Column(modifier = modifier) {

            HeaderLogin()
            Spacer(modifier = Modifier.padding(3.dp))

            Column(modifier = Modifier.padding(30.dp)) {
                EmailField(email) { viewModel.onLoginChanged(it, password) }
                Spacer(modifier = Modifier.padding(13.dp))
                PasswordField(password) { viewModel.onLoginChanged(email, it) }
                Spacer(modifier = Modifier.padding(10.dp))
                ForgotPassword(Modifier.align(Alignment.End))
                Spacer(modifier = Modifier.padding(5.dp))
                Continue()
                Spacer(modifier = Modifier.padding(5.dp))
                ContinueWithGoogle()
                Spacer(modifier = Modifier.padding(8.dp))
                LoginButton(loginEnable, navController) {
                    coroutineScope.launch {
                        viewModel.onLoginSelected()
                    }
                }
            }


        }

    }


}

@Composable
fun LoginButton(loginEnable: Boolean, navController: NavController, onLoginSelected: () -> Unit) {
    ElevatedButton(
        onClick = { navController.navigate(route = AppScreens.MainScreen.route) },
        modifier = Modifier
            .fillMaxWidth()
            .height(48.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.Transparent,
            contentColor = Color(0xFFFFFFFF),
            disabledContainerColor = Color(0xFFB3B6C4)

        ), contentPadding = PaddingValues(),
        enabled = loginEnable
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    brush = Brush.horizontalGradient(
                        colors = listOf(Color(0xFF6663D7), Color(0xFF1E92BA))
                    ),
                    shape = RoundedCornerShape(22.dp)
                ),
            contentAlignment = Alignment.Center,
        ) {
            Text(text = "Iniciar Sesion", fontSize = 16.sp, fontFamily = poppins)
        }
    }
}

@Composable
fun ForgotPassword(modifier: Modifier) {
    var rememberMe by rememberSaveable { mutableStateOf(false) }
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(22.dp)
    ) {
        Column(
            modifier = Modifier.weight(0.4f),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.Start
        ) {
            Row(
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Checkbox(
                    checked = rememberMe,
                    onCheckedChange = {
                        rememberMe = !rememberMe
                    },
                    colors = CheckboxDefaults.colors(
                        checkedColor = Color(0xFF4678CA)
                    )
                )

                Text(
                    text = "Recordar",
                    modifier = modifier.clickable { },
                    fontSize = 13.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color(0xFF4678CA),
                    fontFamily = poppins,

                    )
            }
        }
        Spacer(modifier = Modifier.padding(16.dp))
        Column(
            modifier = Modifier.weight(0.6f),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.End
        ) {
            Text(
                text = "Olvidaste tu contraseña?",
                modifier = modifier.clickable { },
                fontSize = 13.sp,
                fontWeight = FontWeight.Medium,
                color = Color(0xFF4678CA),
                fontFamily = poppins,
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PasswordField(password: String, onTextFieldChanged: (String) -> Unit) {
    var passwordVisible by rememberSaveable { mutableStateOf(true) }
    val visualTransformation = if (!passwordVisible) {
        PasswordVisualTransformation()
    } else {
        VisualTransformation.None
    }

    OutlinedTextField(
        value = password,
        onValueChange = { onTextFieldChanged(it) },
        placeholder = {
            Text(text = "Contraseña", fontFamily = poppins)
        },
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Lock,
                contentDescription = "User",
                tint = Color(0xFF7F8388)
            )
        },
        trailingIcon = {
            if (passwordVisible) {
                Icon(
                    painter = painterResource(id = R.drawable.baseline_visibility_24),
                    contentDescription = "User",
                    modifier = Modifier.clickable { passwordVisible = false },
                    tint = Color(0xFF7F8388)
                )
            } else {
                Icon(
                    painter = painterResource(id = R.drawable.baseline_visibility_off_24),
                    contentDescription = "User",
                    modifier = Modifier.clickable { passwordVisible = true },
                    tint = Color(0xFF7F8388)
                )
            }
        },
        visualTransformation = visualTransformation,
        modifier = Modifier.fillMaxWidth(),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        singleLine = true,
        maxLines = 1,
        colors = TextFieldDefaults.outlinedTextFieldColors(
            containerColor = Color.White,
        )
    )

}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EmailField(email: String, onTextFieldChanged: (String) -> Unit) {


    OutlinedTextField(
        value = email,
        onValueChange = { onTextFieldChanged(it) },
        modifier = Modifier.fillMaxWidth(),
        placeholder = {
            Text(text = "Email", fontFamily = poppins)
        },
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Person,
                contentDescription = "User",
                tint = Color(0xFF7F8388)
            )
        },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),

        singleLine = true,
        maxLines = 1,
        colors = TextFieldDefaults.outlinedTextFieldColors(
            containerColor = Color.White,
        )
    )
}

@Composable
fun Continue() {
    Row(
        modifier = Modifier
            .width(310.dp)
            .height(40.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Primera línea vertical
        Divider(
            color = Color(0xFFCDCED1),
            modifier = Modifier
                .weight(1f) // Espacio igual a la mitad del Row
                .height(1.dp) // Grosor de la línea
        )

        // Carácter "a"
        Text(
            text = "  o continua con:  ",
            fontSize = 15.sp,
            modifier = Modifier.padding(4.dp),
            color = Color(0xFF747980),
            fontFamily = poppins,
        )

        // Segunda línea vertical
        Divider(
            color = Color(0xFFCDCED1),
            modifier = Modifier
                .weight(1f) // Espacio igual a la mitad del Row
                .height(1.dp) // Grosor de la línea
        )
    }
}

@Composable
fun ContinueWithGoogle() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center,

        ) {
        OutlinedIconButton(
            onClick = { },
            shape = RoundedCornerShape(16.dp),
            border = BorderStroke(2.dp, Color(0xFF969AA0)),
            colors = IconButtonDefaults.outlinedIconButtonColors(
                containerColor = Color.White,
            ),
            modifier = Modifier.size(90.dp)
        ) {
            Box(modifier = Modifier.padding(20.dp)) {
                Image(
                    painter = painterResource(id = R.drawable.iconinicio),
                    contentDescription = "Log In Google",
                    modifier = Modifier.size(92.dp, 92.dp)
                )
            }
        }
    }
}
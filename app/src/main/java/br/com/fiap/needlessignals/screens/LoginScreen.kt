package br.com.fiap.needlessignals.screens

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import br.com.fiap.needlessignals.R
import br.com.fiap.needlessignals.components.CheckBoxComponent
import br.com.fiap.needlessignals.components.ClickableLoginTextComponent
import br.com.fiap.needlessignals.components.EmailTextField
import br.com.fiap.needlessignals.components.HeadingTextComponent
import br.com.fiap.needlessignals.components.PasswordTextField
import br.com.fiap.needlessignals.data.Login.LoginFormEvent
import br.com.fiap.needlessignals.data.Login.LoginViewModel
import br.com.fiap.needlessignals.navigation.NeedlesSignalsAppRouter
import br.com.fiap.needlessignals.navigation.Screen
import br.com.fiap.needlessignals.ui.theme.BluePrimary

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(32.dp)
    ) {
        val loginViewModel = viewModel<LoginViewModel>()
        val state = loginViewModel.state
        val context = LocalContext.current
        LaunchedEffect(key1 = context ) {
            loginViewModel.validationEvents.collect { event ->
                when(event) {
                    is LoginViewModel.ValidationEvent.Success -> {
                        Toast.makeText(
                            context,
                            "Login Efetuado com sucesso!",
                            Toast.LENGTH_LONG
                        ).show()
                    }
                }
            }
        }
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                modifier = Modifier.size(width = 200.dp, height = 130.dp),
                painter = painterResource(id = R.drawable.hero),
                contentDescription = "Logo Needles Signal"
            )
            Spacer(modifier = Modifier.height(5.dp))

            HeadingTextComponent(value = stringResource(R.string.welcome))

            Spacer(modifier = Modifier.height(10.dp))
            Column {
                EmailTextField(
                    labelValue = stringResource(id = R.string.emailPlaceHolder),
                    value = state.email,
                    icon = Icons.Outlined.Email,
                    isError = state.emailError != null,
                ) {
                    loginViewModel.onEvent(LoginFormEvent.EmailChange(it))
                }
                if (state.emailError != null) {
                    Text(
                        text = state.emailError,
                        fontSize = 14.sp,
                        color = Color.Red,
                    )
                }
            }


            PasswordTextField(
                confirmPassword = true,
                value = state.password,
                labelValue = stringResource(id = R.string.passwordPlaceHolder),
                icon = Icons.Outlined.Lock,
                isError = state.passwordError != null,
                onTextSelected = {
                    loginViewModel.onEvent(LoginFormEvent.PasswordChange(it))
                }
            )
            if (state.passwordError != null) {
                Text(
                    text = state.passwordError,
                    fontSize = 14.sp,
                    color = Color.Red,
                )
            }

            Spacer(modifier = Modifier.height(22.dp))

            CheckBoxComponent(
                value = stringResource(R.string.remember_password),
                onTextSelected = {
                }
            )

            Spacer(modifier = Modifier.height(69.dp))
            ClickableLoginTextComponent(
                value = stringResource(R.string.forgetPassword),
                onTextSelected = {
                    NeedlesSignalsAppRouter.navigateTo(Screen.EsqueceuSenhaScreen)
                })
//            150 45
            Spacer(modifier = Modifier.height(16.dp))
            Row {
                Button(
                    onClick = {
                        loginViewModel.onEvent(LoginFormEvent.Submit)
                        NeedlesSignalsAppRouter.navigateTo(Screen.HomeScreen)
                    },
                    elevation = ButtonDefaults.buttonElevation(2.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = BluePrimary),
                    modifier = Modifier
                        .width(150.dp)
                        .height(45.dp)
                ) {
                    Text(text = stringResource(id = R.string.login))
                }
                Spacer(modifier = Modifier.width(14.dp))
                Button(
                    elevation = ButtonDefaults.buttonElevation(2.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color.White),
                    onClick = {
                        NeedlesSignalsAppRouter.navigateTo(Screen.CadastroScreen)
                    },
                    modifier = Modifier
                        .width(150.dp)
                        .height(45.dp)
                ) {
                    Text(text = stringResource(id = R.string.register), color = BluePrimary)
                }
            }

        }
    }
}
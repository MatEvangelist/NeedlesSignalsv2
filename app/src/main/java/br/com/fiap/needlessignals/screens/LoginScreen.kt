package br.com.fiap.needlessignals.screens

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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import br.com.fiap.needlessignals.R
import br.com.fiap.needlessignals.components.CheckBoxComponent
import br.com.fiap.needlessignals.components.ClickableLoginTextComponent
import br.com.fiap.needlessignals.components.EmailTextField
import br.com.fiap.needlessignals.components.HeadingTextComponent
import br.com.fiap.needlessignals.components.PasswordTextField
import br.com.fiap.needlessignals.navigation.NeedlesSignalsAppRouter
import br.com.fiap.needlessignals.navigation.Screen
import br.com.fiap.needlessignals.ui.theme.BluePrimary

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen() {
    var email by remember() {
        mutableStateOf("")
    }

    var password by remember {
        mutableStateOf("")
    }

    var emailError by remember {
        mutableStateOf(false)
    }

    var remeberPassword by remember {
        mutableStateOf(false)
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(32.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                modifier = Modifier.size(width = 200.dp, height = 130.dp),
                painter = painterResource(id = R.drawable.hero),
                contentDescription = "Logotipo"
            )
            Spacer(modifier = Modifier.height(5.dp))

            HeadingTextComponent(value = stringResource(R.string.welcome))

            Spacer(modifier = Modifier.height(10.dp))

            EmailTextField(labelValue = "Email", icon = Icons.Outlined.Email)
            PasswordTextField(
                labelValue = stringResource(R.string.password), icon = Icons.Outlined.Lock
            )

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
                        emailError = email.isEmpty()
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
                    onClick = { /*TODO*/ },
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
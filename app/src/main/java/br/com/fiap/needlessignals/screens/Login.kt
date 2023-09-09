package br.com.fiap.needlessignals.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
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
import androidx.compose.ui.text.ParagraphStyle
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.fiap.needlessignals.R
import br.com.fiap.needlessignals.ui.theme.BluePrimary

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Login() {
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
            .background(Color(0xFFEBE4E6))
            .padding(32.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                modifier = Modifier.size(width = 200.dp, height = 130.dp ),
                painter = painterResource(id = R.drawable.hero),
                contentDescription = "Logotipo"
            )
            Spacer(modifier = Modifier.height(5.dp))

            Text(
                text = stringResource(id = R.string.welcome),
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                buildAnnotatedString {
                    withStyle(style = ParagraphStyle(lineHeight = 30.sp)) {
                        withStyle(style = SpanStyle(color = Color.DarkGray)) {
                            append("Registrando-se no nosso app você esta aceitando nossos ")
                        }
                        withStyle(
                            style = SpanStyle(
                                fontWeight = FontWeight.Normal,
                                color = BluePrimary
                            )
                        ) {
                            append("Termos e Politicas de privacidade")
                        }
                    }
                },

                textAlign = TextAlign.Center,
            )
            Spacer(modifier = Modifier.height(12.dp))
            OutlinedTextField(
                value = email,
                trailingIcon = {
                    Icon(
                        imageVector = Icons.Outlined.Email,
                        contentDescription = ""
                    )
                },
                shape = RoundedCornerShape(9.dp),
                onValueChange = {
                    email = it
                    if (email.length > 0) emailError = false
                },
                modifier = Modifier.fillMaxWidth(),
                label = {
                    Text(text = stringResource(id = R.string.email))
                },
                isError = emailError,
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Email
                ),
            )
            if (emailError) {
                Text(
                    text = "E-mail é obrigatório!",
                    modifier = Modifier.fillMaxWidth(),
                    color = Color.Red,
                    textAlign = TextAlign.End
                )
            }
            Spacer(modifier = Modifier.height(22.dp))
            OutlinedTextField(
                value = password,
                trailingIcon = {
                    Icon(
                        imageVector = Icons.Outlined.Lock,
                        contentDescription = ""
                    )
                },
                shape = RoundedCornerShape(9.dp),
                onValueChange = { if (it.length <= 15) password = it },
                modifier = Modifier.fillMaxWidth(),
                label = {
                    Text(text = stringResource(id = R.string.password))
                },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Password
                ),
                visualTransformation = PasswordVisualTransformation()
            )
            Spacer(modifier = Modifier.height(22.dp))
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Checkbox(
                    checked = remeberPassword,
                    onCheckedChange = {
                        remeberPassword = !remeberPassword
                    }
                )
                Text(text = "Lembrar Senha")
            }
            Spacer(modifier = Modifier.height(69.dp))
            Text(
                text = stringResource(id = R.string.forgetPassword),
                color = BluePrimary
            )
//            150 45
            Spacer(modifier = Modifier.height(16.dp))
            Row {
                Button(
                    onClick = { /*TODO*/ },
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
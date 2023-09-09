package br.com.fiap.needlessignals.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.ParagraphStyle
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.fiap.needlessignals.R
import br.com.fiap.needlessignals.ui.theme.BluePrimary

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Cadastro() {
    var termosDeUso by remember {
        mutableStateOf(false)
    }
    var receberNovidades by remember {
        mutableStateOf(false)
    }

    var nome by remember() {
        mutableStateOf("")
    }

    var nomeError by remember {
        mutableStateOf(false)
    }

    var sobrenome by remember() {
        mutableStateOf("")
    }

    var sobrenomeError by remember {
        mutableStateOf(false)
    }

    var email by remember() {
        mutableStateOf("")
    }

    var emailError by remember {
        mutableStateOf(false)
    }

    var cpf by remember() {
        mutableStateOf("")
    }

    var cpfError by remember {
        mutableStateOf(false)
    }

    var senha by remember() {
        mutableStateOf("")
    }

    var senhaError by remember {
        mutableStateOf(false)
    }

    var confirmacaosenha by remember() {
        mutableStateOf("")
    }

    var confirmacaosenhaError by remember {
        mutableStateOf(false)
    }

    Column(
        modifier = Modifier
            .size(width = 382.dp, height = 1005.dp)
            .background(Color.White)
            .padding(28.dp)
    ) {
        Text(
            modifier = Modifier.fillMaxWidth(),
            text = "Cadastro",
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(34.dp))

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

        Text(text = "Seu nome", textAlign = TextAlign.Start)
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(
            value = nome,
            placeholder = {
                Text(text = stringResource(id = R.string.namePlaceHolder))
            },
            trailingIcon = {
                Icon(
                    imageVector = Icons.Outlined.Person,
                    contentDescription = ""
                )
            },
            shape = RoundedCornerShape(9.dp),
            onValueChange = {
                nome = it
                if (nome.length > 0) nomeError = false
            },
            modifier = Modifier.fillMaxWidth(),
            label = {
                Text(text = stringResource(id = R.string.nameLabel))
            },
            isError = nomeError,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text
            ),
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "Seu sobrenome", textAlign = TextAlign.Start)
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(
            value = sobrenome,
            placeholder = {
                Text(text = stringResource(id = R.string.lastNamePlaceHolder))
            },
            trailingIcon = {
                Icon(
                    imageVector = Icons.Outlined.Person,
                    contentDescription = ""
                )
            },
            shape = RoundedCornerShape(9.dp),
            onValueChange = {
                sobrenome = it
                if (sobrenome.length > 0) sobrenomeError = false
            },
            modifier = Modifier.fillMaxWidth(),
            label = {
                Text(text = stringResource(id = R.string.lastNameLabel))
            },
            isError = sobrenomeError,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text
            ),
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "Seu e-mail", textAlign = TextAlign.Start)
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(
            value = email,
            placeholder = {
                Text(text = stringResource(id = R.string.emailPlaceHolder))
            },
            trailingIcon = {
                Icon(
                    imageVector = Icons.Outlined.Person,
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
                Text(text = stringResource(id = R.string.emailLabel))
            },
            isError = emailError,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Email
            ),
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "Seu CPF", textAlign = TextAlign.Start)
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(
            value = cpf,
            placeholder = {
                Text(text = stringResource(id = R.string.cpfPlaceHolder))
            },
            trailingIcon = {
                Icon(
                    imageVector = Icons.Outlined.Person,
                    contentDescription = ""
                )
            },
            shape = RoundedCornerShape(9.dp),
            onValueChange = {
                cpf = it
                if (cpf.length > 0) cpfError = false
            },
            modifier = Modifier.fillMaxWidth(),
            label = {
                Text(text = stringResource(id = R.string.cpfLabel))
            },
            isError = cpfError,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number
            ),
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "Sua senha", textAlign = TextAlign.Start)
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(
            value = senha,
            placeholder = {
                Text(text = stringResource(id = R.string.passwordPlaceHolder))
            },
            trailingIcon = {
                Icon(
                    imageVector = Icons.Outlined.Lock,
                    contentDescription = ""
                )
            },
            shape = RoundedCornerShape(9.dp),
            onValueChange = {
                senha = it
                if (senha.length > 0) senhaError = false
            },
            modifier = Modifier.fillMaxWidth(),
            label = {
                Text(text = stringResource(id = R.string.passwordLabel))
            },
            isError = senhaError,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password
            ),
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "Sua senha novamente", textAlign = TextAlign.Start)
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(
            value = confirmacaosenha,
            placeholder = {
                Text(text = stringResource(id = R.string.confirmation_passwordplaceHolder))
            },
            trailingIcon = {
                Icon(
                    imageVector = Icons.Outlined.Lock,
                    contentDescription = ""
                )
            },
            shape = RoundedCornerShape(9.dp),
            onValueChange = {
                confirmacaosenha = it
                if (confirmacaosenha.length > 0) confirmacaosenhaError = false
            },
            modifier = Modifier.fillMaxWidth(),
            label = {
                Text(text = stringResource(id = R.string.confirmation_passwordLabel))
            },
            isError = confirmacaosenhaError,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password
            ),
        )

        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "Termos de uso",
                color = BluePrimary,
                textAlign = TextAlign.Center
            )
        }
        Spacer(modifier = Modifier.height(12.dp))
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Checkbox(
                checked = termosDeUso,
                onCheckedChange = {
                    termosDeUso = !termosDeUso
                }
            )
            Text(text = "Li e concordo com os termos de uso.")
        }
        Spacer(modifier = Modifier.height(12.dp))
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Checkbox(
                checked = receberNovidades,
                onCheckedChange = {
                    receberNovidades = !receberNovidades
                }
            )
            Text(text = "Receber novidades por e-mail.")
        }
        Spacer(modifier = Modifier.height(81.dp))
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            Button(
                elevation = ButtonDefaults.buttonElevation(2.dp),
                colors = ButtonDefaults.buttonColors(containerColor = BluePrimary),
                onClick = { /*TODO*/ },
                modifier = Modifier
                    .width(150.dp)
                    .height(45.dp)
            ) {
                Icon(
                    imageVector = Icons.Outlined.ArrowBack,
                    contentDescription = "Botão de retorno"
                )
                Spacer(modifier = Modifier.width(16.dp))
                Text(text = stringResource(id = R.string.back), color = Color.White)
            }
            Button(
                elevation = ButtonDefaults.buttonElevation(2.dp),
                colors = ButtonDefaults.buttonColors(containerColor = BluePrimary),
                onClick = { /*TODO*/ },
                modifier = Modifier
                    .width(150.dp)
                    .height(45.dp)
            ) {
                Text(text = stringResource(id = R.string.next), color = Color.White)
                Spacer(modifier = Modifier.width(16.dp))
                Icon(
                    imageVector = Icons.Outlined.ArrowForward,
                    contentDescription = "Botão de Próximo"
                )
            }
        }
    }
}
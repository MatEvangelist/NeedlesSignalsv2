package br.com.fiap.needlessignals.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material.icons.outlined.ArrowForward
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
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
import br.com.fiap.needlessignals.components.CheckBoxNewsletterComponent
import br.com.fiap.needlessignals.components.CheckBoxTermosComponent
import br.com.fiap.needlessignals.components.EmailTextField
import br.com.fiap.needlessignals.components.HeadingTextComponent
import br.com.fiap.needlessignals.components.MyTextField
import br.com.fiap.needlessignals.components.NormalTextComponent
import br.com.fiap.needlessignals.components.PasswordTextField
import br.com.fiap.needlessignals.components.TermsClickableTextComponent
import br.com.fiap.needlessignals.navigation.NeedlesSignalsAppRouter
import br.com.fiap.needlessignals.navigation.Screen
import br.com.fiap.needlessignals.navigation.SystemBackButtonHandler
import br.com.fiap.needlessignals.ui.theme.BluePrimary

@OptIn(ExperimentalMaterial3Api::class, ExperimentalLayoutApi::class)
@Composable
fun CadastroScreen() {
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

    LazyColumn(
        modifier = Modifier
            .background(Color.White)
            .padding(28.dp)
    ) {
        item {
            HeadingTextComponent(value = stringResource(R.string.registrar_head))
            Spacer(modifier = Modifier.height(14.dp))
            TermsClickableTextComponent(
                value = "", onTextSelected = {
                NeedlesSignalsAppRouter.navigateTo(Screen.TermoPrivacidadeScreen)
            })

            Spacer(modifier = Modifier.height(14.dp))
            MyTextField(
                labelValue = stringResource(id = R.string.namePlaceHolder),
                icon = Icons.Outlined.Person
            )
            MyTextField(
                labelValue = stringResource(id = R.string.lastNamePlaceHolder),
                icon = Icons.Outlined.Person
            )
            EmailTextField(
                labelValue = stringResource(id = R.string.emailPlaceHolder),
                icon =Icons.Outlined.Email
            )
            MyTextField(
                labelValue = stringResource(id = R.string.cpfPlaceHolder),
                icon = Icons.Outlined.Person
            )

            PasswordTextField(confirmPassword = true, labelValue = stringResource(id = R.string.passwordPlaceHolder), icon = Icons.Outlined.Lock)
            PasswordTextField(labelValue = stringResource(id = R.string.confirmation_passwordplaceHolder), icon = Icons.Outlined.Lock)

            CheckBoxTermosComponent(value = stringResource(R.string.agree_terms), onTextSelected = {})
            CheckBoxNewsletterComponent(value = stringResource(R.string.newsletter), onTextSelected = {})

            Spacer(modifier = Modifier.height(16.dp))
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                Button(
                    elevation = ButtonDefaults.buttonElevation(2.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = BluePrimary),
                    onClick = {
                        NeedlesSignalsAppRouter.navigateTo(Screen.LoginScreen)
                    },
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
                    onClick = {
                        NeedlesSignalsAppRouter.navigateTo(Screen.LoginScreen)
                    },
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

                SystemBackButtonHandler {
                    NeedlesSignalsAppRouter.navigateTo(Screen.LoginScreen)
                }
            }
        }
    }
}
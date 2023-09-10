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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material.icons.outlined.ArrowForward
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import br.com.fiap.needlessignals.R
import br.com.fiap.needlessignals.components.CheckBoxNewsletterComponent
import br.com.fiap.needlessignals.components.CheckBoxTermosComponent
import br.com.fiap.needlessignals.components.EmailTextField
import br.com.fiap.needlessignals.components.HeadingTextComponent
import br.com.fiap.needlessignals.components.MyTextField
import br.com.fiap.needlessignals.components.PasswordTextField
import br.com.fiap.needlessignals.components.TermsClickableTextComponent
import br.com.fiap.needlessignals.data.LoginViewModel
import br.com.fiap.needlessignals.data.UIEvent
import br.com.fiap.needlessignals.navigation.NeedlesSignalsAppRouter
import br.com.fiap.needlessignals.navigation.Screen
import br.com.fiap.needlessignals.navigation.SystemBackButtonHandler
import br.com.fiap.needlessignals.ui.theme.BluePrimary

@OptIn(ExperimentalMaterial3Api::class, ExperimentalLayoutApi::class)
@Composable
fun CadastroScreen(loginViewModel: LoginViewModel = viewModel()) {
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
                icon = Icons.Outlined.Person,
                onTextSelected = {
                    loginViewModel.onEvent(UIEvent.FirstNameChange(it))
                }
            )
            MyTextField(
                labelValue = stringResource(id = R.string.lastNamePlaceHolder),
                icon = Icons.Outlined.Person,
                onTextSelected = {
                    loginViewModel.onEvent(UIEvent.LastNameChange(it))
                }
            )
            EmailTextField(
                labelValue = stringResource(id = R.string.emailPlaceHolder),
                icon =Icons.Outlined.Email
            ) {
                loginViewModel.onEvent(UIEvent.EmailChange(it))
            }
            MyTextField(
                labelValue = stringResource(id = R.string.cpfPlaceHolder),
                icon = Icons.Outlined.Person,
                onTextSelected = {
                    loginViewModel.onEvent(UIEvent.CPFChange(it))
                }
            )

            PasswordTextField(
                confirmPassword = true,
                labelValue = stringResource(id = R.string.passwordPlaceHolder),
                icon = Icons.Outlined.Lock,
                onTextSelected = {
                    loginViewModel.onEvent(UIEvent.PasswordChange(it))
                }
            )
            PasswordTextField(
                labelValue = stringResource(id = R.string.confirmation_passwordplaceHolder),
                icon = Icons.Outlined.Lock,
                onTextSelected = {
                    loginViewModel.onEvent(UIEvent.ConfirmPasswordChange(it))
                }
            )

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
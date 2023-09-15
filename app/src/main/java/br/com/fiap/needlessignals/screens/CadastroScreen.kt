package br.com.fiap.needlessignals.screens

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.ui.Alignment
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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import br.com.fiap.needlessignals.R
import br.com.fiap.needlessignals.components.CheckBoxNewsletterComponent
import br.com.fiap.needlessignals.components.CheckBoxTermosComponent
import br.com.fiap.needlessignals.components.EmailTextField
import br.com.fiap.needlessignals.components.HeadingTextComponent
import br.com.fiap.needlessignals.components.MyTextField
import br.com.fiap.needlessignals.components.PasswordTextField
import br.com.fiap.needlessignals.components.TermsClickableTextComponent
import br.com.fiap.needlessignals.data.Registration.RegistrationViewModel
import br.com.fiap.needlessignals.data.Registration.RegistrationFormEvent
import br.com.fiap.needlessignals.models.User
import br.com.fiap.needlessignals.models.UserTokenDto
import br.com.fiap.needlessignals.navigation.NeedlesSignalsAppRouter
import br.com.fiap.needlessignals.navigation.Screen
import br.com.fiap.needlessignals.navigation.SystemBackButtonHandler
import br.com.fiap.needlessignals.service.RetrofitFactory
import br.com.fiap.needlessignals.ui.theme.BluePrimary
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CadastroScreen() {


    val registrationViewModel = viewModel<RegistrationViewModel>()
    val state = registrationViewModel.state
    val context = LocalContext.current

    var userTokenDtoState = remember {
        mutableStateOf("")
    }

    LaunchedEffect(key1 = context) {
        registrationViewModel.validationEvents.collect { event ->
            when (event) {
                is RegistrationViewModel.ValidationEvent.Success -> {
                    Toast.makeText(
                        context,
                        "Registration successfull",
                        Toast.LENGTH_LONG
                    ).show()
                }
            }
        }
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
                icon = Icons.Outlined.Person,
                onTextSelected = {
                    registrationViewModel.onEvent(RegistrationFormEvent.FirstNameChange(it))
                },
                value = state.firstName,
                isError = state.firstNameError != null
            )
            if (state.firstNameError != null) {
                Text(
                    text = state.firstNameError,
                    fontSize = 14.sp,
                    color = Color.Red,
                    textAlign = TextAlign.End
                )
            }
            MyTextField(
                labelValue = stringResource(id = R.string.lastNamePlaceHolder),
                value = state.lastName,
                icon = Icons.Outlined.Person,
                isError = state.lastNameError != null,
                onTextSelected = {
                    registrationViewModel.onEvent(RegistrationFormEvent.LastNameChange(it))
                },
            )
            if (state.lastNameError != null) {
                Text(
                    text = state.lastNameError,
                    fontSize = 14.sp,
                    color = Color.Red,
                    textAlign = TextAlign.End
                )
            }
            EmailTextField(
                labelValue = stringResource(id = R.string.emailPlaceHolder),
                value = state.email,
                icon = Icons.Outlined.Email,
                isError = state.emailError != null,
            ) {
                registrationViewModel.onEvent(RegistrationFormEvent.EmailChange(it))
            }
            if (state.emailError != null) {
                Text(
                    text = state.emailError,
                    fontSize = 14.sp,
                    color = Color.Red,
                    textAlign = TextAlign.End
                )
            }
            MyTextField(
                labelValue = stringResource(id = R.string.cpfPlaceHolder),
                icon = Icons.Outlined.Person,
                onTextSelected = {
                    registrationViewModel.onEvent(RegistrationFormEvent.CPFChange(it))
                },
                value = state.cpf,
                isError = state.cpfError != null,
            )
            if (state.cpfError != null) {
                Text(
                    text = state.cpfError,
                    fontSize = 14.sp,
                    color = Color.Red,
                    textAlign = TextAlign.End
                )
            }
            PasswordTextField(
                confirmPassword = true,
                value = state.password,
                labelValue = stringResource(id = R.string.passwordPlaceHolder),
                icon = Icons.Outlined.Lock,
                isError = state.passwordError != null,
                onTextSelected = {
                    registrationViewModel.onEvent(RegistrationFormEvent.PasswordChange(it))
                }
            )
            if (state.passwordError != null) {
                Text(
                    text = state.passwordError,
                    fontSize = 14.sp,
                    color = Color.Red,
                    textAlign = TextAlign.End
                )
            }
            PasswordTextField(
                labelValue = stringResource(id = R.string.confirmation_passwordplaceHolder),
                icon = Icons.Outlined.Lock,
                onTextSelected = {
                    registrationViewModel.onEvent(RegistrationFormEvent.ConfirmPasswordChange(it))
                },
                value = state.confirmPassword,
                isError = state.confirmPasswordError != null
            )

            if (state.confirmPasswordError != null) {
                Text(
                    text = state.confirmPasswordError,
                    fontSize = 14.sp,
                    color = Color.Red,
                    textAlign = TextAlign.End
                )
            }
            CheckBoxTermosComponent(
                value = stringResource(R.string.agree_terms),
                checked = state.acceptedTerms,
                onCheckedChange = {
                    registrationViewModel.onEvent(RegistrationFormEvent.TermsChange(it != null))
                }
            )
            if (state.termsError != null) {
                Text(
                    text = state.termsError,
                    color = Color.Red,
                )
            }
            CheckBoxNewsletterComponent(
                value = stringResource(R.string.newsletter),
                onTextSelected = {}
            )

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
                        var user = User(
                            state.firstName,
                            state.lastName,
                            state.email,
                            state.password,
                            state.cpf
                        )
                        var call = RetrofitFactory().setRegister().setRegister(user)
                        call.enqueue(object : Callback<UserTokenDto> {
                            override fun onResponse(
                                call: Call<UserTokenDto>,
                                response: Response<UserTokenDto>
                            ) {
                                var response = response.body()!!
                                userTokenDtoState.value = response.token.toString()
                                Log.i("FILHADAPUTA", "onResponse: ${userTokenDtoState.value}")
                            }

                            override fun onFailure(call: Call<UserTokenDto>, t: Throwable) {
                                Log.i("FIAP", "onResponse: ${t.message}")
                            }

                        })
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
                    registrationViewModel.onEvent(RegistrationFormEvent.Submit)
                }
            }
        }
    }
}
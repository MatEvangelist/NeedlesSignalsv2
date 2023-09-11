package br.com.fiap.needlessignals.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material.icons.outlined.ArrowForward
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import br.com.fiap.needlessignals.R
import br.com.fiap.needlessignals.components.EmailTextField
import br.com.fiap.needlessignals.components.HeadingTextComponent
import br.com.fiap.needlessignals.components.NormalTextComponent
import br.com.fiap.needlessignals.data.Login.LoginFormEvent
import br.com.fiap.needlessignals.data.Recovery.RecoveryFormEvent
import br.com.fiap.needlessignals.data.Recovery.RecoveryViewModel
import br.com.fiap.needlessignals.navigation.NeedlesSignalsAppRouter
import br.com.fiap.needlessignals.navigation.Screen
import br.com.fiap.needlessignals.navigation.SystemBackButtonHandler
import br.com.fiap.needlessignals.ui.theme.BluePrimary

@Composable
fun EsqueceuSenhaScreen() {
    val recoveryViewModel = viewModel<RecoveryViewModel>()
    val state = recoveryViewModel.state
    val context = LocalContext.current

    LazyColumn(
        modifier = Modifier
            .background(Color.White)
            .padding(28.dp)
    ) {
        item {
            Image(
                modifier = Modifier.size(width = 200.dp, height = 130.dp),
                painter = painterResource(id = R.drawable.hero),
                contentDescription = "Logotipo"
            )
            Spacer(modifier = Modifier.height(5.dp))

            HeadingTextComponent(value = stringResource(R.string.recovery_password))

            Spacer(modifier = Modifier.height(10.dp))

            NormalTextComponent(value = stringResource(R.string.msg_recovery_password))

            Spacer(modifier = Modifier.height(24.dp))

            Column {
                EmailTextField(
                    labelValue = stringResource(id = R.string.emailPlaceHolder),
                    value = state.email,
                    icon = Icons.Outlined.Email,
                    isError = state.emailError != null,
                ) {
                    recoveryViewModel.onEvent(RecoveryFormEvent.EmailChange(it))
                }
                if (state.emailError != null) {
                    Text(
                        text = state.emailError,
                        fontSize = 14.sp,
                        color = Color.Red,
                        textAlign = TextAlign.End
                    )
                }
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
                        recoveryViewModel.onEvent(RecoveryFormEvent.Submit)
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
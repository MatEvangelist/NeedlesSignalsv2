package br.com.fiap.needlessignals.presentation.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import br.com.fiap.needlessignals.R
import br.com.fiap.needlessignals.presentation.components.HeadingTextComponent
import br.com.fiap.needlessignals.presentation.components.NormalTextComponent
import br.com.fiap.needlessignals.presentation.navigation.NeedlesSignalsAppRouter
import br.com.fiap.needlessignals.presentation.navigation.Screen
import br.com.fiap.needlessignals.presentation.navigation.SystemBackButtonHandler
import br.com.fiap.needlessignals.ui.theme.BluePrimary

@Composable
fun TermoPrivacidadeScreen() {
    LazyColumn(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
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

            HeadingTextComponent(value = stringResource(R.string.term_privacy))

            Spacer(modifier = Modifier.height(10.dp))

            NormalTextComponent(value = stringResource(R.string.termo_privacidade))

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

                SystemBackButtonHandler {
                    NeedlesSignalsAppRouter.navigateTo(Screen.CadastroScreen)
                }
            }
        }
    }
}
package br.com.fiap.needlessignals.app

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import br.com.fiap.needlessignals.navigation.NeedlesSignalsAppRouter
import br.com.fiap.needlessignals.navigation.Screen
import br.com.fiap.needlessignals.screens.CadastroScreen
import br.com.fiap.needlessignals.screens.EsqueceuSenhaScreen
import br.com.fiap.needlessignals.screens.LoginScreen

@Composable
fun NeedlesSignalsApp() {
    Surface(modifier = Modifier.fillMaxSize(), color = Color.White) {
        Crossfade(targetState = NeedlesSignalsAppRouter.currentScreen, label = "") { currentState ->
            when (currentState.value) {
                is Screen.LoginScreen -> {
                    LoginScreen()
                }

                is Screen.EsqueceuSenhaScreen -> {
                    EsqueceuSenhaScreen()
                }

                is Screen.CadastroScreen -> {
                    CadastroScreen()
                }
            }

        }
    }
}
package br.com.fiap.needlessignals.app

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import br.com.fiap.needlessignals.presentation.navigation.NeedlesSignalsAppRouter
import br.com.fiap.needlessignals.presentation.navigation.Screen
import br.com.fiap.needlessignals.presentation.screens.CadastroScreen
import br.com.fiap.needlessignals.presentation.screens.EsqueceuSenhaScreen
import br.com.fiap.needlessignals.presentation.screens.HomeScreen
import br.com.fiap.needlessignals.presentation.screens.LoginScreen
import br.com.fiap.needlessignals.presentation.screens.TermoPrivacidadeScreen

@Composable
fun NeedlesSignalsApp() {
    Surface(modifier = Modifier.fillMaxSize(), color = Color.White) {
        Crossfade(targetState = NeedlesSignalsAppRouter.currentScreen, label = "") { currentState ->
            when (currentState.value) {
                is Screen.LoginScreen -> {
                    LoginScreen()
                }

                is Screen.HomeScreen -> {
                    HomeScreen()
                }

                is Screen.EsqueceuSenhaScreen -> {
                    EsqueceuSenhaScreen()
                }

                is Screen.CadastroScreen -> {
                    CadastroScreen()
                }

                is Screen.TermoPrivacidadeScreen -> {
                    TermoPrivacidadeScreen()
                }
            }

        }
    }
}
package br.com.fiap.needlessignals.presentation.navigation

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf

sealed class Screen {
    object LoginScreen : Screen()
    object CadastroScreen : Screen()
    object EsqueceuSenhaScreen : Screen()
    object TermoPrivacidadeScreen : Screen()
    object HomeScreen : Screen()

}

object NeedlesSignalsAppRouter {
    var currentScreen: MutableState<Screen> = mutableStateOf(Screen.LoginScreen)

    fun navigateTo(destination: Screen) {
        currentScreen.value = destination
    }
}
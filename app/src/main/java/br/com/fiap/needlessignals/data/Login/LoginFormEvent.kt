package br.com.fiap.needlessignals.data.Login

sealed class LoginFormEvent {
    data class EmailChange(val email: String) : LoginFormEvent()
    data class PasswordChange(val password: String) : LoginFormEvent()
    data class TermsChange(var terms: Boolean) : LoginFormEvent()

    object Submit : LoginFormEvent()
}

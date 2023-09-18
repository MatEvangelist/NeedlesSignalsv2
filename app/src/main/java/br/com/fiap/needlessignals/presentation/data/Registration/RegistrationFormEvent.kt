package br.com.fiap.needlessignals.presentation.data.Registration

sealed class RegistrationFormEvent {
    data class FirstNameChange(val firstName: String) : RegistrationFormEvent()
    data class LastNameChange(val lastName: String) : RegistrationFormEvent()
    data class EmailChange(val email: String) : RegistrationFormEvent()
    data class CPFChange(val cpf: String) : RegistrationFormEvent()
    data class PasswordChange(val password: String) : RegistrationFormEvent()
    data class ConfirmPasswordChange(val confirmPassword: String) : RegistrationFormEvent()
    data class TermsChange(var terms: Boolean) : RegistrationFormEvent()
    object Submit : RegistrationFormEvent()
}

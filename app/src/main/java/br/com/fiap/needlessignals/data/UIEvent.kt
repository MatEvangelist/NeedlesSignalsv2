package br.com.fiap.needlessignals.data

sealed class UIEvent {
    data class FirstNameChange(val firstName: String) : UIEvent()
    data class LastNameChange(val lastName: String) : UIEvent()
    data class EmailChange(val email: String) : UIEvent()
    data class CPFChange(val cpf: String) : UIEvent()
    data class PasswordChange(val password: String) : UIEvent()
    data class ConfirmPasswordChange(val confirmPassword: String) : UIEvent()

    object RegisterButtonClicked : UIEvent()
}

package br.com.fiap.needlessignals.data

data class RegistrationUIState(
    var firstName: String = "",
    var lastName: String = "",
    var email : String = "",
    var cpf : String = "",
    var password : String = "",
    var confirmPassword : String = ""
)
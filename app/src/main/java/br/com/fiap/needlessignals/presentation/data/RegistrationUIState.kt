package br.com.fiap.needlessignals.presentation.data


data class RegistrationUIState(
    val firstName: String = "",
    val firstNameError: String? = null,
    val lastName: String = "",
    val lastNameError: String? = null,
    val email : String = "",
    val emailError: String? = null,
    val cpf : String = "",
    val cpfError: String? = null,
    val password : String = "",
    val passwordError: String? = null,
    val confirmPassword : String = "",
    val confirmPasswordError: String? = null,
    var acceptedTerms: Boolean = false,
    val termsError: String? = null
)
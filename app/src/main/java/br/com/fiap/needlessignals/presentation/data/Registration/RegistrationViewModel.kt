package br.com.fiap.needlessignals.presentation.data.Registration

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.fiap.cleanarchformavalidation.domain.use_case.ValidateCpf
import br.com.fiap.cleanarchformavalidation.domain.use_case.ValidateEmail
import br.com.fiap.cleanarchformavalidation.domain.use_case.ValidateFirstName
import br.com.fiap.cleanarchformavalidation.domain.use_case.ValidateLastName
import br.com.fiap.cleanarchformavalidation.domain.use_case.ValidatePassword
import br.com.fiap.cleanarchformavalidation.domain.use_case.ValidateRepeatedPassword
import br.com.fiap.cleanarchformavalidation.domain.use_case.ValidateTerms
import br.com.fiap.needlessignals.presentation.data.RegistrationUIState
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

class RegistrationViewModel(
    private val validateFirstName: ValidateFirstName = ValidateFirstName(),
    private val validateLastName: ValidateLastName = ValidateLastName(),
    private val validateEmail: ValidateEmail = ValidateEmail(),
    private val validateCpf: ValidateCpf = ValidateCpf(),
    private val validatePassword: ValidatePassword = ValidatePassword(),
    private val validateRepeatedPassword: ValidateRepeatedPassword = ValidateRepeatedPassword(),
    private val validateTerms: ValidateTerms = ValidateTerms(),
): ViewModel(
) {
    var state by mutableStateOf(RegistrationUIState())
    private val validationEventChannel = Channel<ValidationEvent>()
    val validationEvents = validationEventChannel.receiveAsFlow()
    fun onEvent(event: RegistrationFormEvent){
        when(event) {
            is RegistrationFormEvent.CPFChange -> {
                state = state.copy(cpf = event.cpf)
            }
            is RegistrationFormEvent.FirstNameChange -> {
                state = state.copy(firstName = event.firstName)
            }
            is RegistrationFormEvent.LastNameChange -> {
                state = state.copy(lastName = event.lastName)
            }
            is RegistrationFormEvent.EmailChange -> {
                state = state.copy(email = event.email)
            }
            is RegistrationFormEvent.PasswordChange -> {
                state = state.copy(password = event.password)
            }
            is RegistrationFormEvent.TermsChange -> {
                state = state.copy(acceptedTerms = event.terms)
            }
            is RegistrationFormEvent.ConfirmPasswordChange -> {
                state = state.copy(confirmPassword = event.confirmPassword)
            }

            is RegistrationFormEvent.Submit -> {
                submitData()
            }
        }
    }

    private fun submitData() {
        val firstNameResult = validateFirstName.execute(state.firstName)
        val lastNameResult = validateLastName.execute(state.lastName)
        val cpfResult = validateCpf.execute(state.cpf)
        val emailResult = validateEmail.execute(state.email)
        val passwordResult = validatePassword.execute(state.password)
        val confirmPasswordResult = validateRepeatedPassword.execute(state.password, state.confirmPassword)
        val termsResult = validateTerms.execute(state.acceptedTerms)

        val hasError = listOf(
            firstNameResult,
            lastNameResult,
            cpfResult,
            emailResult,
            passwordResult,
            confirmPasswordResult,
            termsResult
        ).any { !it.successful }

        if(hasError) {
            state = state.copy(
                firstNameError = firstNameResult.errorMessage,
                lastNameError = lastNameResult.errorMessage,
                emailError = emailResult.errorMessage,
                cpfError =  cpfResult.errorMessage,
                passwordError = passwordResult.errorMessage,
                confirmPasswordError = confirmPasswordResult.errorMessage,

                termsError = termsResult.errorMessage
            )
            return
        }
        viewModelScope.launch {
            validationEventChannel.send(ValidationEvent.Success)
        }
    }
    sealed class ValidationEvent {
        object Success: ValidationEvent()
    }
}

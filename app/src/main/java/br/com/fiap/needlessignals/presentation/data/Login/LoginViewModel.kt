package br.com.fiap.needlessignals.presentation.data.Login

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.fiap.cleanarchformavalidation.domain.use_case.ValidateEmail
import br.com.fiap.cleanarchformavalidation.domain.use_case.ValidatePassword
import br.com.fiap.cleanarchformavalidation.domain.use_case.ValidateTerms
import br.com.fiap.needlessignals.presentation.data.RegistrationUIState
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

class LoginViewModel(
    private val validateEmail: ValidateEmail = ValidateEmail(),
    private val validatePassword: ValidatePassword = ValidatePassword(),
    private val validateTerms: ValidateTerms = ValidateTerms()
): ViewModel(
) {
    var state by mutableStateOf(RegistrationUIState())
    private val validationEventChannel = Channel<ValidationEvent>()
    val validationEvents = validationEventChannel.receiveAsFlow()
    fun onEvent(event: LoginFormEvent){
        when(event) {
            is LoginFormEvent.EmailChange -> {
                state = state.copy(email = event.email)
            }
            is LoginFormEvent.PasswordChange -> {
                state = state.copy(password = event.password)
            }
            is LoginFormEvent.TermsChange -> {
                state = state.copy(acceptedTerms = event.terms)
            }

            is LoginFormEvent.Submit -> {
                submitData()
            }
        }
    }

    private fun submitData() {
        val emailResult = validateEmail.execute(state.email)
        val passwordResult = validatePassword.execute(state.password)

        val hasError = listOf(
            emailResult,
            passwordResult,
        ).any { !it.successful }

        if(hasError) {
            state = state.copy(
                emailError = emailResult.errorMessage,
                passwordError = passwordResult.errorMessage,
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

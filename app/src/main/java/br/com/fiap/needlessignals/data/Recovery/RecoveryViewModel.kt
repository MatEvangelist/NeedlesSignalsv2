package br.com.fiap.needlessignals.data.Recovery

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.fiap.cleanarchformavalidation.domain.use_case.ValidateEmail
import br.com.fiap.cleanarchformavalidation.domain.use_case.ValidatePassword
import br.com.fiap.cleanarchformavalidation.domain.use_case.ValidateTerms
import br.com.fiap.needlessignals.data.RegistrationUIState
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

class RecoveryViewModel(
    private val validateEmail: ValidateEmail = ValidateEmail(),
): ViewModel(
) {
    var state by mutableStateOf(RegistrationUIState())
    private val validationEventChannel = Channel<ValidationEvent>()
    val validationEvents = validationEventChannel.receiveAsFlow()
    fun onEvent(event: RecoveryFormEvent){
        when(event) {
            is RecoveryFormEvent.EmailChange -> {
                state = state.copy(email = event.email)
            }

            is RecoveryFormEvent.Submit -> {
                submitData()
            }
        }
    }

    private fun submitData() {
        val emailResult = validateEmail.execute(state.email)

        val hasError = listOf(
            emailResult,
        ).any { !it.successful }

        if(hasError) {
            state = state.copy(
                emailError = emailResult.errorMessage,
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

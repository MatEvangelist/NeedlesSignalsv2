package br.com.fiap.needlessignals.presentation.data.Recovery

sealed class RecoveryFormEvent {
    data class EmailChange(val email: String) : RecoveryFormEvent()
    object Submit : RecoveryFormEvent()
}

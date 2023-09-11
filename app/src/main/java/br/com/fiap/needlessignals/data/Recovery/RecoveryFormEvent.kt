package br.com.fiap.needlessignals.data.Recovery

sealed class RecoveryFormEvent {
    data class EmailChange(val email: String) : RecoveryFormEvent()
    object Submit : RecoveryFormEvent()
}

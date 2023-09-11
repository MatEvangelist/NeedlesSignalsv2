package br.com.fiap.cleanarchformavalidation.domain.use_case

import android.util.Patterns

class ValidateCpf {
    fun execute(cpf: String): ValidationResult {
        if(cpf.isBlank()) {
            return ValidationResult(
                successful = false,
                errorMessage = "The CPF can't be blank"
            )
        }

        return ValidationResult(
            successful = true
        )
    }
}
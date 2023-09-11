package br.com.fiap.cleanarchformavalidation.domain.use_case

import android.util.Patterns

class ValidateLastName {
    fun execute(lastName: String): ValidationResult {
        if(lastName.length < 3) {
            return ValidationResult(
                successful = false,
                errorMessage = "The Last Name needs to consist of at least 3 characters"
            )
        }

        if(lastName.isBlank()) {
            return ValidationResult(
                successful = false,
                errorMessage = "The Last Name can't be blank"
            )
        }

        return ValidationResult(
            successful = true
        )
    }
}
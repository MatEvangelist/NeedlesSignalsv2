package br.com.fiap.cleanarchformavalidation.domain.use_case

import android.util.Patterns

class ValidateFirstName {
    fun execute(firstName: String): ValidationResult {
        if(firstName.length < 4) {
            return ValidationResult(
                successful = false,
                errorMessage = "The First Name needs to consist of at least 3 characters"
            )
        }

        if(firstName.isBlank()) {
            return ValidationResult(
                successful = false,
                errorMessage = "The firstName can't be blank"
            )
        }

        return ValidationResult(
            successful = true
        )
    }
}
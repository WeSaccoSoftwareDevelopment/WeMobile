package com.mobilewe.wemobile.domain.validation

class ValidatePassword {
    fun execute(password: String, confirmPassword: String): PasswordValidationState {
        val validateSpecialCharacter = validateSpecialCharacter(password)
        val validateCapitalizedLetter = validateCapitalizedLetter(password)
        val validateMinimum = validateMinimum(password)
        val validatePasswordMatch = password == confirmPassword // Check password confirmation match

        val hasError = listOf(
            validateCapitalizedLetter,
            validateSpecialCharacter,
            validateMinimum,
            validatePasswordMatch
        ).all { it }

        return PasswordValidationState(
            hasMinimum = validateMinimum,
            hasSpecialCharacter = validateSpecialCharacter,
            hasCapitalizedLetter = validateCapitalizedLetter,
            hasPasswordMatch = validatePasswordMatch,
            successful = hasError
        )
    }

    private fun validateSpecialCharacter(password: String): Boolean {
        // Use .* before and after the regex to allow special characters to appear anywhere
        return password.matches(Regex(".*[!@#\$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?].*"))
    }

    private fun validateCapitalizedLetter(password: String): Boolean {
        // Use .* before and after the regex to allow capitalized letters to appear anywhere
        return password.matches(Regex(".*[A-Z].*"))
    }

    private fun validateMinimum(password: String): Boolean =
        password.length >= 8
}

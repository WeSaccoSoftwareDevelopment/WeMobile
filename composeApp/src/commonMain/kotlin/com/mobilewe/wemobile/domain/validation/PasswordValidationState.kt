package com.mobilewe.wemobile.domain.validation


data class PasswordValidationState(
    val hasMinimum: Boolean = false,
    val hasCapitalizedLetter: Boolean = false,
    val hasSpecialCharacter: Boolean = false,
    val hasPasswordMatch: Boolean = false,
    val successful: Boolean = false
)
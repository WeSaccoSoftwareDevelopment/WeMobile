package com.mobilewe.wemobile.presentation.screen.auth.register.registrationSubmit

import com.mobilewe.wemobile.domain.model.UserAccount

data class RegistrationSubmitUIState(
    val password: String = "",
    val confirmPassword: String = "",
    val showSnackbar: Boolean = false,
    val isPasswordError: Boolean = false,
    val isConfirmPasswordError: Boolean = false,
    val isLoading: Boolean = false,
    val languageCode: String = "us",
    val snackbarMessage: String = "",
    val userAccount: UserAccount? = null
)

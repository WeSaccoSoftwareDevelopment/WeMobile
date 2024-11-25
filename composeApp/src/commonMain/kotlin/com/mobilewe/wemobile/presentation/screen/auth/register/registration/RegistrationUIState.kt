package com.mobilewe.wemobile.presentation.screen.auth.register.registration

data class RegistrationUIState(
    val fullName: String = "",
    val email: String = "",
    val password: String = "",
    val isLoading: Boolean = false,
    val isUsernameError: Boolean = false,
    val isEmailError: Boolean = false,
    val isPasswordError: Boolean = false,
    val snackbarMessage: String = "",
    val showSnackbar: Boolean = false,
    val idNumber: String = "",
    val address: String = "",
    val kraPin: String = "",
    val customerLevel: Int = 0,
    val gender: Int  = 0,
    val errorMessage: String? = null,
    val isFullNameError: Boolean = false,
    val isPhoneError: Boolean = false,
    val isAddressError: Boolean = false,
    val languageCode: String = "ke",
    val phoneNumber: String = ""
)

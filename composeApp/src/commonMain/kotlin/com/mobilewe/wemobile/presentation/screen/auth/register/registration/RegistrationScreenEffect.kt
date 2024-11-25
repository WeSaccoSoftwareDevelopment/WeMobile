package com.mobilewe.wemobile.presentation.screen.auth.register.registration

sealed interface RegistrationScreenEffect {
    data class NavigateToSubmitRegistrationScreen(
        val phoneNumber: String,
        val email: String,
        val idNumber: String,
        val address: String,
        val fullName: String
    ) : RegistrationScreenEffect

    data object NavigateBack : RegistrationScreenEffect
}

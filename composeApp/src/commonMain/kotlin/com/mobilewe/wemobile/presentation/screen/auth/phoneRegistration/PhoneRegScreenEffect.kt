package com.mobilewe.wemobile.presentation.screen.auth.phoneRegistration

sealed interface PhoneRegScreenEffect {
    data class NavigateToSubmitRegistrationScreen(
        val phoneNumber: String,
    ) : PhoneRegScreenEffect

    data object NavigateBack : PhoneRegScreenEffect
}

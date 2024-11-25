package com.mobilewe.wemobile.presentation.screen.auth.register.registrationSubmit

sealed interface RegistrationSubmitScreenEffect {
    data object NavigateToLoginScreen : RegistrationSubmitScreenEffect
    data object NavigateBack : RegistrationSubmitScreenEffect
}

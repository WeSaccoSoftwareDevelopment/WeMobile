package com.mobilewe.wemobile.presentation.screen.auth.login

sealed class LoginScreenUIEffect {
    data object NavigateToHome : LoginScreenUIEffect()
}

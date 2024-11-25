package com.mobilewe.wemobile.presentation.screen.account.security


data class SecurityState(
    val rememberMe: Boolean = false,
    val biometricId: Boolean = false,
    val faceId: Boolean = false,
    val smsAuthenticator: Boolean = false,
    val googleAuthenticator: Boolean = false,
)
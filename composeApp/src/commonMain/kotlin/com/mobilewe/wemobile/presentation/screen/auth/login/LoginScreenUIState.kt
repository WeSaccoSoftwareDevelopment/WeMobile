package com.mobilewe.wemobile.presentation.screen.auth.login

import com.mobilewe.wemobile.domain.model.LoginRequest

data class LoginScreenUIState(
    val username: String = "",
    val password: String = "",
    val keepLoggedIn: Boolean = false,
    val isUsernameError: Boolean = false,
    val isPasswordError: Boolean = false,
    val snackbarMessage: String = "",
    val showSnackbar: Boolean = false,
    val isLoading:Boolean = false,
    val error: String? = null,
    val data: LoginRequest? = null,
    val isPasswordVisible: Boolean = false,
    val isLoggedIn: Boolean = false,
    val authenticationSucceed: Boolean = false,
)

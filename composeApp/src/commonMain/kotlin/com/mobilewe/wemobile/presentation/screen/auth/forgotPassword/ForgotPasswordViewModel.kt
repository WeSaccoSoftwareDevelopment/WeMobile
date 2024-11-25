package com.mobilewe.wemobile.presentation.screen.auth.forgotPassword

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import com.mobilewe.wemobile.presentation.screen.auth.forgotPassword.ForgotPasswordUiState

class ForgotPasswordViewModel: ViewModel(){
    private val  _forgotPasswordUiState = MutableStateFlow(ForgotPasswordUiState())
    val forgotPasswordUiState = _forgotPasswordUiState.asStateFlow()

    fun onEmailChanged(email: String){
        _forgotPasswordUiState.update { it.copy( email = email) }
    }

    fun onPhoneNumberChanged(phoneNumber: String){
        _forgotPasswordUiState.update { it.copy( phoneNumber = phoneNumber) }
    }
}
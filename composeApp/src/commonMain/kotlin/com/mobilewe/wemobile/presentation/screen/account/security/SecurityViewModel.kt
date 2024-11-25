package com.mobilewe.wemobile.presentation.screen.account.security

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class SecurityViewModel (

): ViewModel() {
    private val _securityState = MutableStateFlow(SecurityState())
    val securityState get() = _securityState.asStateFlow()

    fun onBiometric(isChecked: Boolean) {
        _securityState.update {
            securityState.value.copy(biometricId = isChecked)
        }
    }

    fun onRememberMe(isChecked: Boolean) {
        _securityState.update {
            securityState.value.copy(rememberMe = isChecked)
        }
    }
    fun onFaceId(isChecked: Boolean) {
        _securityState.update {
            securityState.value.copy(faceId = isChecked)
        }
    }
    fun onSmsAuthenticator(isChecked: Boolean) {
        _securityState.update {
            securityState.value.copy(smsAuthenticator = isChecked)
        }
    }
    fun onGoogleAuthenticator(isChecked: Boolean) {
        _securityState.update {
            securityState.value.copy(googleAuthenticator = isChecked)
        }
    }


    private val _shouldShowBiometricDialog = mutableStateOf(false)
    val shouldShowBiometricDialog: State<Boolean> = _shouldShowBiometricDialog
    fun setShowBiometricDialogState(value: Boolean) {
        _shouldShowBiometricDialog.value = value
    }

    private val _shouldShowBiometricSuccessDialog = mutableStateOf(false)
    val shouldShowBiometricSuccessDialog: State<Boolean> = _shouldShowBiometricSuccessDialog
    fun setShowBiometricSuccessDialogState(value: Boolean) {
        _shouldShowBiometricSuccessDialog.value = value
    }


    init {
        getBiometric()
    }


    @OptIn(InternalCoroutinesApi::class)
    private fun getBiometric() {
        viewModelScope.launch {
            /* biometricUseCase.execute().collect { isBiometricEnabled ->
                 if (isBiometricEnabled != null) {
                     _uiState.update { it.copy(isBiometricEnabled  = isBiometricEnabled) }
                 }
             }*/
        }
    }


}
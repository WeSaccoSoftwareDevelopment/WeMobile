package com.mobilewe.wemobile.presentation.screen.account.resetPassword


import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.mobilewe.wemobile.domain.validation.PasswordValidationState
import com.mobilewe.wemobile.domain.validation.ValidatePassword
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class ResetPasswordViewModel : ViewModel() {
    private val _passwordValidation = MutableStateFlow(PasswordValidationState())
    val passwordValidation: StateFlow<PasswordValidationState> = _passwordValidation.asStateFlow()
    private val validatePassword = ValidatePassword()

    private val _passwordText = mutableStateOf("")
    val passwordText: State<String> = _passwordText



    private val _confirmPasswordText = mutableStateOf("")
    val confirmPasswordText: State<String> = _confirmPasswordText

    private val _showPassword = mutableStateOf(false)
    val showPassword: State<Boolean> = _showPassword

    private val _showConfirmPassword = mutableStateOf(false)
    val showConfirmPassword: State<Boolean> = _showConfirmPassword


     private val _passwordError = mutableStateOf("")
     val passwordError: State<String> = _passwordError

    private val _confirmPasswordError = mutableStateOf("")
    val confirmPasswordError: State<String> = _confirmPasswordError





    fun setPasswordText(password: String) {
        _passwordText.value = password
    }

    fun setIsPasswordError(error: String) {
         _passwordError.value = error
     }

    fun setShowPassword(showPassword: Boolean) {
        _showPassword.value = showPassword
    }

    fun setShowConfirmPassword(showConfirmPassword: Boolean) {
        _showConfirmPassword.value = showConfirmPassword
    }
}
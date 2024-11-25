package com.mobilewe.wemobile.presentation.screen.account.resetPin


import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import com.mobilewe.wemobile.presentation.common.base.BaseScreenModel

class ResetPinViewModel : BaseScreenModel<ResetPinScreenUIState, ResetPinScreenUIEffect>(
    ResetPinScreenUIState()
),
    ResetPinScreenInteractionListener {


    private val _passwordError = mutableStateOf("")
    val passwordError: State<String> = _passwordError

    private val _confirmPasswordError = mutableStateOf("")
    val confirmPasswordError: State<String> = _confirmPasswordError



    fun setShowCurrentPin(showCurrentPin: Boolean) {
        updateState { it.copy( showCurrentPin = showCurrentPin) }
    }

    fun setShowNewPin(showNewPin: Boolean) {
        updateState { it.copy( showNewPin = showNewPin) }
    }

    fun showConfirmPin(showConfirmPin: Boolean) {
        updateState { it.copy( showConfirmPin = showConfirmPin) }
    }

    override fun onNewPinChanged(newPin: String) {
        updateState { it.copy( newPin = newPin) }
    }

    override fun onConfirmPinChanged(confirmPin: String) {
        updateState { it.copy( confirmPin = confirmPin) }
    }
}
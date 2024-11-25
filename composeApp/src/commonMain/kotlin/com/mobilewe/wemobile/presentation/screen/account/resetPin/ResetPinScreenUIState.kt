package com.mobilewe.wemobile.presentation.screen.account.resetPin

import androidx.compose.ui.graphics.drawscope.Stroke

data class ResetPinScreenUIState(
    val currentPin: String = "",
    val newPin: String = "",
    val confirmPin: String = "",
    val error: String = "",
    val showCurrentPin: Boolean = false,
    val showNewPin: Boolean = false,
    val showConfirmPin: Boolean = false,
)

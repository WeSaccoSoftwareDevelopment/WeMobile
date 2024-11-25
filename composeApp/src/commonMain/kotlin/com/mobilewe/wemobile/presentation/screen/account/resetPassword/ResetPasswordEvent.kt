package com.mobilewe.wemobile.presentation.screen.account.resetPassword


sealed interface ResetPasswordEvent{
    data class OnCurrentPasswordChanged(val currentPassword: String): ResetPasswordEvent
    data class OnNewPasswordChanged(val newPassword: String): ResetPasswordEvent
    data class OnConfirmNewPasswordChanged(val confirmNewPassword: String): ResetPasswordEvent
}
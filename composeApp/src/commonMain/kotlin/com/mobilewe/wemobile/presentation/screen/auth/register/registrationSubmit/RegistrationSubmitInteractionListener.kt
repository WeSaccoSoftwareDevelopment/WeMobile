package com.mobilewe.wemobile.presentation.screen.auth.register.registrationSubmit

import com.mobilewe.wemobile.domain.model.UserAccount
import com.mobilewe.wemobile.presentation.common.base.BaseInteractionListener

interface RegistrationSubmitInteractionListener : BaseInteractionListener {
    fun onConfirmPasswordChanged(confirmPassword: String)
    fun onPasswordChanged(password: String)
    fun onSignUpButtonClicked(userAccount: UserAccount)
    fun onBackButtonClicked()
    fun onDismissSnackBar()
}
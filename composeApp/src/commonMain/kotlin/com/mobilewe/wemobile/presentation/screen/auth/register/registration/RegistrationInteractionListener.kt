package com.mobilewe.wemobile.presentation.screen.auth.register.registration

import com.mobilewe.wemobile.presentation.common.base.BaseInteractionListener

interface RegistrationInteractionListener : BaseInteractionListener {
    fun onEmailChanged(email: String)

    fun onAddressChanged(address: String)
    fun onIdNumberChanged(idNumber: String)

    fun onFullNameChanged(fullName: String)
    fun onNextButtonClicked()
    fun onBackButtonClicked()
}
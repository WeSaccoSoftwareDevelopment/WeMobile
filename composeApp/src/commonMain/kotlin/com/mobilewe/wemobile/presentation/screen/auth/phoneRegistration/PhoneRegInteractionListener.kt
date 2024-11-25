package com.mobilewe.wemobile.presentation.screen.auth.phoneRegistration

import com.mobilewe.wemobile.presentation.common.base.BaseInteractionListener
import com.mobilewe.wemobile.presentation.screen.auth.country.Country

interface PhoneRegInteractionListener : BaseInteractionListener {
    fun onCountrySelected(country: Country)
    fun onPhoneNumberChanged(phoneNumber: String)
    fun onCountryNameChanged(countryFullName: String)
    fun onNextButtonClicked()
    fun onBackButtonClicked()
}
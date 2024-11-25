package com.mobilewe.wemobile.presentation.screen.auth.phoneRegistration

import com.mobilewe.wemobile.presentation.screen.auth.country.Country

data class PhoneRegUiState(
    val countryNameCode: String = "",
    val countryFullName: String = "",
    val countryCode: String = "",
    val phoneNumber: String = "",
    val isActive: Boolean = true,
    val isPhoneVerified :Boolean = true,
    val country: Country? = null,
    val isPhoneError: Boolean = false,
    val errorMessage: String? = null,
    val isLoading: Boolean = false

){
    val  isCountryCodeAndPhoneValid: Boolean
        get() = countryCode.isNotEmpty() && countryFullName.isNotEmpty() && phoneNumber.length.equals(10) && phoneNumber.isNotEmpty()
}

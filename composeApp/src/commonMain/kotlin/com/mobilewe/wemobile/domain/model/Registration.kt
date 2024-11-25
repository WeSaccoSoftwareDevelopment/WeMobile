package com.mobilewe.wemobile.domain.model

data class Registration(
    val address: String,
    val countryCode: String,
    val customerLevel: Int,
    val email: String,
    val fullName: String,
    val gender: Int,
    val idNumber: String,
    val isActive: Boolean,
    val isPhoneVerified: Boolean,
    val kraPin: String,
    val password: String,
    val phoneNumber: String
)

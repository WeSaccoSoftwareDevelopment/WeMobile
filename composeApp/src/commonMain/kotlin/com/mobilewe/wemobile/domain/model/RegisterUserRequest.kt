package com.mobilewe.wemobile.domain.model

// Assume you have a data class representing the user registration data
data class RegisterUserRequest(
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

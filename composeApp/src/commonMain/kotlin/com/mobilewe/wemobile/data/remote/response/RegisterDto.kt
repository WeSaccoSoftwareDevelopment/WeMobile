package com.mobilewe.wemobile.data.remote.response

import kotlinx.serialization.Serializable

@Serializable
data class RegisterDto(
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
package com.mobilewe.wemobile.data.remote.response

import kotlinx.serialization.Serializable

@Serializable
data class UserLoginDto(
    val email: String,
    val password: String,
)

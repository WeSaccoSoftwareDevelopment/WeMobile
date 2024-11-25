package com.mobilewe.wemobile.data.remote.mapper

import com.mobilewe.wemobile.domain.model.*
import com.mobilewe.wemobile.data.remote.response.UserRegistrationDto


fun UserAccount.toUserRegistrationDto(): UserRegistrationDto {
    return UserRegistrationDto(
        fullName = fullName,
        username = username,
        password = password,
        email = email,
        phone = phone,
        address = address
    )
}
package com.mobilewe.wemobile.data.remote.mapper

import com.mobilewe.wemobile.data.remote.response.UserDetailsDto
import com.mobilewe.wemobile.domain.model.*
import org.saccowemobile.wemobile.domain.model.Wallet


fun UserDetailsDto.toEntity() = User(
    id = id ?: "",
    country = fullName ?: "",
    email = email ?: "",
    fullName = fullName ?: "",
    permission = permission ?: 1,
    username = username ?: "",
    wallet = Wallet(walletBalance ?: 0.0, currency ?: ""),
    addresses = addresses?.filterNotNull()?.map { it.toEntity() } ?: emptyList(),
    phoneNumber = phoneNumber ?: ""
)




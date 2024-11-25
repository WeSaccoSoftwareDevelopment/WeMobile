package com.mobilewe.wemobile.data.remote.mapper

import com.mobilewe.wemobile.data.remote.response.AddressDto
import com.mobilewe.wemobile.domain.model.Address


fun AddressDto.toEntity(): Address {
    return Address(
        id = id ?: "",
        locationDto = location?.toEntity(),
        address = address ?: "",
    )
}

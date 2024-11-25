package com.mobilewe.wemobile.data.remote.mapper

import com.mobilewe.wemobile.data.remote.response.LocationDto
import com.mobilewe.wemobile.domain.model.Location

fun LocationDto.toEntity() = Location(latitude = latitude ?: 0.0, longitude = longitude ?: 0.0)
package com.mobilewe.wemobile.data.remote.mapper

import com.mobilewe.wemobile.data.remote.response.SessionDto
import com.mobilewe.wemobile.domain.model.Session


fun SessionDto.toSessionEntity() = Session(
    accessToken = accessToken,
    refreshToken = refreshToken,
    accessTokenExpirationDate = accessTokenExpirationDate,
    refreshTokenExpirationDate = refreshTokenExpirationDate,
)
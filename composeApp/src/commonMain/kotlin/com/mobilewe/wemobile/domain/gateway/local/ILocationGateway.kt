package com.mobilewe.wemobile.domain.gateway.local

import com.mobilewe.wemobile.domain.model.Location
import kotlinx.coroutines.flow.Flow

interface ILocationGateway {
    suspend fun startTracking()
    suspend fun getCurrentLocation(): Flow<Location>
    suspend fun stopTracking()
}
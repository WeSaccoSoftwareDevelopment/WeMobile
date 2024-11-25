package com.mobilewe.wemobile.data.gateway.service

interface ILocationService {
    fun isDeviceLocationEnabled(): Boolean
    fun openLocationSettings()
}
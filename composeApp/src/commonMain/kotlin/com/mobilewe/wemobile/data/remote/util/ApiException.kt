package com.mobilewe.wemobile.data.remote.util

class ApiException(
    val statusCode: Int = 0,
    val statusMessage: String
) : Throwable(statusMessage)
package com.mobilewe.wemobile.domain.model


data class Address(
    val id: String,
    val address: String,
    val locationDto: Location? = null,
)

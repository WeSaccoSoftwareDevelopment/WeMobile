package com.mobilewe.wemobile.domain.model

data class Time(
    val hours: Int,
    val minutes: Int
) {
    init {
        require(hours in 0..23)
        require(minutes in 0..59)
    }
}
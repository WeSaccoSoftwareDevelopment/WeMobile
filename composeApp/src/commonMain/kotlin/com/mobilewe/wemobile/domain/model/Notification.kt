package com.mobilewe.wemobile.domain.model

import kotlinx.datetime.LocalDate
import com.mobilewe.wemobile.domain.model.Time

data class Notification(
    val id: String,
    val title: String,
    val body: String,
    val date: LocalDate,
    val time: Time,
    val userId: String,
    val topic: String,
)
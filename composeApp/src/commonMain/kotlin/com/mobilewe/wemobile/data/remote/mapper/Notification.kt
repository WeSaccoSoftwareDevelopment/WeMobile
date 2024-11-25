package com.mobilewe.wemobile.data.remote.mapper

import com.mobilewe.wemobile.data.remote.response.NotificationDto
import com.mobilewe.wemobile.domain.model.Notification

fun NotificationDto.toEntity(): Notification {
    return Notification(
        id = id ?: "",
        title = title,
        body = body,
        date = date.toDate(),
        time = date.toTime(),
        userId = userId ?: "",
        topic = topic ?: "",
    )
}
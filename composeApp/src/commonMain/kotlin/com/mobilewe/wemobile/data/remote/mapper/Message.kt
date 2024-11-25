package com.mobilewe.wemobile.data.remote.mapper

import com.mobilewe.wemobile.data.remote.response.MessageDto
import com.mobilewe.wemobile.domain.model.Message
import kotlin.random.Random


fun MessageDto.toEntity(): Message {
    return Message(
        id = id ?: "",
        ticketId = ticketId ?: "",
        message = message ?: "",
        avatarUrl = senderAvatar ?: "",
        isMe = senderId == "1",
        senderId = senderId ?: ""
    )
}

fun List<MessageDto>.toEntity(): List<Message> {
    return map { it.toEntity() }
}

fun Message.toDto(): MessageDto {
    return MessageDto(
        id = Random.nextInt(0, 1000000).toString(),
        ticketId = ticketId,
        message = message,
        senderId = senderId,
    )
}
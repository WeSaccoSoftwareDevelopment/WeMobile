package com.mobilewe.wemobile.domain.model

data class Message(
    val id: String,
    val ticketId: String,
    val senderId: String,
    val message: String,
    val isMe: Boolean,
    val avatarUrl: String,
)
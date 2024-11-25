package com.mobilewe.wemobile.domain.model

data class PhoneCallLogs(
    val callId: String,
    val phoneId: String,
    val phoneNumber: String,
    val callType: Int,
    val callDuration: String,
    val callDate: String,
    val callTime: String,
    val sim: String,
    val simDisplayName: String

)


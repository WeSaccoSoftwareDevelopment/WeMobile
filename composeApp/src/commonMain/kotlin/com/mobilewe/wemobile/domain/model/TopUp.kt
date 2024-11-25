package com.mobilewe.wemobile.domain.model


data class TopUp(
    val topUpId: String = "",
    val accountId: String = "",
    val isForSelf: Boolean = false,
    val phoneNumber: String? = "",
    val topUpDate: String? = "",
    val amount: Double? = 0.0,
    val provider: MobileServiceProvider? = null,
    val time: String? = null

    )

enum class MobileServiceProvider(val providerName: String) {
    SAFARICOM("Safaricom"),
    AIRTEL("Artel"),
    TELKOM("Telkom"),
    EQUITEL("Equitel"),
    // Add more providers as needed
}
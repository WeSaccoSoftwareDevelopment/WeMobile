package com.mobilewe.wemobile.domain.model


data class SendMoney(
    val transactionId: String = "",
    val senderAccountId: String,
    val recipientPhoneNumber: String,
    val amount: Double = 0.0,
    val provider: RecipientProvider = RecipientProvider.Mpesa,
    val transactionDate: String
)

enum class PaymentServiceProvider(val providerName: String) {
    MPESA("MPESA"),
    AIRTEL_MONEY("AIRTEL MONEY"),
    TKASH("TKASH"),
}

val sendMoneyDetails = listOf(
    SendMoney(
        recipientPhoneNumber = "",
        amount = 0.0,
        transactionDate = "",
        transactionId =  "1",
        provider = RecipientProvider.Mpesa,
        senderAccountId = AccountTypeName.FOSA.accountName
    ),
)

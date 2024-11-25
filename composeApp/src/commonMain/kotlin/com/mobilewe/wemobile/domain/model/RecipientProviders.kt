package com.mobilewe.wemobile.domain.model

enum class WithdrawRecipientProviders(val recipientProviders: String) {
    MPESA("Mpesa"),
    AIRTELMONEY("Airtel Money")
}

enum class BuyAirtimeProviders(val buyAirtime: String){
    SAFARICOM("Safaricom"),
    AIRTEL("Airtel")
}

val recipientProvider = listOf(
    RecipientProvider.Mpesa,
    RecipientProvider.AirtelMoney
)

enum class RecipientProvider(val icon: String, val providerName: String) {
    Mpesa("", "M-PESA"),
    AirtelMoney("", "AirtelMoney"),
    Tkash("", "Tkash"),
}
package com.mobilewe.wemobile.domain.model



data class PayBill(
    val transactionId: String = "",
    val businessName: String = "",
    val businessNumber: String = "",
    val accountNumber: String = "",
    val logoUrl: String? = null,
    val amount: Double? = 0.0,
    val transactionDate: String? = "",
)


val payBillItems = listOf(
    PayBill(
        businessName = "Equity Paybill Account",
        businessNumber = "247247",
    ),
    PayBill(
        businessName = "KCB Paybill Account",
        businessNumber = "522522",
        logoUrl = null,
    ),
    PayBill(
        businessName = "Co-operative Bank Collection Account",
        businessNumber = "400222",
        logoUrl = null,
    ),
    PayBill(
        businessName = "KPLC PREPAID",
        businessNumber = "888880",
        logoUrl = null,
    ),
    PayBill(
        businessName = "ENA INVESTMENTS LIMITED",
        businessNumber = "181893",
        logoUrl = null,
    )
)
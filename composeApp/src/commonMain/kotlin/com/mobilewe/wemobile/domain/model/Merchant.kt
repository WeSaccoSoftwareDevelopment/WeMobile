package com.mobilewe.wemobile.domain.model



data class Merchant(
    val tillName: String = "",
    val tillNumber: String = "",
    val amount: Double = 0.0,
    val transactionDate: String? = null,
    val logoUrl: String? = null,
    val merchantId: String =  "",

    )

fun getTillNumber():List<Merchant> = listOf(
    Merchant(
        "Mwambuka Nsoto",
        "123456",
        200.00,
        "12 June, 2022"
    ),
    Merchant(
        "Mwambuka Nsoto",
        "123456",
        200.00,
        "12 June, 2022"
    ),
    Merchant(
        "Mwambuka",
        "123456",
        200.00,
        "12 June, 2022"
    )
)
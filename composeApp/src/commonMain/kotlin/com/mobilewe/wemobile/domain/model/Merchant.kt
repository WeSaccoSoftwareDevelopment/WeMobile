package com.mobilewe.wemobile.domain.model

import kotlinx.serialization.Serializable


@Serializable
data class Merchant(
    val tillName: String = "",
    val tillNumber: String = "",
    val amount: String = "",
    val transactionDate: String? = null,
    val logoUrl: String? = null,
    val merchantId: String =  "",

    )

fun getTillNumber():List<Merchant> = listOf(
    Merchant(
        "Mwambuka Nsoto",
        "123456",
        "12 June, 2022"
    ),
    Merchant(
        "Mwambuka Nsoto",
        "123456",
        "12 June, 2022"
    ),
    Merchant(
        "Mwambuka",
        "123456",
        "12 June, 2022"
    )
)
package com.mobilewe.wemobile.domain.model

data class Bank(
    val bankName: String,
    val bankImageUrl: String? = null,
    val bankAccountNumber: String = ""
)
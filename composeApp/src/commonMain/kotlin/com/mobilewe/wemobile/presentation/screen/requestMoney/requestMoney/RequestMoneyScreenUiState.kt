package com.mobilewe.wemobile.presentation.screen.requestMoney.requestMoney

import androidx.compose.material.ExperimentalMaterialApi
import com.mobilewe.wemobile.domain.model.RecipientProvider

@OptIn(ExperimentalMaterialApi::class)
data class RequestMoneyScreenUiState(
    val expanded: Boolean = false,
    val phoneNumber: String = "",
    val amount: String = "",
    val recipientProvider: RecipientProvider = RecipientProvider.Mpesa,
    val accountTypeName: String = ""
)
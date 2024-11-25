package com.mobilewe.wemobile.presentation.screen.sendMoney.sendMoneyConfirmation

import com.mobilewe.wemobile.domain.model.RecipientProvider
import com.mobilewe.wemobile.domain.model.SendMoney

data class SendMoneyConfirmUiState(
    val sendMoney: List<SendMoney> = emptyList(),
    val transactionId: String = "",
    val recipientProvider: RecipientProvider = RecipientProvider.Mpesa
)

package com.mobilewe.wemobile.presentation.screen.requestMoney.requestMoneyConfirmation

import com.mobilewe.wemobile.domain.model.SendMoney

data class RequestMoneyConfirmUiState(
    val requestMoney: List<SendMoney> = emptyList()
)

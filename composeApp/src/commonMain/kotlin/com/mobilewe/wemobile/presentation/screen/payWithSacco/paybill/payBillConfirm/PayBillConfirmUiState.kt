package com.mobilewe.wemobile.presentation.screen.payWithSacco.paybill.payBillConfirm

import com.mobilewe.wemobile.domain.model.PayBill

data class PayBillConfirmUiState(
    val payBill: List<PayBill> = emptyList()
)

package com.mobilewe.wemobile.presentation.screen.payWithSacco.wesacco

import com.mobilewe.wemobile.domain.model.AccountTypeName
import com.mobilewe.wemobile.domain.model.PayBill

data class WePayBillScreenUiState(
    val businessName: String = "",
    val businessNumber: String = "",
    val accountName: String = "",
    val accountNumber: String = "",
    val amount: String = "",
    val searchParams: String = "",
    val payBillList: List<PayBill> = emptyList(),
    val isLoading: Boolean = false,
    val error: String = "",
    val isBusinessNoError: Boolean = false,
    val isAccountNoError: Boolean = false,
    val errorMessage: String? = null,
    val selectedPayBill: PayBill? = null,
    val accountTypeName: AccountTypeName = AccountTypeName.FOSA


) {
    private val isAmountValid: Boolean
        get() = amount.replace("-", "").trim().isNotEmpty() && amount.trim()
            .toIntOrNull() != null && amount.trim().toInt() in 1..299999
    private val areDetailsFilled: Boolean
        get() = accountNumber.trim().isNotEmpty() || businessNumber.trim().isNotEmpty() as Boolean
    val isPayBillEnabled = isAmountValid && areDetailsFilled
}
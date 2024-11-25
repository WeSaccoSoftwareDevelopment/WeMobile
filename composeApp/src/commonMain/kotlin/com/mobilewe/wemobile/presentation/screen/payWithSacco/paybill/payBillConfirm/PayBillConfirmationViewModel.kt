package com.mobilewe.wemobile.presentation.screen.payWithSacco.paybill.payBillConfirm

import androidx.lifecycle.ViewModel
import com.mobilewe.wemobile.domain.model.PayBill
import com.mobilewe.wemobile.domain.model.payBillItems
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class PayBillConfirmationViewModel : ViewModel() {
    private val _payBillUiState = MutableStateFlow(PayBillConfirmUiState())
    val uiState = _payBillUiState.asStateFlow()

    fun getPayBillById(id: String): PayBill {
        return payBillItems.first { it.transactionId == id }
    }


}

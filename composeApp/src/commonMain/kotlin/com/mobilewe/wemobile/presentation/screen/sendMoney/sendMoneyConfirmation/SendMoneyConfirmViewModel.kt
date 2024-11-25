package com.mobilewe.wemobile.presentation.screen.sendMoney.sendMoneyConfirmation

import androidx.lifecycle.ViewModel
import com.mobilewe.wemobile.domain.model.PayBill
import com.mobilewe.wemobile.domain.model.SendMoney
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class SendMoneyConfirmViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(SendMoneyConfirmUiState())
    val uiState = _uiState.asStateFlow()

    private var sendMoneyLists = mutableListOf<SendMoney>()


    private var initialPayBills = listOf<PayBill>()
    private var initialSendMoney = listOf<SendMoney>()



    fun getTransaction(transactionId: String): SendMoney {
        return sendMoneyLists.find { it.transactionId == transactionId }?: SendMoney(
            recipientPhoneNumber = "",
            amount = 0.0,
            transactionDate = "getCurrentDateTime()",
            transactionId =  "",
            provider = uiState.value.recipientProvider,
            senderAccountId = ""
        )

    }

    fun setSendMoney(sendMoney: SendMoney){
        sendMoneyLists.add(sendMoney)
    }


}
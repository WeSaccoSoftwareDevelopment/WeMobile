package com.mobilewe.wemobile.presentation.screen.payWithSacco.buyGoods

import com.mobilewe.wemobile.domain.model.AccountTypeName
import com.mobilewe.wemobile.domain.usecases.IValidationUseCase
import com.mobilewe.wemobile.presentation.common.base.BaseScreenModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class BuyGoodsViewModel(
    private val validation: IValidationUseCase

) : BaseScreenModel<BuyGoodsUIState, BuyGoodsScreenUIEffect>(BuyGoodsUIState()),
    BuyGoodsInteractionListener {

    private val _settledPage = MutableStateFlow<Int?>(null)
    val settledPage = _settledPage.asStateFlow()

    private val _showDialog = MutableStateFlow(false)
    val showDialog: StateFlow<Boolean> = _showDialog

   override fun onTillNumberChanged(tillNumber: String) {
       updateState { it.copy(tillNumber = tillNumber) }
    }

    override fun onTillNameChanged(tillName: String) {
        updateState { it.copy(tillName = tillName) }
    }

    override fun onAmountChanged(amount: String) {
       updateState { it.copy(amount = amount) }
    }

    override fun onAccountTypeChanged(accountTypeName: String) {
        updateState { it.copy( accountTypeName = AccountTypeName.FOSA) }
    }

    fun onDialogDismissed() {
        _showDialog.value = false
    }


    fun isInputValid(): Boolean {
        val currentState = state.value
        val tillNumber = currentState.tillNumber
        val amount = currentState.amount

        val isValidTillNumber = tillNumber.isNotEmpty() && tillNumber.length > 5
        val isValidAmount =
            amount.isNotEmpty() && amount.toDouble() > 0

        return isValidTillNumber && isValidAmount
    }


    fun onContinueButtonClicked() {
        val currentState = state.value
        val tillNumber = currentState.tillNumber
        val amount = currentState.amount

        val isValidTillNumber = tillNumber.isNotEmpty() && tillNumber.length > 5
        val isValidAmount =
            amount.isNotEmpty() && amount.toDouble() > 0 && amount.toDouble() < 300000

        if (isInputValid()) {
            _showDialog.value = true
        }

        if (isValidTillNumber && isValidAmount) {
            _showDialog.value = true
        } else {
            // Show an error message or handle invalid input
        }
    }


}



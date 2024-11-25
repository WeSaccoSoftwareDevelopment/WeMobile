package com.mobilewe.wemobile.presentation.screen.buyAirtime.buyAirtime

import com.mobilewe.wemobile.domain.usecases.IValidationUseCase
import com.mobilewe.wemobile.presentation.common.base.BaseScreenModel

class BuyAirtimeViewModel (
    private val validation: IValidationUseCase
): BaseScreenModel<BuyAirtimeUiState, BuyAirtimeUIEffect>(BuyAirtimeUiState()),
    BuyAirtimeInteractionListener {


    init {
        validateInput()
    }


    private fun validateInput() {
        val amount = state.value.amount
        val phoneNumber = state.value.phoneNumber

        val isAmountValid = amount.trim().isNotEmpty() && amount.trim().toIntOrNull() != null && amount.trim().toInt() in 5..9999
        val areDetailsFilled = when (state.value.targetRadio) {
            "myself" -> true
            "someone_else" -> phoneNumber.trim().isNotEmpty()
            else -> false
        }
        state.value.isBuyAirtimeEnabled == isAmountValid && areDetailsFilled
    }


    fun setSheetOpen(isSheetOpen: Boolean) {
        updateState { it.copy(isSheetOpen = isSheetOpen) }
    }



    override fun onAmountChanged(amount: String) {
        updateState { it.copy( amount = amount) }
    }

    override fun onPhoneNumberChanged(phoneNumber: String) {
        updateState { it.copy( phoneNumber = phoneNumber) }
    }

    override fun onTargetRadioButton(targetRadio: String) {
        updateState { it.copy( targetRadio = targetRadio) }
    }

    override fun onAccountChanged(accountTypeName: String) {
        updateState { it.copy(accountTypeName = accountTypeName) }
    }

    override fun onShouldShowDialog(shouldShowDialog: Boolean) {
        updateState { it.copy(shouldShowDialog = shouldShowDialog) }
    }


}
package com.mobilewe.wemobile.presentation.screen.deposit

import com.mobilewe.wemobile.presentation.common.base.BaseScreenModel

class DepositScreenViewModel : BaseScreenModel<DepositScreenUIState, DepositScreenUIEffect>(
    DepositScreenUIState()
), DepositScreenInteractionListener {
    override fun onDepositServiceChanged(depositService: String) {
        updateState { it.copy(depositService = depositService) }
    }

    override fun onAmountChanged(amount: String) {
        updateState { it.copy( amount = amount) }
    }

    override fun onAccountTypeChanged(accountType: String) {
        updateState { it.copy( depositAccount = accountType) }
    }
}
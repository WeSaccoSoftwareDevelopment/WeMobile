package com.mobilewe.wemobile.presentation.screen.withdraw

import com.mobilewe.wemobile.domain.model.AccountTypeName
import com.mobilewe.wemobile.presentation.common.base.BaseScreenModel

class WithdrawScreenViewModel: BaseScreenModel<WithdrawScreenUIState, WithdrawScreenUIEffect>(
    WithdrawScreenUIState()
),
    WithdrawScreenInteractionListener {
    override fun onAmountChanged(amount: String) {
        updateState { it.copy( amount = amount) }
    }

    override fun onPayAccount(withdrawService: String) {

    }

    override fun onAccountTypeChanged(accountTypeName: AccountTypeName) {
        updateState { it.copy( payWithAccountTypeName = accountTypeName) }
    }

}
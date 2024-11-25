package com.mobilewe.wemobile.presentation.screen.withdraw

import com.mobilewe.wemobile.domain.model.AccountTypeName
import com.mobilewe.wemobile.presentation.common.base.BaseInteractionListener

interface WithdrawScreenInteractionListener : BaseInteractionListener {
    fun onAmountChanged(amount: String)
    fun onPayAccount(withdrawService: String)

    fun onAccountTypeChanged(accountTypeName: AccountTypeName)
}
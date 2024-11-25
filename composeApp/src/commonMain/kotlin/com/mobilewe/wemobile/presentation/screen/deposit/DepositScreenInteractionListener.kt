package com.mobilewe.wemobile.presentation.screen.deposit

import com.mobilewe.wemobile.presentation.common.base.BaseInteractionListener

interface DepositScreenInteractionListener : BaseInteractionListener {
    fun onDepositServiceChanged(depositService: String)
    fun onAmountChanged(amount: String)
    fun onAccountTypeChanged(accountType: String)
}
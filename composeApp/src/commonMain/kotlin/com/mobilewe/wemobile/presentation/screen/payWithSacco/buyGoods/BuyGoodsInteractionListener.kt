package com.mobilewe.wemobile.presentation.screen.payWithSacco.buyGoods

import com.mobilewe.wemobile.presentation.common.base.BaseInteractionListener

interface BuyGoodsInteractionListener : BaseInteractionListener {
    fun onTillNumberChanged(tillNumber: String)

    fun onTillNameChanged(tillName: String)

    fun onAmountChanged(amount: String)
    fun onAccountTypeChanged(accountTypeName: String)
}
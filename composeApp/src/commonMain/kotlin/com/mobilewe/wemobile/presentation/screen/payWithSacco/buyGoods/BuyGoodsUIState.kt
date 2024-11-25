package com.mobilewe.wemobile.presentation.screen.payWithSacco.buyGoods

import com.mobilewe.wemobile.domain.model.AccountTypeName

data class BuyGoodsUIState(
    val tillNumber: String = "",
    val tillName: String = "",
    val date: String = "",
    val amount: String = "",
    val accountTypeName: AccountTypeName = AccountTypeName.FOSA
)
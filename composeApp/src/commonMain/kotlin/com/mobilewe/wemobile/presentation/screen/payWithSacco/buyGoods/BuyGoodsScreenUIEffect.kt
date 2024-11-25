package com.mobilewe.wemobile.presentation.screen.payWithSacco.buyGoods

sealed class BuyGoodsScreenUIEffect {
    data object OnNavigateNext : BuyGoodsScreenUIEffect()
    data object OnNavigateBack : BuyGoodsScreenUIEffect()

}





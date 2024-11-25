package com.mobilewe.wemobile.presentation.screen.payWithSacco.payWithSacco.composable

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.mobilewe.wemobile.presentation.screen.payWithSacco.buyGoods.BuyGoodsScreen
import com.mobilewe.wemobile.presentation.screen.payWithSacco.paybill.PayBillScreen

typealias ComposableFun = @Composable () -> Unit
sealed class TabItem constructor(
    open var title: String,
    var screen: ComposableFun,
) {
    data class BuyGoods(
        val navController: NavController,
        override var title: String
    ) : TabItem( title = title , screen = { BuyGoodsScreen(navController = navController) })

    data class PayBill(
        val navController: NavController,
        override var title: String
    ) : TabItem(title = title, screen = { PayBillScreen(navController = navController) }
    )
}

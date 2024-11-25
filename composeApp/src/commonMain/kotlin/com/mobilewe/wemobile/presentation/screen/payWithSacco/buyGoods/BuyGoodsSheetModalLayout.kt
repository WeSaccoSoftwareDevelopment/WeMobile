package com.mobilewe.wemobile.presentation.screen.payWithSacco.buyGoods

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.mobilewe.wemobile.presentation.common.list.UserAccountSelectionScreen

enum class BuyGoodsSheetModalType{
    ACCOUNT
}

@Composable
fun BuyGoodsSheetModalLayout(
    modifier: Modifier = Modifier,
    buyGoodsSheetModalType: BuyGoodsSheetModalType,
    onClose:()-> Unit
) {
    when(buyGoodsSheetModalType){
        BuyGoodsSheetModalType.ACCOUNT -> {
            UserAccountSelectionScreen(
                onClose = { /*TODO*/ },
                accountList = emptyList()
            )
        }
    }

}
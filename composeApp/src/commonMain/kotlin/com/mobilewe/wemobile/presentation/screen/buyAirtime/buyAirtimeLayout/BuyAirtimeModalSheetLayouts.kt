package com.mobilewe.wemobile.presentation.screen.buyAirtime.buyAirtimeLayout

import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import com.mobilewe.wemobile.presentation.screen.buyAirtime.buyAirtime.BuyAirtimeUiState
import com.mobilewe.wemobile.presentation.common.list.UserAccountSelectionScreen


enum class BuyAirtimeModalSheetLayout{
    ACCOUNT,CONTACT
}
@Composable
fun BuyAirtimeModalSheetLayouts(
    modifier: Modifier = Modifier,
    buyAirtimeModalSheetLayout: BuyAirtimeModalSheetLayout,
    buyAirtimeUiState: BuyAirtimeUiState,
    onClose:()->Unit
) {
    val coroutineScope = rememberCoroutineScope()

    when(buyAirtimeModalSheetLayout){
        BuyAirtimeModalSheetLayout.ACCOUNT -> {
            UserAccountSelectionScreen(
                onClose = { /*TODO*/ },
                accountList = emptyList()
            )
        }
        BuyAirtimeModalSheetLayout.CONTACT -> {}
    }
}
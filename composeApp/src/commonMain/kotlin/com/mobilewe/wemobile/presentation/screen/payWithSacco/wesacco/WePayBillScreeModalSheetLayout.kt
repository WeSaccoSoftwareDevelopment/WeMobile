package com.mobilewe.wemobile.presentation.screen.payWithSacco.wesacco

import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import com.mobilewe.wemobile.domain.model.PayBill
import com.mobilewe.wemobile.presentation.common.list.UserAccountSelectionScreen
import kotlinx.coroutines.launch
import com.mobilewe.wemobile.presentation.screen.payWithSacco.paybill.component.PayBillSelection

enum class WePayBillScreeModalSheetType{ACCOUNT,PAYBILL}

@Composable
fun WePayBillScreeModalSheetLayout(
    modifier: Modifier = Modifier,
    wePayBillScreeModalSheetType: WePayBillScreeModalSheetType,
    onPayBillSelected:(PayBill)->Unit,
    onClose:()->Unit
) {
    val coroutineScope = rememberCoroutineScope()
    when(wePayBillScreeModalSheetType) {
        WePayBillScreeModalSheetType.ACCOUNT -> {
            UserAccountSelectionScreen(
                onClose = { coroutineScope.launch { onClose() }},
                accountList = emptyList()
            )
        }

        WePayBillScreeModalSheetType.PAYBILL -> {
            PayBillSelection(
                onPayBillSelected = { payBill ->
                    coroutineScope.launch {
                        onPayBillSelected(payBill)
                        onClose()
                    }
                },
            )
        }
    }
}
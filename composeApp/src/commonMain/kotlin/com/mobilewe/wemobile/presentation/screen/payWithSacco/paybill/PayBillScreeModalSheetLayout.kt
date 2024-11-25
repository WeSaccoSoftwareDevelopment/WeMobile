package com.mobilewe.wemobile.presentation.screen.payWithSacco.paybill

import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import com.mobilewe.wemobile.domain.model.PayBill
import com.mobilewe.wemobile.presentation.common.list.UserAccountSelectionScreen
import kotlinx.coroutines.launch
import com.mobilewe.wemobile.presentation.screen.payWithSacco.paybill.component.PayBillSelection

enum class PayBillScreeModalSheetType{ACCOUNT,PAYBILL}

@Composable
fun PayBillScreeModalSheetLayout(
    modifier: Modifier = Modifier,
    payBillScreeModalSheetType: PayBillScreeModalSheetType,
    onPayBillSelected:(PayBill)->Unit,
    onClose:()->Unit
) {
    val coroutineScope = rememberCoroutineScope()
    when(payBillScreeModalSheetType) {
        PayBillScreeModalSheetType.ACCOUNT -> {
            UserAccountSelectionScreen(
                onClose = { coroutineScope.launch { onClose() } },
                accountList = emptyList()
            )
        }

        PayBillScreeModalSheetType.PAYBILL -> {
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
package com.mobilewe.wemobile.presentation.screen.deposit

import androidx.compose.runtime.Composable
import com.mobilewe.wemobile.presentation.common.list.BankListSelectionScreen
import com.mobilewe.wemobile.presentation.common.list.UserAccountSelectionScreen

@Composable
fun DepositSheetModalLayout(
    bottomSheetType: DepositBottomSheetType,
    onClose: () -> Unit
) {
    when (bottomSheetType) {
        DepositBottomSheetType.ACCOUNT -> {
            UserAccountSelectionScreen(
                onClose = onClose,
                accountList = emptyList()
            )
        }
        DepositBottomSheetType.SERVICE -> {
            BankListSelectionScreen(
                onClose = onClose,
                onBankItemClicked = {},
                bankList = emptyList()
            )
        }
    }
}
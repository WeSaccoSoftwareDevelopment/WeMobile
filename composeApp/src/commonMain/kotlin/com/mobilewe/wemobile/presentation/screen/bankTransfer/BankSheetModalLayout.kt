package com.mobilewe.wemobile.presentation.screen.bankTransfer

import androidx.compose.runtime.Composable
import com.mobilewe.wemobile.presentation.common.list.BankListSelectionScreen
import com.mobilewe.wemobile.presentation.common.list.UserAccountSelectionScreen


@Composable
fun BankSheetModalLayout(
    bottomSheetType: BankTransferBottomSheetType,
    onClose: () -> Unit
) {
    when (bottomSheetType) {
        BankTransferBottomSheetType.ACCOUNT -> {
            UserAccountSelectionScreen(
                onClose = onClose,
                accountList = emptyList()
            )
        }
        BankTransferBottomSheetType.BANK -> {
            BankListSelectionScreen(
                onClose = onClose,
                onBankItemClicked = {},
                bankList = emptyList()
            )

        }
        else -> {
            null
        }
    }
}
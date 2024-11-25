package com.mobilewe.wemobile.presentation.screen.withdraw

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.mobilewe.wemobile.presentation.common.list.UserAccountSelectionScreen

enum class WithdrawModalSheetType{ ACCOUNT}

@Composable
fun WithdrawModalSheetLayout(
    modifier: Modifier = Modifier,
    withdrawModalSheetType: WithdrawModalSheetType,
    onClose:()->Unit
) {
    when(withdrawModalSheetType){
        WithdrawModalSheetType.ACCOUNT -> {
            UserAccountSelectionScreen(
                onClose = onClose,
                accountList = emptyList()
            )
        }
    }

}
package com.mobilewe.wemobile.presentation.screen.withdraw

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.input.KeyboardType
import androidx.lifecycle.viewmodel.compose.viewModel
import com.mobilewe.wemobile.presentation.common.composables.MainBackgroundHeader
import com.mobilewe.wemobile.presentation.common.composables.appbar.AppToolbar
import com.mobilewe.wemobile.presentation.common.composables.button.ContinueButton
import com.mobilewe.wemobile.presentation.common.composables.modalSheet.WeSaccoModalSheet
import com.mobilewe.wemobile.presentation.common.composables.textfield.AccountTypeTextField
import com.mobilewe.wemobile.presentation.common.composables.textfield.RideOutlinedTextField
import com.mobilewe.wemobile.resources.Resources
import org.koin.compose.viewmodel.koinViewModel


@Composable
fun WithdrawScreen(
    navigateBack: () -> Unit
) {
    WithdrawContent (
        navigateBack = navigateBack
    )
    
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WithdrawContent(
    navigateBack:()->Unit
) {
    val viewModel: WithdrawScreenViewModel = koinViewModel()
    val uiState by viewModel.state.collectAsState()
    var isSheetOpen by rememberSaveable { mutableStateOf(false) }
    var currentBottomSheet: WithdrawModalSheetType? by remember { mutableStateOf(null) }
    val sheetState = rememberModalBottomSheetState()

    MainBackgroundHeader(
        topBar = {
            AppToolbar(
                title = "View your statement",
                showBackArrow = true,
                navigateBack = { navigateBack() }
            )
        },
        bottomBar = {
            ContinueButton(
                onClick = { },
                text = "Withdraw"
            )
        }
    ) {
        AccountTypeTextField(
            accountTypeName = uiState.payWithAccountTypeName.accountName,
            onAccountTypeChanged = {},
            onCountryClick = {
                isSheetOpen = true
                currentBottomSheet = WithdrawModalSheetType.ACCOUNT
            }
        )

        RideOutlinedTextField(
            value = uiState.amount,
            onValueChange = viewModel::onAmountChanged,
            hint = Resources.strings.amount,
            keyboardType = KeyboardType.Number,
        )

        WeSaccoModalSheet(
            isSheetOpen = isSheetOpen,
            onDismissRequest = { isSheetOpen = false },
            sheetState = sheetState
        ) {
            currentBottomSheet.let { withdrawModalSheetType ->
                if (withdrawModalSheetType != null) {
                    WithdrawModalSheetLayout(
                        withdrawModalSheetType = withdrawModalSheetType,
                        onClose = { isSheetOpen = false },
                    )
                }
            }
        }

    }
}
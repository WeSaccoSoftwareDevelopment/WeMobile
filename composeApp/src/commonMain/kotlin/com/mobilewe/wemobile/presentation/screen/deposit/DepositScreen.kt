package com.mobilewe.wemobile.presentation.screen.deposit

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
fun DepositScreen(
    navigateBack:()->Unit
) {
    DepositScreenContent(
        navigateBack = navigateBack
    )
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DepositScreenContent(
    navigateBack: ()->Unit
) {
    val depositScreenViewModel: DepositScreenViewModel = koinViewModel()
    val depositState by depositScreenViewModel.state.collectAsState()
    var isSheetOpen by rememberSaveable { mutableStateOf(false) }
    var currentBottomSheet: DepositBottomSheetType? by remember { mutableStateOf(null) }
    val sheetState = rememberModalBottomSheetState()

    MainBackgroundHeader(
        topBar = {
            AppToolbar(
                title = "Deposit",
                navigateBack = navigateBack
            )
        }
    ) {
        AccountTypeTextField(
            accountTypeName = depositState.depositAccount,
            onAccountTypeChanged = depositScreenViewModel::onAccountTypeChanged,
            onCountryClick = {
                isSheetOpen = true
                currentBottomSheet = DepositBottomSheetType.ACCOUNT
            }
        )

        RideOutlinedTextField(
            value = depositState.depositService,
            onValueChange = depositScreenViewModel::onDepositServiceChanged,
            hint = "Recipient Service"
        )

        RideOutlinedTextField(
            value = depositState.amount,
            onValueChange = depositScreenViewModel::onAmountChanged,
            hint = Resources.strings.amount,
            keyboardType = KeyboardType.Number
        )

        ContinueButton(
            onClick = { /* Perform deposit */ },
            modifier = Modifier.align(Alignment.End),
            text = "Deposit"
        )

        WeSaccoModalSheet(
            onDismissRequest = { isSheetOpen = false },
            sheetState = sheetState,
            isSheetOpen = isSheetOpen
        ) {
            currentBottomSheet?.let { depositBottomSheetType ->
                DepositSheetModalLayout(
                    bottomSheetType = depositBottomSheetType,
                    onClose = { isSheetOpen = false }
                )
            }
        }
    }

}


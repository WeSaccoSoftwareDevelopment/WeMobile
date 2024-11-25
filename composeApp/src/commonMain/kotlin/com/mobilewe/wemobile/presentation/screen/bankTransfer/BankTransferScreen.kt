package com.mobilewe.wemobile.presentation.screen.bankTransfer

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.mobilewe.wemobile.presentation.common.composables.AccountTypeDropDown
import com.mobilewe.wemobile.presentation.common.composables.MainBackgroundHeader
import com.mobilewe.wemobile.presentation.common.composables.appbar.AppToolbar
import com.mobilewe.wemobile.presentation.common.composables.modalSheet.WeSaccoModalSheet
import com.mobilewe.wemobile.presentation.common.composables.textfield.AccountTypeTextField
import com.mobilewe.wemobile.presentation.common.composables.textfield.RideOutlinedTextField
import com.mobilewe.wemobile.presentation.screen.bankTransfer.component.BankTextField
import org.koin.compose.viewmodel.koinViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BankTransferScreen(
    navController: NavController = rememberNavController(),
) {

    var isSheetOpen by rememberSaveable { mutableStateOf(false) }
    var currentBottomSheet: BankTransferBottomSheetType? by remember { mutableStateOf(null) }
    val viewModel: BankTransferViewModel = koinViewModel()
    val bankTransferState by viewModel.state.collectAsState()
    val sheetState = rememberModalBottomSheetState()

    MainBackgroundHeader(
        topBar = {
            AppToolbar(title = "Bank Transfer")
        }
    ) {
        AccountTypeDropDown(
            value = bankTransferState.accountName,
            isLoading = bankTransferState.isLoading,
            onValueChanged = {},
            accountTypeList = emptyList()
        )

        /*AccountTypeSelectionTextField(
            accountTypeName = bankTransferState.accountType,
            onAccountTypeNameChanged = {},
            onClickTrailingIcon = {
                isSheetOpen = true
            },
            onDisMissRequest = { isSheetOpen = false },
            isSheetOpen = isSheetOpen,
            sheetState = sheetState,
            accountList = emptyList()

        )*/


        // Goes with WeModalSheet
        AccountTypeTextField(
            accountTypeName = bankTransferState.accountName,
            onAccountTypeChanged = {},
            onCountryClick = {
                isSheetOpen = true
                currentBottomSheet = BankTransferBottomSheetType.ACCOUNT
            }
        )


        BankTextField(
            text = bankTransferState.bankName,
            onValuedChanged = viewModel::onBankNameChanged,
            label = "Selected Bank",
            hint = "Select Bank",
            onClickTrailingIcon = {
                isSheetOpen = true
                currentBottomSheet = BankTransferBottomSheetType.BANK
            },
        )

        RideOutlinedTextField(
            value = bankTransferState.accountNumber,
            onValueChange = viewModel::onAccountNumberChanged,
            hint = "Account Number",
            keyboardType = KeyboardType.Number,
            modifier = Modifier.fillMaxWidth(),
        )


        RideOutlinedTextField(
            value = bankTransferState.amount,
            onValueChange = viewModel::onAmountChanged,
            hint = "Amount",
            keyboardType = KeyboardType.Number,
            modifier = Modifier.fillMaxWidth(),
        )

        RideOutlinedTextField(
            value = bankTransferState.transferDescription,
            onValueChange = viewModel::onTransferDescription,
            hint = "Transfer Description",
            keyboardType = KeyboardType.Number,
            modifier = Modifier.fillMaxWidth(),
        )



        WeSaccoModalSheet(
            onDismissRequest = { isSheetOpen = false },
            sheetState = sheetState,
            isSheetOpen = isSheetOpen
        ) {
                currentBottomSheet?.let {
                    BankSheetModalLayout(
                        bottomSheetType = it,
                        onClose = { isSheetOpen = false }
                    )
                }
            }

    }
}

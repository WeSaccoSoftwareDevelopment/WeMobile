package com.mobilewe.wemobile.presentation.screen.requestMoney.requestMoney

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.input.KeyboardType
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.mobilewe.wemobile.domain.model.SendMoney
import com.mobilewe.wemobile.presentation.common.composables.MainBackgroundHeader
import com.mobilewe.wemobile.presentation.common.composables.appbar.AppToolbar
import com.mobilewe.wemobile.presentation.common.composables.button.ContinueButton
import com.mobilewe.wemobile.presentation.common.composables.modalSheet.WeSaccoModalSheet
import com.mobilewe.wemobile.presentation.common.composables.textfield.AccountTypeTextField
import com.mobilewe.wemobile.presentation.common.composables.textfield.RideOutlinedTextField
import com.mobilewe.wemobile.presentation.common.composables.textfield.SendMoneyProviderTextField
import com.mobilewe.wemobile.presentation.screen.requestMoney.composable.PhoneNumberTextField
import com.mobilewe.wemobile.presentation.screen.requestMoney.composable.RequestMoneyDialog
import org.koin.compose.viewmodel.koinViewModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RequestMoneyScreen(
    navController: NavController = rememberNavController(),
    requestMoneyViewModel: RequestMoneyViewModel = koinViewModel(),
    onNavigateToRequestConfirm:(String)->Unit

) {

    val uiState by requestMoneyViewModel.state.collectAsStateWithLifecycle()
    val shouldShowDialog = requestMoneyViewModel.shouldShowDialog.value
    var isSheetOpen by rememberSaveable { mutableStateOf(false) }
    var currentBottomSheet: SendMoneyModalSheetType? by remember { mutableStateOf(null) }
    val sheetState = rememberModalBottomSheetState()


    MainBackgroundHeader(
        topBar = {
            AppToolbar(
                title = "Request Money",
                showBackArrow = true,
                navigateBack = { navController.popBackStack() }
            )
        },
        bottomBar = {

        }
    ) {
        if (shouldShowDialog) {
            RequestMoneyDialog(
                onDismiss = {
                    requestMoneyViewModel.setShowDialogState(!requestMoneyViewModel.shouldShowDialog.value)
                },
                onClickSend = { sendMoney->
                    val requestMoneyId = sendMoney.transactionId
                    onNavigateToRequestConfirm(requestMoneyId)
                },
                sendMoney = SendMoney(
                    recipientPhoneNumber = uiState.phoneNumber,
                    amount = uiState.amount.toDouble(),
                    transactionDate = "getCurrentDateTime()",
                    transactionId =  "1",
                    provider = uiState.recipientProvider,
                    senderAccountId = uiState.accountTypeName
                )
            )
        }

        AccountTypeTextField(
            accountTypeName = uiState.accountTypeName,
            onAccountTypeChanged = {},
            onCountryClick = {
                isSheetOpen = true
                currentBottomSheet = SendMoneyModalSheetType.ACCOUNT
            }
        )

        SendMoneyProviderTextField(
            recipientProviderText = uiState.recipientProvider.providerName,
            onRecipientProvider = requestMoneyViewModel::onRecipientProviderSelected,
            leadingRecipientIcon = "",
            onClickTrailingIcon = {
                isSheetOpen = true
                currentBottomSheet = SendMoneyModalSheetType.PROVIDER
            }
        )

        PhoneNumberTextField(
            phoneNumber = uiState.phoneNumber,
            onPhoneNumberChanged = requestMoneyViewModel::onPhoneNumberChanged,
            onClickTrailingIcon = {
                isSheetOpen = true
                currentBottomSheet = SendMoneyModalSheetType.CONTACT
            }
        )

        RideOutlinedTextField(
            value = uiState.amount,
            onValueChange = requestMoneyViewModel::onAmountChanged,
            keyboardType = KeyboardType.Number,
            hint = "stringResource(id = R.string.amount)",
            supportText = "stringResource(id = R.string.amount_support_text)"
        )

        ContinueButton(
            text = "stringResource(id = R.string.continuee)",
            onClick = {
                requestMoneyViewModel.setShowDialogState(true)
            },
            enable = uiState.phoneNumber.isNotBlank() && uiState.amount.isNotBlank()
        )



        WeSaccoModalSheet(
            isSheetOpen = isSheetOpen,
            onDismissRequest = { isSheetOpen = false },
            sheetState = sheetState
        ) {
            currentBottomSheet.let { sendMoneyModalSheetType ->
                if (sendMoneyModalSheetType != null) {
                    RequestMoneyModalSheetLayout(
                        sendMoneyModalSheetType = sendMoneyModalSheetType,
                        onPhoneContactSelected = requestMoneyViewModel::onPhoneNumberChanged,
                        onClose = { isSheetOpen = false },
                        onRecipientProvider = requestMoneyViewModel::onRecipientProviderSelected,
                        recipientProviderText = uiState.recipientProvider
                    )
                }
            }
        }
    }

}
package com.mobilewe.wemobile.presentation.screen.sendMoney.sendMoney


import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.ContentAlpha
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.mobilewe.wemobile.domain.model.SendMoney
import com.mobilewe.wemobile.presentation.common.composables.MainBackgroundHeader
import com.mobilewe.wemobile.presentation.common.composables.appbar.AppToolbar
import com.mobilewe.wemobile.presentation.common.composables.button.ContinueButton
import com.mobilewe.wemobile.presentation.common.composables.modalSheet.WeSaccoModalSheet
import com.mobilewe.wemobile.presentation.common.composables.textfield.AccountTypeTextField
import com.mobilewe.wemobile.presentation.common.composables.textfield.RideOutlinedTextField
import com.mobilewe.wemobile.presentation.common.composables.textfield.SendMoneyProviderTextField
import com.mobilewe.wemobile.presentation.screen.sendMoney.components.SendMoneyDialog
import com.mobilewe.wemobile.utils.clickableWithoutRipple
import org.koin.compose.viewmodel.koinViewModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SendMoneyMainScreen(
    onNavigateToSendMoneyDetail: (String)-> Unit,
    onNavigateBack:()->Unit,
    sendMoneyViewModel: SendMoneyViewModel = koinViewModel()
) {

    val sendMoneyState by sendMoneyViewModel.state.collectAsStateWithLifecycle()
    val shouldShowDialog = sendMoneyViewModel.shouldShowDialog.value
    var isSheetOpen by rememberSaveable { mutableStateOf(false) }
    val skipPartiallyExpanded by remember { mutableStateOf(true) }
//    val sheetState = rememberModalBottomSheetState(skipPartiallyExpanded = skipPartiallyExpanded)
    var currentBottomSheet: SendMoneyModalSheetType? by remember { mutableStateOf(null) }
    val sheetState = rememberModalBottomSheetState()



    MainBackgroundHeader(
        topBar = {
            AppToolbar(
                title = "stringResource(id = R.string.send_money)",
                showBackArrow = true,
                navigateBack = onNavigateBack
            )
        },
        bottomBar = {
            ContinueButton(
                text = "stringResource(id = R.string.continuee)",
                onClick = {
                    sendMoneyViewModel.setShowDialogState(true)
                },
                enable = sendMoneyState.phoneNumber.isNotBlank() && sendMoneyState.amount.isNotBlank()
            )
        }
    ) {
        if (shouldShowDialog) {
            SendMoneyDialog(
                onDismiss = {
                        sendMoneyViewModel.setShowDialogState(!sendMoneyViewModel.shouldShowDialog.value)
                    },
                    onClickSend = { sendMoney->
                        val transactionId = sendMoney.transactionId
                        onNavigateToSendMoneyDetail(transactionId)
                    },
                    sendMoney = SendMoney(
                        recipientPhoneNumber = sendMoneyState.phoneNumber,
                        amount = sendMoneyState.amount.toDouble(),
                        transactionDate = "getCurrentDateTime()",
                        transactionId =  "11",
                        provider = sendMoneyState.recipientProvider,
                        senderAccountId = sendMoneyState.accountTypeName
                    )
                )
            }

        AccountTypeTextField(
            accountTypeName = sendMoneyState.accountTypeName,
            onAccountTypeChanged = {},
            onCountryClick = {
                isSheetOpen = true
                currentBottomSheet = SendMoneyModalSheetType.ACCOUNT
            }
        )

        SendMoneyProviderTextField(
            recipientProviderText = sendMoneyState.recipientProvider.providerName,
            onRecipientProvider = sendMoneyViewModel::onRecipientProviderSelected,
            leadingRecipientIcon = "",
            onClickTrailingIcon = {
                isSheetOpen = true
                currentBottomSheet = SendMoneyModalSheetType.PROVIDER
            }
        )

        PhoneNumberTextField(
            sendMoneyScreenUiState = sendMoneyState,
            onPhoneNumberChanged = sendMoneyViewModel::onPhoneNumberChanged,
            onClickTrailingIcon = {
                isSheetOpen = true
                currentBottomSheet = SendMoneyModalSheetType.CONTACT
                }
        )

        RideOutlinedTextField(
            value = sendMoneyState.amount,
            onValueChange = sendMoneyViewModel::onAmountChanged,
            keyboardType = KeyboardType.Number,
            hint = "stringResource(id = R.string.amount)",
            supportText = "stringResource(id = R.string.amount_support_text)"
        )



        WeSaccoModalSheet(
            isSheetOpen = isSheetOpen,
            onDismissRequest = { isSheetOpen = false },
            sheetState = sheetState
        ) {
            currentBottomSheet.let { sendMoneyModalSheetType ->
                if (sendMoneyModalSheetType != null) {
                    SendMoneyModalSheetLayout(
                        sendMoneyModalSheetType = sendMoneyModalSheetType,
                        onPhoneContactSelected = sendMoneyViewModel::onPhoneNumberChanged,
                        onClose = { isSheetOpen = false },
                        onRecipientProvider = sendMoneyViewModel::onRecipientProviderSelected,
                        recipientProviderText = sendMoneyState.recipientProvider
                    )
                }
            }
        }
    }
}


@Composable
fun PhoneNumberTextField(
    sendMoneyScreenUiState: SendMoneyScreenUiState,
    onPhoneNumberChanged: (String) -> Unit,
    onClickTrailingIcon: () -> Unit
) {

    RideOutlinedTextField(
            value = sendMoneyScreenUiState.phoneNumber,
            onValueChange = { onPhoneNumberChanged(it) },
            keyboardType = KeyboardType.Phone,
            hint = "stringResource(id = R.string.phoneNumber)",
            trailingIcon = {
                Icon(
                    imageVector = Icons.Outlined.Search,
                    contentDescription = "Call",
                    tint = LocalContentColor.current.copy(alpha = ContentAlpha.medium),
                    modifier = Modifier
                        .padding(8.dp)
                        .size(24.dp)
                        .clickableWithoutRipple(
                            onClick = {
//                                if (permissionState.status.isGranted) {
//                                    onClickTrailingIcon()
//                                } else {
//                                    permissionState.launchPermissionRequest()
//                                }
                            }
                        )

                )
            },
        )
}





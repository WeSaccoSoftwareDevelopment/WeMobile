package com.mobilewe.wemobile.presentation.screen.buyAirtime.buyAirtime

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.navigation.NavController
import com.mobilewe.wemobile.presentation.screen.buyAirtime.buyAirtimeLayout.BuyAirtimeModalSheetLayout
import com.mobilewe.wemobile.presentation.screen.buyAirtime.buyAirtimeLayout.BuyAirtimeModalSheetLayouts
import com.mobilewe.wemobile.presentation.screen.buyAirtime.components.BuyAirtimeDialog
import com.mobilewe.wemobile.presentation.screen.buyAirtime.components.BuyAirtimeForm
import com.mobilewe.wemobile.domain.model.TopUp
import com.mobilewe.wemobile.presentation.common.composables.MainBackgroundHeader
import com.mobilewe.wemobile.presentation.common.composables.appbar.AppToolbar
import com.mobilewe.wemobile.presentation.common.composables.button.ContinueButton
import com.mobilewe.wemobile.presentation.common.composables.modalSheet.WeSaccoModalSheet
import com.mobilewe.wemobile.presentation.common.composables.textfield.AccountTypeTextField
import com.mobilewe.wemobile.resources.Resources
import org.jetbrains.compose.resources.stringResource
import org.koin.compose.viewmodel.koinViewModel
import wemobile.composeapp.generated.resources.Res
import wemobile.composeapp.generated.resources.allStringResources
import wemobile.composeapp.generated.resources.buy_airtime


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BuyAirtimeScreen(
    navController: NavController,
    buyAirtimeViewModel: BuyAirtimeViewModel = koinViewModel(),
) {
    val buyAirtimeState by buyAirtimeViewModel.state.collectAsState()
    var isSheetOpen by rememberSaveable { mutableStateOf(false) }
    val shouldShowDialog = buyAirtimeState.shouldShowDialog
    var currentBottomSheet: BuyAirtimeModalSheetLayout? by remember { mutableStateOf(null) }
    val sheetState = rememberModalBottomSheetState()

    if (shouldShowDialog) {
        BuyAirtimeDialog(
            onDismiss = {},
            onClickSend = {
//                navigator.openBuyAirtimeConfirm(topUp = topUp)
            },
            topUp = TopUp(
                phoneNumber = buyAirtimeState.phoneNumber,
                amount = buyAirtimeState.amount.toDouble(),
                topUpDate = "",
                time = "",
            ),
        )
    }

    MainBackgroundHeader(
        topBar = {
            AppToolbar(
                title = stringResource(Res.string.buy_airtime),
                showBackArrow = true,
                navigateBack = { navController.popBackStack() }
            )
        }
    ) {
        AccountTypeTextField(
            accountTypeName = buyAirtimeState.accountTypeName,
            onAccountTypeChanged = {},
            onCountryClick = {
                isSheetOpen = true
                currentBottomSheet = BuyAirtimeModalSheetLayout.ACCOUNT
            }
        )

        BuyAirtimeForm(
            buyAirtimeState = buyAirtimeState,
            onTargetRadioChange = buyAirtimeViewModel::onTargetRadioButton,
            onPhoneNumberChange = buyAirtimeViewModel::onPhoneNumberChanged,
            onAmountChange = buyAirtimeViewModel::onAmountChanged,
            isSheetOpen = isSheetOpen,
            setIsSheetOpen = {
                isSheetOpen = true
                currentBottomSheet = BuyAirtimeModalSheetLayout.CONTACT
            }
        )

        ContinueButton(
            text =  Resources.strings.continuee,
            onClick = {
                buyAirtimeViewModel.onShouldShowDialog(true)
            },
            enable = buyAirtimeState.isBuyAirtimeEnabled,
        )

        WeSaccoModalSheet(
            onDismissRequest = { isSheetOpen = false },
            sheetState = sheetState,
            isSheetOpen = isSheetOpen
        ) {
            currentBottomSheet?.let {
                BuyAirtimeModalSheetLayouts(
                    buyAirtimeModalSheetLayout = it,
                    onClose = { isSheetOpen = false },
                    buyAirtimeUiState = buyAirtimeState,
                )
            }
        }
    }
}



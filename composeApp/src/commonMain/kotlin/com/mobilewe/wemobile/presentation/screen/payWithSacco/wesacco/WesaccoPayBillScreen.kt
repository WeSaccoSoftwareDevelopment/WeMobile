package com.mobilewe.wemobile.presentation.screen.payWithSacco.wesacco

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.mobilewe.wemobile.domain.model.PayBill
import com.mobilewe.wemobile.domain.model.payBillItems
import com.mobilewe.wemobile.presentation.common.composables.button.ContinueButton
import com.mobilewe.wemobile.presentation.common.composables.modalSheet.WeSaccoModalSheet
import com.mobilewe.wemobile.presentation.common.composables.textfield.AccountTypeTextField
import com.mobilewe.wemobile.presentation.common.composables.textfield.RideOutlinedTextField
import com.mobilewe.wemobile.presentation.screen.payWithSacco.paybill.component.BillDialog
import com.mobilewe.wemobile.presentation.screen.payWithSacco.paybill.component.BusinessNumberTextField
import com.mobilewe.wemobile.presentation.screen.payWithSacco.paybill.component.PayBillComponent
import com.mobilewe.wemobile.resources.Resources
import org.jetbrains.compose.resources.stringResource
import org.koin.compose.viewmodel.koinViewModel
import wemobile.composeapp.generated.resources.Res
import wemobile.composeapp.generated.resources.*
import wemobile.composeapp.generated.resources.accountNumber
import wemobile.composeapp.generated.resources.amount

@Composable
fun WesaccoPayBillScreen(
    navController: NavController
) {
    WesaccoPayBillScreenContent(
        navController = navController
    )

}

@Composable
fun WesaccoPayBillScreenContent(
    modifier: Modifier = Modifier,
    navController: NavController,
    wePayBillViewModel: WePayBillScreenViewModel = koinViewModel(),
) {
    val payBillState by wePayBillViewModel.state.collectAsState()
    val shouldShowDialog = wePayBillViewModel.shouldShowDialog.value

    WePayBillContentScreen(
        onPayBillClick = { payBill ->
//            val route = PayWithSacco.BillConfirm.sendPayBillData(
//                accountName = payBill.businessName,
//                businessNumber = payBill.businessNumber,
//                accountNumber = payBill.accountNumber.toString(),
//                amount = payBill.amount!!.toDouble(),
//                date = payBill.transactionDate.toString()
//            )
//            navController.navigate(route = route)
        },
        screenUiState = payBillState,
        setShowDialogState = {
            wePayBillViewModel.setShowDialogState(!wePayBillViewModel.shouldShowDialog.value)
        },
        onClickButton = {
            wePayBillViewModel.setShowDialogState(true)
        },
        shouldShowDialog = shouldShowDialog,
        onAmountChanged = wePayBillViewModel::onAmountChanged,
        onAccountNumberChanged = wePayBillViewModel::onAccountNumberChanged ,
        onBusinessNumberChanged = wePayBillViewModel::onBusinessNumberChanged,
        onAccountNameChanged = wePayBillViewModel::onAccountNameChanged,
        onSelectedPayBill = wePayBillViewModel::selectedPayBill,
        onAccountTypeChanged = {}
    )

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WePayBillContentScreen(
    onPayBillClick: (PayBill) -> Unit,
    screenUiState: WePayBillScreenUiState,
    onBusinessNumberChanged:(String)-> Unit,
    onAccountNumberChanged:(String)-> Unit,
    onAmountChanged:(String)-> Unit,
    onAccountNameChanged:(String)-> Unit,
    shouldShowDialog: Boolean = false,
    setShowDialogState:()->Unit,
    onClickButton:()->Unit,
    onSelectedPayBill: (PayBill)->Unit,
    onAccountTypeChanged: (String)->Unit
) {

    var currentBottomSheet: WePayBillScreeModalSheetType? by remember { mutableStateOf(null) }
    val sheetState = rememberModalBottomSheetState()
    var isSheetOpen by rememberSaveable { mutableStateOf(false) }


    if (shouldShowDialog) {
        BillDialog(
            onDismiss = setShowDialogState,
            onClickSend = onPayBillClick,
            payBill = PayBill(
                businessName = screenUiState.accountName,
                businessNumber = screenUiState.businessNumber!!,
                accountNumber = screenUiState.accountNumber,
                amount = screenUiState.amount.toDouble(),
                transactionDate = "Clock.System.currentTimeMillis().toString()"
            )
        )
    }

    Column(
        modifier = Modifier
            .background(MaterialTheme.colorScheme.background)
            .padding(horizontal = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
        ) {
            item {
                AccountTypeTextField(
                    accountTypeName = screenUiState.accountTypeName.accountName,
                    onAccountTypeChanged = onAccountTypeChanged,
                    onCountryClick = {
                        isSheetOpen = true
                        currentBottomSheet = WePayBillScreeModalSheetType.ACCOUNT
                    }
                )
            }
            item {
                BusinessNumberTextField(
                    businessNumber = screenUiState.businessNumber ,
                    businessName = screenUiState.businessName,
                    onBusinessNumberChanged = onBusinessNumberChanged,
                    onClickTrailingIcon = {
                        isSheetOpen = true
                        currentBottomSheet = WePayBillScreeModalSheetType.PAYBILL
                    }
                )
            }
            item {
                RideOutlinedTextField(
                    value = screenUiState.accountNumber,
                    onValueChange = onAccountNumberChanged,
                    keyboardType = KeyboardType.Text,
                    hint = stringResource(Res.string.accountNumber),
                    accountNumberLength = "${screenUiState.accountNumber.length}/${20}",
                    maxLength = 20,
                    error = if (screenUiState.isAccountNoError) Resources.strings.invalidEmail else "",
                    isError = screenUiState.isAccountNoError,
                )
            }
            item {
                RideOutlinedTextField(
                    value = screenUiState.amount,
                    onValueChange = onAmountChanged,
                    keyboardType = KeyboardType.Number,
                    hint = stringResource(Res.string.amount)
                )
            }

            item {
                ContinueButton(
                    text = stringResource(Res.string.continuee),
                    onClick = onClickButton,
                    enable = screenUiState.isPayBillEnabled
                )
            }

            item {
                Text(
                    text = "Frequent",
                    fontSize = 18.sp,
                    textAlign = TextAlign.Start,
                    modifier = Modifier.padding(vertical = 16.dp)
                )
            }
            items(payBillItems) { payBill ->
                PayBillComponent(
                    payBill = payBill,
                    onPayBillItemClick = { onSelectedPayBill(payBill)}
                )
            }
        }
    }

    AnimatedVisibility(
        visible = isSheetOpen,
        enter = slideInVertically(initialOffsetY = { it }),
        exit = slideOutVertically(targetOffsetY = { it })
    ) {
        WeSaccoModalSheet(
            onDismissRequest = { isSheetOpen = false },
            sheetState = sheetState,
            modifier = Modifier.fillMaxHeight(0.8f),
            isSheetOpen = isSheetOpen
        ) {
            currentBottomSheet?.let { payBillScreeModalSheetType->
                WePayBillScreeModalSheetLayout(
                    wePayBillScreeModalSheetType = payBillScreeModalSheetType,
                    onPayBillSelected = onSelectedPayBill,
                    onClose = { isSheetOpen = false}
                )
            }
        }

    }
}
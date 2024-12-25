package com.mobilewe.wemobile.presentation.screen.payWithSacco.buyGoods

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.mobilewe.wemobile.domain.model.Merchant
import com.mobilewe.wemobile.presentation.common.composables.button.ContinueButton
import com.mobilewe.wemobile.presentation.common.composables.modalSheet.WeSaccoModalSheet
import com.mobilewe.wemobile.presentation.common.composables.textfield.AccountTypeTextField
import com.mobilewe.wemobile.presentation.common.composables.textfield.RideOutlinedTextField
import com.mobilewe.wemobile.presentation.common.navigation.TransactDes
import org.koin.compose.viewmodel.koinViewModel
import com.mobilewe.wemobile.presentation.screen.payWithSacco.buyGoods.components.TillNumberDropDown
import com.mobilewe.wemobile.presentation.screen.payWithSacco.buyGoods.components.BuyGoodsDialog
import com.mobilewe.wemobile.resources.Resources


@Composable
fun BuyGoodsScreen(
    navController: NavController
) {
    BuyGoodsContentScreen(
        navController = navController
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BuyGoodsContentScreen(
    buyGoodsViewModel: BuyGoodsViewModel = koinViewModel(),
    navController: NavController
) {

    val state by buyGoodsViewModel.state.collectAsState()
    val currentPage by buyGoodsViewModel.settledPage.collectAsState()
    val focusRequester = remember { FocusRequester() }
    var isSheetOpen by rememberSaveable { mutableStateOf(false) }
    var currentBottomSheet: BuyGoodsSheetModalType? by remember { mutableStateOf(null) }
    val sheetState = rememberModalBottomSheetState()

    LaunchedEffect(key1 = currentPage) {
        if (currentPage == 0) {
            focusRequester.requestFocus()
        }
    }

    Column(
        modifier = Modifier.fillMaxSize().padding(horizontal = 16.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        if (buyGoodsViewModel.showDialog.collectAsState().value) {
            BuyGoodsDialog(
                onDismiss = { buyGoodsViewModel.onDialogDismissed() },
                buyGoods = Merchant(
                    tillName = state.tillName,
                    tillNumber = state.tillNumber.toString(),
                    amount = state.amount.toString(),
                    transactionDate = state.date.toString()
                ),
                onClickSend = {
                    navController.navigate(TransactDes.BuyGoodsDetailsRoute(id =  state.tillName))
                },
            )
        }

        AccountTypeTextField(
            accountTypeName = state.accountTypeName.accountName,
            onAccountTypeChanged = buyGoodsViewModel::onAccountTypeChanged,
            onCountryClick = {
                isSheetOpen = true
                currentBottomSheet = BuyGoodsSheetModalType.ACCOUNT
            }
        )


        TillNumberDropDown(
            state = state,
            onTillNumberChanged = buyGoodsViewModel::onTillNumberChanged,
            onTillNameChanged = buyGoodsViewModel::onTillNameChanged,
        )

        RideOutlinedTextField(
            value = state.amount,
            onValueChange = { buyGoodsViewModel.onAmountChanged(it) },
            hint = Resources.strings.amount,
            maxLength = 7,
            keyboardType = KeyboardType.Number,
        )

        Spacer(modifier = Modifier.height(12.dp))

        Box {
            ContinueButton(
                text = Resources.strings.continuee,
                onClick = {
                    buyGoodsViewModel.onContinueButtonClicked()
                },
                enable = buyGoodsViewModel.isInputValid(),
                modifier = Modifier.align(Alignment.BottomCenter)
            )
        }

        WeSaccoModalSheet(
            onDismissRequest = { isSheetOpen = false },
            sheetState = sheetState,
            isSheetOpen = isSheetOpen
        ) {
            currentBottomSheet?.let { buyGoodsSheetModalType ->
                BuyGoodsSheetModalLayout(
                    buyGoodsSheetModalType = buyGoodsSheetModalType,
                    onClose = { isSheetOpen = false }
                )
            }
        }
    }
}




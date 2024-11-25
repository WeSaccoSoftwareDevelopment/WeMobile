package com.mobilewe.wemobile.presentation.screen.payWithSacco.paybill.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.mobilewe.wemobile.domain.model.PayBill
import com.mobilewe.wemobile.presentation.common.composables.button.RetryButton
import org.koin.compose.viewmodel.koinViewModel
import com.mobilewe.wemobile.presentation.screen.payWithSacco.paybill.PayBillScreenViewModel

@Composable
fun PayBillSelection(
    payBillScreenViewModel: PayBillScreenViewModel = koinViewModel(),
    onPayBillSelected: (PayBill) -> Unit,
) {
    val payBillState by payBillScreenViewModel.state.collectAsState()
    val lazyState = rememberLazyListState()
        Column(
            modifier = Modifier.padding().fillMaxSize(),
            verticalArrangement = Arrangement.Top
        ) {
            PayBillSearchTopBar(
                title = "Search PayBill",
                initialValue = payBillState.searchParams,
                onSearchParamChange = payBillScreenViewModel::searchPayBill,
                showBackArrow = true,
                showSearchBar = true,
            )

            if (payBillState.isLoading) {
                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
                }
            } else if (payBillState.payBillList.isNotEmpty()) {
                LazyColumn(
                    modifier = Modifier.fillMaxSize().padding(horizontal = 12.dp),
                    state = lazyState,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    val payBills = payBillState.payBillList
                    items(payBills) { payBill ->
                        PayBillComponent(
                            payBill = payBill,
                            onPayBillItemClick = { onPayBillSelected(payBill) }
                        )
                    }
                    item {
                        Box {}
                    }
                }
            } else if (payBillState.error.isNotEmpty()) {
                RetryButton(
                    error = payBillState.error,
                    onRetryEvent = {
                        payBillScreenViewModel.getPayBill()
                    }
                )
            } else {
                Text("Mp raw match found ")
            }

        }
}

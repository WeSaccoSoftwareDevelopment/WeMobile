package com.mobilewe.wemobile.presentation.screen.reports.transaction_history

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import com.mobilewe.wemobile.domain.model.transactionsItem

@Composable
fun TransactionHistoryScreen() {
    Column {
        LazyColumn {
            items(transactionsItem.size) { index ->
                TransactionHistoryItem(
                    transactionItem = transactionsItem[index],
                    onTransactionClick = {}
                )
            }
        }
    }
}
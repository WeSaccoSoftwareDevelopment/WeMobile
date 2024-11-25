package com.mobilewe.wemobile.presentation.screen.reports.transaction_history

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Receipt
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.mobilewe.wemobile.domain.model.TransactionsItem
import com.mobilewe.wemobile.domain.model.transactionsItem
import com.mobilewe.wemobile.presentation.common.composables.appbar.AppToolbar
import com.mobilewe.wemobile.presentation.common.theme.PrimaryColor
import com.mobilewe.wemobile.presentation.common.theme.WeThemes


@Composable
fun TransactionsHistoryScreen() {
    AllTransactionsScreen {

    }
    
}
@OptIn(ExperimentalFoundationApi::class, ExperimentalMaterial3Api::class)
@Composable
fun AllTransactionsScreen(
    navigateBack: () -> Unit
) {
    val interactionSource = remember{MutableInteractionSource() }
    Scaffold(
        topBar = {
            AppToolbar(
                title = "All Transactions",
                showBackArrow = true,
                navigateBack = { navigateBack() }
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                containerColor = MaterialTheme.colorScheme.background,
                onClick = { /*TODO*/ },
                content = {
                    Row(
                        modifier = Modifier.padding(
                            horizontal = 12.dp,
                            vertical = 8.dp
                        ),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Icon(
                            imageVector = Icons.Filled.Receipt,
                            contentDescription = null,
                            tint = PrimaryColor
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            text = "Export Statement",
                            style = WeThemes.typography.labelMedium,
                            color = PrimaryColor
                        )
                    }
                },
                interactionSource = interactionSource
            )

        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .padding(horizontal = 16.dp)
        ) {
            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(5.dp)
            ) {
                val sortedTransactions =
                    transactionsItem.sortedWith(compareByDescending<TransactionsItem> { it.date }.thenByDescending { it.time })

                val groupedTransactions = sortedTransactions.groupBy { it.date }

                groupedTransactions.forEach { (date, transactionsByDate) ->
                    val formattedDate = date
                    stickyHeader {
                        if (formattedDate != null) {
                            TransactionStickyHeader(date = formattedDate)
                        }
                    }
                    itemsIndexed(
                        transactionsByDate,
                        key = { id, trans -> "$id" + trans.name }) { index: Int, transaction: TransactionsItem ->
                        TransactionHistoryItem(
                            transactionItem = transaction,
                            onTransactionClick = { },
                        )
                        if (index < transactionsByDate.lastIndex)
                            Divider(
                                color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.08F)
                            )
                    }
                }
            }
        }
    }
}

//
//
//fun formatDateMonthYear(date: String): String? {
//    val inputFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
//    val outputFormat = SimpleDateFormat("dd MMM yyyy", Locale.getDefault())
//    val parsedDate = inputFormat.parse(date)
//    return parsedDate?.let { outputFormat.format(it) }
//}

@Composable
fun AllTransactionsScreenPreview() {
    AllTransactionsScreen(
        navigateBack = {}
    )
}
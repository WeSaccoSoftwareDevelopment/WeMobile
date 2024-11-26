package com.mobilewe.wemobile.presentation.screen.transactions

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.mobilewe.wemobile.presentation.common.composables.CategoryTabs
import com.mobilewe.wemobile.presentation.common.composables.appbar.AppToolbar
import com.mobilewe.wemobile.presentation.common.theme.WeThemes
import com.mobilewe.wemobile.presentation.screen.transactions.composable.TransactCardItem
import org.koin.compose.viewmodel.koinViewModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NewTransactionScreen(
    navController: NavController = rememberNavController()
) {
    val transactViewModel: TransactViewModel = koinViewModel()
    val newTransactUiState by transactViewModel.newTransactUiState.collectAsStateWithLifecycle()
    val isRemittanceCategory = newTransactUiState.selectedCategory == "Remittance"


    Scaffold(
        topBar = {
            AppToolbar(
                title = "Transact",
                showBackArrow = true
            )
        },
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 12.dp)
                .padding(paddingValues)
        ) {

                LazyVerticalGrid(
                    columns = GridCells.Fixed(3),
                    verticalArrangement = Arrangement.spacedBy(12.dp),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {

                    item(span = { GridItemSpan(3) }) {
                        Box(
                            modifier = Modifier.fillMaxWidth(),
                            contentAlignment = Alignment.TopStart
                        ) {
                            Text(
                                text = "Here are some things you can do",
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold,
                                textAlign = TextAlign.Start
                            )
                        }
                    }

                    item(span = { GridItemSpan(3) }) {
                        CategoryTabs(
                            categories = newTransactUiState.categories,
                            selectedCategory = newTransactUiState.selectedCategory,
                            onCategorySelected = { transactViewModel.selectCategory(it) }
                        )
                    }


                    if (newTransactUiState.selectedCategory == "All") {
                        val groupedProducts = newTransactUiState.transactProducts.groupBy { it.category }
                        groupedProducts.forEach { (category, products) ->
                            item(span = { GridItemSpan(3) }) {
                                Text(
                                    text = category,
                                    fontWeight = FontWeight.SemiBold,
                                    style = WeThemes.typography.titleLarge,
                                    modifier = Modifier.padding(vertical = 8.dp)
                                )
                            }
                            items(products.size) { index ->
                                val product = products[index]
                                TransactCardItem(
                                    text = product.text,
                                    icon = product.icon,
                                    onClick = { sendMoneyOption ->
                                        when (sendMoneyOption) {
//                                            R.string.send_money -> navController.navigate(SEND_MONEY_SCREEN_ROUTE)
//                                            R.string.bank_transfer -> navController.navigate(BANK_TRANSFER_SCREEN_ROUTE)
//                                            R.string.withdraw -> navController.navigate(WITHDRAW_SCREEN_ROUTE)
//                                            R.string.loan -> navController.navigate(LOANS_SCREEN_ROUTE)
//                                            R.string.deposit -> navController.navigate(DEPOSIT_SCREEN_ROUTE)
//                                            R.string.buy_airtime -> navController.navigate(BUY_AIRTIME_ROUTE)
//                                            R.string.bill_pay_and_till_pay_hint -> navController.navigate(PAY_WITH_SACCO_SCREEN_ROUTE)PAY_WITH_SACCO_SCREEN_ROUTE
                                        }
                                    },
                                )
                            }
                        }
                    } else {
                        item(span = { GridItemSpan(3) }) {
                            newTransactUiState.selectedCategory?.let {
                                Text(
                                    text = it,
                                    fontWeight = FontWeight.SemiBold,
                                    style = WeThemes.typography.titleLarge,
                                    modifier = Modifier.padding(vertical = 8.dp)
                                )
                            }
                        }
                        items(newTransactUiState.selectedProducts.size) { index ->
                            val product = newTransactUiState.selectedProducts[index]
                            TransactCardItem(
                                text = product.text,
                                icon = product.icon,
                                showDrawableColorTint = isRemittanceCategory,
                                onClick = { sendMoneyOption ->
                                    when (sendMoneyOption) {
                                        "R.string.send_money" ->{}
                                        "R.string.bank_transfer" -> {}
                                       " R.string.withdraw" -> {}
                                       " R.string.loan" -> {}
                                       " R.string.deposit" -> {}
                                       " R.string.buy_airtime" -> {}
                                       " R.string.bill_pay_and_till_pay_hint "-> {}
                                    }
                                },
                            )
                        }
                    }

                    item(span = { GridItemSpan(3) }) {
                        Spacer(modifier = Modifier.height(12.dp))
                    }

                }
            }

        }
}


@Composable
fun FilterChips(
    filterTypes: List<String>,
    selectedType: String,
    onTypeSelected: (String) -> Unit
) {
    // Create filter chips here
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        filterTypes.forEach { type ->
            FilterChip(
                text = type,
                selected = type == selectedType,
                onSelectedChange = {
                    onTypeSelected(type)
                },
                modifier = Modifier.weight(1f)
            )
        }
    }
}

@Composable
fun FilterChip(
    modifier: Modifier = Modifier,
    text: String,
    selected: Boolean,
    onSelectedChange: (Boolean) -> Unit,
) {
    // Customize the appearance of your filter chip, e.g., use a Chip or Button composable
    Button(
        onClick = { onSelectedChange(!selected) },
        colors = ButtonDefaults.buttonColors(
            containerColor = if (selected) Color.Gray else Color.LightGray,
        ),
        modifier = modifier
    ) {
        Text(text = text)
    }
}




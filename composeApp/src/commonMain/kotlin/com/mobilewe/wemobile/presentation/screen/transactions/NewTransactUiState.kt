package com.mobilewe.wemobile.presentation.screen.transactions

import androidx.compose.runtime.Composable
import org.jetbrains.compose.resources.DrawableResource
import wemobile.composeapp.generated.resources.Res
import wemobile.composeapp.generated.resources.*
import wemobile.composeapp.generated.resources.paid_icon

data class Transact(
    val sendMoneyItem: List<SendMoneyItem>

)

data class NewTransactUiState(
    val transactProducts: List<SendMoneyItem> = emptyList(),
    val selectedCategory: String? = null,
    val transactProductCategories: Set<String> = emptySet(),
    val selectedProduct: SendMoneyItem? = null,
    val isRemittanceCategorySelected: Boolean = false,
    val selectAllCategories: Boolean = false,
) {
    val categories: Set<String> = transactProducts.map { it.category }.toSet() + "All"
    val selectedProducts: List<SendMoneyItem>
        get() = if (selectedCategory == "All") transactProducts else transactProducts.filter { it.category == selectedCategory }
}


sealed interface TransactionListEvent {
    data class ProductLoaded(val products: List<SendMoneyItem>) : TransactionListEvent
    data class OnSelectProduct(val product: SendMoneyItem): TransactionListEvent
    data object OnLoadCategories : TransactionListEvent
    data object OnLoadProducts : TransactionListEvent
}


data class SendMoneyItem(
    val text: String,
    val icon: DrawableResource,
    val category: String
)



fun getTravelAndShop(): List<SendMoneyItem>{
    return listOf(
        SendMoneyItem(
            text = "R.string.bus_travel_hint",
            icon = Res.drawable.paid_icon,
            category = "Travel & Shop"

        ),
        SendMoneyItem(
            text = "R.string.flight_hint",
            icon = Res.drawable.paid_icon,
            category = "Travel & Shop"

        ),
        SendMoneyItem(
            text = "R.string.train_hint",
            icon = Res.drawable.paid_icon,
            category = "Travel & Shop"
        ),
        SendMoneyItem(
            text = "R.string.train_hint",
            icon = Res.drawable.paid_icon,
            category = "Travel & Shop"
        )
    )
}


fun getSendMoneyList(): List<SendMoneyItem>{
    return listOf(
        SendMoneyItem(
            text = "R.string.send_money",
            icon = Res.drawable.send,
            category = "Transact"
        ),
        SendMoneyItem(
            text = "Res.string.bank_transfer",
            icon = Res.drawable.bankss,
            category = "Transact"

        ),
        SendMoneyItem(
            text = "R.string.withdraw",
            icon = Res.drawable.withdraw,
            category = "Transact"

        ),
        SendMoneyItem(
            text = "R.string.loan",
            icon = Res.drawable.loan_icon,
            category = "Transact"

        ),
        SendMoneyItem(
            text = "R.string.buy_airtime",
            icon = Res.drawable.ic_system_upate_24,
            category = "Transact"

        ),
        SendMoneyItem(
            text = "R.string.bill_pay_and_till_pay_hint",
            icon = Res.drawable.ic_utility,
            category = "Transact"

        ),
    )
}
fun getInvestmentInsurance(): List<SendMoneyItem>{
    return listOf(
        SendMoneyItem(
            text = "R.string.savings",
            icon = Res.drawable.savings_icons,
            category = "Invest & Insurance"
        ),
        SendMoneyItem(
            text = "R.string.deposit",
            icon = Res.drawable.icon_deposit,
            category = "Invest & Insurance"
        )
    )
}

val allList = getSendMoneyList() + getTravelAndShop() + getInvestmentInsurance().sortedBy { it.category }


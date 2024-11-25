package com.mobilewe.wemobile.presentation.screen.home

import com.mobilewe.wemobile.domain.model.UserData
import com.mobilewe.wemobile.presentation.screen.home.model.PaymentOption
import org.jetbrains.compose.resources.DrawableResource

data class HomeUiState(
    val paymentOptions: List<PaymentOption> = emptyList(),
    val selectedCategory: String? = null,
    val paymentOptionCategories: Set<String> = emptySet(),
    val selectedPaymentOption: PaymentOption? = null,
    val selectedOptions: List<PaymentOption> = emptyList(),
    val isRemittanceCategorySelected: Boolean = false, // Define this property
    val selectAllCategories: Boolean = false, // Flag to select all categories
    val userData: UserData? = null // Initialize with null
){
    val categories = paymentOptions.map { it.category }.toSet()
    private val selectedProducts = paymentOptions.filter { it.category == selectedCategory }
    fun selectedProductsForAllCategories(): List<PaymentOption> {
        return if (selectAllCategories) {
            paymentOptions
        } else {
            selectedProducts
        }
    }

}


sealed interface HomeUiEvent {
    data class ProductLoaded(val products: List<PaymentOption>) : HomeUiEvent
    data class OnSelectedProduct(val product: PaymentOption): HomeUiEvent
    data object OnLoadCategories : HomeUiEvent
    data object OnLoadProducts : HomeUiEvent

}

enum class ModalSheetState {
    None,
    SendMoney,
    PayMerchant,
    BuyAirtime,
}



data class SendMoneyItem(
    val text: String,
    val icon: DrawableResource,
    val category: String
)



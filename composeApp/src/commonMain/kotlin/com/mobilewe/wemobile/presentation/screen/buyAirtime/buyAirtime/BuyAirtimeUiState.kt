package com.mobilewe.wemobile.presentation.screen.buyAirtime.buyAirtime

data class BuyAirtimeUiState(
    val targetRadio: String = "myself",
    val phoneNumber: String = "",
    val amount: String = "",
    val isBuyAirtimeEnabled: Boolean = false,
    val shouldShowDialog: Boolean = false,
    val isLoading: Boolean = false,
    val accountTypeName: String = "",
    val isSheetOpen: Boolean = false,
    val currentAirtimeSheetType: BuyAirtimeSheetType? = null
)

enum class BuyAirtimeSheetType(val sheetType: String){
    ACCOUNT("AccountType"),CONTACT("Contact")
}
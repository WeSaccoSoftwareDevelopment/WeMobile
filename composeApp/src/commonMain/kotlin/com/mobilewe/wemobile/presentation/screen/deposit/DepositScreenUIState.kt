package com.mobilewe.wemobile.presentation.screen.deposit

data class DepositScreenUIState(
    val amount: String = "",
    val depositService: String = "",
    val depositAccount: String = "",
)

enum class DepositBottomSheetType(val sheetType: String){
    ACCOUNT("Account"),
    SERVICE("Recipient Service")
}

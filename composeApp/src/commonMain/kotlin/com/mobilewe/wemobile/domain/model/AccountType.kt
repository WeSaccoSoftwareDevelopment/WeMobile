package com.mobilewe.wemobile.domain.model


data class WesaccoAccounts(
    val imageUrl: String = "",
    val accountType: AccountTypeName = AccountTypeName.FOSA
)


data class AccountType(
    val accountName: AccountTypeName = AccountTypeName.FOSA,
    val accountNumber: String
)

enum class AccountTypeName(val accountName: String){
    FOSA("Fosa Savings Account"),
    BOSA("Bosa Savings Account"),
    BBF("BBF")
}


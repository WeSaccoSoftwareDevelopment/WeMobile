package com.mobilewe.wemobile.presentation.screen.bankTransfer

import com.mobilewe.wemobile.domain.model.AccountList
import com.mobilewe.wemobile.domain.model.Bank

data class BankTransferUiState(
    val amount: String = "",
    val accountNumber: String = "",
    val bankName: String = "",
    val accountType: String = "",
    val bankList: List<Bank> = emptyList(),
    val accountList:List<AccountList> = emptyList(),
    val accountName: String ="",
    val searchParams: String = "",
    val transferDescription: String ="",
    val isLoading: Boolean = false,
    val error: String = ""
)

enum class BankTransferBottomSheetType{ ACCOUNT, BANK }


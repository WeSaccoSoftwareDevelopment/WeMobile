package com.mobilewe.wemobile.presentation.screen.withdraw

import com.mobilewe.wemobile.domain.model.AccountTypeName
import com.mobilewe.wemobile.domain.model.WithdrawRecipientProviders

data class WithdrawScreenUIState(
    val payWithAccountTypeName: AccountTypeName = AccountTypeName.FOSA,
    val amount: String = "",
    val withdrawService : WithdrawRecipientProviders = WithdrawRecipientProviders.MPESA
)

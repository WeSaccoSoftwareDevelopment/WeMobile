package com.mobilewe.wemobile.presentation.screen.bankTransfer

sealed class BankTransferScreenUIEffect {
    data object NavigateToHome : BankTransferScreenUIEffect()
    data object NavigateToSignup : BankTransferScreenUIEffect()
}

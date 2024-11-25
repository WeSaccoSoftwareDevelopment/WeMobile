package org.saccowemobile.wemobile.presentation.bankTransfer

import com.mobilewe.wemobile.presentation.common.base.BaseInteractionListener


interface BankTransferScreenInteractionListener : BaseInteractionListener {
    fun onBankNameChanged(bankName: String)
    fun onAccountTypeChanged(accountType: String)

    fun onAmountChanged(amount: String)

    fun onAccountNumberChanged(accountNumber: String)

    fun onTransferDescription(transferDescription: String)

    fun onContinueClicked()
    fun onClickLogin(username: String, password: String, keepLoggedIn: Boolean)
    fun onClickBack()
}
package com.mobilewe.wemobile.presentation.screen.bankTransfer

import com.mobilewe.wemobile.domain.model.Bank
import com.mobilewe.wemobile.domain.usecases.IValidationUseCase
import com.mobilewe.wemobile.presentation.common.base.BaseScreenModel
import kotlinx.coroutines.Job
import org.saccowemobile.wemobile.presentation.bankTransfer.BankTransferScreenInteractionListener

class BankTransferViewModel(
    private val validation: IValidationUseCase

) : BaseScreenModel<BankTransferUiState, BankTransferScreenUIEffect>(BankTransferUiState()),
    BankTransferScreenInteractionListener {


    private var searchJob: Job? = null

    private val initialBankList = listOf<Bank>()


    override fun onBankNameChanged(bankName: String) {
        updateState { it.copy(bankName = bankName) }
    }

    override fun onAccountTypeChanged(accountType: String) {
        updateState { it.copy( accountType = accountType) }
    }

    override fun onAmountChanged(amount: String) {
        updateState { it.copy( amount = amount) }
    }

    override fun onAccountNumberChanged(accountNumber: String) {
        updateState { it.copy( accountNumber = accountNumber) }
    }

    override fun onTransferDescription(transferDescription: String) {
        updateState { it.copy( transferDescription = transferDescription) }
    }

    override fun onContinueClicked() {

    }

    override fun onClickLogin(username: String, password: String, keepLoggedIn: Boolean) {

    }

    override fun onClickBack() {

    }


}
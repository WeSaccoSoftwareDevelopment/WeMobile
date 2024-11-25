package com.mobilewe.wemobile.presentation.screen.payWithSacco.wesacco

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import com.mobilewe.wemobile.domain.model.AccountTypeName
import com.mobilewe.wemobile.domain.model.PayBill
import com.mobilewe.wemobile.domain.model.payBillItems
import com.mobilewe.wemobile.domain.usecases.IValidationUseCase
import com.mobilewe.wemobile.domain.utils.PayBillException
import com.mobilewe.wemobile.presentation.common.base.BaseScreenModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class WePayBillScreenViewModel(
    private val validation: IValidationUseCase
) : BaseScreenModel<WePayBillScreenUiState, WePayBillScreenUIEffect>(WePayBillScreenUiState()),
    WePayBillInteractionListener {


    private val _shouldShowDialog = mutableStateOf(false)
    val shouldShowDialog: State<Boolean> = _shouldShowDialog

    fun setShowDialogState(value: Boolean) {
        _shouldShowDialog.value = value
    }

    init {
        getPayBillList()
    }


    private var initialPayBills = listOf<PayBill>()

    private var searchJob: Job? = null

    override fun getPayBill(){
        viewModelScope.launch {
            try {
                val payBilLNumbers = withContext(Dispatchers.IO) {
                    getPayBillList()
                }

                initialPayBills = payBilLNumbers
                updateState { it.copy(
                    payBillList = initialPayBills.take(1000),
                    isLoading = false
                ) }

            } catch (e: Exception) {
                updateState { it.copy(
                    error = e.message ?: "Unknown error",
                    isLoading = false
                ) }
            }
        }
    }


   override fun searchPayBill(searchParams: String){
        if (searchParams.isNotEmpty()) {
            updateState{ it.copy(searchParams = searchParams, isLoading = true) }
            searchJob?.cancel()
            searchJob = viewModelScope.launch {
                delay(500L)
                val filteredPayBills = initialPayBills.filter {
                    it.businessName.contains(state.value.searchParams, ignoreCase = true) ||
                            it.businessName.contains(state.value.searchParams)
                }
                updateState {
                    it.copy(
                        payBillList = filteredPayBills,
                        isLoading = false
                    )
                }
            }
        } else {
            updateState {
                it.copy(
                    payBillList = initialPayBills.take(10),
                    isLoading = false
                )
            }
        }
    }

    override fun onBusinessNumberChanged(businessNumber: String) {
        deSelectPaybill()
        updateState { it.copy( businessNumber = businessNumber) }
        tryCatch { validation.validateBusinessNumber(businessNumber) }

    }

    override fun onAccountNameChanged(accountName: String) {
        updateState { it.copy( accountName = accountName) }
    }

    override fun onAccountNumberChanged(accountNumber: String) {
        updateState { it.copy( accountNumber = accountNumber) }
        tryCatch { validation.validateAccountNumber(accountNumber) }

    }

    override fun onAmountChanged(amount: String) {
        updateState { it.copy(amount = amount) }
    }

    override fun onAccountTypeChanged(accountTypeName: AccountTypeName) {
        updateState { it.copy( accountTypeName = accountTypeName) }
    }


    private fun getPayBillList():List<PayBill> {
        val payBills = mutableStateListOf<PayBill>()
        initialPayBills = payBillItems.sortedBy { it.businessName }
        updateState { it.copy(payBillList = initialPayBills, isLoading = false) }

        return payBills
    }

    fun selectedPayBill(paybill: PayBill){
        updateState{ it.copy(businessName =  paybill.businessName) }
        updateState { it.copy(businessNumber =  paybill.businessNumber) }
        updateState { it.copy(accountNumber =  paybill.accountNumber) }
        updateState { it.copy( selectedPayBill = paybill) }
    }




    private fun deSelectPaybill() {
        var selectedPaybill = state.value.selectedPayBill
        var businessName = state.value.businessName
        if (selectedPaybill?.businessName != null) businessName = null.toString()
        selectedPaybill = null
    }


    private fun tryCatch(block: () -> Unit) {
        try {
            block()
            clearErrors()
        } catch (e: PayBillException.InvalidAccountNumber) {
            updateState { it.copy(isAccountNoError = true) }
        } catch (e: PayBillException.InvalidBusinessNumber) {
            updateState { it.copy(isBusinessNoError = true) }
        }
    }

    private fun clearErrors() {
        updateState {
            it.copy(isAccountNoError = false, isBusinessNoError = false,)
        }
    }
}
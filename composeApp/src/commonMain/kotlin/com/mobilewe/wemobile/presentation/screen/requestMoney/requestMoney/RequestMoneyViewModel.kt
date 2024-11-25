package com.mobilewe.wemobile.presentation.screen.requestMoney.requestMoney


import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import com.mobilewe.wemobile.domain.model.RecipientProvider
import com.mobilewe.wemobile.domain.usecases.IValidationUseCase
import com.mobilewe.wemobile.presentation.common.base.BaseScreenModel

class RequestMoneyViewModel(
    private val validation: IValidationUseCase
) : BaseScreenModel<RequestMoneyScreenUiState, RequestMoneyScreenUiEffect>(
    RequestMoneyScreenUiState()
)
, RequestMoneyScreenInteractionListener {


    private val _shouldShowDialog = mutableStateOf(false)
    val shouldShowDialog: State<Boolean> = _shouldShowDialog

    fun setShowDialogState(value: Boolean) {
        _shouldShowDialog.value = value
    }


    override fun onPhoneNumberChanged(phoneNumber: String) {
        updateState { it.copy( phoneNumber = phoneNumber) }
    }

    override fun onRecipientProviderSelected(recipientProvider: RecipientProvider) {
        updateState { it.copy( recipientProvider = recipientProvider) }
    }

    override fun onAmountChanged(amount: String) {
        updateState { it.copy( amount = amount) }
    }

}
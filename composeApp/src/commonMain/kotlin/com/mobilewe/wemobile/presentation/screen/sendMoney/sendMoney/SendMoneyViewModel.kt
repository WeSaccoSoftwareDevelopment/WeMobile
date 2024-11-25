package com.mobilewe.wemobile.presentation.screen.sendMoney.sendMoney


import androidx.compose.material.BottomSheetValue
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import com.mobilewe.wemobile.domain.model.RecipientProvider
import com.mobilewe.wemobile.domain.usecases.IValidationUseCase
import com.mobilewe.wemobile.presentation.common.base.BaseScreenModel
import kotlinx.coroutines.flow.MutableStateFlow

class SendMoneyViewModel(
    private val validation: IValidationUseCase

) : BaseScreenModel<SendMoneyScreenUiState, SendMoneyScreenUiEffect>(SendMoneyScreenUiState())
, SendMoneyScreenInteractionListener {
    @OptIn(ExperimentalMaterialApi::class)
    private val _sheetState = mutableStateOf(BottomSheetValue.Collapsed)
    @OptIn(ExperimentalMaterialApi::class)
    val sheetState: State<BottomSheetValue> = _sheetState

    val sendMoneyScreenUiState = MutableStateFlow(SendMoneyScreenUiState())

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
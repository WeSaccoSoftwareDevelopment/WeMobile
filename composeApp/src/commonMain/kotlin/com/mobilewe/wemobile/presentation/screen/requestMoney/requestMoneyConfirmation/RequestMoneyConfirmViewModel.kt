package com.mobilewe.wemobile.presentation.screen.requestMoney.requestMoneyConfirmation

import androidx.lifecycle.ViewModel
import com.mobilewe.wemobile.presentation.screen.requestMoney.requestMoneyConfirmation.RequestMoneyConfirmUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class RequestMoneyConfirmViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(RequestMoneyConfirmUiState())
    val uiState = _uiState.asStateFlow()

}
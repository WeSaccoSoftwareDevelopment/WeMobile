package com.mobilewe.wemobile.presentation.screen.buyAirtime.buyConfirmation

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import com.mobilewe.wemobile.presentation.screen.buyAirtime.buyConfirmation.BuyAirtimeConfirmUiState

class BuyAirtimeConfirmViewModel : ViewModel() {
    private val _state = MutableStateFlow(BuyAirtimeConfirmUiState())
    val state = _state.asStateFlow()
}
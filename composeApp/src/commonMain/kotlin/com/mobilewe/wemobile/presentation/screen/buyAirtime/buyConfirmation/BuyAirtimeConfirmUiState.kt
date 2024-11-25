package com.mobilewe.wemobile.presentation.screen.buyAirtime.buyConfirmation

import com.mobilewe.wemobile.domain.model.TopUp

data class BuyAirtimeConfirmUiState(
    val topUp: List<TopUp> = emptyList(),
    val error: String = "",
    val isLoading: Boolean = false
)

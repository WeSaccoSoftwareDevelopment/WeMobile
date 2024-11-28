package com.mobilewe.wemobile.presentation.screen.payWithSacco.payWithSacco

import com.mobilewe.wemobile.presentation.common.base.ErrorState

data class PayWithSaccoUiState(
    val selectedType: PayWithSacco = PayWithSacco.BUYGOODS,
    val isLoggedIn: Boolean = false,
    val isLoading: Boolean = false,
    val error: ErrorState? = null
) {
    enum class PayWithSacco(type: String) {
        BUYGOODS("Coffee"),
        PAYBILL("Non Coffee"),
        WESSACCO("W")
    }
}

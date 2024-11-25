package com.mobilewe.wemobile.presentation.screen.payWithSacco.payWithSacco

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class PayWithSaccoViewModel: ViewModel() {
    private val _settledPage = MutableStateFlow<Int?>(null)
    val settledPage = _settledPage.asStateFlow()

    private val _phoneNumber =
        MutableStateFlow<Pair<String, String?>>(Pair("", null))  //Pair(value,errorMsg)
    val phoneNumber = _phoneNumber.asStateFlow()

    private val _dialCode = MutableStateFlow<Pair<String, String?>>(Pair("Np +977", null))
    val dialCode = _dialCode.asStateFlow()

    private val _email = MutableStateFlow<Pair<String, String?>>(Pair("", null))
    val email = _email.asStateFlow()


}

sealed class PayWithSaccoEvent{
    data class PayWithSaccoClicked(val targetPayWithSacco: String): PayWithSaccoEvent()
}
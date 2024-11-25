package com.mobilewe.wemobile.presentation.screen.buyAirtime.buyAirtime

import com.mobilewe.wemobile.presentation.common.base.BaseInteractionListener

interface BuyAirtimeInteractionListener : BaseInteractionListener {
    fun onAmountChanged(amount: String)
    fun onPhoneNumberChanged(phoneNumber: String)
    fun onTargetRadioButton(radio: String)
    fun onAccountChanged(accountTypeName: String)
    fun onShouldShowDialog(shouldShowDialog: Boolean)
}
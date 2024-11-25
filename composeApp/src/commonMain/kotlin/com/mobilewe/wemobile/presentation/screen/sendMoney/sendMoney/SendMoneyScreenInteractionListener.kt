package com.mobilewe.wemobile.presentation.screen.sendMoney.sendMoney

import com.mobilewe.wemobile.domain.model.RecipientProvider
import com.mobilewe.wemobile.presentation.common.base.BaseInteractionListener

interface SendMoneyScreenInteractionListener : BaseInteractionListener {
    fun onPhoneNumberChanged(phoneNumber: String)
    fun onRecipientProviderSelected(recipientProvider: RecipientProvider)
    fun onAmountChanged(amount: String)
}
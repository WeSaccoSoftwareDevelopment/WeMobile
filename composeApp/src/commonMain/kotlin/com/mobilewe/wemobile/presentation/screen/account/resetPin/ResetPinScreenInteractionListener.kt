package com.mobilewe.wemobile.presentation.screen.account.resetPin

import com.mobilewe.wemobile.presentation.common.base.BaseInteractionListener

interface ResetPinScreenInteractionListener : BaseInteractionListener {
    fun onNewPinChanged(newPin: String)
    fun onConfirmPinChanged(confirmPin: String)
}
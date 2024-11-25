package com.mobilewe.wemobile.presentation.screen.payWithSacco.paybill

import com.mobilewe.wemobile.domain.model.AccountTypeName
import com.mobilewe.wemobile.presentation.common.base.BaseInteractionListener

interface PayBillInteractionListener : BaseInteractionListener {
    fun  getPayBill()
    fun  searchPayBill(searchParams: String)
    fun onBusinessNumberChanged(businessNumber: String)
    fun onAccountNameChanged(accountName: String)
    fun onAccountNumberChanged(accountNumber: String)
    fun onAmountChanged(amount: String)

    fun onAccountTypeChanged(accountTypeName: AccountTypeName)


}
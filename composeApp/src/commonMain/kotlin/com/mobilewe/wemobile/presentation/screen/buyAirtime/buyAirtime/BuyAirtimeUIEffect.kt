package com.mobilewe.wemobile.presentation.screen.buyAirtime.buyAirtime

sealed class BuyAirtimeUIEffect {
    data object OnNavigateBack: BuyAirtimeUIEffect()
    data object OnNavigateToBuyAirtimeConfirmation: BuyAirtimeUIEffect()
}
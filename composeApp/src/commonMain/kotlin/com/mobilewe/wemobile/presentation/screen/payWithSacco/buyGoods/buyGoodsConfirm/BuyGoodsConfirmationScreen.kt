package com.mobilewe.wemobile.presentation.screen.payWithSacco.buyGoods.buyGoodsConfirm

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.mobilewe.wemobile.domain.model.Merchant
import com.mobilewe.wemobile.presentation.common.composables.appbar.AppToolbar

@Composable
fun BuyGoodsConfirmationScreen(
    merchantId: String
) {
    Scaffold(
        topBar = {
            AppToolbar(
                title = "Confirm Payment",
                navigateBack = {}
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(horizontal = 16.dp, vertical = 16.dp)
        ) {
            Text(merchantId.toString())
            BuyGoodsConfirmsComponent(merchant = Merchant())
        }
    }

}


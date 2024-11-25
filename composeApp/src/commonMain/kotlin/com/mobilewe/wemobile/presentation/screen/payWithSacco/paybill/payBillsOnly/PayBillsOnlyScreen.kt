package com.mobilewe.wemobile.presentation.screen.payWithSacco.paybill.payBillsOnly

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.mobilewe.wemobile.presentation.common.composables.appbar.AppToolbar
import com.mobilewe.wemobile.presentation.screen.payWithSacco.paybill.PayBillScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PayBillsOnlyScreen(
    modifier: Modifier = Modifier,
    navController: NavController
) {
    Scaffold(
        topBar = {
            AppToolbar(title = "Pay Bill")
        }
    ) { paddingValues ->
        Box(
            modifier = modifier.padding(paddingValues)
        ){
            PayBillScreen(
                navController = navController
            )
        }
    }

}
package com.mobilewe.wemobile.presentation.screen.buyAirtime.buyConfirmation

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.mobilewe.wemobile.presentation.common.composables.MainBackgroundHeader
import com.mobilewe.wemobile.presentation.common.composables.appbar.AppToolbar
import org.jetbrains.compose.resources.painterResource
import wemobile.composeapp.generated.resources.Res
import wemobile.composeapp.generated.resources.outline_check_24


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BuyAirtimeConfirmScreen(
    navController: NavController,
    buyAirtimeConfirmViewModel: BuyAirtimeConfirmViewModel = viewModel()
) {
    val topUpId = navController.currentBackStackEntry?.arguments?.getString("TOPUP_ID")
    val state by buyAirtimeConfirmViewModel.state.collectAsState()

    val topUp = state.topUp.find { it.topUpId == topUpId }

    MainBackgroundHeader(
        topBar = {
            AppToolbar(
                title = "Top Up",
                navigateBack = {}
            )

        }
    ) {
        Box(
            modifier = Modifier
                .border(
                    2.dp,
                    color = MaterialTheme.colorScheme.inversePrimary,
                    shape = CircleShape
                )
                .size(50.dp)
                .background(MaterialTheme.colorScheme.onPrimary, CircleShape),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                painter = painterResource(Res.drawable.outline_check_24),
                contentDescription = null,
                modifier = Modifier.size(24.dp),
                tint = MaterialTheme.colorScheme.inversePrimary
            )
        }

        Text(text = "Message Show or Success")

        if (topUp!=null){
            BuyAirtimeConfirmComponent(
                topUp = topUp
            )
        }
    }

}


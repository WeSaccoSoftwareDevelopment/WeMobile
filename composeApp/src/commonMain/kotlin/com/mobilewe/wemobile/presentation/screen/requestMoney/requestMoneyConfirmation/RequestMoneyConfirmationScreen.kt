package com.mobilewe.wemobile.presentation.screen.requestMoney.requestMoneyConfirmation

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.mobilewe.wemobile.presentation.common.composables.appbar.AppToolbar
import com.mobilewe.wemobile.presentation.screen.requestMoney.requestMoneyConfirmation.composable.RequestMoneyConfirmComponent
import org.jetbrains.compose.resources.painterResource
import wemobile.composeapp.generated.resources.Res
import wemobile.composeapp.generated.resources.outline_check_24

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RequestMoneyConfirmationScreen(
    requestMoneyConfirmViewModel: RequestMoneyConfirmViewModel = viewModel(),
    requestMoneyId: String,
) {
    val state  by requestMoneyConfirmViewModel.uiState.collectAsState()
    val sendMoney = state.requestMoney.first { it.transactionId == requestMoneyId}

    Scaffold(
        topBar = {
            AppToolbar(
                title = "Send Money",
                navigateBack = {}
            )

        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(horizontal = 16.dp, vertical = 16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
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

            RequestMoneyConfirmComponent(
                sendMoney = sendMoney
            )
        }
    }
}
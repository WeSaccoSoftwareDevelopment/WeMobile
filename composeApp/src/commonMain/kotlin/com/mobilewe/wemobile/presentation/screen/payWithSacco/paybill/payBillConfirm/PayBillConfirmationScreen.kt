package com.mobilewe.wemobile.presentation.screen.payWithSacco.paybill.payBillConfirm

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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.mobilewe.wemobile.domain.model.PayBill
import com.mobilewe.wemobile.presentation.common.composables.appbar.AppToolbar
import org.jetbrains.compose.resources.painterResource
import wemobile.composeapp.generated.resources.Res
import wemobile.composeapp.generated.resources.outline_check_24

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PayBillConfirmationScreen(
    payBillConfirmViewModel: PayBillConfirmationViewModel = viewModel(),
    payBill: PayBill,
    onNavigateUp:()->Unit
) {
    Scaffold(
        topBar = {
            AppToolbar(
                title = "Pay Bill",
                navigateBack = {}
            )

        }
    ) { paddingValues ->
        Column(
            modifier = Modifier.fillMaxSize().padding(paddingValues)
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

            PayBillConfirmComponent(
                payBill = payBill,
                onClickDone = onNavigateUp
            )

        }

    }
}
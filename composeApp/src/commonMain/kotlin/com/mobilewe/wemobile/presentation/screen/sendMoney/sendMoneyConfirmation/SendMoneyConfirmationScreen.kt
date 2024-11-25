package com.mobilewe.wemobile.presentation.screen.sendMoney.sendMoneyConfirmation

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.mobilewe.wemobile.presentation.common.composables.MainBackgroundHeader
import com.mobilewe.wemobile.presentation.common.composables.appbar.AppToolbar
import com.mobilewe.wemobile.presentation.screen.sendMoney.components.SendMoneyConfirmComponent
import org.jetbrains.compose.resources.painterResource
import wemobile.composeapp.generated.resources.Res
import wemobile.composeapp.generated.resources.outline_check_24

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SendMoneyConfirmationScreen(
    transactionId: String,
    sendMoneyConfirmViewModel: SendMoneyConfirmViewModel = viewModel()
) {
    val uiState by sendMoneyConfirmViewModel.uiState.collectAsState()
    val sendMoney = sendMoneyConfirmViewModel.getTransaction(transactionId)

    LaunchedEffect(key1 = true) {
        uiState.sendMoney?.let { sendMoneyConfirmViewModel.setSendMoney(sendMoney) }
    }


    MainBackgroundHeader(
        topBar = {
            AppToolbar(
                title = "Send Money",
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


        SendMoneyConfirmComponent(
            sendMoney = sendMoney
        )

        Column {
            Text(text = sendMoney.amount.toString())
            Text(text = sendMoney.provider.providerName)
            Text(text = sendMoney.recipientPhoneNumber)
            Text(text = sendMoney.transactionId)
            Text(text = sendMoney.transactionDate)
            Text(text = sendMoney.transactionDate)
            Text(text = sendMoney.transactionDate)
        }
    }
}
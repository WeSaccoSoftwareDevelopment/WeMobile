package com.mobilewe.wemobile.presentation.screen.buyAirtime.components


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.mobilewe.wemobile.presentation.screen.buyAirtime.buyAirtime.BuyAirtimeUiState
import dev.icerock.moko.permissions.PermissionState

@Composable
fun BuyAirtimeForm(
    buyAirtimeState: BuyAirtimeUiState,
    onTargetRadioChange: (String) -> Unit,
    onPhoneNumberChange: (String) -> Unit,
    onAmountChange: (String) -> Unit,
    isSheetOpen: Boolean,
    setIsSheetOpen: (Boolean) -> Unit
) {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
       TargetRadioGroup(
            targetRadio = buyAirtimeState.targetRadio,
            onTargetRadioChange = onTargetRadioChange
        )

        if (buyAirtimeState.targetRadio == "someone_else") {
            PhoneNumberField(
                phoneNumber = buyAirtimeState.phoneNumber,
                onPhoneNumberChange = onPhoneNumberChange,
                isSheetOpen = isSheetOpen,
                setIsSheetOpen = setIsSheetOpen
            )
        }

        Spacer(modifier = Modifier.height(5.dp))

        AmountField(
            amount = buyAirtimeState.amount,
            onAmountChange = onAmountChange
        )

        Spacer(modifier = Modifier.height(24.dp))
    }
}
package com.mobilewe.wemobile.presentation.screen.buyAirtime.components


import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.ContentAlpha
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalContentColor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.mobilewe.wemobile.presentation.common.composables.textfield.RideOutlinedTextField
import com.mobilewe.wemobile.resources.Resources
import dev.icerock.moko.permissions.PermissionState

@Composable
fun PhoneNumberField(
    phoneNumber: String,
    onPhoneNumberChange: (String) -> Unit,
    isSheetOpen: Boolean,
    setIsSheetOpen: (Boolean) -> Unit
) {
    RideOutlinedTextField(
        value = phoneNumber,
        onValueChange = onPhoneNumberChange,
        keyboardType = KeyboardType.Phone,
        hint = Resources.strings.phoneNumber,
        trailingIcon = {
            Icon(
                imageVector = Icons.Outlined.Search,
                tint = LocalContentColor.current.copy(alpha = ContentAlpha.medium),
                contentDescription = "Call",
                modifier = Modifier
                    .padding(8.dp)
                    .size(24.dp)
                    .clickable {
//                        if (permissionState.) {
//                            setIsSheetOpen(true)
//                        } else {
//                            permissionState.launchPermissionRequest()
//                        }
                    },
            )
        }
    )
}

@Composable
fun AmountField(
    amount: String,
    onAmountChange: (String) -> Unit
) {
    RideOutlinedTextField(
        value = amount,
        onValueChange = onAmountChange,
        maxLength = 5,
        keyboardType = KeyboardType.Number,
        hint = "stringResource(id = R.string.amount)",
        supportText = "stringResource(id = R.string.amount_support_text)"
    )
}
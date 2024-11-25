package com.mobilewe.wemobile.presentation.common.composables.textfield

import androidx.compose.foundation.clickable
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForwardIos
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun AccountTypeTextField(
    accountTypeName: String,
    onCountryClick: () -> Unit,
    onAccountTypeChanged: (String)->Unit,
    hint: String = "Select account",
    label: String = "Pay With"
) {
    AppOutlinedTextField(
        text = accountTypeName,
        onValueChange = onAccountTypeChanged,
        hint = hint,
        label = label,
        trailingIcon = {
            Icon(
                imageVector = Icons.AutoMirrored.Filled.ArrowForwardIos,
                contentDescription = null,
                modifier = Modifier.clickable { onCountryClick() }
            )
        },
        readOnly = true
    )
}
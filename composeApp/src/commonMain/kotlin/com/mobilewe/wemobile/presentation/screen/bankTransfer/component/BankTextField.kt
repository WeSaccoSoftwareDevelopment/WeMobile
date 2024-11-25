package com.mobilewe.wemobile.presentation.screen.bankTransfer.component

import androidx.compose.foundation.clickable
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForwardIos
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.mobilewe.wemobile.presentation.common.composables.textfield.AppOutlinedTextField

@Composable
fun BankTextField(
    text: String,
    onClickTrailingIcon: () -> Unit,
    onValuedChanged: (String)->Unit,
    hint: String = "",
    label: String = ""
) {
    AppOutlinedTextField(
        text = text,
        onValueChange = onValuedChanged,
        hint = hint,
        label = label,
        trailingIcon = {
            Icon(
                imageVector = Icons.AutoMirrored.Filled.ArrowForwardIos,
                contentDescription = null,
                modifier = Modifier.clickable { onClickTrailingIcon() }
            )
        },
        readOnly = true
    )
}
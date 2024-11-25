package com.mobilewe.wemobile.presentation.common.composables.textfield

import androidx.compose.material.ContentAlpha
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color


@Composable
fun outlinedTextFieldColorDefaults(isError: Boolean = false) = OutlinedTextFieldDefaults.colors(
    disabledTextColor = MaterialTheme.colorScheme.onSurface.copy(alpha = ContentAlpha.disabled),
    cursorColor = MaterialTheme.colorScheme.onBackground,
    focusedBorderColor = if (isError) Color.Red else MaterialTheme.colorScheme.onSurface.copy(
        alpha = ContentAlpha.medium
    ),
    unfocusedBorderColor = if (isError) Color.Red else MaterialTheme.colorScheme.onSurface.copy(
        alpha = ContentAlpha.medium
    ),
    disabledBorderColor = MaterialTheme.colorScheme.onSurface.copy(alpha = ContentAlpha.disabled),
    errorBorderColor = Color.Red,
    disabledLeadingIconColor = MaterialTheme.colorScheme.onSurface.copy(alpha = ContentAlpha.disabled),
    errorLeadingIconColor = Color.Red,
    disabledTrailingIconColor = MaterialTheme.colorScheme.onSurface.copy(alpha = ContentAlpha.disabled),
    errorTrailingIconColor = Color.Red,
    focusedLabelColor = MaterialTheme.colorScheme.onSurface.copy(alpha = ContentAlpha.medium),
    unfocusedLabelColor = MaterialTheme.colorScheme.onSurface.copy(alpha = ContentAlpha.medium),
)
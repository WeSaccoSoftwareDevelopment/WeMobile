package com.mobilewe.wemobile.presentation.common.composables.textfield

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.mobilewe.wemobile.presentation.common.theme.WeThemes
import com.mobilewe.wemobile.presentation.common.composables.modifier.noRippleEffect

@Composable
fun WsSimpleTextField(
    text: String,
    hint: String,
    onValueChange: (String) -> Unit,
    onClick: () -> Unit = {},
    hintColor: Color = MaterialTheme.colorScheme.onTertiary,
    modifier: Modifier = Modifier,
    trailingPainter: Painter? = null,
    leadingPainter: Painter? = null,
    keyboardType: KeyboardType = KeyboardType.Text,
    radius: Dp = WeThemes.radius.medium,
    errorMessage: String = "",
    isError: Boolean = errorMessage.isNotEmpty(),
    onTrailingIconClick: () -> Unit = {},
    isSingleLine: Boolean = true,
    trailingIconEnabled: Boolean = onTrailingIconClick != {},
    outlinedTextFieldDefaults: TextFieldColors = OutlinedTextFieldColorDefaults()
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.Start
    ) {
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth().heightIn(min = 56.dp, max = 160.dp),
            value = text,
            placeholder = {
                Text(
                    hint,
                    style = WeThemes.typography.body,
                    color = hintColor,
                )
            },
            onValueChange = onValueChange,
            shape = RoundedCornerShape(radius),
            textStyle = WeThemes.typography.body.copy(color = MaterialTheme.colorScheme.onPrimary),
            singleLine = isSingleLine,
            keyboardOptions = KeyboardOptions(keyboardType = keyboardType),
            isError = isError,
            trailingIcon = {
                trailingPainter?.let {
                    IconButton(
                        onClick = onTrailingIconClick,
                        enabled = trailingIconEnabled,
                    ) {
                        Icon(
                            painter = trailingPainter,
                            contentDescription = "trailing icon",
                            tint = MaterialTheme.colorScheme.onTertiary
                        )
                    }
                }
            },
            leadingIcon = if (leadingPainter != null) {
                {
                    Icon(
                        painter = leadingPainter,
                        contentDescription = "leading icon",
                        tint = MaterialTheme.colorScheme.onSecondary,
                        modifier = Modifier.noRippleEffect(onClick)
                    )
                }
            } else null,
            colors = outlinedTextFieldDefaults,
        )
        AnimatedVisibility(isError) {
            Text(
                text = errorMessage,
                modifier = Modifier.padding(top = 8.dp),
                style = WeThemes.typography.caption,
                color = MaterialTheme.colorScheme.primary
            )
        }
    }

}

@Composable
fun OutlinedTextFieldColorDefaults() = OutlinedTextFieldDefaults.colors(
    focusedContainerColor = MaterialTheme.colorScheme.surface,
    unfocusedContainerColor = MaterialTheme.colorScheme.surface,
    cursorColor = MaterialTheme.colorScheme.onTertiary,
    errorCursorColor = MaterialTheme.colorScheme.primary,
    focusedBorderColor = MaterialTheme.colorScheme.onTertiary.copy(alpha = 0.2f),
    unfocusedBorderColor = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.1f),
    errorBorderColor = MaterialTheme.colorScheme.primary.copy(alpha = 0.5f),
)


package com.mobilewe.wemobile.presentation.common.composables.textfield

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.mobilewe.wemobile.presentation.common.theme.WeThemes

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WsPriceField(
    text: String,
    onValueChange: (String) -> Unit,
    flag: Painter,
    currency: String,
    modifier: Modifier = Modifier,
    label: String = "",
    hint: String = "",
    keyboardType: KeyboardType = KeyboardType.Text,
    shapeRadius: Shape = RoundedCornerShape(WeThemes.radius.medium),
    errorMessage: String = "",
    correctValidation: Boolean = false,
    isError: Boolean = errorMessage.isNotEmpty(),

    ) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.Start
    ) {
        Text(
            text = label,
            modifier = Modifier.padding(bottom = WeThemes.dimens.space8),
            style = WeThemes.typography.title,
            color = MaterialTheme.colorScheme.onPrimary
        )

        OutlinedTextField(
            modifier = Modifier.fillMaxWidth().height(56.dp),
            value = text,
            placeholder = {
                Text(
                    hint,
                    style = WeThemes.typography.caption,
                    color = MaterialTheme.colorScheme.onTertiary
                )
            },
            onValueChange = onValueChange,
            shape = shapeRadius,
            textStyle = WeThemes.typography.body.copy(MaterialTheme.colorScheme.onPrimary),
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = keyboardType),
            trailingIcon = {
                Row(
                    modifier = Modifier.padding(end = WeThemes.dimens.space8),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(WeThemes.dimens.space8)
                ) {
                    Image(
                        painter = flag,
                        contentDescription = currency,)
                    Text(
                        text = currency,
                        style = WeThemes.typography.body,
                        color = MaterialTheme.colorScheme.onSecondary
                    )
                }

            },
            isError = isError,
            colors = OutlinedTextFieldDefaults.colors(
                unfocusedBorderColor = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.1f),
                focusedBorderColor = MaterialTheme.colorScheme.onTertiary.copy(alpha = 0.2f),
                errorBorderColor = MaterialTheme.colorScheme.primary.copy(alpha = 0.5f),
                errorCursorColor = MaterialTheme.colorScheme.primary,
                cursorColor = MaterialTheme.colorScheme.onTertiary,
            ),
        )

        AnimatedVisibility(isError) {
            Text(
                text = errorMessage,
                modifier = Modifier.padding(top = WeThemes.dimens.space8),
                style = WeThemes.typography.caption,
                color = MaterialTheme.colorScheme.primary
            )
        }
    }
}
@Composable
private fun containerColor(isError: Boolean, correctValidation: Boolean): Color {
    return if (isError) {
        MaterialTheme.colorScheme.surface
    } else if (correctValidation) {
        MaterialTheme.colorScheme.surface
    } else {
        MaterialTheme.colorScheme.surface
    }
}
package com.mobilewe.wemobile.presentation.common.composables.textfield

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.ContentAlpha
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.mobilewe.wemobile.presentation.common.theme.WeThemes


@Composable
fun RideOutlinedTextField(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    hint: String = "",
    maxLength: Int = 20,
    isError: Boolean = false,
    textStyle: TextStyle = LocalTextStyle.current,
    leadingIcon: ImageVector? = null,
    trailingIcon: (@Composable () -> Unit)? = null,
    keyboardActions: KeyboardActions = KeyboardActions.Default,
    singleLine: Boolean = false,
    keyboardType: KeyboardType = KeyboardType.Text,
    maxLines: Int = if (singleLine) 1 else Int.MAX_VALUE,
    minLines: Int = 1,
    supportText: String = "",
    accountNumberLength: String = "",
    error: String = "",
    readOnly: Boolean = false,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    showErrorBorder: Boolean = false,
    focusRequester: FocusRequester = FocusRequester()


) {

    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        OutlinedTextField(
            value = value,
            onValueChange = {
                if (it.length <= maxLength) {
                    onValueChange(it)
                }
            },
            placeholder = {
                Text(
                    text = hint,
                    style = WeThemes.typography.labelSmall,
                    color = LocalContentColor.current.copy(alpha = ContentAlpha.medium),)
            },
            label = {
                Text(
                    text = hint,
                    style = WeThemes.typography.labelSmall,
                    color = LocalContentColor.current.copy(alpha = ContentAlpha.medium),
                )
            },
            modifier = modifier
                .focusRequester(focusRequester = focusRequester)
                .fillMaxWidth()
                .semantics {},
            keyboardOptions = KeyboardOptions(keyboardType = keyboardType),
            readOnly = readOnly,
            leadingIcon = if (leadingIcon != null) {
                val icon: @Composable () -> Unit = {
                    Icon(
                        imageVector = leadingIcon,
                        contentDescription = null,
                        modifier = Modifier.size(25.dp)
                    )
                }
                icon
            } else null,
            trailingIcon = trailingIcon,
            isError = isError,
            interactionSource = interactionSource,
            singleLine = true,
            maxLines = maxLines,
            textStyle = textStyle,
            colors = outlinedTextFieldColorDefaults(isError = isError)
        )
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            if (error.isNotEmpty()) {
                Text(
                    text = error,
                    textAlign = TextAlign.Start,
                    style = WeThemes.typography.labelSmall,
                    color = Color.Red
                )

            } else {
                Text(
                    text = supportText,
                    style = WeThemes.typography.labelMedium,
                    color = LocalContentColor.current.copy(alpha = ContentAlpha.medium),
                    modifier = Modifier
                        .padding(start = 12.dp, top = 2.dp),
                    textAlign = TextAlign.Start

                )
            }
            Text(
                text = accountNumberLength,
                style = WeThemes.typography.labelMedium,
                color = LocalContentColor.current.copy(alpha = ContentAlpha.medium),
                modifier = Modifier
                    .padding(end = 12.dp, top = 2.dp),
                textAlign = TextAlign.End
            )

        }

    }
}


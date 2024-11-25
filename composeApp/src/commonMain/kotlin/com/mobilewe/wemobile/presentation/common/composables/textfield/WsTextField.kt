package com.mobilewe.wemobile.presentation.common.composables.textfield

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Visibility
import androidx.compose.material.icons.outlined.VisibilityOff
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.mobilewe.wemobile.presentation.common.theme.WeThemes.dimens
import com.mobilewe.wemobile.presentation.common.theme.WeThemes.radius
import com.mobilewe.wemobile.presentation.common.theme.WeThemes.typography

@Composable
fun WsTextField(
    label: String,
    text: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    textFieldModifier: Modifier = Modifier.fillMaxWidth().height(56.dp),
    hint: String = "",
    keyboardType: KeyboardType = KeyboardType.Text,
    shapeRadius: Shape = RoundedCornerShape(radius.medium),
    singleLine: Boolean = true,
    errorMessage: String = "",
    correctValidation: Boolean = false,
    isError: Boolean = errorMessage.isNotEmpty(),
    maxLength: Int = 40
) {
    var showPassword by remember { mutableStateOf(false) }

    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.Start
    ) {
        Text(
            text = label,
            modifier = Modifier.padding(bottom = dimens.space8),
            style = typography.title
        )
        OutlinedTextField(
            modifier = textFieldModifier,
            value = text,
            placeholder = {
                Text(
                    hint,
                    style = typography.caption
                )
            },
            onValueChange = {
                if (it.length <= maxLength) {
                    onValueChange(it)
                }
            },
            shape = shapeRadius,
            textStyle = typography.body.copy(MaterialTheme.colorScheme.onBackground),
            singleLine = singleLine,
            keyboardOptions = KeyboardOptions(keyboardType = keyboardType),
            trailingIcon = if (keyboardType == KeyboardType.Password) {
                { TrailingIcon(showPassword) { showPassword = !showPassword } }
            } else null,
            visualTransformation = wsVisualTransformation(keyboardType, showPassword),
            isError = isError,
            colors = outlinedTextFieldColorDefaults(isError = isError),
        )

        AnimatedVisibility(isError) {
            Text(
                text = errorMessage,
                modifier = Modifier.padding(top = dimens.space8),
                style = typography.caption,
                color = colorScheme.primary
            )
        }
    }
}

@Composable
private fun containerColor(isError: Boolean, correctValidation: Boolean): Color {
    return if (isError) {
        colorScheme.surface
    } else if (correctValidation) {
        colorScheme.surface
    } else {
        colorScheme.surface
    }
}

@Composable
private fun TrailingIcon(
    showPassword: Boolean,
    togglePasswordVisibility: () -> Unit
) {
    IconButton(onClick = { togglePasswordVisibility() }) {
        Icon(
            imageVector = if (showPassword) Icons.Outlined.VisibilityOff else Icons.Outlined.Visibility,
            contentDescription = if (showPassword) "Show Password" else "Hide Password",
            tint = MaterialTheme.colorScheme.primary
        )
    }

}

@Composable
private fun wsVisualTransformation(
    keyboardType: KeyboardType,
    showPassword: Boolean
): VisualTransformation {
    return if (showPassword || keyboardType != KeyboardType.Password && keyboardType != KeyboardType.NumberPassword) {
        VisualTransformation.None
    } else {
        PasswordVisualTransformation()
    }
}
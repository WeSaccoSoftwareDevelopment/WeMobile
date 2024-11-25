package com.mobilewe.wemobile.presentation.common.composables.textfield

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mobilewe.wemobile.presentation.common.theme.WeThemes


@Composable
fun AppOutlinedTextField(
    modifier: Modifier = Modifier,
    text: String,
    hint: String = "",
    label: String = "",
    maxLength: Int = 40,
    errorMessage: String = "",
    singleLine: Boolean = true,
    maxLines: Int = 1,
    leadingIcon: ImageVector? = null,
    leadingIconComponent: (@Composable () -> Unit)? = null,
    trailingIcon: (@Composable () -> Unit)? = null,
    supportingText: (@Composable () -> Unit)? = null,
    keyboardType: KeyboardType = KeyboardType.Text,
    isPasswordToggleDisplayed: Boolean = keyboardType == KeyboardType.Password,
    isPasswordVisible: Boolean = false,
    onPasswordToggleClick: (Boolean) -> Unit = {},
    onValueChange: (String) -> Unit,
    focusRequester: FocusRequester = FocusRequester(),
    readOnly: Boolean = false,
    shapeRadius: Shape = RoundedCornerShape(WeThemes.radius.medium),
    isError: Boolean = errorMessage.isNotEmpty(),

    ) {
    val interactionSource = remember { MutableInteractionSource() }

    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.Start
    ) {
        Text(
            text = label,
            modifier = Modifier.padding(bottom = WeThemes.dimens.space8),
            fontSize = 14.sp,
            fontWeight = FontWeight.W600,
        )

        OutlinedTextField(
            value = text,
            onValueChange = {
                if (it.length <= maxLength) {
                    onValueChange(it)
                }
            },
            maxLines = maxLines,
            readOnly = readOnly,
            placeholder = {
                Text(
                    text = hint,
                    textAlign = TextAlign.Start,
                    fontWeight = FontWeight.W400,
                    fontSize = 12.sp
                )
            },
            shape = shapeRadius,
            isError = isError,
            keyboardOptions = KeyboardOptions(
                keyboardType = keyboardType
            ),
            visualTransformation = if (!isPasswordVisible && isPasswordToggleDisplayed) {
                PasswordVisualTransformation()
            } else {
                VisualTransformation.None
            },
            singleLine = singleLine,
            leadingIcon = if (leadingIcon != null) {
                val icon: @Composable () -> Unit = {
                    Icon(
                        imageVector = leadingIcon,
                        contentDescription = null,
                        modifier = Modifier.size(25.dp)
                    )
                }
                icon
            } else leadingIconComponent,
            trailingIcon = if (isPasswordToggleDisplayed) {
                val icon: @Composable () -> Unit = {
                    IconButton(onClick = {
                        onPasswordToggleClick(!isPasswordVisible)
                    }, modifier = Modifier.semantics {
                        testTag = "TestTags.PASSWORD_TOGGLE"
                    }) {
                        Icon(
                            imageVector = if (isPasswordVisible) {
                                Icons.Filled.VisibilityOff
                            } else {
                                Icons.Filled.Visibility
                            }, tint = MaterialTheme.colorScheme.primary, contentDescription = if (isPasswordVisible) {
                               " stringResource(id = R.string.password_visible_content_description)"
                            } else {
                                "stringResource(id = R.string.password_hidden_content_description)"
                            }, modifier = Modifier.padding(end = 10.dp)
                        )
                    }
                }
                icon
            } else trailingIcon,
            interactionSource = interactionSource,
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp)
                .semantics {
                    testTag = "TestTags.STANDARD_TEXT_FIELD"
                }
                .focusRequester(focusRequester = focusRequester),
            colors = outlinedTextFieldColorDefaults(isError = isError),

            )
        AnimatedVisibility(isError) {
            Text(
                text = errorMessage,
                modifier = Modifier.padding(top = WeThemes.dimens.space8),
                fontWeight = FontWeight.W400,
                fontSize = 12.sp,
                color = Color.Red
            )
        }
    }

}

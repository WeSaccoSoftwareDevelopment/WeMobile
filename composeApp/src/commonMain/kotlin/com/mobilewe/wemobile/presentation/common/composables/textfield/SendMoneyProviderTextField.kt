package com.mobilewe.wemobile.presentation.common.composables.textfield

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.ContentAlpha
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.toSize
import coil3.compose.AsyncImage
import com.mobilewe.wemobile.domain.model.RecipientProvider
import com.mobilewe.wemobile.domain.model.recipientProvider
import com.mobilewe.wemobile.presentation.common.theme.WeThemes
import com.mobilewe.wemobile.utils.clickableWithoutRipple

@Composable
fun SendMoneyProviderTextField(
    modifier: Modifier = Modifier,
    recipientProviderText: String,
    onRecipientProvider: (RecipientProvider) -> Unit,
    isError: Boolean = false,
    leadingRecipientIcon: String,
    onClickTrailingIcon: ()-> Unit,
    label: String = "Send to",
    hint: String = "Select recipient"
) {
    val colors = OutlinedTextFieldDefaults.colors(
        disabledTextColor = MaterialTheme.colorScheme.onSurface.copy(alpha = ContentAlpha.disabled),
        cursorColor = MaterialTheme.colorScheme.onBackground,
        focusedBorderColor = if (isError) Color.Red else MaterialTheme.colorScheme.onSurface.copy(alpha = ContentAlpha.medium),
        unfocusedBorderColor = if (isError) Color.Red else MaterialTheme.colorScheme.onSurface.copy(alpha = ContentAlpha.medium),
        disabledBorderColor = MaterialTheme.colorScheme.onSurface.copy(alpha = ContentAlpha.disabled),
        errorBorderColor = Color.Red,
        disabledLeadingIconColor = MaterialTheme.colorScheme.onSurface.copy(alpha = ContentAlpha.disabled),
        errorLeadingIconColor = Color.Red,
        disabledTrailingIconColor = MaterialTheme.colorScheme.onSurface.copy(alpha = ContentAlpha.disabled),
        errorTrailingIconColor = Color.Red,
        focusedLabelColor = MaterialTheme.colorScheme.onSurface.copy(alpha = ContentAlpha.medium),
        unfocusedLabelColor = MaterialTheme.colorScheme.onSurface.copy(alpha = ContentAlpha.medium),
    )
    var textfieldSize by remember { mutableStateOf(Size.Zero) }
    var expanded by remember { mutableStateOf(false) }
    val interactionSource = remember { MutableInteractionSource() }
    if (interactionSource.collectIsPressedAsState().value)
        expanded = !expanded
    val icon = if (expanded) Icons.Filled.KeyboardArrowUp else Icons.Filled.KeyboardArrowDown
    var isSheetOpen by rememberSaveable { mutableStateOf(false) }

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
            value = recipientProviderText,
            onValueChange = { newValue ->
                val newProvider = recipientProvider.find { it.name == newValue }
                if (newProvider != null) {
                    onRecipientProvider(newProvider)
                }
            },
            placeholder = {
                Text(
                    text = hint,
                    textAlign = TextAlign.Start,
                    fontWeight = FontWeight.W400,
                    fontSize = 12.sp
                )
            },
            trailingIcon = {
                Icon(
                    icon, "contentDescription",
                    Modifier.clickableWithoutRipple(interactionSource = interactionSource,
                        onClick = {
                            expanded = !expanded
                            onClickTrailingIcon()
                        }
                    )
                )
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 10.dp)
                .clickableWithoutRipple(
                    interactionSource = interactionSource,
                    onClick = {
                        expanded = !expanded
                        onClickTrailingIcon()
                    }
                )
                .onGloballyPositioned { coordinates ->
                    textfieldSize = coordinates.size.toSize()
                },
            readOnly = true,
            leadingIcon = {
                AsyncImage(
                    model = leadingRecipientIcon,
                    contentDescription = "contentDescription",
                    modifier = Modifier.size(24.dp).clickableWithoutRipple(
                        interactionSource = interactionSource,
                        onClick = {
                            expanded = !expanded
                            isSheetOpen = true
                        }
                    )
                )
            },
            interactionSource = interactionSource,
            colors = colors
        )
    }
}





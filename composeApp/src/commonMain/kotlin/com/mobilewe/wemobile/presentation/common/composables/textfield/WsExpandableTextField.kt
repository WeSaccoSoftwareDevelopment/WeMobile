package com.mobilewe.wemobile.presentation.common.composables.textfield

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.mobilewe.wemobile.presentation.common.theme.WeThemes.dimens
import com.mobilewe.wemobile.presentation.common.theme.WeThemes.radius
import com.mobilewe.wemobile.presentation.common.theme.WeThemes.typography


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WsExpandableTextField(
    label: String,
    text: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    hint: String = "",
    keyboardType: KeyboardType = KeyboardType.Text,
    shapeRadius: Shape = RoundedCornerShape(radius.medium),
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.Start
    ) {
        Text(
            text = label,
            modifier = Modifier.padding(bottom = dimens.space8),
            style = typography.title,
            color = colorScheme.onPrimary
        )

        OutlinedTextField(
            modifier = Modifier.fillMaxWidth().heightIn(min = 104.dp, max = 160.dp),
            value = text,
            placeholder = {
                Text(
                    hint,
                    style = typography.caption,
                    color = colorScheme.onTertiary
                )
            },
            onValueChange = onValueChange,
            shape = shapeRadius,
            textStyle = typography.body.copy(colorScheme.onPrimary),
            singleLine = false,
            keyboardOptions = KeyboardOptions(keyboardType = keyboardType),
            colors = OutlinedTextFieldDefaults.colors(
                focusedContainerColor = colorScheme.surface,
                unfocusedBorderColor = colorScheme.onPrimaryContainer.copy(alpha = 0.1f),
                focusedBorderColor = colorScheme.onTertiary.copy(alpha = 0.2f),
                cursorColor = colorScheme.onTertiary,
            ),
        )
    }
}

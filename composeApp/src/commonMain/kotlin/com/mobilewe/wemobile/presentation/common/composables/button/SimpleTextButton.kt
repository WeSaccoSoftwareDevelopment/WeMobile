package com.mobilewe.wemobile.presentation.common.composables.button

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.material3.MaterialTheme
import com.mobilewe.wemobile.presentation.common.theme.WeThemes


@Composable
fun SimpleTextButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    textColor: Color = MaterialTheme.colorScheme.primary,
    shape: RoundedCornerShape = RoundedCornerShape(WeThemes.radius.small),
    height: Dp = 34.dp,
    border: BorderStroke = BorderStroke(width = 1.dp, color = MaterialTheme.colorScheme.primary)
) {
    TextButton(
        onClick = onClick,
        modifier = modifier.height(height),
        shape = shape,
        border = border,
        contentPadding = PaddingValues(vertical = 8.dp, horizontal = 16.dp)
    ) {
        Text(text = text, style = WeThemes.typography.title, color = textColor)
    }
}
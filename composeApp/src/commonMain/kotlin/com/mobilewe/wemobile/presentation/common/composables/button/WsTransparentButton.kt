package com.mobilewe.wemobile.presentation.common.composables.button

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.dp
import com.mobilewe.wemobile.presentation.common.theme.WeThemes.typography

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WsTransparentButton(
    title: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled : Boolean = true,
    shape: Shape = RoundedCornerShape(8.dp),
    contentColor: Color = MaterialTheme.colorScheme.onTertiary,
    horizontalArrangement: Arrangement.Horizontal = Arrangement.Center
) {

    Surface(
        modifier = modifier.height(32.dp),
        onClick = onClick,
        shape = shape,
        enabled = enabled,
        color = Color.Transparent,
        contentColor = contentColor,
    ) {
        Row(
            Modifier
                .defaultMinSize(
                    minWidth = ButtonDefaults.MinWidth,
                    minHeight = ButtonDefaults.MinHeight
                ),
            horizontalArrangement = horizontalArrangement,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(text = title, style = typography.title.copy(color = contentColor))
        }
    }
}
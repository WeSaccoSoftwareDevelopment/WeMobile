package com.mobilewe.wemobile.presentation.common.composables.button

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.dp
import com.mobilewe.wemobile.presentation.common.composables.WsThreeDotLoadingIndicator
import com.mobilewe.wemobile.presentation.common.theme.*

@ExperimentalMaterial3Api
@Composable
fun WsButton(
    title: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    painter: Painter? = null,
    enabled: Boolean = true,
    textPadding: PaddingValues = PaddingValues(WeThemes.dimens.space16),
    shape: Shape = RoundedCornerShape(WeThemes.radius.medium),
    containerColor: Color = MaterialTheme.colorScheme.primary,
    contentColor: Color = MaterialTheme.colorScheme.onPrimary,
    horizontalArrangement: Arrangement.Horizontal = Arrangement.Center,
    isLoading: Boolean = false,
) {
    val buttonColor by animateColorAsState(
        if (enabled) containerColor else MaterialTheme.colorScheme.surface
    )

    Surface(
        modifier = modifier.height(56.dp),
        onClick = onClick,
        shape = shape,
        color = buttonColor,
        enabled = enabled,
        contentColor = contentColor,
    ) {
        Row(
            Modifier.defaultMinSize(
                minWidth = ButtonDefaults.MinWidth,
                minHeight = ButtonDefaults.MinHeight
            ),
            horizontalArrangement = horizontalArrangement,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            painter?.let {
                Image(
                    modifier = Modifier
                        .size(WeThemes.dimens.space24)
                        .padding(end = WeThemes.dimens.space8),
                    painter = painter,
                    contentDescription = null
                )
            }
            AnimatedContent(targetState = isLoading, label = "") {
                if (isLoading) WsThreeDotLoadingIndicator()
                else Text(
                    text = title,
                    style = WeThemes.typography.titleLarge.copy(color = contentColor),
                    modifier = Modifier.padding(textPadding)
                )
            }
        }
    }
}
package com.mobilewe.wemobile.presentation.common.composables

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import com.mobilewe.wemobile.presentation.common.theme.WeThemes

@Composable
fun WsSnackBar(
    icon: Painter,
    modifier: Modifier = Modifier,
    isVisible: Boolean = true,
    iconTint: Color = MaterialTheme.colorScheme.primary,
    iconBackgroundColor: Color = MaterialTheme.colorScheme.surface,
    backgroundColor: Color = MaterialTheme.colorScheme.surface,
    content: @Composable () -> Unit,
) {
    AnimatedVisibility(
        visible = isVisible,
        enter = slideInVertically { it },
        exit = slideOutVertically { it },
        modifier = modifier
    ) {
        Row(
            modifier = Modifier.fillMaxWidth()
                .padding(horizontal = WeThemes.dimens.space16, vertical = WeThemes.dimens.space24)
                .clip(RoundedCornerShape(WeThemes.radius.medium))
                .background(backgroundColor)
                .padding(horizontal = WeThemes.dimens.space16, vertical = WeThemes.dimens.space8),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(WeThemes.dimens.space8)
        ) {
            Icon(
                modifier = Modifier.background(
                    color = iconBackgroundColor,
                    shape = RoundedCornerShape(WeThemes.radius.medium)
                ).padding(WeThemes.dimens.space8),
                painter = icon,
                contentDescription = null,
                tint = iconTint
            )
            content()
        }
    }
}
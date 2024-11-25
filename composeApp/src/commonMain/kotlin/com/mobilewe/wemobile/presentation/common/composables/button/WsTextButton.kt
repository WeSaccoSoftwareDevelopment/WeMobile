package com.mobilewe.wemobile.presentation.common.composables.button

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.mobilewe.wemobile.presentation.common.theme.WeThemes
import com.mobilewe.wemobile.presentation.common.theme.WeThemes.dimens
import com.mobilewe.wemobile.presentation.common.theme.WeThemes.radius
import com.mobilewe.wemobile.presentation.common.theme.WeThemes.typography

@Composable
fun WsTextButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    heightInDp: Int = 32,
) {
    Surface(
        modifier = modifier
            .height(heightInDp.dp)
            .border(width = 1.dp, color = colorScheme.onBackground, shape = RoundedCornerShape(radius.small))
            .padding(horizontal = WeThemes.dimens.space16, vertical = dimens.space8)
            .clickable(
                indication = null,
                interactionSource = remember { MutableInteractionSource() }
            ) { onClick() },
        color = Color.Transparent,
    ) {
        Text(text = text, style = typography.body, color = colorScheme.onPrimary,)
    }
}
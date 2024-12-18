package com.mobilewe.wemobile.presentation.screen.auth.pickLanguage.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.mobilewe.wemobile.presentation.common.theme.WeThemes
import com.mobilewe.wemobile.presentation.screen.auth.pickLanguage.LanguageUIState
import org.jetbrains.compose.resources.ExperimentalResourceApi


@OptIn(ExperimentalResourceApi::class)
@Composable
fun LanguageCard(onClick: () -> Unit,state: LanguageUIState) {
    Box(
        modifier = Modifier
            .height(88.dp)
            .clickable(
                indication = null,
                interactionSource = remember { MutableInteractionSource() } ,
            ) { onClick() },
        contentAlignment = Alignment.Center
    ) {
        /*Image(
            painter = painterResource(state.image),
            contentDescription = "${state.name} Picture",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.clip(MaterialTheme.shapes.large)
        )*/
        Box(
            modifier = Modifier.fillMaxSize().background(
                Color.Black.copy(alpha = 0.4f),
                shape = MaterialTheme.shapes.large
            )
        )
        Text(
            text = state.name,
            style = WeThemes.typography.titleLarge,
            color = MaterialTheme.colorScheme.onPrimary
        )
    }
}
package com.mobilewe.wemobile.presentation.common.composables

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.BiasAlignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.mobilewe.wemobile.presentation.common.theme.WeThemes

@Composable
fun WsTap(
    firstTabLabel: String,
    secondTabLabel: String,
    onTap: (Int) -> Unit,
    modifier: Modifier = Modifier,
    selectedTab: Int = 1,

    ) {
    val horizontalBias by animateFloatAsState(
        targetValue = when (selectedTab == 2) {
            true -> 1f
            else -> -1f
        },
        animationSpec = tween(500)
    )
    val alignment = remember {
        derivedStateOf {
            BiasAlignment(horizontalBias = horizontalBias, verticalBias = 0f)
        }
    }
    Box(
        modifier
            .border(
                width = 1.dp, color = MaterialTheme.colorScheme.onBackground, shape = RoundedCornerShape(
                    WeThemes.radius.medium
                )
            )
            .fillMaxWidth()
            .height(40.dp)
            .background(
                color = MaterialTheme.colorScheme.background,
                shape = RoundedCornerShape(WeThemes.radius.medium)
            )

    ) {

        Card(
            modifier = Modifier
                .fillMaxWidth(.5f)
                .fillMaxHeight()
                .padding(WeThemes.dimens.space4)
                .align(alignment.value),
            shape = RoundedCornerShape(WeThemes.radius.small),
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primary),
            elevation = CardDefaults.elevatedCardElevation(0.dp),
        ) {}
        Row(
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxSize()
        ) {
            Text(
                text = firstTabLabel,
                style = WeThemes.typography.titleMedium,
                color = if (selectedTab == 1) Color.White else MaterialTheme.colorScheme.onTertiary,
                textAlign = TextAlign.Center,
                modifier = Modifier.clickable(
                    indication = null,
                    interactionSource = remember { MutableInteractionSource() }
                ) { onTap(1) }
            )
            Text(
                text = secondTabLabel,
                style = WeThemes.typography.titleMedium,
                color = if (selectedTab == 2) Color.White else MaterialTheme.colorScheme.onTertiary,
                textAlign = TextAlign.Center,
                modifier = Modifier.clickable(
                    indication = null,
                    interactionSource = remember { MutableInteractionSource() }
                ) { onTap(2) }
            )
        }
    }
}
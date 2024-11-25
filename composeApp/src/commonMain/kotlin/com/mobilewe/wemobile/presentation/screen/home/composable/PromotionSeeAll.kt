package com.mobilewe.wemobile.presentation.screen.home.composable

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.resources.painterResource
import wemobile.composeapp.generated.resources.Res
import wemobile.composeapp.generated.resources.chevron_right

@Composable
fun PromotionSeeAll(
    onClickSeeAllPromotion:()->Unit
) {
    val interactionSource = remember { MutableInteractionSource() }
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "Promotions",
            fontSize = 14.sp
        )
        Row(
            modifier = Modifier.clickable(interactionSource, null) {
                onClickSeeAllPromotion()
            }
        ) {
            Text(
                text = "Show All",
                color = MaterialTheme.colorScheme.primary,
                fontSize = 14.sp
            )
            Icon(
                painter = painterResource(Res.drawable.chevron_right),
                contentDescription = null,
                tint = MaterialTheme.colorScheme.primary
            )
        }
    }

}
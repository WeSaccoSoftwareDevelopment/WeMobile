package com.mobilewe.wemobile.presentation.screen.home.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.painterResource
import wemobile.composeapp.generated.resources.Res
import wemobile.composeapp.generated.resources.sako_outlined_icon


@Composable
fun PromotionCardItem() {
    Card(
        modifier = Modifier
            .width(300.dp)
            .height(140.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.outline
        )
    ) {
       Image(
           painter = painterResource(Res.drawable.sako_outlined_icon),
           contentDescription = null,
           modifier = Modifier
               .fillMaxWidth()
               .fillMaxHeight()
       )
    }

}


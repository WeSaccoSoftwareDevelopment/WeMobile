package com.mobilewe.wemobile.presentation.screen.account.account.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mobilewe.wemobile.presentation.common.theme.WeThemes
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource


@Composable
fun AccountCardItem(
   text: String,
    subTitle: String?,
    icon: DrawableResource,
    onClick: (String) -> Unit,
    showDrawableColorTint: Boolean = false

) {
    val interaction = remember {
        MutableInteractionSource()
    }
    Card(
        modifier = Modifier
            .width(120.dp)
            .wrapContentHeight()
            .clickable(interaction, null) {
                onClick(text)
            },
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.outline  )

        ) {
        Column(
            modifier = Modifier
                .padding(all = 16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.Start
        ) {
            Image(
                painter = painterResource(icon),
                contentDescription = null,
                modifier = Modifier.size(24.dp),
                colorFilter = if (showDrawableColorTint) null else ColorFilter.tint(MaterialTheme.colorScheme.primary)
            )
            Spacer(modifier = Modifier.height(14.dp))
            Text(
                text = text,
                style = WeThemes.typography.titleSmall,
                textAlign = TextAlign.Start,
                modifier = Modifier.fillMaxWidth(),
                color = MaterialTheme.colorScheme.onBackground,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis

            )
            Spacer(modifier = Modifier.height(8.dp))
            if (subTitle !=null){
                Text(
                    text = "stringResource(id = subTitle)",
                    fontSize = 11.sp,
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Start,
                    color = Color(0xFF8B8B8B),
                )
            }

        }
    }

}
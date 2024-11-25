package com.mobilewe.wemobile.presentation.screen.home.composable


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.mobilewe.wemobile.presentation.common.theme.WeThemes
import com.mobilewe.wemobile.utils.clickableWithoutRipple
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource


@Composable
fun TextImageItem(
    drawable: DrawableResource,
    stringRes: String,
    onItemClick: (String) -> Unit
) {
    val sizeIcon = 24.dp
    Column(
        modifier = Modifier
            .wrapContentHeight()
            .clickableWithoutRipple { onItemClick(stringRes) },
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .clip(CircleShape)
                .size(48.dp)
                .background(MaterialTheme.colorScheme.primary),
            contentAlignment = Alignment.Center

        ) {
            Icon(
                painter = painterResource(drawable),
                contentDescription = "",
                modifier = Modifier
                    .size(sizeIcon),
                tint = MaterialTheme.colorScheme.background
            )

        }
        Spacer(modifier = Modifier.height(5.dp))
        Text(
            text = stringRes,
            textAlign = TextAlign.Center,
            style = WeThemes.typography.labelSmall,
            color = MaterialTheme.colorScheme.onBackground

        )

    }

}


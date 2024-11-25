package com.mobilewe.wemobile.presentation.common.composables.appbar

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.mobilewe.wemobile.presentation.common.theme.WeThemes
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource


@Composable
fun TextWithRightChevron(
    modifier: Modifier = Modifier,
    icon: DrawableResource,
    title: String,
    onItemClick: () -> Unit
) {

    Surface(
        onClick = { onItemClick() },
        shape = RoundedCornerShape(WeThemes.dimens.space10),
        color = MaterialTheme.colorScheme.background,
        modifier = modifier
    ) {

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(
                horizontal = WeThemes.dimens.space10,
                vertical = WeThemes.dimens.space10
            )
        ) {

            Text(
                text = title, style = WeThemes.typography.titleMedium,
                color = MaterialTheme.colorScheme.onBackground,
                modifier = Modifier
                    .weight(1f)
            )

            Icon(
                painter = painterResource(icon),
                contentDescription = null,
                modifier = Modifier.size(20.dp),
                tint = MaterialTheme.colorScheme.onBackground
            )
        }

    }

}
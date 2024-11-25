package com.mobilewe.wemobile.presentation.screen.account.account.composable


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
import wemobile.composeapp.generated.resources.Res
import wemobile.composeapp.generated.resources.chevron_right


@Composable
fun AccountItem(
    modifier: Modifier = Modifier,
    icon: DrawableResource,
    title: String,
    onItemClick: () -> Unit
) {

    Surface(
        onClick = { onItemClick() },
        shape = RoundedCornerShape(10.dp),
        color = MaterialTheme.colorScheme.background,
        modifier = modifier
    ) {

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(
                horizontal = 10.dp,
                vertical = 10.dp
            )
        ) {
            Icon(
                painter = painterResource(icon),
                contentDescription = null,
                modifier = Modifier.size(20.dp),
            )

            Text(
                text = title, style = WeThemes.typography.titleMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .weight(1f)
            )

            Icon(
                painter = painterResource(Res.drawable.chevron_right),
                contentDescription = null,
                modifier = Modifier.size(20.dp),
            )
        }

    }

}
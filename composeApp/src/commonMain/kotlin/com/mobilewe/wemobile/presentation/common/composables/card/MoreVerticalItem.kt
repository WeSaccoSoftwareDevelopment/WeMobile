package com.mobilewe.wemobile.presentation.common.composables.card



import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.mobilewe.wemobile.presentation.common.composables.divider.WeSaccoDivider
import com.mobilewe.wemobile.presentation.common.theme.WeThemes
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource


@Composable
fun MoreVerticalItem(
    modifier: Modifier = Modifier,
    drawable: DrawableResource? = null,
    title: String,
    subtitle: String? = null,
    onClick: (String) -> Unit = { String },
    onCheckChange: (Boolean) -> Unit = {},
    isChecked: Boolean = false ,
    showSwitcher: Boolean = false,
    statusNotification: Boolean = false,
    showColorFilter: Boolean = false
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(MutableInteractionSource(), null, onClickLabel = title.toString()) {
                onClick(title)
                onCheckChange(isChecked)
            },
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = if (drawable != null) 0.dp else 0.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            if (drawable != null) {
                Box(
                    modifier = Modifier
                        .size(48.dp)
                        .clip(CircleShape)
                        .background(MaterialTheme.colorScheme.outline),
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        painter = painterResource(drawable),
                        contentDescription = "",
                        modifier = Modifier.size(24.dp),
                        colorFilter = if(showColorFilter) null else ColorFilter.tint(MaterialTheme.colorScheme.primary)
                    )
                }
            }

            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(start = if (drawable != null) 10.dp else 0.dp, end = 10.dp),
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = title,
                    color = MaterialTheme.colorScheme.onBackground,
                    style = WeThemes.typography.titleMedium,
                    fontWeight = FontWeight.SemiBold
                )
                if (subtitle != null) {
                    Text(
                        text = subtitle,
                        color = Color(0xFF8B8B8B),
                        style = WeThemes.typography.labelSmall
                    )
                }

            }
            if (drawable ==null && statusNotification){
                Text(
                    text = "On",
                    textAlign = TextAlign.End,
                    modifier = Modifier.padding(horizontal = 5.dp)
                )
            }
            if (showSwitcher) {
                Switch(
                    checked = isChecked,
                    onCheckedChange = onCheckChange,
                )
            } else {

                Icon(
                    imageVector = Icons.Default.ArrowForward,
                    contentDescription = "",
                    modifier = Modifier
                        .size(24.dp),
                    tint = MaterialTheme.colorScheme.primary

                )

            }

        }
        Spacer(modifier = Modifier.height(16.dp))
        if (drawable != null) {
            WeSaccoDivider(
                modifier = Modifier.padding(start = 56.dp, end = 8.dp)
            )
        } else {
            WeSaccoDivider()
        }


    }

}

@Composable
fun MoreVerticalItemWithCard(
    modifier: Modifier = Modifier,
    drawable: DrawableResource? = null,
    title: String,
    subtitle: String? = null,
    onClick: (String) -> Unit = { String },
    onCheckChange: (Boolean) -> Unit = {},
    isChecked: Boolean = false ,
    showSwitcher: Boolean = false,
    statusNotification: Boolean = false,
    showColorFilter: Boolean = false
) {

    StandardCard {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .clickable(MutableInteractionSource(), null, onClickLabel = title.toString()) {
                    onClick(title)
                    onCheckChange(isChecked)
                },
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = if (drawable != null) 0.dp else 0.dp),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                if (drawable != null) {
                    Box(
                        modifier = Modifier
                            .size(24.dp)
                            .clip(CircleShape)
                            .background(MaterialTheme.colorScheme.outline),
                        contentAlignment = Alignment.Center
                    ) {
                        Image(
                            painter = painterResource(drawable),
                            contentDescription = "",
                            modifier = Modifier.size(24.dp),
                            colorFilter = if(showColorFilter) null else ColorFilter.tint(MaterialTheme.colorScheme.primary)
                        )
                    }
                }

                Column(
                    modifier = Modifier
                        .weight(1f)
                        .padding(start = if (drawable != null) 10.dp else 0.dp, end = 10.dp),
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = title,
                        color = MaterialTheme.colorScheme.onBackground,
                        style = WeThemes.typography.titleMedium,
                        fontWeight = FontWeight.SemiBold
                    )
                    if (subtitle != null) {
                        Text(
                            text = subtitle,
                            color = Color(0xFF8B8B8B),
                            style = WeThemes.typography.labelSmall
                        )
                    }

                }
                if (drawable ==null && statusNotification){
                    Text(
                        text = "On",
                        textAlign = TextAlign.End,
                        modifier = Modifier.padding(horizontal = 5.dp)
                    )
                }
                if (showSwitcher) {
                    Switch(
                        checked = isChecked,
                        onCheckedChange = onCheckChange,
                    )
                } else {
                    Image(
                        imageVector = Icons.Default.ArrowForward,
                        contentDescription = "",
                        modifier = Modifier.size(24.dp),
                        colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.primary)

                    )

                }

            }

        }
    }
}

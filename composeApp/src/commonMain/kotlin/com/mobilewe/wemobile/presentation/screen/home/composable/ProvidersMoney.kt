package com.mobilewe.wemobile.presentation.screen.home.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.mobilewe.wemobile.presentation.common.theme.WeThemes
import com.mobilewe.wemobile.presentation.screen.home.model.PaymentOption
import com.mobilewe.wemobile.utils.clickableWithoutRipple
import com.mobilewe.wemobile.utils.getInitials
import com.mobilewe.wemobile.utils.randomColor
import org.jetbrains.compose.resources.painterResource
import wemobile.composeapp.generated.resources.Res
import wemobile.composeapp.generated.resources.chevron_right
import wemobile.composeapp.generated.resources.img_placeholder


@Composable
fun ProvidersMoney(
    sendProvider: PaymentOption,
    onProviderSelected: (String) -> Unit,
) {
    val size48 = 48.dp
    val interactionSource = remember { MutableInteractionSource() }
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 16.dp)
            .clickableWithoutRipple(
                interactionSource,
                onClick = { onProviderSelected(sendProvider.name) }
            )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            if (sendProvider.icon != null) {
                AsyncImage(
                    model = sendProvider.icon,
                    contentDescription = "",
                    placeholder = painterResource(Res.drawable.img_placeholder),
                    error = painterResource(Res.drawable.img_placeholder),
                    modifier = Modifier
                        .size(size48)
                        .clip(CircleShape)
                        .align(Alignment.CenterVertically),
                    contentScale = ContentScale.Crop
                )

            } else {
                Box(
                    modifier = Modifier
                        .size(48.dp)
                        .clip(CircleShape)
                        .background(randomColor()),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = getInitials(sendProvider.name),
                        fontWeight = FontWeight.Normal,
                        textAlign = TextAlign.Center,
                        style = WeThemes.typography.headlineSmall,
                        color = MaterialTheme.colorScheme.onBackground
                    )
                }
            }
            Spacer(modifier = Modifier.width(12.dp))
            Text(
                text = sendProvider.name,
                fontSize = 14.sp,
                color = MaterialTheme.colorScheme.onBackground

            )
            Spacer(modifier = Modifier.weight(1f))
            Icon(
                painter = painterResource(Res.drawable.chevron_right),
                contentDescription = sendProvider.name,
                modifier = Modifier.size(24.dp)
            )

        }

    }

}
package com.mobilewe.wemobile.presentation.screen.markets.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.mobilewe.wemobile.presentation.common.theme.WeThemes
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource
import wemobile.composeapp.generated.resources.Res
import wemobile.composeapp.generated.resources.icon_deposit


@Composable
fun MarketTypeCard(
    title: String,
    subTitle: String? = null,
    onClick: (String) -> Unit,
    modifier: Modifier = Modifier,
    imageResourceId: DrawableResource,
    containerColor: Color = MaterialTheme.colorScheme.surface
) {
    Card(
        modifier = modifier
            .height(110.dp)
            .clickable { onClick(title) },
        colors = CardDefaults.cardColors(
            containerColor = containerColor
        ),
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Row(modifier = Modifier.fillMaxWidth()) {
                Text(
                    text = title,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    style = WeThemes.typography.labelMedium
                )
                Spacer(modifier = Modifier.weight(1f))
                Box(
                    contentAlignment = Alignment.TopEnd,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Image(
                        modifier = Modifier
                            .size(24.dp)
                            .align(Alignment.TopEnd),
                        painter = painterResource(imageResourceId),
                        contentDescription = null,
                        colorFilter = ColorFilter.tint(Color.White)
                    )


                }
            }
            Spacer(modifier = Modifier.height(12.dp))
            if (subTitle != null) {
                Text(
                    text = subTitle,
                    fontWeight = FontWeight.Normal,
                    color = Color.White,
                    style = WeThemes.typography.labelSmall,
                    modifier = Modifier.fillMaxWidth()

                )
            }
        }
    }

}


data class MarketType(
    val title: String,
    val subTitle: String,
    val imageResourceId: DrawableResource,
    val containerColor: Color,
)

 val marketTypeOption = listOf(
    MarketType(
        title = "R.string.buy_airtime_home_title",
        subTitle = "R.string.buy_airtime_desc",
        imageResourceId = Res.drawable.icon_deposit,
        containerColor = Color(0, 48, 72)
    ),
    MarketType(
        title = "R.string.buy_airtime_home_title",
        subTitle = "R.string.buy_airtime_desc",
        imageResourceId = Res.drawable.icon_deposit,
        containerColor = Color(71, 126, 149)
    ),
    MarketType(
        title = "R.string.buy_airtime_home_title",
        subTitle = "R.string.buy_airtime_desc",
        imageResourceId = Res.drawable.icon_deposit,
        containerColor = Color(141, 103, 171)
    )
)
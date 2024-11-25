package com.mobilewe.wemobile.presentation.screen.auth.welcome.component

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.mobilewe.wemobile.presentation.common.theme.WeThemes
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource
import wemobile.composeapp.generated.resources.Res
import wemobile.composeapp.generated.resources.icon_arrow_back
import wemobile.composeapp.generated.resources.insights_icon


@Composable
fun FeatureCard(feature: Feature) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .size(40.dp)
                .border(1.dp, MaterialTheme.colorScheme.inverseSurface, CircleShape)
        ) {
            Icon(
                painter = painterResource(feature.iconRes),
                contentDescription = null,
                modifier = Modifier
                    .size(24.dp)
                    .align(Alignment.Center),
                tint = MaterialTheme.colorScheme.onBackground
            )
        }


        Column(
            modifier = Modifier
                .weight(1f)
                .padding(start = 10.dp)
        ) {
            Text(
                text = feature.title,
                style = WeThemes.typography.titleMedium
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = feature.desc,
                style = WeThemes.typography.bodySmall
            )
        }
    }
}

data class Feature(val title: String, val desc: String, val iconRes: DrawableResource)

@Composable
fun getFeatures(): List<Feature> = listOf(
    Feature(
        title = "stringResource(R.string.intro_feature_one_title)",
        desc = "stringResource(R.string.intro_feature_one_desc)",
        iconRes = Res.drawable.insights_icon
    ),
    Feature(
        title = "stringResource(R.string.intro_feature_two_title)",
        desc = "stringResource(R.string.intro_feature_two_desc)",
        iconRes = Res.drawable.insights_icon
    ),
    Feature(
        title = "stringResource(R.string.intro_feature_three_title)",
        desc = "stringResource(R.string.intro_feature_three_desc)",
        iconRes = Res.drawable.icon_arrow_back
    )
)
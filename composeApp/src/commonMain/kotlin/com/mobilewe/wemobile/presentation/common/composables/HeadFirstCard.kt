package com.mobilewe.wemobile.presentation.common.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.mobilewe.wemobile.presentation.common.theme.WeThemes
import org.jetbrains.compose.resources.ExperimentalResourceApi


@Composable
fun HeadFirstCard(
    modifier: Modifier = Modifier,
    textHeader: String? = null,
    textSubHeader: String? = null,
    logo: String = "",
    topAppBar: @Composable () -> Unit = {},
    bottomBar: @Composable () -> Unit = {},
    content: @Composable () -> Unit
) {
    Scaffold(
        topBar = topAppBar,
        bottomBar = { Column(
            modifier
                .fillMaxWidth()
                .padding(16.dp)) { bottomBar() } }
    ) { paddingValues ->
        Column(
            modifier = modifier
                .fillMaxWidth()
                .padding(paddingValues)
                .padding(16.dp)
                .clip(shape = RoundedCornerShape(WeThemes.radius.medium))
                .background(MaterialTheme.colorScheme.background)
                .padding(horizontal = 16.dp, vertical = 32.dp)
        ) {
            Box(modifier = Modifier) {
                CardHeader(
                    textHeader = textHeader,
                    textSubHeader = textSubHeader,
                    logo = logo
                )
            }
                content()
            }

        }


}

@Composable
private fun CardHeader(
    textHeader: String? = null,
    textSubHeader: String?= null,
    logo: String,
    modifier: Modifier = Modifier,
) {
    Column(modifier = modifier, verticalArrangement = Arrangement.spacedBy(32.dp)) {
        Column(
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            if (textHeader != null){
                Text(
                    text = textHeader,
                    style = WeThemes.typography.titleLarge,
                    color = MaterialTheme.colorScheme.onPrimary
                )
            }
            if (textSubHeader != null){
                Text(
                    text = textSubHeader,
                    style = WeThemes.typography.body,
                    color = MaterialTheme.colorScheme.onTertiary
                )
            }
        }
    }
}
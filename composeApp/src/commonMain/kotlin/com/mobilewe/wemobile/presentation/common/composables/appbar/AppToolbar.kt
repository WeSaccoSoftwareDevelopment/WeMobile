package com.mobilewe.wemobile.presentation.common.composables.appbar

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import com.mobilewe.wemobile.presentation.common.theme.WeThemes


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppToolbar(
    title: String,
    modifier: Modifier = Modifier,
    colors: TopAppBarColors = TopAppBarDefaults.centerAlignedTopAppBarColors(
        containerColor = MaterialTheme.colorScheme.tertiaryContainer
    ),
    scrollBehavior: TopAppBarScrollBehavior? = null,
    showBackArrow: Boolean = false,
    showForwardArrow: Boolean = false,
    navigateBack:()-> Unit = {}
){
    CenterAlignedTopAppBar(
        title = {
            Text(
                text = title,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                style = WeThemes.typography.labelLarge,
                color = Color.White,
                fontWeight = FontWeight.SemiBold
            )
        }, navigationIcon = {
            if (showBackArrow) {
                IconButton(onClick = { navigateBack() }) {
                    Image(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = "Localized description",
                        colorFilter = ColorFilter.tint(Color.White)
                    )
                }
            }
        }, actions = {
            if (showForwardArrow) {
                IconButton(onClick = { navigateBack()}) {
                    Icon(
                        imageVector = Icons.Filled.Close,
                        contentDescription = "Localized description",
                        tint = Color.White
                    )
                }
            }
        },
        colors = colors,
        scrollBehavior = scrollBehavior,
        modifier = modifier.fillMaxWidth()
    )
}

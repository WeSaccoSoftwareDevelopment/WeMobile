package com.mobilewe.wemobile.presentation.common.composables.appbar

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.mobilewe.wemobile.presentation.common.theme.WeThemes
import com.mobilewe.wemobile.presentation.screen.home.composable.HorizontalImageTextView
import com.mobilewe.wemobile.resources.Resources
import com.mobilewe.wemobile.utils.getStatusBarPadding
import org.jetbrains.compose.resources.painterResource
import wemobile.composeapp.generated.resources.Res
import wemobile.composeapp.generated.resources.outline_account_circle
import wemobile.composeapp.generated.resources.sacco_logo

/*@OptIn(ExperimentalMaterial3Api::class)
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
        modifier = modifier
    )
}*/

@Composable
fun AppToolbar(
    modifier: Modifier = Modifier,
    title: String = "",
    showBackArrow: Boolean = false,
    showForwardArrow: Boolean = false,
    navigateBack:()-> Unit = {}
) {
    Row(
        modifier = modifier.fillMaxWidth().padding(bottom = 16.dp)
            .background(MaterialTheme.colorScheme.background),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        if (showBackArrow) {
            IconButton(onClick = { navigateBack() }) {
                Image(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Localized description",
                    colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.onBackground)
                )
            }
        }
        Text(
            text = title,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            style = WeThemes.typography.labelLarge,
            color = MaterialTheme.colorScheme.onBackground,
            fontWeight = FontWeight.SemiBold
        )
        Spacer(modifier = Modifier.width(10.dp))

        if (showForwardArrow) {
            IconButton(onClick = { navigateBack()}) {
                Icon(
                    imageVector = Icons.Filled.Close,
                    contentDescription = "Localized description",
                    tint = MaterialTheme.colorScheme.onBackground
                )
            }
        }
    }
}

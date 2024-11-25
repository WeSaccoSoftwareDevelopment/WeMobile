package com.mobilewe.wemobile.presentation.common.composables.appbar

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.dp
import com.mobilewe.wemobile.presentation.common.theme.WeThemes
import com.mobilewe.wemobile.presentation.common.composables.modifier.noRippleEffect

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WsAppBar(
    onNavigateUp: (() -> Unit)? = null,
    title: String = "",
    modifier: Modifier = Modifier,
    isBackIconVisible: Boolean = true,
    painterResource :Painter? = null,
    leading: (@Composable (() -> Unit))? = null,
    actions: (@Composable (() -> Unit))? = null
) {
    TopAppBar(
        title = {
            Text(
                text = title,
                style = WeThemes.typography.titleLarge,
                color = colorScheme.onPrimary
            )
        },
        navigationIcon = {
            if (isBackIconVisible) {
                if (painterResource != null) {
                    Icon(
                        painter = painterResource,
                        contentDescription = "",
                        modifier = Modifier.noRippleEffect { onNavigateUp?.invoke() }
                            .padding(start = 16.dp, end = 16.dp),
                        tint = colorScheme.onSecondary,
                    )
                }
            } else {
                leading?.invoke()
            }

        },
        actions = {
            actions?.invoke()
        },
        colors = TopAppBarDefaults.topAppBarColors(containerColor = colorScheme.surface),
        modifier = modifier,
    )
}


package com.mobilewe.wemobile.presentation.common.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

data class Radius(
    val small: Dp = 4.dp,
    val medium: Dp = 8.dp,
    val large: Dp = 16.dp,
    val extraLarge: Dp = 24.dp
)

val localRadius = staticCompositionLocalOf { Radius() }


val MaterialTheme.weRadius: Radius
    @Composable
    @ReadOnlyComposable
    get() = localRadius.current

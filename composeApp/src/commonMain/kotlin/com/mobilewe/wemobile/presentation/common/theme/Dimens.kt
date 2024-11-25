package com.mobilewe.wemobile.presentation.common.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

data class Dimens(
    val space1: Dp = 1.dp,
    val space4: Dp = 4.dp,
    val space5: Dp = 5.dp,
    val space8: Dp = 8.dp,
    val space10: Dp = 10.dp,
    val space16: Dp = 16.dp,
    val space20: Dp = 20.dp,
    val space24: Dp = 24.dp,
    val space32: Dp = 32.dp,
    val space40: Dp = 40.dp,
    val space100: Dp = 100.dp,
)

val localDimens = staticCompositionLocalOf { Dimens() }

val weDimens: Dimens
    @Composable
    @ReadOnlyComposable
    get() = localDimens.current


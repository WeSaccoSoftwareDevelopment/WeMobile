package com.mobilewe.wemobile.presentation.common.theme

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.TextStyle

data class Typography(
    val headline: TextStyle = TextStyle(),
    val title: TextStyle = TextStyle(),
    val body: TextStyle = TextStyle(),
    val caption: TextStyle = TextStyle(),
    val displayLarge: TextStyle = TextStyle(),
    val displayMedium: TextStyle = TextStyle(),
    val displaySmall: TextStyle = TextStyle(),
    val headlineLarge: TextStyle = TextStyle(),
    val headlineMedium: TextStyle = TextStyle(),
    val headlineSmall: TextStyle = TextStyle(),
    val bodyLarge: TextStyle = TextStyle(),
    val bodyMedium: TextStyle = TextStyle(),
    val bodySmall: TextStyle = TextStyle(),
    val labelLarge: TextStyle = TextStyle(),
    val labelMedium: TextStyle = TextStyle(),
    val labelSmall: TextStyle = TextStyle(),
    val titleLarge: TextStyle = TextStyle(),
    val titleMedium: TextStyle = TextStyle(),
    val titleSmall: TextStyle = TextStyle(),
)

val localTypography = staticCompositionLocalOf { Typography() }

/*

val MaterialTheme.weTypography: Typography
    @Composable
    @ReadOnlyComposable
    get() = localTypography.current*/

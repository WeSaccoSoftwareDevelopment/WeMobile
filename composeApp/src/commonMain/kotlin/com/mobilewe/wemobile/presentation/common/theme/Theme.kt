package com.mobilewe.wemobile.presentation.common.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.ui.graphics.Color

enum class ThemeMode { LIGHT, NIGHT, SYSTEM }


private val DarkColorScheme = darkColorScheme(
    primary= PrimaryDarkModeColor,
    onPrimary= PrimaryTextColor,
    primaryContainer= BottomBarDark,
    secondary= SecondaryLightColor,
    onSecondary= SecondaryTextColor,
    secondaryContainer = PrimaryColor,
    onSecondaryContainer = Color.White,
    tertiary = PrimaryLightColor,
    onTertiary = PrimaryTextColor,
    background = BackgroundDarkColor,
    onBackground = Color.White,
    surface = SurfaceDark,
    onSurface = Color.White,
    surfaceVariant = SurfaceDark,
    onSurfaceVariant = Color.White,
    error = ErrorColor,
    onError= OnErrorColor,
    outline = CardDarkColor,
    scrim = ScrimDarkColor,
    tertiaryContainer = ToolbarBarDark,
    onPrimaryContainer= ModalSheetContentDarkColor,
    inversePrimary = HomeDarkModeColor,
    surfaceTint= AuthToolBarDarkColor,

    /*
    tertiaryContainer= Color,
    onTertiaryContainer= Color,
    surfaceTint= Color,
    inverseSurface=Color,
    inverseOnSurface =Color,
    errorContainer= Color,
    onErrorContainer= Color,
    outlineVariant =Color,*/
    //




)

private val LightColorScheme = lightColorScheme(
    primary = PrimaryLightColor,
    onPrimary = PrimaryTextColor,
    primaryContainer= BottomBarLight,
    secondary = SecondaryColor,
    onSecondary = SecondaryTextColor,
    tertiary = PrimaryLightColor,
    onTertiary = PrimaryTextColor,
    background = BackgroundLightColor,
    onBackground = Color.Black,
    surface = SurfaceLight,
    onSurface = Color.Black,
    surfaceVariant = SurfaceLight,
    onSurfaceVariant = Color.Black,
    secondaryContainer = PrimaryColor,
    onSecondaryContainer = Color.White,
    error = ErrorColor,
    onError = OnErrorColor,
    outline = CardLightColor,
    scrim = ScrimLightColor,
    tertiaryContainer = ToolbarBarLight,
    onPrimaryContainer= ModalSheetContentLightColor,
    inversePrimary = HomeLightModeColor,
    surfaceTint= AuthToolBarLightColor
)


@Composable
fun WsTheme(
    useDarkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = if (useDarkTheme) DarkColorScheme else LightColorScheme


    MaterialTheme(
        colorScheme = colorScheme,
        typography = AppTypography,
        shapes= Shapes,
        content = content,
    )
}





object WeThemes{
   /* val colorScheme: WeColors
        @Composable
        @ReadOnlyComposable
        get() = localColorScheme.current*/

    val typography: Typography
        @Composable
        @ReadOnlyComposable
        get() = localTypography.current

    val radius: Radius
        @Composable
        @ReadOnlyComposable
        get() = localRadius.current

    val dimens: Dimens
        @Composable
        @ReadOnlyComposable
        get() = localDimens.current

    val shapes: Shapes
        @Composable
        @ReadOnlyComposable
        get() = localShape.current
}



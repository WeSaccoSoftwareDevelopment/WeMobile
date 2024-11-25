package com.mobilewe.wemobile.presentation.common.theme

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

val Purple200 = Color(0xFFBB86FC)
val Purple500 = Color(0xFF6200EE)
val Purple700 = Color(0xFF3700B3)
val Teal200 = Color(0xFF03DAC5)
val Blue = Color(0xFF007BFF)
val DeepRed = Color(0xFFd9517c)
val LightGreen = Color(0xFF6eb34e)
val LightYellow = Color(0xFFe2b047)
val Purple1 = Color(0xFFb551ca)
val Purple2 = Color(0xFFc466d5)
val  Cyan = Color(0xFF66a9c3)
val darkGray = Color(0xFF1a1717)
val darkBlue = Color(0xFF18192b)
val gray = Color(0xFF3F3F3F)
val blueGray = Color(0xFF404352)
val nightDark = Color(0xFF403757)
val purple = Color(0xFF9B11ba)
val orange = Color(0xFFdb660d)
val redOrange = Color(0xFFe84a23)
val green = Color(0xFF0ddb25)
val brightBlue = Color(0xFF027cf5)
val PrimaryOrangeColor = Color(0xffFF4500)
val PrimaryOrange2Color = Color(0xFFE86105)
val PrimaryColorEquityColor = Color(0xFFAF0043)
val PrimaryColorEquityColor2 = Color(0xFFBD001E)
val PrimaryColorKQ = Color(0xFF8E2158)
val PrimaryColorABSA = Color(0xFFD61341)
val PrimaryColorABSA2 = Color(0xFFDB0032)
val BottomBarDark = Color(0xFF1E1E1E)
val BottomBarLight = Color(0xFFFFFFFF)
val ToolbarBarDark = Color(0xFF262624)
val ToolbarBarLight = Color(0xFF42b029)
val ButtonDefaultColors = Color(0xFF818286)
val ButtonDefaultLight = Color(0xFF818286)
val CardDarkColor = Color(0xFF262626)
val CardLightColor = Color(0xFFFFFFFF)
val CardIcon = Color(0xFF29591C)
val BackgroundLightColor = Color(0xFFF2F2F2)
val BackgroundDarkColor = Color(0xff131313)
val ScrimLightColor = Color(0xFFA6A6A6)
val ScrimDarkColor = Color(0xff070707)
val ModalSheetContentLightColor = Color(0xFFFFFFFF)
val ModalSheetContentDarkColor = Color(0xff343434)
val HomeDarkModeColor = Color(0xff131313)
val HomeLightModeColor = Color(0xFF42B029)
val StatusBarLightColor = Color(0xFF2B8F13)
val AuthToolBarDarkColor = Color(0xff131313)
val AuthToolBarLightColor = Color(0xFF42b029)
val PrimaryColor = Color(0xFF45B42F)
val PrimaryDarkModeColor = Color(0xFF49BF5A)
val PrimaryLightColor = Color(0xFF45B42F)
val SecondaryColor = Color(0xff6167FF)
val SecondaryLightColor = Color(0xffBEC1FF)
val PrimaryTextColor = Color(0xffffffff)
val SecondaryTextColor = Color(0xff000000)
val SurfaceDark = Color(0xFF3A3A3A)
val SurfaceLight = Color(0xFFFFFFFF)
val ErrorColor = Color(0xFFFF8989)
val OnErrorColor = Color(0xFF000000)
val ColorSurface = Color(0xFF292E34)
val HintGray = Color(0xFF8B8B8B)
val mainBackground = Color(0xFF1E2329)
val Border = Color(0xFF535457)
val contentBorder = Color(0x14FFEFEF)
val hover = Color(0xFF242424)
val disable = Color(0x40FFFFFF)
val divider = Color(0x14FFFFFF)
val success = Color(0xFF66CB9F)
val successContainer = Color(0x14EBFFF4)
val warning = Color(0xFFCBB567)
val warningContainer = Color(0x14FFFCEB)
val pink = Color(0xFF261F1F)

// Pie chart DonutColors
val PayBillColor = Color(0xFF3BBF6C)
val SendMoneyColor = Color(0xFFB300FC)
val FulizaColor = Color(0xFFFDC61D)
val MshwariColor = Color(0xFFFE0189)
val WithdrawalColor = Color(0xFF1EB8FD)
val Green67_A = Color(0x80d6ffbe)
val White = Color(0xFFFFFFFF)
val Grey62 = Color(0xff9e9f9e)
val BorderLight = Color(0xFFBCD3E6)
val BorderDark = Color(0xFF63798D)



data class WeColors(
    val primary: Color,
    val secondary: Color,
    val onBackground:Color,
    val onPrimary: Color,
    val onSecondary: Color,
    val onTertiary: Color,
    val surface: Color,
    val background: Color,
    val onPrimaryContainer:Color,
    val error: Color,
    val onError: Color,
    val surfaceTint: Color,
    val outline: Color,
    val primaryContainer : Color,
    val onSurface : Color,
    val surfaceVariant : Color,
    val onSurfaceVariant : Color,
    var secondaryContainer : Color,
    val onSecondaryContainer : Color,
    val scrim : Color,
    val tertiaryContainer : Color,
    val inversePrimary : Color,
    val tertiary : Color,
    val inverseSurface: Color
    )

val LightWeColors = WeColors(
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
    surfaceTint= AuthToolBarLightColor,
    inverseSurface = SurfaceLight,
)

val DarkWeColors = WeColors(
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
    inverseSurface = SurfaceDark
)

val localColorScheme = staticCompositionLocalOf { LightWeColors }




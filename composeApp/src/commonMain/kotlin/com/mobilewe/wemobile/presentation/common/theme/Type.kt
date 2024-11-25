package com.mobilewe.wemobile.presentation.common.theme

import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import org.jetbrains.compose.resources.Font
import androidx.compose.ui.unit.sp
import wemobile.composeapp.generated.resources.Res
import wemobile.composeapp.generated.resources.brutalista_bold
import wemobile.composeapp.generated.resources.brutalista_medium
import wemobile.composeapp.generated.resources.brutalista_regular


val AppTypography = Typography(
    displayLarge = TextStyle(
        fontWeight = FontWeight.W400,
        fontSize = 57.sp,
        lineHeight = 64.sp,
        letterSpacing = (-0.25).sp
    ),
    displayMedium = TextStyle(
        fontWeight = FontWeight.W400,
        fontSize = 45.sp,
        lineHeight = 52.sp
    ),
    displaySmall = TextStyle(
        fontWeight = FontWeight.W400,
        fontSize = 36.sp,
        lineHeight = 44.sp
    ),
    headlineLarge = TextStyle(
        fontWeight = FontWeight.W400,
        fontSize = 32.sp,
        lineHeight = 40.sp
    ),
    headlineMedium = TextStyle(
        fontWeight = FontWeight.W400,
        fontSize = 28.sp,
        lineHeight = 36.sp
    ),
    headlineSmall = TextStyle(
        fontWeight = FontWeight.W400,
        fontSize = 20.sp,
        lineHeight = 30.sp
    ),
    titleLarge = TextStyle(
        fontWeight = FontWeight.SemiBold,
        fontSize = 22.sp,
        lineHeight = 28.sp
    ),
    titleMedium = TextStyle(
        fontWeight = FontWeight.SemiBold,
        fontSize = 16.sp,
        lineHeight = 24.sp,
    ),
    titleSmall = TextStyle(
        fontWeight = FontWeight.W500,
        fontSize = 14.sp,
        lineHeight = 20.sp,
    ),
    bodyLarge = TextStyle(
        fontWeight = FontWeight.W400,
        fontSize = 16.sp,
        lineHeight = 24.sp,
    ),
    bodyMedium = TextStyle(
        fontWeight = FontWeight.W400,
        fontSize = 14.sp,
        lineHeight = 20.sp,
    ),
    bodySmall = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp,
        lineHeight = 20.sp
    ),
    labelLarge = TextStyle(
        fontWeight = FontWeight.W400,
        fontSize = 14.sp,
        lineHeight = 20.sp,
    ),
    labelMedium = TextStyle(
        fontWeight = FontWeight.W400,
        fontSize = 14.sp,
    ),
    labelSmall = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    )
)

//
//val BrutalistaRegular = FontFamily(Font(Res.font.brutalista_regular))
//val BrutalistaBold = FontFamily(Font(Res.font.brutalista_bold))
//val BrutalistaMedium = FontFamily(Font(Res.font.brutalista_medium))
//
//
//@Composable
//fun headlineLarge(): TextStyle {
//    return TextStyle(
//        fontSize = 24.sp,
//        lineHeight = 32.4.sp,
//        fontFamily = BrutalistaMedium,
//        fontWeight = FontWeight.W600,
//    )
//}
//@Composable
//fun headline(): TextStyle {
//    return TextStyle(
//        fontSize = 20.sp,
//        fontFamily = BrutalistaMedium,
//        fontWeight = FontWeight.W600,
//    )
//}
//@Composable
//fun titleLarge(): TextStyle {
//    return TextStyle(
//        fontSize = 16.sp,
//        lineHeight = 20.sp,
//        fontFamily = BrutalistaMedium,
//        fontWeight = FontWeight.W600,
//    )
//}
//@Composable
//fun title(): TextStyle {
//    return TextStyle(
//        fontSize = 14.sp,
//        fontFamily = BrutalistaMedium,
//        fontWeight = FontWeight.W600,
//    )
//}
//@Composable
//fun titleMedium(): TextStyle {
//    return TextStyle(
//        fontSize = 16.sp,
//        fontFamily = BrutalistaMedium,
//        fontWeight = FontWeight.W400,
//    )
//}
//@Composable
//fun body(): TextStyle {
//    return TextStyle(
//        fontSize = 14.sp,
//        lineHeight = 19.6.sp,
//        fontFamily = BrutalistaRegular,
//        fontWeight = FontWeight.W400,
//    )
//}
//@Composable
//fun caption(): TextStyle {
//    return TextStyle(
//        fontFamily = BrutalistaRegular,
//        fontWeight = FontWeight.W400,
//        fontSize = 12.sp,
//    )
//}

package com.mobilewe.wemobile.resources

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.remember
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.platform.LocalLayoutDirection
import com.mobilewe.wemobile.resources.strings.IStringResources
import com.mobilewe.wemobile.utils.LanguageCode
import com.mobilewe.wemobile.utils.LocalizationManager
import com.mobilewe.wemobile.presentation.common.theme.WsTheme
import com.mobilewe.wemobile.utils.generateImageLoader
import com.mobilewe.wemobile.utils.getPlatformContext
import com.mobilewe.wemobile.utils.setInsetsController
import com.seiko.imageloader.LocalImageLoader


private val localDrawableResources = staticCompositionLocalOf { DrawableResources() }
private val localStringResources = staticCompositionLocalOf<IStringResources> {
    error("CompositionLocal IStringResources not present")
}


@Composable
fun WeSaccoMobileTheme(
    useDarkTheme: Boolean = isSystemInDarkTheme(),
    languageCode: LanguageCode = LanguageCode.EN,
    content: @Composable () -> Unit,
) {
    val drawableResources = if (useDarkTheme) BpDrawableDarkResources else DrawableResources()
    val context = getPlatformContext()

    CompositionLocalProvider(
        localDrawableResources provides drawableResources,
        localStringResources provides LocalizationManager.getStringResources(languageCode),
        LocalLayoutDirection provides LocalizationManager.getLayoutDirection(languageCode),
        LocalImageLoader provides remember { generateImageLoader(context) }
    ) {
        WsTheme(useDarkTheme = useDarkTheme) {
            setInsetsController(useDarkTheme)
            content()
        }
    }

}


object Resources {
    val images: DrawableResources
        @Composable
        @ReadOnlyComposable
        get() = localDrawableResources.current

    val strings: IStringResources
        @Composable
        @ReadOnlyComposable
        get() = localStringResources.current
}


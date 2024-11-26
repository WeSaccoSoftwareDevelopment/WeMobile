package com.mobilewe.wemobile.utils

import androidx.compose.ui.unit.LayoutDirection
import com.mobilewe.wemobile.resources.strings.IStringResources
import com.mobilewe.wemobile.resources.strings.en.English
import com.mobilewe.wemobile.resources.strings.sw.Swahili


object LocalizationManager {
    fun getStringResources(languageCode: LanguageCode): IStringResources {
        return when (languageCode) {
            LanguageCode.EN -> English()
            LanguageCode.SW -> Swahili()
        }
    }

    fun getLayoutDirection(languageCode: LanguageCode): LayoutDirection {
        return when (languageCode) {
            LanguageCode.EN -> LayoutDirection.Ltr
            LanguageCode.SW -> LayoutDirection.Ltr
            else -> LayoutDirection.Ltr
        }
    }
}
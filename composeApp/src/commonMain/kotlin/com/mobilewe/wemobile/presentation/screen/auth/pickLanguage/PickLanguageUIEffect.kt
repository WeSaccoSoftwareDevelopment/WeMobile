package com.mobilewe.wemobile.presentation.screen.auth.pickLanguage

sealed class PickLanguageUIEffect {
    data object OnGoToPreferredLanguage : PickLanguageUIEffect()
}
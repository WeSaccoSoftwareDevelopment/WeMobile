package com.mobilewe.wemobile.presentation.screen.auth.pickLanguage

import com.mobilewe.wemobile.presentation.common.base.BaseInteractionListener

interface PickLanguageInteractionListener : BaseInteractionListener {
    fun onLanguageSelected(language: LanguageUIState)

}
package com.mobilewe.wemobile.presentation.screen.auth.pickLanguage

import com.mobilewe.wemobile.utils.LanguageCode

data class PickLanguageUIState(
    val isLoading: Boolean = false,
    val languages: List<LanguageUIState> = getLanguage(),
    val selectedLanguage: LanguageUIState = LanguageUIState(),
)

data class LanguageUIState(
    val name: String = "",
    val code: String = "",
    val image: String = ""
)


private fun getLanguage(): List<LanguageUIState> {
    return LanguageCode.entries.map {
        LanguageUIState(
            name = it.str,
            code = it.value,
        )
    }
}

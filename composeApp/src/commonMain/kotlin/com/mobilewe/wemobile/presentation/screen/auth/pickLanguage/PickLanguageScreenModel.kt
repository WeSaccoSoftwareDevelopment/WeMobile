package com.mobilewe.wemobile.presentation.screen.auth.pickLanguage

import com.mobilewe.wemobile.domain.usecases.IManageSettingUseCase
import com.mobilewe.wemobile.presentation.common.base.BaseScreenModel
import com.mobilewe.wemobile.presentation.common.base.ErrorState

class PickLanguageScreenModel(
    private val userPreferences: IManageSettingUseCase,
) : BaseScreenModel<PickLanguageUIState, PickLanguageUIEffect>(PickLanguageUIState()),
    PickLanguageInteractionListener {


    override fun onLanguageSelected(language: LanguageUIState) {
        tryToExecute(
            { userPreferences.saveLanguageCode(language.code) },
            ::onSavedLanguageSuccess,
            ::onError
        )
    }

    private fun onSavedLanguageSuccess(unit: Unit) {
        sendNewEffect(PickLanguageUIEffect.OnGoToPreferredLanguage)
    }

    private fun onError(errorState: ErrorState) {
        println(errorState)
    }
}

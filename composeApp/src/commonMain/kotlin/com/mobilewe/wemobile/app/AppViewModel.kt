package com.mobilewe.wemobile.app

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mobilewe.wemobile.domain.usecases.IManageSettingUseCase
import com.mobilewe.wemobile.utils.LanguageCode
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class AppViewModel(
    private val manageUser: IManageSettingUseCase,
) : ViewModel() {


    private val _language: MutableStateFlow<LanguageCode> = MutableStateFlow(LanguageCode.EN)
    val language: StateFlow<LanguageCode> = _language.asStateFlow()

    private val _isFirstTimeOpenApp: MutableStateFlow<Boolean> = MutableStateFlow(false)
    val isFirstTimeOpenApp: StateFlow<Boolean> = _isFirstTimeOpenApp.asStateFlow()

    init {
        getUserLanguageCode()
        getInitScreen()
    }


    private fun getUserLanguageCode() {
        viewModelScope.launch(Dispatchers.IO) {
            manageUser.getUserLanguageCode().distinctUntilChanged().collectLatest { lang ->
                _language.update {
                    LanguageCode.entries.find { languageCode -> languageCode.value == lang }
                        ?: LanguageCode.EN
                }
            }
        }
    }

    private fun getInitScreen() {
        viewModelScope.launch(Dispatchers.IO) {
            _isFirstTimeOpenApp.update { manageUser.getIsFirstTimeUseApp() }
        }
    }

}
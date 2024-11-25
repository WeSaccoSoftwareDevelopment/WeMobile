package com.mobilewe.wemobile.presentation.screen.account.settings


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mobilewe.wemobile.domain.repo.ThemeRepository
import kotlinx.coroutines.launch

class SettingsViewModel constructor (
    private val themeRepository: ThemeRepository
) : ViewModel() {



    fun updateTheme(themeValue: Int) {
        viewModelScope.launch {
            themeRepository.setTheme(themeValue)
        }
    }
}
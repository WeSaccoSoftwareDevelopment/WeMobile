package com.mobilewe.wemobile.presentation.screen.main

import com.mobilewe.wemobile.domain.usecases.IManageAuthenticationUseCase
import com.mobilewe.wemobile.presentation.common.base.BaseScreenModel
import com.mobilewe.wemobile.presentation.common.base.ErrorState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch

class MainViewModel (
    private val manageAuthentication: IManageAuthenticationUseCase,
): BaseScreenModel<MainScreenUiState, MainScreenUIEffect>(MainScreenUiState()) {

    init {
        checkIfLoggedIn()
    }

    private fun checkIfLoggedIn() {
        tryToExecute(
            { manageAuthentication.getAccessToken() },
            ::onCheckIfLoggedInSuccess,
            ::onError
        )
    }

    private fun onCheckIfLoggedInSuccess(accessToken: Flow<String>) {
        viewModelScope.launch {
            accessToken.distinctUntilChanged().collectLatest { token ->
                if (token.isNotEmpty()) {
                    updateState { it.copy(isLoggedIn = true) }
                } else {
                    updateState { it.copy(isLoggedIn = false) }
                }
            }
        }
    }


    private fun onError(errorState: ErrorState) {
        updateState { it.copy(isLoggedIn = false) }
    }
}
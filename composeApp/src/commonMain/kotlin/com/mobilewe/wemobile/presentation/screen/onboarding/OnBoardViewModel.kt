package com.mobilewe.wemobile.presentation.screen.onboarding


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mobilewe.wemobile.data.repo.OnDataStoreRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class OnBoardViewModel constructor(
    private val repository: OnDataStoreRepository
) : ViewModel() {
    fun saveOnBoardingState(completed: Boolean) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.saveOnBoardingState(completed = completed)
        }
    }

    fun isOnBoardingCompleted(): Flow<Boolean> {
        return repository.readOnBoardingState()
    }
}
package com.mobilewe.wemobile.presentation.screen.home

import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {
    private val _shouldShowDialog = mutableStateOf(true)
    val shouldShowDialog: State<Boolean> = _shouldShowDialog
    private val _homeUiState = MutableStateFlow(HomeUiState())
    val homeUiState = _homeUiState.asStateFlow()

    init {
        // Load user data when the ViewModel is created
        loadUserData()
    }

    private fun loadUserData() {
       /* viewModelScope.launch {
            // Read user data from UserDataStore
            val userData = userDataStore.readUserData()

            // Update the HomeUiState with the loaded user data
            _homeUiState.value = _homeUiState.value.copy(userData = userData)
        }*/
    }

    fun setShowDialogState(value: Boolean) {
        _shouldShowDialog.value = value
    }



    var newProduct: SendMoneyItem? by mutableStateOf(null)
        private set

    var isAllSelected by mutableStateOf(false)
        private set


    var isRemittanceCategorySelected by mutableStateOf(false)
        private set

    init {
        loadProducts()
        loadCategories()
        selectDefaultCategory()
    }

    fun onEvent(event: HomeUiEvent) {
        when (event) {
            HomeUiEvent.OnLoadCategories -> {
                viewModelScope.launch { loadCategories() }
            }

            HomeUiEvent.OnLoadProducts -> {
                viewModelScope.launch { loadProducts() }
            }

            is HomeUiEvent.ProductLoaded -> {
                _homeUiState.update { state ->
                    state.copy(selectedOptions = event.products)
                }
            }

            is HomeUiEvent.OnSelectedProduct -> {
                _homeUiState.update {
                    it.copy(selectedPaymentOption = event.product)
                }
            }

        }
    }

    private fun loadProducts() {
        /*val products = paymentOption
        _homeUiState.value = _homeUiState.value.copy(selectedOptions = products)*/
    }

    private fun loadCategories() {
        _homeUiState.update { state ->
            state.copy(paymentOptionCategories = state.paymentOptions.map { it.category }
                .toSet())
        }
    }

    fun selectCategory(category: String) {
        _homeUiState.update { state ->
            state.copy(selectedCategory = category)
        }
    }


    private fun selectDefaultCategory() {
        _homeUiState.update { state ->
            if (state.selectedCategory == null && state.categories.isNotEmpty()) {
                state.copy(selectedCategory = state.categories.first())
            } else {
                state
            }
        }
    }
}
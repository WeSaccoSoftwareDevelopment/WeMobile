package com.mobilewe.wemobile.presentation.screen.account.help

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class HelpViewModel : ViewModel() {

    private val _searchState = MutableStateFlow(SearchState())
    val searchState get() = _searchState.asStateFlow()
    fun onSearch(query: String) {
        _searchState.update {
            searchState.value.copy(query = query)
        }
    }

}

data class SearchState(
    val query: String = ""
)
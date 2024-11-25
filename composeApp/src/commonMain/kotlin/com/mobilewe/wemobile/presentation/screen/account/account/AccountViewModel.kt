package com.mobilewe.wemobile.presentation.screen.account.account


import com.mobilewe.wemobile.presentation.screen.account.account.composable.SwitchState
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class AccountViewModel  : ViewModel(){

    private val _switchState = MutableStateFlow(SwitchState())
    val switchState get() = _switchState.asStateFlow()

    private val _moreUiState = MutableStateFlow(MoreUiState())
    val moreUiState: StateFlow<MoreUiState> = _moreUiState

    fun onCheckChange(isChecked: Boolean) {
        _switchState.update {
            switchState.value.copy(isChecked = isChecked)
        }
    }





}
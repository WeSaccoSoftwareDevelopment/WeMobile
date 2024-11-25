package com.mobilewe.wemobile.presentation.screen.auth.forgotPassword

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.mobilewe.wemobile.presentation.common.composables.button.TwoButtons
import com.mobilewe.wemobile.presentation.common.composables.textfield.WsTextField

@Composable
fun ForgotPasswordWithEmail(
    navigator: NavController,
    forgotPasswordViewModel: ForgotPasswordViewModel = viewModel()
) {
    val  forgotPasswordUiState by forgotPasswordViewModel.forgotPasswordUiState.collectAsStateWithLifecycle()
    Column(
        modifier = Modifier.fillMaxSize()
    ){
        WsTextField(
            text = forgotPasswordUiState.email,
            onValueChange = forgotPasswordViewModel::onEmailChanged,
            hint = "stringResource(id = R.string.email_hint)",
            label = "stringResource(id = R.string.email_hint)",
            keyboardType = KeyboardType.Email
        )
        TwoButtons(
            leftButtonText = "stringResource(id = R.string.cancel)" ,
            rightButtonText = "stringResource(id = R.string.continuee)" ,
            onLeftButtonClick = { },
            onRightButtonClick = { },
            enableRightButton = forgotPasswordUiState.email.isNotEmpty()
        )
    }

}
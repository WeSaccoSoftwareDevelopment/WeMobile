package com.mobilewe.wemobile.presentation.screen.auth.forgotPassword

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.mobilewe.wemobile.presentation.common.composables.appbar.AppToolbar
import com.mobilewe.wemobile.presentation.common.composables.button.TwoButtons
import com.mobilewe.wemobile.presentation.common.composables.textfield.WsTextField
import com.mobilewe.wemobile.resources.Resources


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ForgotPasswordScreen(
    navController: NavController,
    forgotPasswordViewModel: ForgotPasswordViewModel = viewModel()
) {

    Scaffold(
        topBar = {
            AppToolbar(
                title = "Forgot Password",
                showForwardArrow = true,
                navigateBack = { navController.popBackStack()},
            )
        },

        ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(all = 16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {

            val forgotPasswordUiState by forgotPasswordViewModel.forgotPasswordUiState.collectAsStateWithLifecycle()
            WsTextField(
                text = forgotPasswordUiState.email,
                onValueChange = forgotPasswordViewModel::onEmailChanged,
                hint = Resources.strings.emailHint,
                label = Resources.strings.emailHint,
                keyboardType = KeyboardType.Email
            )
            Spacer(modifier = Modifier.height(16.dp))
            TwoButtons(
                leftButtonText = "Cancel",
                rightButtonText = Resources.strings.continuee,
                onLeftButtonClick = { },
                onRightButtonClick = { },
                enableRightButton = forgotPasswordUiState.email.isNotEmpty()
            )
        }

    }
}


@Composable
fun TextSwitcher(
    text: String
) {
    Column {
        Text(
            text = text,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            textAlign = TextAlign.Center
        )
    }
}



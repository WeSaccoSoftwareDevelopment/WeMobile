package com.mobilewe.wemobile.presentation.screen.auth.login

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.mobilewe.wemobile.presentation.common.composables.HeadFirstCard
import com.mobilewe.wemobile.presentation.common.composables.WsSnackBar
import com.mobilewe.wemobile.presentation.common.composables.appbar.AppToolbar
import com.mobilewe.wemobile.presentation.common.composables.button.WsButton
import com.mobilewe.wemobile.presentation.common.composables.textfield.WsTextField
import com.mobilewe.wemobile.presentation.common.theme.WeThemes
import com.mobilewe.wemobile.resources.Resources
import com.mobilewe.wemobile.utils.getNavigationBarPadding
import kotlinx.coroutines.flow.collectLatest
import org.jetbrains.compose.resources.painterResource
import org.koin.compose.viewmodel.koinViewModel
import wemobile.composeapp.generated.resources.Res
import wemobile.composeapp.generated.resources.ic_error


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(
    viewModel: LoginScreenModel = koinViewModel(),
    onBiometricSetUp:()->Unit = {},
    navigateBack: ()->Unit = {},
) {

    val state by viewModel.state.collectAsStateWithLifecycle()

    LaunchedEffect(key1 = true) {
        viewModel.effect.collectLatest { effect ->
            when (effect) {
                is LoginScreenUIEffect.NavigateToHome -> onBiometricSetUp()
            }
        }

    }


    HeadFirstCard(
        textHeader = Resources.strings.loginWelcomeMessage,
        textSubHeader = Resources.strings.loginSubWelcomeMessage,
        topAppBar = {
            AppToolbar(
                title = "Welcome Back",
                navigateBack = { navigateBack() },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.surfaceTint
                ),
            )
        }
    ) {
        WsTextField(
            modifier = Modifier.fillMaxWidth().padding(top = 24.dp),
            text = state.username,
            onValueChange = viewModel::onUsernameChanged,
            label = Resources.strings.username,
            keyboardType = KeyboardType.Number,
            errorMessage = if (state.isUsernameError) Resources.strings.invalidUsername else "",
            isError = state.isUsernameError,
        )
        WsTextField(
            modifier = Modifier.fillMaxWidth().padding(top = 16.dp),
            text = state.password,
            onValueChange = viewModel::onPasswordChanged,
            label = Resources.strings.password,
            keyboardType = KeyboardType.Password,
            errorMessage = if (state.isPasswordError) Resources.strings.invalidPassword else "",
            isError = state.isPasswordError,
        )

        WsButton(
            modifier = Modifier.fillMaxWidth().padding(top = 24.dp),
            title = Resources.strings.login,
            onClick = onBiometricSetUp,
            isLoading = state.isLoading,
            enabled = true
        )
    }

    AnimatedVisibility(
        visible = state.showSnackbar,
        enter = slideInVertically { it },
        exit = slideOutVertically { it },
    ) {
        WsSnackBar(
            icon = painterResource(Res.drawable.ic_error), modifier = Modifier
                .padding(bottom = getNavigationBarPadding().calculateBottomPadding())
        ) {
            Text(
                text = state.snackbarMessage,
                style = WeThemes.typography.body.copy(color = MaterialTheme.colorScheme.onPrimary),
            )
        }
    }
}



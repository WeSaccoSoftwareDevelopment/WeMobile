package com.mobilewe.wemobile.presentation.screen.auth.register.registrationSubmit

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.mobilewe.wemobile.domain.model.UserAccount
import com.mobilewe.wemobile.presentation.common.composables.HeadFirstCard
import com.mobilewe.wemobile.presentation.common.composables.WsBrandBackgroundContainer
import com.mobilewe.wemobile.presentation.common.composables.WsSnackBar
import com.mobilewe.wemobile.presentation.common.composables.button.WsButton
import com.mobilewe.wemobile.presentation.common.composables.modifier.noRippleEffect
import com.mobilewe.wemobile.presentation.common.composables.textfield.WsTextField
import com.mobilewe.wemobile.presentation.common.theme.WeThemes
import com.mobilewe.wemobile.presentation.screen.auth.register.component.RegisterPasswordCheck
import com.mobilewe.wemobile.resources.Resources
import com.mobilewe.wemobile.utils.getNavigationBarPadding
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collectLatest
import org.jetbrains.compose.resources.painterResource
import org.koin.compose.viewmodel.koinViewModel
import wemobile.composeapp.generated.resources.*


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegistrationSubmitScreen(
    onClickContinue: () -> Unit,
    navigateBack: ()-> Unit
) {
    val viewModel = koinViewModel<RegistrationSubmitScreenModel>()
    val state by viewModel.state.collectAsStateWithLifecycle()

    LaunchedEffect(key1 = true) {
        viewModel.effect.collectLatest { effect ->
            when (effect) {
                RegistrationSubmitScreenEffect.NavigateBack -> navigateBack()
                RegistrationSubmitScreenEffect.NavigateToLoginScreen -> onClickContinue()
            }
        }
    }

    WsBrandBackgroundContainer {
        Row(
            Modifier
                .height(56.dp)
                .fillMaxWidth()
                .align(Alignment.TopCenter)
                .padding(horizontal = 16.dp, vertical = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                Modifier
                    .size(40.dp)
                    .clip(RoundedCornerShape(WeThemes.radius.medium))
                    .background(color = MaterialTheme.colorScheme.surface)
                    .noRippleEffect { viewModel.onBackButtonClicked() },
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    painter = painterResource(Res.drawable.ic_arrow_back),
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.primary,
                    modifier = Modifier.size(16.dp)
                )
            }
        }
        HeadFirstCard(
            textHeader = Resources.strings.justOnMoreStep,
            textSubHeader = Resources.strings.completeYourRegistration
        ) {
            WsTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp),
                text = state.password,
                onValueChange = viewModel::onPasswordChanged,
                label = Resources.strings.password,
                keyboardType = KeyboardType.Password,
                errorMessage = if (state.isPasswordError) Resources.strings.invalidPassword else "",
                isError = state.isPasswordError,
            )

            WsTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp),
                text = state.confirmPassword,
                onValueChange = viewModel::onConfirmPasswordChanged,
                label = Resources.strings.password,
                keyboardType = KeyboardType.Password,
                errorMessage = if (state.isPasswordError) Resources.strings.invalidPassword else "",
                isError = state.isPasswordError,
            )

            RegisterPasswordCheck(
                password = state.password,
                confirmPassword = state.confirmPassword
            )

            WsButton(
                modifier = Modifier
                    .fillMaxWidth().padding(top = 24.dp),
                title = Resources.strings.signUp,
                onClick = {
                    viewModel.onSignUpButtonClicked(
                        UserAccount(
                            fullName = "fullName",
                            email = "email",
                            username = "idNumber",
                            phone = "phoneNumber",
                            address = "address",
                            password = state.password
                        )
                    )
                },
                isLoading = state.isLoading,
            )
        }

        AnimatedVisibility(
            visible = state.showSnackbar,
            enter = slideInVertically { it },
            exit = slideOutVertically { it },
            modifier = Modifier.align(Alignment.BottomCenter)
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

        LaunchedEffect(state.showSnackbar) {
            if (state.showSnackbar) {
                delay(2000)
                viewModel.onDismissSnackBar()
            }
        }
    }
}







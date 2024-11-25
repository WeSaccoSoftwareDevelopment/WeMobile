package com.mobilewe.wemobile.presentation.screen.auth.register.registration

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.mobilewe.wemobile.presentation.common.composables.HeadFirstCard
import com.mobilewe.wemobile.presentation.common.composables.appbar.AppToolbar
import com.mobilewe.wemobile.presentation.common.composables.button.WsButton
import com.mobilewe.wemobile.presentation.common.composables.textfield.WsTextField
import com.mobilewe.wemobile.resources.Resources
import kotlinx.coroutines.flow.collectLatest
import org.koin.compose.viewmodel.koinViewModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegistrationScreen(
    onClickContinue: ()->Unit,
    onNavigateUp: () -> Unit,
    viewModel: RegistrationScreenModel = koinViewModel()
) {
    val state by viewModel.state.collectAsStateWithLifecycle()
    val email = state.email
    val idNumber = state.idNumber
    val address = state.address
    val fullName = state.fullName


    LaunchedEffect(key1 = true) {
        viewModel.effect.collectLatest { effect ->
            when (effect) {
                is RegistrationScreenEffect.NavigateBack -> onNavigateUp()
                is RegistrationScreenEffect.NavigateToSubmitRegistrationScreen -> {
                    onClickContinue()
                }
            }
        }
    }

    Box(modifier = Modifier.fillMaxWidth()){
        HeadFirstCard(
            textHeader = Resources.strings.joinBpToday,
            textSubHeader = Resources.strings.createYourAccount,
            topAppBar = {
                    AppToolbar(
                        title = "Personal Details",
                        showBackArrow = true,
                        navigateBack = onNavigateUp,
                        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                            containerColor = MaterialTheme.colorScheme.surfaceTint
                        )
                    )
                }
        ) {
//            if (phoneNumber != null) {
//                Text(
//                    text = phoneNumber,
//                    color = Color.Red,
//                    modifier = Modifier.fillMaxWidth(),
//                    textAlign = TextAlign.Center
//                )
//            }
            WsTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 24.dp),
                text = state.fullName,
                onValueChange = viewModel::onFullNameChanged,
                label = Resources.strings.fullName,
                errorMessage = if (state.isFullNameError) Resources.strings.invalidFullName else "",
                isError = state.isFullNameError,
            )

            WsTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp),
                text = state.email,
                onValueChange = viewModel::onEmailChanged,
                label = Resources.strings.email,
                errorMessage = if (state.isEmailError) Resources.strings.invalidEmail else "",
                isError = state.isEmailError
            )
            WsTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp),
                text = state.idNumber,
                onValueChange = viewModel::onIdNumberChanged,
                label = "Id Number",
                keyboardType = KeyboardType.Number,

            )
            WsTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp),
                text = state.address,
                onValueChange = viewModel::onAddressChanged,
                label = Resources.strings.yourAddress,
                errorMessage = if (state.isAddressError) Resources.strings.invalidAddress else "",
                isError = state.isAddressError,
            )
            WsButton(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 24.dp),
                title = Resources.strings.next,
                onClick = viewModel::onNextButtonClicked,
                isLoading = state.isLoading
            )
        }

        /*AnimatedVisibility(
            visible = state.showSnackbar,
            enter = slideInVertically { it },
            exit = slideOutVertically { it },
            modifier = Modifier.align(Alignment.BottomCenter)
        ) {
            WsSnackBar(
                icon = painterResource(Resources.images.icError), modifier = Modifier
                    .padding(bottom = getNavigationBarPadding().calculateBottomPadding())
            ) {
                Text(
                    text = state.snackbarMessage,
                    style = WeThemes.typography.body.copy(color = MaterialTheme.colorScheme.onPrimary),
                )
            }
        }*/
    }

}










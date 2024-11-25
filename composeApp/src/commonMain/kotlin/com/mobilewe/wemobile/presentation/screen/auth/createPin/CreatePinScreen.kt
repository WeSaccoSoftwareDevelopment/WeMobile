package com.mobilewe.wemobile.presentation.screen.auth.createPin

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.text.input.KeyboardType
import androidx.navigation.NavController
import com.mobilewe.wemobile.presentation.common.composables.HeadFirstCard
import com.mobilewe.wemobile.presentation.common.composables.WsBrandBackgroundContainer
import com.mobilewe.wemobile.presentation.common.composables.appbar.AppToolbar
import com.mobilewe.wemobile.presentation.common.composables.button.ContinueButton
import com.mobilewe.wemobile.presentation.common.composables.textfield.WsTextField


@Composable
fun CreatePinScreen(
    navigator: NavController
) {
    CreatePinContent(
        onClickAction = {
//            navigator.switchNavGraphRoot()
        },
        viewModel = CreatePinViewModel()
    )

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CreatePinContent(
    onClickAction: () -> Unit,
    viewModel: CreatePinViewModel
) {
    val (pin, setPin) = rememberSaveable { mutableStateOf("") }
    val (confirmPin, setConfirmPin) = rememberSaveable { mutableStateOf("") }

    WsBrandBackgroundContainer {
        HeadFirstCard(
            textHeader = "",
            textSubHeader = "",
            topAppBar = {
                AppToolbar(
                    title = "Create Pin",
                    showForwardArrow = true,
                    navigateBack = {}
                )
            }
        ) {
            WsTextField(
                text = pin,
                onValueChange = { setPin(it) },
                hint = "stringResource(id = R.string.pin_hint)",
                label = "stringResource(id = R.string.pin_hint)",
                keyboardType = KeyboardType.NumberPassword,
                errorMessage = viewModel.passwordError.value,
                maxLength = 4

            )
            WsTextField(
                text = confirmPin,
                onValueChange = { setConfirmPin(it) },
                keyboardType = KeyboardType.NumberPassword,
                label = "stringResource(id = R.string.confirmPin)",
                hint = "stringResource(id = R.string.confirmPin)",
                errorMessage = viewModel.passwordError.value,
                maxLength = 4
            )

            ContinueButton(
                text = "stringResource(id = R.string.continuee)",
                onClick = onClickAction
            )
        }
    }


}


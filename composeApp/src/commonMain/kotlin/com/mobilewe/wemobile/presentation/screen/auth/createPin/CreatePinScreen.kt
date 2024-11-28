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
import com.mobilewe.wemobile.resources.Resources


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
                    title = Resources.strings.confirmPin,
                    showForwardArrow = true,
                    navigateBack = {}
                )
            }
        ) {
            WsTextField(
                text = pin,
                onValueChange = { setPin(it) },
                hint = Resources.strings.pin,
                label = Resources.strings.pinHint,
                keyboardType = KeyboardType.NumberPassword,
                errorMessage = viewModel.passwordError.value,
                maxLength = 4

            )
            WsTextField(
                text = confirmPin,
                onValueChange = { setConfirmPin(it) },
                keyboardType = KeyboardType.NumberPassword,
                label = Resources.strings.confirmNewPin,
                hint = Resources.strings.confirmPin,
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


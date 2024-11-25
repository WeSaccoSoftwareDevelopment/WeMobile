package com.mobilewe.wemobile.presentation.screen.account.resetPin


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.mobilewe.wemobile.presentation.common.composables.appbar.AppToolbar
import com.mobilewe.wemobile.presentation.common.composables.button.ContinueButton
import com.mobilewe.wemobile.presentation.common.composables.textfield.AppOutlinedTextField

@Composable
fun ResetPinScreen(
    onClickAction: () -> Unit,
    navigateBack: () -> Unit
) {
    ResetPinContent(
        onClickAction = onClickAction,
        navigateBack = navigateBack
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ResetPinContent(
    onClickAction: () -> Unit,
    resetPinViewModel: ResetPinViewModel = viewModel(),
    navigateBack: () -> Unit
) {
    val state by resetPinViewModel.state.collectAsStateWithLifecycle()
    Scaffold(
        topBar = {
            AppToolbar(
                title = "Reset pin",
                showBackArrow = true,
                navigateBack = {navigateBack()}
            )
        },
        bottomBar = {
            ContinueButton(
                text = "stringResource(id = R.string.continuee)",
                onClick = onClickAction,
            )

        }
    ) { paddingValues ->
        Column(
            modifier = Modifier.fillMaxSize().padding(paddingValues)
                .padding(horizontal = 16.dp, vertical = 16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Text(
                text = "Reset your pin",
                fontSize = 24.sp
            )

            AppOutlinedTextField(
                text = state.newPin,
                onValueChange = resetPinViewModel::onNewPinChanged,
                hint = "stringResource(id = R.string.current_pin)",
                keyboardType = KeyboardType.NumberPassword,
                isPasswordVisible = state.showCurrentPin,
                onPasswordToggleClick = resetPinViewModel::setShowCurrentPin,
                maxLength = 4
            )

            AppOutlinedTextField(
                text = state.newPin,
                onValueChange = resetPinViewModel::onNewPinChanged,
                keyboardType = KeyboardType.NumberPassword,
                hint = "stringResource(id = R.string.new_pin)",
                isPasswordVisible = state.showNewPin,
                onPasswordToggleClick = resetPinViewModel::setShowCurrentPin,
                maxLength = 4

            )

            AppOutlinedTextField(
                text = state.confirmPin,
                onValueChange = resetPinViewModel::onConfirmPinChanged,
                keyboardType = KeyboardType.NumberPassword,
                hint = "stringResource(id = R.string.confirmNewPin)",
                isPasswordVisible = state.showConfirmPin,
                onPasswordToggleClick = resetPinViewModel::showConfirmPin,
                maxLength = 4
            )
            
            Spacer(modifier = Modifier.height(12.dp))


        }
    }
}


package com.mobilewe.wemobile.presentation.screen.account.resetPassword

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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.mobilewe.wemobile.presentation.common.composables.appbar.AppToolbar
import com.mobilewe.wemobile.presentation.common.composables.button.ContinueButton
import com.mobilewe.wemobile.presentation.common.composables.textfield.AppOutlinedTextField
import org.jetbrains.compose.resources.stringResource
import wemobile.composeapp.generated.resources.Res
import wemobile.composeapp.generated.resources.continuee

@Composable
fun ResetPasswordScreen(
    onClickAction: () -> Unit,
    navigateBack: () -> Unit
) {
    ResetPasswordContent(
        onClickAction = onClickAction,
        navigateBack = navigateBack
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ResetPasswordContent(
    onClickAction: () -> Unit,
    resetPasswordViewModel: ResetPasswordViewModel = viewModel(),
    navigateBack: () -> Unit
) {
    val (currentPassword, setCurrentPassword) = rememberSaveable { mutableStateOf("") }
    val (newPassword, setNewPassword) = rememberSaveable { mutableStateOf("") }
    val (confirmNewPassword, setConfirmNewPassword) = rememberSaveable { mutableStateOf("") }
    Scaffold(
        topBar = {
            AppToolbar(
                title = "Reset Password",
                showForwardArrow = true,
                showBackArrow = true,
                navigateBack = {navigateBack()}
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(horizontal = 16.dp, vertical = 16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Text(
                text = "Reset your password",
                fontSize = 24.sp
            )

            AppOutlinedTextField(
                text = currentPassword,
                onValueChange = { setCurrentPassword(it) },
                hint = "stringResource(id = R.string.current_password)",
                keyboardType = KeyboardType.Password,
                errorMessage = resetPasswordViewModel.passwordError.value,
                isPasswordVisible = resetPasswordViewModel.showPassword.value,
                onPasswordToggleClick = {
                    resetPasswordViewModel.setShowPassword(it)
                }
            )
            AppOutlinedTextField(
                text = newPassword,
                onValueChange = { setNewPassword(it) },
                keyboardType = KeyboardType.Password,
                hint = "stringResource(id = R.string.new_password)",
                errorMessage = resetPasswordViewModel.passwordError.value,
                isPasswordVisible = resetPasswordViewModel.showPassword.value,
                onPasswordToggleClick = {
                    resetPasswordViewModel.setShowPassword(it)
                }
            )
            AppOutlinedTextField(
                text = confirmNewPassword,
                onValueChange = { setConfirmNewPassword(it) },
                keyboardType = KeyboardType.Password,
                hint = "stringResource(id = R.string.confirmNewPassword)",
                errorMessage = resetPasswordViewModel.passwordError.value,
                isPasswordVisible = resetPasswordViewModel.showConfirmPassword.value,
                onPasswordToggleClick = {
                    resetPasswordViewModel.setShowConfirmPassword(it)
                }
            )
            Spacer(modifier = Modifier.height(12.dp))
            ContinueButton(
                text = stringResource(Res.string.continuee),
                onClick = onClickAction,
                enable = currentPassword.isNotEmpty() && newPassword.isNotEmpty() && confirmNewPassword.isNotEmpty() && newPassword == confirmNewPassword
            )


        }
    }
}


package com.mobilewe.wemobile.presentation.screen.auth.register.registrationSubmit

import com.mobilewe.wemobile.domain.model.UserAccount
import com.mobilewe.wemobile.domain.usecases.IManageAuthenticationUseCase
import com.mobilewe.wemobile.domain.usecases.IManageSettingUseCase
import com.mobilewe.wemobile.domain.usecases.IValidationUseCase
import com.mobilewe.wemobile.domain.utils.AuthorizationException
import com.mobilewe.wemobile.domain.validation.PasswordValidationState
import com.mobilewe.wemobile.domain.validation.ValidatePassword
import com.mobilewe.wemobile.presentation.common.base.BaseScreenModel
import com.mobilewe.wemobile.presentation.common.base.ErrorState
import com.mobilewe.wemobile.utils.LanguageCode
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class RegistrationSubmitScreenModel(
    private val validation: IValidationUseCase,
    private val manageAuthentication: IManageAuthenticationUseCase,
    private val manageUser: IManageSettingUseCase,
) : BaseScreenModel<RegistrationSubmitUIState, RegistrationSubmitScreenEffect>(
    RegistrationSubmitUIState()
), RegistrationSubmitInteractionListener {
    private val _language: MutableStateFlow<LanguageCode> = MutableStateFlow(LanguageCode.EN)
    val language: StateFlow<LanguageCode> = _language.asStateFlow()

    private val _passwordValidation = MutableStateFlow(PasswordValidationState())
    val passwordValidation: StateFlow<PasswordValidationState> = _passwordValidation.asStateFlow()
    private val validatePassword = ValidatePassword()
    init {
        getUserLanguageCode()
    }
    private fun getUserLanguageCode() {
        viewModelScope.launch(Dispatchers.IO) {
            manageUser.getUserLanguageCode().distinctUntilChanged().collectLatest { lang ->
                _language.update {
                    LanguageCode.entries.find { languageCode -> languageCode.value == lang }
                        ?: LanguageCode.EN
                }
            }
        }
    }



    override fun onConfirmPasswordChanged(confirmPassword: String) {
        updateState { it.copy(confirmPassword = confirmPassword) }
        tryCatch { validation.validatePassword(confirmPassword) }
        updatePasswordErrorState()
    }

    override fun onPasswordChanged(password: String) {
        updateState { it.copy(password = password) }
        tryCatch { validation.validatePassword(password) }
        updatePasswordErrorState()
    }

    override fun onSignUpButtonClicked(userAccount: UserAccount) {
        with(state.value) {
            updateState { it.copy(isLoading = true) }
            tryToExecute(
                function = {
                    manageAuthentication.createUser(userAccount)
                },
                onSuccess = ::onRegistrationSuccess,
                onError = ::onError
            )
        }
    }

    private fun onRegistrationSuccess(success: Boolean) {
        sendNewEffect(RegistrationSubmitScreenEffect.NavigateToLoginScreen)
    }

    private fun onError(error: ErrorState) {
        clearErrors()
        when (error) {
            ErrorState.InvalidPassword -> updateState { it.copy(isPasswordError = true) }

            ErrorState.InvalidPassword -> updateState { it.copy(isConfirmPasswordError = true) }

            is ErrorState.UserAlreadyExists -> showSnackbar(error.message)
            else -> {}
        }
    }

    override fun onBackButtonClicked() {
        sendNewEffect(RegistrationSubmitScreenEffect.NavigateBack)
    }

    private fun updatePasswordErrorState() {
        val passwordState = state.value.password
        val confirmPasswordState = state.value.confirmPassword
        val validation = validatePassword.execute(passwordState, confirmPasswordState)
        _passwordValidation.value = validation
    }


    override fun onDismissSnackBar() {
        updateState { it.copy(snackbarMessage = "", showSnackbar = false) }
    }

    // region private methods
    private fun tryCatch(block: () -> Unit) {
        try {
            block()
            clearErrors()
        } catch (e: AuthorizationException.InvalidPasswordException) {
            updateState { it.copy(isPasswordError = true) }
        } catch (e: AuthorizationException.InvalidPasswordException) {
            updateState {
                it.copy(isConfirmPasswordError = true)
            }
        }
    }

    private fun clearErrors() {
        updateState {
            it.copy(
                isPasswordError = false,
                isConfirmPasswordError = false,
                isLoading = false
            )
        }
    }

    private fun showSnackbar(message: String) {
        viewModelScope.launch {
            updateState { it.copy(snackbarMessage = message, showSnackbar = true) }
            delay(2000) // wait for snackbar to show
            updateState { it.copy(showSnackbar = false) }
            delay(300) // wait for snackbar to hide
            updateState { it.copy(snackbarMessage = "") }
        }
    }
    // endregion
}

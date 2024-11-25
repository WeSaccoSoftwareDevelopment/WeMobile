package com.mobilewe.wemobile.presentation.screen.auth.register.registration

import com.mobilewe.wemobile.domain.usecases.IValidationUseCase
import com.mobilewe.wemobile.domain.utils.AuthorizationException
import com.mobilewe.wemobile.presentation.common.base.BaseScreenModel

class RegistrationScreenModel(private val validation: IValidationUseCase) :
    BaseScreenModel<RegistrationUIState, RegistrationScreenEffect>(RegistrationUIState()),
    RegistrationInteractionListener {



    override fun onEmailChanged(email: String) {
        updateState { it.copy(email = email) }
        tryCatch { validation.validateEmail(email) }
    }

    override fun onAddressChanged(address: String) {
        updateState { it.copy(address = address) }
        tryCatch { validation.validateAddress(address) }
    }

    override fun onIdNumberChanged(idNumber: String) {
        updateState { it.copy(idNumber = idNumber) }

    }

    override fun onFullNameChanged(fullName: String) {
        updateState { it.copy(fullName = fullName) }
    }

    override fun onNextButtonClicked() {
        with(state.value) {
            tryCatch {
                validation.validateEmail(email)
                sendNewEffect(
                    RegistrationScreenEffect.NavigateToSubmitRegistrationScreen(
                      phoneNumber=phoneNumber,
                        email= email,
                        idNumber = idNumber,
                        address = address,
                        fullName = fullName,
                    )
                )
            }
        }
    }

    override fun onBackButtonClicked() {
        sendNewEffect(RegistrationScreenEffect.NavigateBack)
    }
    // endregion

    // region private methods
    private fun tryCatch(block: () -> Unit) {
        try {
            block()
            clearErrors()
        } catch (e: AuthorizationException.InvalidFullNameException) {
            updateState { it.copy(isFullNameError = true) }
        } catch (e: AuthorizationException.InvalidEmailException) {
            updateState {
                it.copy(isEmailError = true)
            }
        } catch (e: AuthorizationException.InvalidAddressException){
            updateState {
                it.copy(isAddressError = true)
            }
        }
    }

    private fun clearErrors() {
        updateState {
            it.copy(
                isFullNameError = false,
                isAddressError = false,
                isEmailError = false,
            )
        }
    }
    // endregion
}
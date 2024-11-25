package com.mobilewe.wemobile.presentation.screen.auth.phoneRegistration

import com.mobilewe.wemobile.domain.usecases.IValidationUseCase
import com.mobilewe.wemobile.domain.utils.AuthorizationException
import com.mobilewe.wemobile.presentation.common.base.BaseScreenModel
import com.mobilewe.wemobile.presentation.common.base.ErrorState
import com.mobilewe.wemobile.presentation.screen.auth.country.Country
import com.mobilewe.wemobile.presentation.screen.auth.country.getCountriesList
import com.mobilewe.wemobile.utils.LanguageCode
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class PhoneRegViewModel(private val validation: IValidationUseCase) :
    BaseScreenModel<PhoneRegUiState, PhoneRegScreenEffect>(PhoneRegUiState()),
    PhoneRegInteractionListener {


    private val _language: MutableStateFlow<LanguageCode> = MutableStateFlow(LanguageCode.EN)
    val language: StateFlow<LanguageCode> = _language.asStateFlow()

    val countriesList = getCountriesList()


    override fun onCountrySelected(country: Country) {
        updateState { it.copy(countryNameCode = country.nameCode) }
        updateState { it.copy(countryCode = country.code) }
        updateState { it.copy(countryFullName = country.fullName) }

    }

    override fun onPhoneNumberChanged(phoneNumber: String) {
        updateState { it.copy(phoneNumber = phoneNumber) }
//        tryCatch { validation.validatePhone(phoneNumber,_language.value.value) }
    }

    override fun onCountryNameChanged(countryFullName: String) {
        updateState { it.copy(countryFullName = countryFullName) }
    }




    override fun onNextButtonClicked() {
        with(state.value) {
            tryCatch {
//                validation.validatePhone(phoneNumber)
                sendNewEffect(
                    PhoneRegScreenEffect.NavigateToSubmitRegistrationScreen(
                        phoneNumber = phoneNumber,
                    )
                )
            }

        }
    }


    private fun onError(error: ErrorState) {
        clearErrors()
        when (error) {
            ErrorState.InvalidPhone -> updateState { it.copy(isPhoneError = true) }
            else -> {}
        }
    }
    override fun onBackButtonClicked() {
        sendNewEffect(PhoneRegScreenEffect.NavigateBack)
    }

    private fun tryCatch(block: () -> Unit) {
        try {
            block()
            clearErrors()
        }
        catch (e: AuthorizationException.InvalidPhoneException) {
            updateState  {
                it.copy(isPhoneError = true)
            }
        }
    }

    private fun clearErrors() {
        updateState {
            it.copy(
                isPhoneError = false,
            )
        }
    }

}
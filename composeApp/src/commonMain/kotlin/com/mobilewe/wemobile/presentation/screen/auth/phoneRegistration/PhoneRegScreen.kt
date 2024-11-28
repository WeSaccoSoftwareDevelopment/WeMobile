package com.mobilewe.wemobile.presentation.screen.auth.phoneRegistration

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Close
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.input.KeyboardType
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.mobilewe.wemobile.presentation.common.composables.HeadFirstCard
import com.mobilewe.wemobile.presentation.common.composables.appbar.AppToolbar
import com.mobilewe.wemobile.presentation.common.composables.button.ContinueButton
import com.mobilewe.wemobile.presentation.common.composables.textfield.AppOutlinedTextField
import com.mobilewe.wemobile.resources.Resources
import com.mobilewe.wemobile.presentation.screen.auth.phoneRegistration.component.CountrySelectionModalBottomSheet
import com.mobilewe.wemobile.presentation.screen.auth.phoneRegistration.component.CountryTextField
import kotlinx.coroutines.flow.collectLatest
import org.koin.compose.viewmodel.koinViewModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PhoneRegScreen(
    viewModel: PhoneRegViewModel = koinViewModel(),
    onNavigate:(String)-> Unit
) {
    val phoneRegUiState by viewModel.state.collectAsStateWithLifecycle()
    var isSheetOpen by rememberSaveable { mutableStateOf(false) }
    val sheetState = rememberModalBottomSheetState()
    val coroutineScope = rememberCoroutineScope()

    val phoneNumber = phoneRegUiState.phoneNumber


    LaunchedEffect(key1 = true) {
        viewModel.effect.collectLatest { effect->
            when (effect) {
                is PhoneRegScreenEffect.NavigateBack -> {}
                is PhoneRegScreenEffect.NavigateToSubmitRegistrationScreen -> onNavigate(phoneNumber)
            }
        }
    }

    HeadFirstCard(
        textHeader = "",
        textSubHeader = "",
        topAppBar = {
            AppToolbar(
                title = "Let get started with SaccoMobile",
                showBackArrow = true,
                navigateBack = { },
            )
        }
    ) {
        CountryTextField(
            phoneRegUiState = phoneRegUiState,
            viewModel = viewModel,
            onCountryClick = { isSheetOpen = true }
        )

        AppOutlinedTextField(
            text = phoneRegUiState.phoneNumber,
            label = Resources.strings.mobileNumber,
            onValueChange = viewModel::onPhoneNumberChanged,
            hint = Resources.strings.phoneNumber,
            keyboardType = KeyboardType.Phone,
            leadingIconComponent = {
                Text(text = phoneRegUiState.countryCode)
            }
        )

        ContinueButton(
            onClick = viewModel::onNextButtonClicked,
            text = Resources.strings.continuee,
            enable = phoneRegUiState.phoneNumber.isNotEmpty()
        )

        CountrySelectionModalBottomSheet(
            isSheetOpen = isSheetOpen,
            onDismissRequest = { isSheetOpen = false },
            sheetState = sheetState,
            phoneRegUiState = phoneRegUiState,
            viewModel = viewModel,
            coroutineScope = coroutineScope
        )


    }

}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CountryTopBar(
    title: String,
    onClose:()->Unit
) {
    CenterAlignedTopAppBar(
        title = { Text(text = title)},
        navigationIcon = {
            IconButton(onClick = { onClose()}) {
                Icons.Outlined.Close
            }
        }
    )

}
package com.mobilewe.wemobile.presentation.screen.account.security

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.mobilewe.wemobile.presentation.common.composables.card.MoreVerticalItem
import com.mobilewe.wemobile.presentation.common.theme.WeThemes
import org.koin.compose.viewmodel.koinViewModel
import wemobile.composeapp.generated.resources.Res
import wemobile.composeapp.generated.resources.devices_24
import wemobile.composeapp.generated.resources.fingerprint_24
import wemobile.composeapp.generated.resources.message_chat_icon
import wemobile.composeapp.generated.resources.password
import wemobile.composeapp.generated.resources.sim_card


@Composable
fun SecurityScreen(navigator: NavController) {
    val viewModel: SecurityViewModel = koinViewModel()


    val securityState by viewModel.securityState.collectAsStateWithLifecycle()
    var isBiometricEnabledBiometric by remember { mutableStateOf(false) }




    /*LaunchedEffect(Unit) {
       val isBiometricEnabled = biometricUseCase.execute().first()
        if (isBiometricEnabled == true) {
             isBiometricEnabledBiometric = isBiometricEnabled
            Toast.makeText(context, "Biometric authentication is  enabled", Toast.LENGTH_SHORT).show()
        } else {
            lifecycleCoroutineScope.launch {
                biometric.authenticate()
            }
        }
    }*/

    Scaffold(
        topBar = {
            /*AppBarWithTwoActions(
                onLeftButtonClick = { },
                onRightButtonClick = { },
                rightIcon = Icons.Outlined.ArrowBack,
                leftIcon = Icons.Outlined.ArrowBack,
                toolbarTitle = stringResource(id = R.string.security),
                isRightIconVisible = false
            )*/
        }
    ) { paddingValues ->

        Column(
            modifier = Modifier
                .padding(paddingValues)
                .padding(horizontal = WeThemes.dimens.space16)
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.spacedBy(WeThemes.dimens.space10)
        ) {



            MoreVerticalItem(
                title = "R.string.manage_password",
                subtitle = "R.string.reset_password_or_create_new",
                drawable = Res.drawable.password
            )

            MoreVerticalItem(
                title = "R.string.manage_pin",
                subtitle = "R.string.reset_pin_or_change_pin",
                drawable = Res.drawable.sim_card
            )

            MoreVerticalItem(
                title =" R.string.biometric_id",
                subtitle = "R.string.unlock_with_touch",
                showSwitcher = true,
                drawable = Res.drawable.fingerprint_24,
                onCheckChange = {
//                    if (!biometricUiState.isBiometricEnabled) {
//                        biometric.authenticate()
//                    } else {
//                        // The user disabled biometric authentication
//                        // Update the SharedPreferences to store the status
//                        viewModel.onEvent(BiometricUiEvent.EnableBiometricToggled(false))
//                    }
                },
                isChecked = false
            )


            MoreVerticalItem(
                onCheckChange = viewModel::onSmsAuthenticator,
                isChecked = securityState.smsAuthenticator ,
                title =  "R.string.sms_authenticator",
                drawable = Res.drawable.message_chat_icon
            )

            MoreVerticalItem(
                drawable  = Res.drawable.devices_24,
                title = "(R.string.device_management)",
                subtitle =" R.string.device_management_subtitle",
                onClick = {}
            )

        }
    }

}

package com.mobilewe.wemobile.presentation.screen.account.settings

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.mobilewe.wemobile.presentation.common.composables.appbar.AppToolbar
import com.mobilewe.wemobile.presentation.common.composables.card.AppCardComponent
import org.jetbrains.compose.resources.DrawableResource
import org.koin.compose.viewmodel.koinViewModel
import wemobile.composeapp.generated.resources.Res
import wemobile.composeapp.generated.resources.devices
import wemobile.composeapp.generated.resources.fingerprint_icon
import wemobile.composeapp.generated.resources.password
import wemobile.composeapp.generated.resources.sim_card

@Composable
fun SettingsScreen(
    navigateToTheme: () -> Unit,
    navigateToBiometricSettings: () -> Unit,
    navigateToResetPin: () -> Unit,
    navigateToResetPassword: () -> Unit,
    navigateBack: () -> Unit,
    navigateToManageDevice:()->Unit
) {
    SettingsScreenContent(
        navigateToTheme = { navigateToTheme() },
        navigateToBiometricSettings = { navigateToBiometricSettings() },
        navigateBack = { navigateBack() },
        navigateToResetPassword = { navigateToResetPassword() },
        navigateToResetPin = { navigateToResetPin() },
        navigateToManageDevice = { navigateToManageDevice()}
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingsScreenContent(
    settingsViewModel: SettingsViewModel = koinViewModel(),
    navigateToTheme: () -> Unit,
    navigateToBiometricSettings: () -> Unit,
    navigateToResetPin: () -> Unit,
    navigateToResetPassword: () -> Unit,
    navigateBack: () -> Unit,
    navigateToManageDevice:()->Unit
) {

    Scaffold(
        topBar = {
            AppToolbar(
                title = "App Settings ",
                showBackArrow = true,
                navigateBack = { navigateBack() }
            )
        }
    ) { paddingValues ->

        Box(modifier = Modifier.fillMaxSize()) {
            LazyColumn(
                contentPadding = paddingValues,
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                item {
                    Spacer(modifier = Modifier.height(16.dp))
                }


                item {
                    AppCardComponent(
                        onClick = { navigateToBiometricSettings() },
                        title = "R.string.biometric",
                        icon = Res.drawable.fingerprint_icon,
                    )
                }

                items(settingScreenOptions) { settingsItem ->
                    AppCardComponent(
                        title = settingsItem.title,
                        icon = settingsItem.drawable,
                        onClick = { settingOptions ->
                            when (settingOptions) {
                                "R.string.manage_password" -> { navigateToResetPassword() }
                                "R.string.manage_pin" -> { navigateToResetPin() }
                                "R.string.manage_your_devices_title" ->{ navigateToManageDevice()}
                            }
                        }
                    )
                }

            }
        }

    }

}

data class SettingsItem(
    val title: String,
    val subTitle: String,
    val drawable: DrawableResource
)


private val settingScreenOptions = listOf(
    SettingsItem(
        title = "R.string.manage_password",
        subTitle = "R.string.reset_password_or_create_new",
        drawable = Res.drawable.password
    ),
    SettingsItem(
        title = "R.string.manage_pin",
        subTitle =" R.string.reset_pin_or_change_pin",
        drawable = Res.drawable.sim_card
    ),
    SettingsItem(
        drawable = Res.drawable.devices,
        title = "R.string.manage_your_devices_title",
        subTitle = "R.string.manage_your_devices_subtitle"
    )
)
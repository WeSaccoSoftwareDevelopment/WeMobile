package com.mobilewe.wemobile.presentation.screen.account.notificationPreferences


import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.mobilewe.wemobile.presentation.common.composables.appbar.AppToolbar
import com.mobilewe.wemobile.presentation.common.composables.card.MoreVerticalItem
import com.mobilewe.wemobile.presentation.common.theme.WeThemes
import com.mobilewe.wemobile.presentation.screen.account.account.AccountViewModel
import org.jetbrains.compose.resources.DrawableResource
import org.koin.compose.viewmodel.koinViewModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable

fun NotificationPreferenceScreen(
    navigator: NavController = rememberNavController()
) {

    val moreViewModel: AccountViewModel = koinViewModel()
    val moreUiState by moreViewModel.moreUiState.collectAsStateWithLifecycle()

    Scaffold(
        topBar = {
            AppToolbar(
                showBackArrow = true,
                title = "Notification Preference",
                navigateBack = { navigator.popBackStack()}
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            verticalArrangement = Arrangement.Top
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                contentAlignment = Alignment.TopStart
            ) {
                LazyColumn(
                    modifier = Modifier.fillMaxWidth(),
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    item {
                        Column(
                            modifier = Modifier.fillMaxWidth(),
                        ) {
                            Text(
                                text = "Set your notification screen preferences",
                                style = WeThemes.typography.titleLarge
                            )
                            Text(
                                text = "Select which notifications you would like to receive",
                            )
                        }
                    }

                    items(notificationPreferenceOption) { accountItem ->
                        MoreVerticalItem(
                            title = accountItem.title,
                            subtitle = accountItem.subtitle,
                            statusNotification = accountItem.statusNotification,
                            showSwitcher = accountItem.showSwitcher,
                            onClick = { accountOptions ->
                                when (accountOptions) {
                                    "R.string.transaction_alert" -> {
//                                        navigator.openTransactionAlertScreen()
                                    }

                                    "R.string.reminders" -> {
//                                        navigator.openSaccoRemindersNotificationScreen()
                                    }

                                    "R.string.wesacco_account_alert" -> {
//                                        navigator.openSaccoAccountNotificationSettings()
                                    }

                                    "R.string.service_update" -> {

                                    }
                                    "R.string.marketing_content" -> {
//                                        if (moreUiState.isMarketContentEnabled){
//                                            moreViewModel.onEvent(MoreUiEvent.EnableMarketContentToggled(true))
//                                        } else{
//                                            moreViewModel.onEvent(MoreUiEvent.EnableMarketContentToggled(false))
//                                        }
                                    }
                                   " R.string.events" -> {
//                                        moreViewModel.onEvent(MoreUiEvent.EnableEventToggled(true))

                                    }

                                }
                            },
                            isChecked = moreUiState.isMarketContentEnabled,
                            onCheckChange = {isEnabled->
//                                if (moreUiState.isMarketContentEnabled){
//                                    moreViewModel.onEvent(MoreUiEvent.EnableMarketContentToggled(isEnabled))
//                                } else{
//                                    moreViewModel.onEvent(MoreUiEvent.EnableMarketContentToggled(isEnabled))
//                                }
                            }
                        )
                    }
                    item {
                        MoreVerticalItem(
                            title = "R.string.service_update",
                            showSwitcher = true,
                            isChecked = moreUiState.isMarketContentEnabled,
                            onCheckChange = {isEnabled->
//                                if (!moreUiState.isMarketContentEnabled){
//                                    moreViewModel.onEvent(MoreUiEvent.EnableMarketContentToggled(isEnabled))
//
//                                } else{
//                                    moreViewModel.onEvent(MoreUiEvent.EnableMarketContentToggled(isEnabled))
//                                }
                            }
                        )
                    }

                }
            }

        }
    }


}


data class NotificationPreferencesItem(
    val title: String,
    val subtitle: String? = null,
    val icon: DrawableResource? = null,
    val onCheckChange: (Boolean) -> Unit = {},
    val isChecked: () -> Boolean = { false },
    val showSwitcher: Boolean = false,
    val statusNotification: Boolean = false

)

private val notificationPreferenceOption = listOf(
    NotificationPreferencesItem(
        title = "R.string.transaction_alert",
        subtitle = "R.string.transaction_alert_desc",
        statusNotification = true
    ),
    NotificationPreferencesItem(
        title = "R.string.reminders",
        subtitle = "R.string.reminder_desc",
        statusNotification = true
    ),
    NotificationPreferencesItem(
        title = "R.string.wesacco_account_alert",
        subtitle = "R.string.wesacco_account_alert_desc",
        statusNotification = true
    ),
    NotificationPreferencesItem(
        title = "R.string.service_update",
        subtitle = "R.string.service_update_desc",
        showSwitcher = true
    ),
    NotificationPreferencesItem(
        title = "R.string.marketing_content",
        subtitle = "R.string.marketing_content_desc",
        showSwitcher = true
    ),

    NotificationPreferencesItem(
        title ="= R.string.events",
        subtitle = "R.string.events_desc",
        showSwitcher = true
    )
)


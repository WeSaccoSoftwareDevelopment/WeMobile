package com.mobilewe.wemobile.presentation.screen.account.notificationSettings

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.mobilewe.wemobile.presentation.common.composables.divider.CustomDivider
import com.mobilewe.wemobile.presentation.common.theme.WeThemes
import org.koin.compose.viewmodel.koinViewModel


@Composable
fun NotificationSettingsScreen(
    navController: NavController
) {
    val viewModel: NotificationSettingsViewModel = koinViewModel()
    val notificationSettingsState by viewModel.notificationSettingsState.collectAsStateWithLifecycle()

    Scaffold(
        topBar = {
//            AppBarWithTwoActions(
//                onLeftButtonClick = { navController.popBackStack() },
//                onRightButtonClick = { },
//                rightIcon = Icons.Outlined.ArrowBack,
//                leftIcon = Icons.Outlined.ArrowBack,
//                toolbarTitle = stringResource(id = R.string.notification),
//                isRightIconVisible = false
//            )
        }
    ) { paddingValues ->

        Column(
            modifier = Modifier
                .padding(paddingValues)
                .padding(horizontal = WeThemes.dimens.space16)
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.spacedBy(WeThemes.dimens.space10)
        ) {

            CustomDivider(
                text = "stringResource(id = R.string.general)",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = WeThemes.dimens.space10)
            )

            SwitchItem(
                onCheckChange = viewModel::onStatusUpdate,
                isChecked = { notificationSettingsState.statusUpdate },
                text = "stringResource(R.string.transactions_status_updates)"
            )

            SwitchItem(
                onCheckChange = viewModel::onFraudAlert,
                isChecked = { notificationSettingsState.fraudAlert },
                text = "stringResource(R.string.fraud_alert)"
            )

            SwitchItem(
                onCheckChange = viewModel::onPaymentRequest,
                isChecked = { notificationSettingsState.paymentRequest },
                text = "stringResource(R.string.payment_requests)"
            )

            SwitchItem(
                onCheckChange = viewModel::onCardActivity,
                isChecked = { notificationSettingsState.cardActivity },
                text = "stringResource(R.string.card_activity)"
            )

            SwitchItem(
                onCheckChange = viewModel::onSupportNotifications,
                isChecked = { notificationSettingsState.supportNotifications },
                text = "stringResource(R.string.customer_support)"
            )

            SwitchItem(
                onCheckChange = viewModel::onAccountBalance,
                isChecked = { notificationSettingsState.accountBalance },
                text = "stringResource(R.string.account_balance)"
            )

            SwitchItem(
                onCheckChange = viewModel::onSecurityAlert,
                isChecked = { notificationSettingsState.securityAlert },
                text = "stringResource(R.string.security_alert)"
            )

            SwitchItem(
                onCheckChange = viewModel::onDailyWeeklySummary,
                isChecked = { notificationSettingsState.dailyWeeklySummary },
                text = "stringResource(R.string.daily_weekly_summary)"
            )

            Spacer(modifier = Modifier.height(WeThemes.dimens.space5))

            CustomDivider(
                text = "stringResource(id = R.string.general)",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = WeThemes.dimens.space10)
            )

            Spacer(modifier = Modifier.height(WeThemes.dimens.space5))

            SwitchItem(
                onCheckChange = viewModel::onAppUpdates,
                isChecked = { notificationSettingsState.appUpdates },
                text = "stringResource(R.string.app_updates)"
            )

            SwitchItem(
                onCheckChange = viewModel::onPromotionalOffers,
                isChecked = { notificationSettingsState.promotionalOffers },
                text = "stringResource(R.string.promotional_offers)"
            )

            SwitchItem(
                onCheckChange = viewModel::onSurvey,
                isChecked = { notificationSettingsState.survey },
                text = "stringResource(R.string.participate_servey)"
            )
        }
    }
}


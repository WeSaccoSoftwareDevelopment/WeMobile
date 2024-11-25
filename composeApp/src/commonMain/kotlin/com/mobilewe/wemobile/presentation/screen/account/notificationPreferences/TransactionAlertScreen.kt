package com.mobilewe.wemobile.presentation.screen.account.notificationPreferences

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.mobilewe.wemobile.presentation.common.composables.appbar.AppToolbar
import com.mobilewe.wemobile.presentation.common.composables.card.MoreVerticalItem
import com.mobilewe.wemobile.presentation.common.theme.WeThemes
import wemobile.composeapp.generated.resources.Res
import wemobile.composeapp.generated.resources.email
import wemobile.composeapp.generated.resources.*


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TransactionAlertScreen(
    navigator: NavController
) {
    Scaffold(
        topBar = {
            AppToolbar(
                title = "Transaction alert",
                showBackArrow = true,
                navigateBack = {navigator.popBackStack()}
            )
        }
    ) { paddingValues->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)

        ) {
            Text(
                text = "stringResource(R.string.select_the_account_you_want_to_get_transaction_alert_for)",
                style = WeThemes.typography.titleLarge
            )

            /*EquityTextField(
                onValueChange = {},
                title = "Account",
                hint = "All accounts",
                showDefaultTrailingIcon = true
            )*/

            Text(
                text = "stringResource(R.string.how_do_you_want_to_receive_your_alerts)",
                style = WeThemes.typography.titleLarge
            )

            MoreVerticalItem(
                title = "R.string.email_notification,",
                drawable = Res.drawable.email,
                subtitle = "R.string.notification_disabled",
                showSwitcher = true
            )

            MoreVerticalItem(
                title = "R.string.sms_alert",
                drawable = Res.drawable.ic_question_answer_background,
                subtitle = "R.string.alert_enabled",
                showSwitcher = true
            )


        }
    }

}
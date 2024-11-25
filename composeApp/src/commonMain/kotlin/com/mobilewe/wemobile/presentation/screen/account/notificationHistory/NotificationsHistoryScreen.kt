package com.mobilewe.wemobile.presentation.screen.account.notificationHistory

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.mobilewe.wemobile.presentation.common.composables.MainBackgroundHeader
import com.mobilewe.wemobile.presentation.common.composables.divider.WeSaccoDivider
import com.mobilewe.wemobile.presentation.common.theme.WeThemes


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun NotificationsHistoryScreen(
    navController: NavController
) {
    MainBackgroundHeader(
        topBar = {
//            AppBarWithTwoActions(
//                onLeftButtonClick = {  },
//                onRightButtonClick = {  },
//                rightIcon = Icons.Outlined.Settings,
//                leftIcon = Icons.Outlined.ArrowBack,
//                toolbarTitle = stringResource(id = R.string.notification),
//                isRightIconVisible = true
//            )
        }
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = WeThemes.dimens.space5)
        ) {

            item { 
                Spacer(modifier = Modifier.height(WeThemes.dimens.space16))
            }

            notifications.groupBy { it.date }.forEach { (date, notifications) ->
                stickyHeader {
                    Column {
                        Spacer(modifier = Modifier.height(WeThemes.dimens.space16))
                        NotificationHistoryStickyHeader(
                            text = date
                        )
                        Spacer(modifier = Modifier.height(WeThemes.dimens.space16))
                    }
                }

                itemsIndexed(
                    notifications,
                    key = { id, notif -> "$id ${notif.title}" }
                ) { index, notification ->
                    NotificationHistoryItem(
                        notification = notification,
                        onNotificationClick = {},
                        modifier = Modifier.fillMaxWidth())
                }
            }
        }
    }

}


@Composable
fun NotificationHistoryStickyHeader(
    modifier: Modifier = Modifier, text: String
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(
            text = text, style = WeThemes.typography.labelSmall,
            color = MaterialTheme.colorScheme.onBackground
        )

        Spacer(modifier = Modifier.width(16.dp))

        WeSaccoDivider(modifier = Modifier.weight(1f))
    }
}

package com.mobilewe.wemobile.presentation.screen.account.account


import com.mobilewe.wemobile.presentation.screen.account.account.composable.AccountCardItem
import com.mobilewe.wemobile.presentation.screen.account.account.composable.AccountDetailsSection
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.DrawableResource
import org.koin.compose.viewmodel.koinViewModel
import wemobile.composeapp.generated.resources.Res
import wemobile.composeapp.generated.resources.insights_icon
import wemobile.composeapp.generated.resources.notifications
import wemobile.composeapp.generated.resources.*

@Composable
fun AccountScreen(
    navigateBack:()->Unit,
    onNavigateToStatement: ()->Unit,
    navigateToSettings: ()->Unit,
    navigateToAboutSaccoRide:()->Unit,
    navigateToNotification:()->Unit,
    navigateToManagePin:()->Unit,
    navigateToManagePassword:()->Unit
) {

    val viewModel: AccountViewModel = koinViewModel()
    var isSheetOpen by rememberSaveable { mutableStateOf(false) }
    var isLogoutSheetOpen by rememberSaveable { mutableStateOf(false) }

    Scaffold(
        topBar = {
//            CommonAppBar(
//                isRightIconVisible = false,
//                toolBarTitle = stringResource(id = R.string.account),
//                onMoreClick = { }) {
//            }
        }
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(paddingValues)
        ) {
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                verticalArrangement = Arrangement.spacedBy(12.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp)
            ) {

                item(span = { GridItemSpan(2) }) {
                    Column {
                        AccountDetailsSection(
                            onQrCodeClick = {
                                isSheetOpen = true
                            },
                            modifier = Modifier.fillMaxWidth(),
                            onClick = {}
                        )
                    }
                }

                items(accountOptions2.size) { product ->
                    AccountCardItem(
                        text = accountOptions2[product].title,
                        subTitle = accountOptions2[product].subTitle,
                        icon = accountOptions2[product].icon,
                        onClick = { sendMoneyOption ->
                            when (sendMoneyOption) {
                                "R.string.notification_updates" -> { navigateToNotification()}
                                "R.string.about_sacco_title "->{ navigateToAboutSaccoRide()}
                               " R.string.privacy" ->{ }
                               " R.string.get_in_touch" ->{ }
                            }
                        },
                        showDrawableColorTint = false
                    )


                }

                item(span = { GridItemSpan(2) }) {
                    Text(text = "Account")
                }

                items(accountOptions.size) { product ->
                    AccountCardItem(
                        text = accountOptions[product].title,
                        subTitle = accountOptions[product].subTitle,
                        icon = accountOptions[product].icon,
                        onClick = { sendMoneyOption ->
                            when (sendMoneyOption) {
                                "R.string.payment_methods" ->{ }
                                "R.string.notification_preferences "-> { }
                                "R.string.account_setting" ->{ navigateToSettings() }
                            }
                        },
                        showDrawableColorTint = false
                    )

                }

            }

        }
    }
}

data class AccountItem(
    val title: String,
    val subTitle: String? = null,
    val icon: DrawableResource,
)

private val accountOptions = listOf(
    AccountItem(
        title =  "R.string.payment_methods",
        icon = Res.drawable.insights_icon,
        subTitle = "R.string.manage_options"
    ),
    AccountItem(
        title = "R.string.notification_preferences",
        icon = Res.drawable.notifications,
        subTitle = "R.string.manage_your_notification"
    ),
    AccountItem(
        title = "R.string.account_setting",
        icon = Res.drawable.sim_card,
        subTitle = "R.string.account_settings_subtitle"
    ),
)


private val accountOptions2 = listOf(
    AccountItem(
        title =  "R.string.get_in_touch",
        icon = Res.drawable.insights_icon,
        subTitle = "R.string.get_in_touch_subtile"
    ),
    AccountItem(
        title = "R.string.notification_updates",
        icon = Res.drawable.notifications,
        subTitle = "R.string.manage_your_notification"
    ),
    AccountItem(
        title = "R.string.about_sacco_title",
        icon = Res.drawable.sim_card,
        subTitle = "R.string.terms_and_conditions"
    ),
    AccountItem(
        title = "R.string.privacy",
        icon = Res.drawable.sim_card,
        subTitle = "R.string.privacy_subtitle"
    )
)

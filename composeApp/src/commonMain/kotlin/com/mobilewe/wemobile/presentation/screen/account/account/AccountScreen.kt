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
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.mobilewe.wemobile.presentation.screen.auth.welcome.component.Feature
import com.mobilewe.wemobile.presentation.screen.auth.welcome.component.getFeatures
import com.mobilewe.wemobile.resources.Resources
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
    val features = accountOptions()
    val features2 = accountOptions2()
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
            Column {

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



                    items(features.size) { product ->
                        AccountCardItem(
                            text = accountOptions()[product].title,
                            subTitle = accountOptions()[product].subTitle,
                            icon = accountOptions()[product].icon,
                            onClick = { sendMoneyOption ->
                                when (sendMoneyOption) {
                                    "R.string.about_sacco_title"-> {
                                        navigateToNotification()
                                    }

                                    "R.string.about_sacco_title " -> {
                                        navigateToAboutSaccoRide()
                                    }

                                    " R.string.privacy" -> {}
                                    " R.string.get_in_touch" -> {}
                                }
                            },
                            showDrawableColorTint = false
                        )


                    }

                    item(span = { GridItemSpan(2) }) {
                        Text(text = "Account")
                    }

                    items(features2.size) { product ->
                        AccountCardItem(
                            text = accountOptions2()[product].title,
                            subTitle = accountOptions2()[product].subTitle,
                            icon = accountOptions2()[product].icon,
                            onClick = { sendMoneyOption ->
                                when (sendMoneyOption) {
                                    "Payment Methods" -> {}
                                    "R.string.notification_preferences " -> {}
                                    "R.string.account_setting" -> {
                                        navigateToSettings()
                                    }
                                }
                            },
                            showDrawableColorTint = false
                        )

                    }

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

@Composable
fun accountOptions2(): List<AccountItem> = listOf(
    AccountItem(
        title =  Resources.strings.schedulePayment,
        icon = Res.drawable.insights_icon,
        subTitle = Resources.strings.managePin
    ),
    AccountItem(
        title = Resources.strings.notification,
        icon = Res.drawable.notifications,
        subTitle = "R.string.manage_your_notification"
    ),
    AccountItem(
        title = "Account Settings",
        icon = Res.drawable.sim_card,
        subTitle = "Change your sign details"
    ),
)

@Composable
fun accountOptions(): List<AccountItem> = listOf(
    AccountItem(
        title =  Resources.strings.introFeatureTwoTitle,
        icon = Res.drawable.insights_icon,
        subTitle = "Email,call or find us on social media"
    ),
    AccountItem(
        title = Resources.strings.notification,
        icon = Res.drawable.notifications,
        subTitle = Resources.strings.notification
    ),
    AccountItem(
        title = Resources.strings.aboutSaccoRide,
        icon = Res.drawable.sim_card,
        subTitle = Resources.strings.termsAndConditions
    ),
    AccountItem(
        title = Resources.strings.privacyPolicy,
        icon = Res.drawable.sim_card,
        subTitle = Resources.strings.promptInfoSubtitle
    )
)


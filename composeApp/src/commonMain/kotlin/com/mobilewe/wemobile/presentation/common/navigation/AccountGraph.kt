package com.mobilewe.wemobile.presentation.common.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.mobilewe.wemobile.presentation.screen.account.account.AccountScreen
import kotlinx.serialization.Serializable

fun NavGraphBuilder.accountGraph(navController: NavHostController){
    navigation<RootGraph.AccountGraph>(startDestination = RootGraph.AccountMain){
        composable<RootGraph.AccountMain> {
            AccountScreen(
                onNavigateToStatement = {},
                navigateToManagePin = {},
                navigateBack = {},
                navigateToSettings = {},
                navigateToAboutSaccoRide = {},
                navigateToNotification = {  },
                navigateToManagePassword = {}
            )
        }
    }
}
sealed interface AccountDes {
    @Serializable
    data object AccountMain : DiscoverDes
}
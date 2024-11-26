package com.mobilewe.wemobile.app

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavBackStackEntry
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.mobilewe.wemobile.presentation.common.bottomNav.StandardScaffold
import com.mobilewe.wemobile.presentation.common.navigation.AppNavigation
import com.mobilewe.wemobile.presentation.common.navigation.Route
import com.mobilewe.wemobile.resources.WeSaccoMobileTheme
import com.mobilewe.wemobile.utils.getNavigationBarPadding
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.viewmodel.koinViewModel

@Composable
@Preview
fun App() {
    val navController = rememberNavController()
    val newBackStackEntry by navController.currentBackStackEntryAsState()
    val appScreenModel = koinViewModel<AppViewModel>()
    val userLanguage by appScreenModel.language.collectAsState()
    val firstTime by appScreenModel.isFirstTimeOpenApp.collectAsState()

    WeSaccoMobileTheme(
        languageCode = userLanguage
    ) {
        StandardScaffold(
            navController = navController,
            showBottomBar = true,
            modifier = Modifier.fillMaxSize(),
            onFabClick = {  },
            isLoggedIn = true,
        ) {
            AppNavigation(navController)
        }
    }
}


fun shouldShowBottomBar(backStackStackEntry: NavBackStackEntry?): Boolean {
    return backStackStackEntry?.destination?.route in listOf(
        Route.Home.toString(),
        Route.Transact.toString(),
        Route.Discover.toString(),
        Route.Account.toString()
    )
}
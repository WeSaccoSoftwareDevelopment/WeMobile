package com.mobilewe.wemobile.app

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeGesturesPadding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.mobilewe.wemobile.presentation.common.bottomNav.StandardScaffold
import com.mobilewe.wemobile.presentation.common.navigation.NavigationGraph
import com.mobilewe.wemobile.resources.WeSaccoMobileTheme
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.viewmodel.koinViewModel

@Composable
@Preview
fun App() {
    val navController = rememberNavController()
    val appScreenModel = koinViewModel<AppViewModel>()
    val userLanguage by appScreenModel.language.collectAsState()
    val firstTime by appScreenModel.isFirstTimeOpenApp.collectAsState()

    WeSaccoMobileTheme(
        languageCode = userLanguage
    ) {
        StandardScaffold(
            navController = navController,
            modifier = Modifier.fillMaxSize(),
            onFabClick = {  },
            isLoggedIn = true,
        ) {
            NavigationGraph(navController)
        }
    }
}

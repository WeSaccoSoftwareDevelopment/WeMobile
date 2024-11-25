package com.mobilewe.wemobile.presentation.screen.main

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.mobilewe.wemobile.presentation.common.navigation.AppNavigation
import com.mobilewe.wemobile.presentation.common.navigation.Route
import com.mobilewe.wemobile.presentation.common.bottomNav.StandardScaffold
import com.mobilewe.wemobile.utils.getNavigationBarPadding
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun MainScreen(navController: NavHostController) {
    val newBackStackEntry by navController.currentBackStackEntryAsState()
    val viewModel: MainViewModel = koinViewModel()

}


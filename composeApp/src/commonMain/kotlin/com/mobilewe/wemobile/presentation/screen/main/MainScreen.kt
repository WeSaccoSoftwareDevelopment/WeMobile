package com.mobilewe.wemobile.presentation.screen.main

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun MainScreen(navController: NavHostController) {
    val newBackStackEntry by navController.currentBackStackEntryAsState()
    val viewModel: MainViewModel = koinViewModel()

}


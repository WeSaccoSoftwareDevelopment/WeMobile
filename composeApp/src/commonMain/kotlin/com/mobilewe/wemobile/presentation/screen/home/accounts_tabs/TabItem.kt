package com.mobilewe.wemobile.presentation.screen.home.accounts_tabs

import androidx.compose.runtime.Composable
import androidx.navigation.NavController


typealias ComposableFun = @Composable () -> Unit
sealed class TabItem constructor(
    var title: String,
    var screen: ComposableFun,
) {
    data class MyAccount(
        val navController: NavController
    ) : TabItem("Accounts", screen = { AccountTypeScreen(navController = navController) })

    data class Loans(
        val navigator: NavController
    ) : TabItem("Loans", screen = { LoanLimitScreen(navController = navigator) }
    )
}
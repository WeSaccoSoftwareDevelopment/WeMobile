package com.mobilewe.wemobile.presentation.screen.home.accounts_tabs

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.mobilewe.wemobile.presentation.screen.home.composable.MyAccountsCard

@Composable
fun AccountTypeScreen(navController: NavController) {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        MyAccountsCard(navController)

    }
}
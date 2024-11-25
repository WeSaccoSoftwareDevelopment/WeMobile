package com.mobilewe.wemobile.presentation.screen.loans.loanStatement

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.mobilewe.wemobile.presentation.common.composables.appbar.AppToolbar
import com.mobilewe.wemobile.presentation.common.pieCharts.PieCharts


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoanMiniStatementScreen() {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            AppToolbar(
                title = "Loan MiniStatement",
                navigateBack = {},
                showBackArrow = true
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier.fillMaxSize().padding(paddingValues),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            PieCharts(
                data = mapOf(
                    Pair("Pay Bill", 79095),
                    Pair("Withdrawal", 51810-9999),
                )
            )

            PieCharts(
                data = mapOf(
                    Pair("Pay Bill", 176550),
                    Pair("Send Money", 58080),
                    Pair("M-Shwari", 51086),
                    Pair("Fuliza", 48732),
                    Pair("Withdrwal", 48661),
                )
            )
        }

    }

}
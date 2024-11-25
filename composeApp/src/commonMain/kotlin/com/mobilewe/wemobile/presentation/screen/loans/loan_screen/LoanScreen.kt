package com.mobilewe.wemobile.presentation.screen.loans.loan_screen


import androidx.compose.animation.rememberSplineBasedDecay
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mobilewe.wemobile.domain.model.Loan
import com.mobilewe.wemobile.presentation.screen.loans.components.LoanCard
import org.jetbrains.compose.resources.painterResource
import com.mobilewe.wemobile.presentation.screen.loans.payLoan.PayLoans
import com.mobilewe.wemobile.presentation.screen.loans.requestLoan.RequestLoans
import wemobile.composeapp.generated.resources.Res
import wemobile.composeapp.generated.resources.sacco_logo


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoanScreen(
    navigateToLoanMiniStatement:()->Unit = {}
) {
    var isPayLoanExpanded by remember { mutableStateOf(false) }
    var isRequestLoanExpanded by remember { mutableStateOf(false) }
    val topAppBarState = rememberTopAppBarState()
    val decayAnimationSpec = rememberSplineBasedDecay<Float>()
    val scrollBehavior =
        TopAppBarDefaults.exitUntilCollapsedScrollBehavior(topAppBarState)

    LaunchedEffect(isPayLoanExpanded) {
        if (isPayLoanExpanded) {
            isRequestLoanExpanded = false
        }
    }

    LaunchedEffect(isRequestLoanExpanded) {
        if (isRequestLoanExpanded) {
            isPayLoanExpanded = false
        }
    }
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Loans",
                        fontSize = 20.sp,
                        maxLines = 2,
                        modifier = Modifier.fillMaxWidth()
                    )
                },
                navigationIcon = {
                    IconButton(onClick = { }) {
                        Icon(
                            painter = painterResource(Res.drawable.sacco_logo),
                            contentDescription = "Localized description",
                            tint = MaterialTheme.colorScheme.onBackground
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.background,
                    scrolledContainerColor = MaterialTheme.colorScheme.background
                ),
                scrollBehavior = scrollBehavior
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            LoanCard(
                loan = Loan(
                    balance = 100000.0,
                    limit = 100000.0,
                    dueDate = "12 June,2023"
                )
            )
            PayLoans(
                expanded = isPayLoanExpanded,
                onExpandToggle = { isPayLoanExpanded = !isPayLoanExpanded },
                onAmountChanged = {},
                amount = "",
                isLoading = false,
                accountTypeName = ""
            )

            RequestLoans(
                expanded = isRequestLoanExpanded,
                onExpandToggle = { isRequestLoanExpanded = !isRequestLoanExpanded },
                onAmountChanged = {},
                amount = "",
                isLoading = false,
                accountTypeName = ""
            )

        }
    }

}



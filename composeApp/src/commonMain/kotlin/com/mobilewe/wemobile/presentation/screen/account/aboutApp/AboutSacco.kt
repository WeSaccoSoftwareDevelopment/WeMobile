package com.mobilewe.wemobile.presentation.screen.account.aboutApp


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mobilewe.wemobile.presentation.common.composables.appbar.AppToolbar
import com.mobilewe.wemobile.presentation.common.theme.WeThemes


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AboutWeSaccoScreen(
    navigateBack: ()-> Unit
) {
    Scaffold(
        topBar = {
            AppToolbar(
                title = "stringResource(R.string.about_saccoride)",
                showBackArrow = true,
                navigateBack = navigateBack
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp)
                .verticalScroll(rememberScrollState())
                .padding(paddingValues)
        ) {
            Text(
                text = "WeSacco",
                modifier = Modifier.padding(bottom = 16.dp),
                fontWeight = FontWeight.Bold,
                style = WeThemes.typography.titleMedium
            )
            Text(
                text = "stringResource(R.string.about_sacco_ride)",
                modifier = Modifier.padding(bottom = 16.dp),
                fontWeight = FontWeight.Thin,
                style = WeThemes.typography.titleSmall

            )
            TermsAndConditions()
            ServiceCharter()

        }
    }
}

@Composable
fun TermsAndConditions() {
    Text(
        text = "stringResource(R.string.terms_and_conditions)",
        modifier = Modifier.padding(bottom = 8.dp),
        fontWeight = FontWeight.Bold

    )
    Text(
        text = "stringResource(R.string.sacco_term_and_condition)",
        modifier = Modifier.padding(bottom = 16.dp),
        fontSize = 12.sp,
        fontWeight = FontWeight.Thin,
    )
}

@Composable
fun ServiceCharter() {
    Text(
        text = "stringResource(R.string.service_charter)",
        modifier = Modifier.padding(bottom = 8.dp),
        fontWeight = FontWeight.Bold
    )
    Text(
        text = "stringResource(R.string.sacco_service_charter)",
        modifier = Modifier.padding(bottom = 16.dp),
        fontSize = 12.sp,
        fontWeight = FontWeight.Thin,
    )
}


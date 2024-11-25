package com.mobilewe.wemobile.presentation.screen.account.privacyPolicy

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun PrivacyPolicyScreen() {
    Scaffold(
        topBar = {

        }
    ) {  paddingValues ->
        Column(
            modifier = Modifier.padding(paddingValues)
                .padding(all = 16.dp)
        ) {
            Text(
                text = "Privacy Policy",
                modifier = Modifier.padding(bottom = 8.dp),
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "stringResource(R.string.sacco_privacy_policy)",
                modifier = Modifier.padding(bottom = 16.dp),
                fontSize = 12.sp,
                fontWeight = FontWeight.Thin,
            )
        }

    }

}

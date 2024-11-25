package com.mobilewe.wemobile.presentation.screen.auth.welcome

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.mobilewe.wemobile.presentation.common.composables.button.ContinueButton
import com.mobilewe.wemobile.presentation.screen.auth.welcome.component.FeatureCard
import com.mobilewe.wemobile.presentation.screen.auth.welcome.component.WelcomeHeader
import com.mobilewe.wemobile.presentation.screen.auth.welcome.component.getFeatures
import com.mobilewe.wemobile.resources.Resources


@Composable
fun WelcomeScreen(
    onLogin: () -> Unit,
) {
    val features = getFeatures()
    Scaffold(
        content = { innerPadding ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 16.dp, vertical = 10.dp)
                    .padding(innerPadding)
                    .verticalScroll(rememberScrollState(), true)
            ) {

                WelcomeHeader(
                    title = "stringResource(R.string.welcome_title_one)",
                    desc = "stringResource(R.string.welcome_sub_one)"
                )

                Spacer(modifier = Modifier.height(16.dp))

                features.forEach {
                    FeatureCard(it)
                }
            }
        },
        bottomBar = {
            ContinueButton(
                onClick = onLogin,
                text = Resources.strings.login
            )
        }
    )

}
package com.mobilewe.wemobile.presentation.screen.auth.verification


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.mobilewe.wemobile.presentation.common.composables.HeadFirstCard
import com.mobilewe.wemobile.presentation.common.composables.appbar.AppToolbar
import com.mobilewe.wemobile.presentation.common.composables.button.ContinueButton
import com.mobilewe.wemobile.presentation.common.composables.button.WeSaccoOutlinedButton


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChooseVerificationScreen(
    navigator: NavController
) {
    var selectedOption by remember { mutableStateOf<VerificationOption?>(null) }

    HeadFirstCard(
        textHeader = "stringResource(id = R.string.verify_header)",
        textSubHeader = "stringResource(id = R.string.select_hint)",
        topAppBar = {
            AppToolbar(
                showBackArrow = true,
                title = "Verify",
            )
        },
        bottomBar = {
            Column(
                modifier = Modifier.fillMaxWidth().padding(24.dp).navigationBarsPadding(),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                WeSaccoOutlinedButton(
                    onClick = { },
                    text = "I've changed my contact details",
                    enable = true
                )
                selectedOption?.let {
                    ContinueButton(
                        onClick = {  },
                        text = "Confirm",
                        enable = it.equals(true)
                    )
                }
            }
        }
    ) {
        verificationOptions.forEach { option ->
            VerificationOptionItemList(
                icon = option.icon,
                title = option.title,
                descriptionValue = option.description,
                selected = selectedOption == option // Check if this option is selected
            ) {
                selectedOption = option // Set the selected option when clicked
            }
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}

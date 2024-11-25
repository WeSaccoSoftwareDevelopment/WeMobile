package com.mobilewe.wemobile.presentation.screen.auth.welcome.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.mobilewe.wemobile.presentation.common.theme.WeThemes


@Composable
fun WelcomeHeader(title: String, desc: String) {
    Column {
        Text(
            text = title,
            style = WeThemes.typography.titleMedium,
            modifier = Modifier.testTag("welcome_header_title")
        )

        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = desc,
            fontWeight = FontWeight.Normal,
            style = WeThemes.typography.bodySmall,
            modifier = Modifier.testTag("welcome_header_description"),
        )
    }
}
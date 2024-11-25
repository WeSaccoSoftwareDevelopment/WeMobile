package com.mobilewe.wemobile.presentation.common.composables.button

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.mobilewe.wemobile.presentation.common.theme.WeThemes


@Composable
fun SubmitButton(
    onClickAction: () -> Unit = {}
) {
    val submitButtonColor = ButtonDefaults.buttonColors(
        containerColor = MaterialTheme.colorScheme.onBackground,
        contentColor = MaterialTheme.colorScheme.onPrimary
    )
    Button(
        onClick = onClickAction,
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        colors = submitButtonColor
    ) {
        Text(
            text = "Submit",
            modifier = Modifier.padding(5.dp),
            style = WeThemes.typography.labelSmall

        )
    }
}


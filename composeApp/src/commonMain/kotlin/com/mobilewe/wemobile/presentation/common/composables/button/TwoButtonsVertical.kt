package com.mobilewe.wemobile.presentation.common.composables.button

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.mobilewe.wemobile.presentation.common.composables.divider.WeSaccoDivider
import com.mobilewe.wemobile.presentation.common.theme.WeThemes


@Composable
fun TwoButtonsVertical(
    outlinedText: String,
    buttonText: String,
    onOutlinedButtonClick:() -> Unit,
    onButtonClick:() -> Unit,
    modifier: Modifier = Modifier,
    enabletButton: Boolean = false,
    enableOutlinedButton: Boolean = false,
    showDivider: Boolean = true
) {
    Column(modifier = modifier) {
        if (showDivider){
            WeSaccoDivider(modifier = Modifier.fillMaxWidth())
        }
        Spacer(modifier = Modifier.height(8.dp))
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(10.dp),
            modifier = Modifier.fillMaxWidth()
                .padding(
                    start = 16.dp,
                    end = 16.dp,
                    top = 16.dp,
                    bottom = 12.dp
                )
        ) {
            OutlinedButton(
                onClick = { onOutlinedButtonClick() },
                modifier = Modifier.fillMaxWidth().height(50.dp),
                border = BorderStroke(1.dp, MaterialTheme.colorScheme.primary),
                colors = ButtonDefaults.outlinedButtonColors(containerColor = Color.Transparent)

            ) {
                Text(
                    text = outlinedText,
                    style = WeThemes.typography.titleSmall,
                    color = MaterialTheme.colorScheme.onBackground
                )
            }


            Button(
                onClick = onButtonClick,
                modifier = Modifier.fillMaxWidth().height(50.dp),
                colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primary),
                enabled = enabletButton,
            ) {
                Text(
                    text = buttonText,
                    style = WeThemes.typography.titleSmall,
                    color = MaterialTheme.colorScheme.onBackground,
                )
            }
        }
    }
}
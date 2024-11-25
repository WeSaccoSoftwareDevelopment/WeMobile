package com.mobilewe.wemobile.presentation.common.composables.button

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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
import com.mobilewe.wemobile.presentation.common.theme.WeThemes
import com.mobilewe.wemobile.presentation.common.composables.divider.WeSaccoDivider


@Composable
fun TwoButtons(
    leftButtonText: String,
    rightButtonText: String,
    onLeftButtonClick:() -> Unit,
    onRightButtonClick:() -> Unit,
    modifier: Modifier = Modifier,
    enableRightButton: Boolean = false,
    enableLeftButton: Boolean = false
) {
    Column(modifier = modifier) {
        WeSaccoDivider(modifier = Modifier.fillMaxWidth())
        Spacer(modifier = Modifier.height(12.dp))
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    start = 16.dp,
                    end = 16.dp,
                    top = 16.dp,
                    bottom = 20.dp
                )
        ) {
            OutlinedButton(
                onClick = { onLeftButtonClick() },
                modifier = Modifier
                    .weight(1f)
                    .height(50.dp),
                border = BorderStroke(1.dp, MaterialTheme.colorScheme.primary),
                colors = ButtonDefaults.outlinedButtonColors(
                    containerColor = Color.Transparent
                )

            ) {
                Text(
                    text = leftButtonText,
                    style = WeThemes.typography.titleSmall,
                    color = MaterialTheme.colorScheme.onSecondary
                )
            }


            Button(
                onClick = {
                       onRightButtonClick()
                },
                modifier = Modifier
                    .weight(1f)
                    .height(50.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.primary
                ),
                enabled = enableRightButton,
            ) {
                Text(
                    text = rightButtonText,
                    style = WeThemes.typography.titleSmall,
                    color = MaterialTheme.colorScheme.onBackground,
                )
            }
        }
    }
}
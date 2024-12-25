package com.mobilewe.wemobile.presentation.common.composables.button

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.mobilewe.wemobile.presentation.common.theme.ButtonDefaultColors
import com.mobilewe.wemobile.presentation.common.theme.WeThemes
import com.mobilewe.wemobile.presentation.common.composables.divider.WeSaccoDivider


@Composable
fun ContinueButton(
    text: String,
    modifier: Modifier = Modifier,
    onClick: (() -> Unit),
    enable: Boolean =  true,
    showDivider: Boolean = false
) {
    Column(modifier = modifier) {
        if (showDivider){
            WeSaccoDivider()
            Spacer(modifier = Modifier.height(8.dp))
        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    start = 12.dp,
                    end = 12.dp,
                    top = 16.dp,
                    bottom = 12.dp
                )
        ){
            Button(
                onClick = onClick,
                modifier = modifier
                    .fillMaxWidth()
                    .height(50.dp),
                colors = ButtonDefaults.buttonColors(
                    contentColor = Color.White,
                    containerColor = if (enable) MaterialTheme.colorScheme.primary else ButtonDefaultColors,
                ),
                enabled = enable,
            ) {
                Text(
                    modifier = modifier.padding(5.dp),
                    text = text,
                    style = WeThemes.typography.labelSmall

                )
            }
        }

    }

}

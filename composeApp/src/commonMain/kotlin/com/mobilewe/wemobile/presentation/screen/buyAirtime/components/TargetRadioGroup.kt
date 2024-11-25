package com.mobilewe.wemobile.presentation.screen.buyAirtime.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.mobilewe.wemobile.presentation.common.theme.PrimaryColor


@Composable
fun TargetRadioGroup(
    targetRadio: String,
    onTargetRadioChange: (String) -> Unit
) {
    Column(
        modifier = Modifier.fillMaxWidth()
            .padding(bottom = 8.dp, top = 12.dp),
    ) {
        Text(text = "Buy Airtime For:")
        Row(verticalAlignment = Alignment.CenterVertically) {
            RadioButton(
                selected = targetRadio == "myself",
                onClick = { onTargetRadioChange("myself") },
                colors = RadioButtonDefaults.colors(selectedColor = PrimaryColor)
            )
            Text(
                text = "Myself",
                modifier = Modifier.clickable { onTargetRadioChange("myself") }
            )
            RadioButton(
                selected = targetRadio == "someone_else",
                onClick = { onTargetRadioChange("someone_else") },
                colors = RadioButtonDefaults.colors(selectedColor = PrimaryColor)
            )
            Text(
                text = "Someone Else",
                modifier = Modifier.clickable { onTargetRadioChange("someone_else") }
            )
        }
    }
}
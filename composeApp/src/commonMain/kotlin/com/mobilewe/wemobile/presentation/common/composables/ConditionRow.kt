package com.mobilewe.wemobile.presentation.common.composables

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Circle
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun ConditionRow(
    condition: String,
    check: Boolean
) {
    val color by animateColorAsState(
        targetValue = if (check) Color.Green else MaterialTheme.colorScheme.onBackground,
        label = "text color"
    )

    val icon = if (check) {
        Icons.Default.Check
    } else {
       Icons.Default.Circle
    }

    Row (
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth().padding(5.dp)
    ){
        Icon(
            imageVector = icon,
            tint = color,
            contentDescription = "status icon",
            modifier = Modifier.size(24.dp)
        )

        Spacer(modifier = Modifier.width(10.dp))
        Text(
            text = condition,
            color = color,
            fontSize = 12.sp
        )
    }
}
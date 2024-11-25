package com.mobilewe.wemobile.presentation.common.pieCharts

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.mobilewe.wemobile.presentation.common.theme.WeThemes


@Composable
fun DetailPieChartItem(
    data: Pair<String, Int>,
    color: Color,
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier.fillMaxWidth()
            .padding(top = 5.dp, bottom = 5.dp)
    ) {
        Text(
            text = data.first,
            textAlign = TextAlign.Start,
            overflow = TextOverflow.Ellipsis,
            style = WeThemes.typography.labelSmall
        )
        val datasecond = data.second.toDouble()
        Text(
            text = datasecond.toString(),
            textAlign = TextAlign.End,
            overflow = TextOverflow.Ellipsis,
            style = WeThemes.typography.labelSmall
        )

    }
}
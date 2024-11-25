package com.mobilewe.wemobile.presentation.common.pieCharts

import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color


@Composable
fun DetailsPieCharts(
    data: Map<String, Int>,
    colors: List<Color>,
    totalSum: Int
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        // create the data items
        data.values.forEachIndexed { index, value ->
            DetailsPieChartItems(
                data = Pair(data.keys.elementAt(index), value),
                color = colors[index],
                totalSum = totalSum
            )
        }

    }
}
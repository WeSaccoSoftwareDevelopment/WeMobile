package com.mobilewe.wemobile.presentation.common.composables

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.TabRowDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
@Composable
fun CategoryTabs(
    categories: Set<String>,
    selectedCategory: String?,
    onCategorySelected: (String) -> Unit
) {
    val categoriesList = listOf("All") + categories.toList()
    ScrollableTabRow(
        selectedTabIndex = categoriesList.indexOf(selectedCategory),
        containerColor = MaterialTheme.colorScheme.background,
        contentColor = MaterialTheme.colorScheme.onBackground,
        edgePadding = 0.dp,
        indicator = { tabPositions ->
            TabRowDefaults.Indicator(
                modifier = Modifier.tabIndicatorOffset(tabPositions[categoriesList.indexOf(selectedCategory)]),
                color = Color.Transparent
            )
        },
        divider = {
            HorizontalDivider(color = Color.Transparent)
        },
    ) {
        categoriesList.forEachIndexed { index, category ->
            Tab(
                selected = selectedCategory == category,
                onClick = { onCategorySelected(category) },
                modifier = Modifier.padding(horizontal = 5.dp),
            ) {
                OutlinedButton(
                    onClick = { onCategorySelected(category) },
                    shape = RoundedCornerShape(8.dp),
                    border = BorderStroke(
                        1.dp, color = if (selectedCategory == category) MaterialTheme.colorScheme.primary else Color.Gray
                    )
                ) {
                    Text(
                        text = category,
                        fontSize = 12.sp,
                        color = if (selectedCategory == category) MaterialTheme.colorScheme.primary else Color.Gray,
                    )
                }
            }
        }
    }
}

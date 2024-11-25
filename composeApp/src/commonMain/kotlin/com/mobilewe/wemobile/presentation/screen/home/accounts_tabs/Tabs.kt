package com.mobilewe.wemobile.presentation.screen.home.accounts_tabs

import androidx.compose.foundation.pager.PagerState
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TabRowDefaults.SecondaryIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.unit.dp
import com.mobilewe.wemobile.presentation.common.theme.PrimaryColor
import kotlinx.coroutines.launch


@Composable
fun Tabs(tabs: List<TabItem>, pagerState: PagerState) {
    val coroutineScope = rememberCoroutineScope()

    TabRow(
        selectedTabIndex = pagerState.currentPage,
        backgroundColor = MaterialTheme.colorScheme.background,
        divider = {
            Divider(
                thickness = 0.5.dp,
            )
        },
        indicator = { tabPositions ->
            SecondaryIndicator(
                height = 2.dp,
                color = MaterialTheme.colorScheme.primary
            )
        },
    ) {
        tabs.forEachIndexed { index, item ->
            Tab(
                selected = pagerState.currentPage == index,
                onClick = {
                    coroutineScope.launch { pagerState.scrollToPage(index) }
                },
                text = {
                    Text(
                        text = item.title,
                        color = if (pagerState.currentPage == index) MaterialTheme.colorScheme.primary
                        else MaterialTheme.colorScheme.onBackground
                    )
                },
                selectedContentColor = PrimaryColor,
                unselectedContentColor = MaterialTheme.colorScheme.onBackground
            )
        }
    }
}
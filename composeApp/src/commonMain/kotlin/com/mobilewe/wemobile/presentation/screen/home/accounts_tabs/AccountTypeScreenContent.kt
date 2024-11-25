package com.mobilewe.wemobile.presentation.screen.home.accounts_tabs

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController


@Composable
fun AccountTypeScreenContent(
    navController: NavController,
    modifier: Modifier = Modifier,
) {
    val listOfTabs = listOf(
        TabItem.MyAccount(navController),
        TabItem.Loans(navController)
    )
    val pagerState = rememberPagerState(initialPage = 0, pageCount = {2})

    Column(modifier = modifier) {
        Tabs(
            tabs = listOfTabs,
            pagerState = pagerState,
        )
        Spacer(modifier = Modifier.height(24.dp))
        TabContent(
            tabs = listOfTabs,
            pagerState = pagerState,
        )
    }
}

@Composable
fun TabContent(tabs: List<TabItem>, pagerState: PagerState) {
    HorizontalPager(
        state = pagerState,
        modifier = Modifier,
        userScrollEnabled = true
    ) { page ->
        tabs[page].screen()
    }
}

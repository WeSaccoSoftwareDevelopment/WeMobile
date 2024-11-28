package com.mobilewe.wemobile.presentation.screen.payWithSacco.payWithSacco

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.mobilewe.wemobile.presentation.common.composables.SpAnimatedTabLayout
import com.mobilewe.wemobile.presentation.common.composables.appbar.AppToolbar
import com.mobilewe.wemobile.presentation.screen.payWithSacco.buyGoods.BuyGoodsScreen
import com.mobilewe.wemobile.resources.Resources
import com.mobilewe.wemobile.presentation.screen.payWithSacco.payWithSacco.composable.TabItem
import com.mobilewe.wemobile.presentation.screen.payWithSacco.payWithSacco.composable.Tabs
import com.mobilewe.wemobile.presentation.screen.payWithSacco.paybill.PayBillScreen
import com.mobilewe.wemobile.presentation.screen.payWithSacco.wesacco.WesaccoPayBillScreen
import org.koin.compose.viewmodel.koinViewModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PayWithSaccoScreen(
    navController: NavController,
    viewModel: PayWithSaccoViewModel = koinViewModel()
) {

    val orderTabs = PayWithSaccoUiState.PayWithSacco.entries
    var selectedTab by remember { mutableStateOf(PayWithSaccoUiState.PayWithSacco.BUYGOODS) }


    Scaffold(
        topBar = {
            AppToolbar(
                title = "LipaNaSacco",
                showBackArrow = true,
                navigateBack = { navController.popBackStack() }
            )
        },
    ) { padding ->
        Box(modifier = Modifier.padding(padding)) {
            SpAnimatedTabLayout(
                tabItems = PayWithSaccoUiState.PayWithSacco.entries,
                modifier = Modifier.fillMaxWidth(),
            ) { type ->
                when (type) {
                    PayWithSaccoUiState.PayWithSacco.BUYGOODS -> {
                        BuyGoodsScreen(navController)
                    }

                    PayWithSaccoUiState.PayWithSacco.PAYBILL -> {
                        PayBillScreen(navController)
                    }

                    PayWithSaccoUiState.PayWithSacco.WESSACCO -> {
                        WesaccoPayBillScreen(navController)
                    }

                }
            }
        }
    }
}


@Composable
fun MainContent(
    navController: NavController,
    modifier: Modifier = Modifier,
) {
    val listOfTabs = listOf(
        TabItem.BuyGoods(
            title = Resources.strings.buyGoodsTitle,
            navController = navController
        ),
        TabItem.PayBill(
            title = Resources.strings.payBillTitle,
            navController = navController
        )
    )

    val pagerState = rememberPagerState(initialPage = 0, pageCount = { 2 })

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




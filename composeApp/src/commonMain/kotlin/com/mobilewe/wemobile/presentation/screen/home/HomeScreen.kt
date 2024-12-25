package com.mobilewe.wemobile.presentation.screen.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.mobilewe.wemobile.presentation.screen.home.accounts_tabs.AccountTypeScreenContent
import com.mobilewe.wemobile.presentation.screen.home.composable.HomeScreenHeader
import com.mobilewe.wemobile.presentation.screen.home.composable.HomeServiceCardItem
import com.mobilewe.wemobile.presentation.screen.home.composable.HomeTopBar
import com.mobilewe.wemobile.presentation.screen.home.composable.PromotionCardItem
import com.mobilewe.wemobile.presentation.screen.home.composable.PromotionSeeAll
import com.mobilewe.wemobile.presentation.screen.home.composable.ProvidersMoney
import com.mobilewe.wemobile.presentation.screen.home.composable.ReusableModalSheet
import com.mobilewe.wemobile.presentation.screen.home.model.getBuyAirtimeOptions
import com.mobilewe.wemobile.presentation.screen.home.model.getHomeItems
import com.mobilewe.wemobile.presentation.screen.home.model.getPayBillMerchants
import com.mobilewe.wemobile.presentation.screen.home.model.getPaySomeone
import com.mobilewe.wemobile.resources.Resources
import org.jetbrains.compose.resources.stringResource
import org.koin.compose.viewmodel.koinViewModel
import wemobile.composeapp.generated.resources.Res
import wemobile.composeapp.generated.resources.general


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    navController: NavController,
) {
    val homeViewModel: HomeViewModel = koinViewModel()
    val homeUiState by homeViewModel.homeUiState.collectAsStateWithLifecycle()
    val sheetState = rememberModalBottomSheetState()
    var modalState by rememberSaveable { mutableStateOf(ModalSheetState.None) }
    val paySomeone = Resources.strings.paySomeone
    val requestMoney = Resources.strings.requestMoney
    val buyAirtime = Resources.strings.buyAirtime
    val payBillsGoods = Resources.strings.payBillAndBuyGoods

    val homeItems = getHomeItems()
    val payBillMerchants = getPayBillMerchants(navController)
    val buyAirtimeOptions = getBuyAirtimeOptions(navController)
    val paymentOption = getPaySomeone(navController)

    HomeScreenHeader(
        topBar = { HomeTopBar(greetings = stringResource(Res.string.general)) }
    ) {
        AccountTypeScreenContent(
            navController = navController
        )

        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            verticalArrangement = Arrangement.spacedBy(12.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            items(homeItems.size) { product ->
                HomeServiceCardItem(
                    title = homeItems[product].title,
                    icon = homeItems[product].icon,
                    description = homeItems[product].description,
                    onClick = { sendMoneyOption ->
                        when (sendMoneyOption) {
                            paySomeone -> modalState = ModalSheetState.SendMoney
                            requestMoney -> modalState = ModalSheetState.SendMoney
                            buyAirtime -> modalState = ModalSheetState.BuyAirtime
                            payBillsGoods -> modalState = ModalSheetState.PayMerchant
                        }
                    },
                )

            }

            item(span = { GridItemSpan(2) }) {
                PromotionSeeAll(
                    onClickSeeAllPromotion = { }
                )
            }

            item(span = { GridItemSpan(2) }) {
                LazyRow(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(12.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    items(5) {
                        PromotionCardItem()
                    }
                }
            }

        }

        val (isOpen, items) = when (modalState) {
            ModalSheetState.SendMoney -> true to paymentOption
            ModalSheetState.PayMerchant -> true to payBillMerchants
            ModalSheetState.BuyAirtime -> true to buyAirtimeOptions
            ModalSheetState.None -> false to emptyList()
        }

        ReusableModalSheet(
            isOpen = isOpen,
            onDismissRequest = { modalState = ModalSheetState.None },
            sheetState = sheetState,
            items = items
        ) { selectedProvider ->
            ProvidersMoney(
                sendProvider = selectedProvider,
                onProviderSelected = {
                    selectedProvider.onNavigate()
                    modalState = ModalSheetState.None
                },
            )
        }
    }
}




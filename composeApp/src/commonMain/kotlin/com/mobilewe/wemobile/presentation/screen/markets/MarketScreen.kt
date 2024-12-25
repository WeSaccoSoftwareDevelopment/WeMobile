package com.mobilewe.wemobile.presentation.screen.markets

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.mobilewe.wemobile.presentation.common.composables.appbar.AppToolbar
import com.mobilewe.wemobile.presentation.screen.home.composable.HomeScreenHeader
import com.mobilewe.wemobile.presentation.screen.markets.composable.AnimatedCardPager
import com.mobilewe.wemobile.presentation.screen.markets.composable.MarketTypeCard
import com.mobilewe.wemobile.presentation.screen.markets.composable.getCardImages
import com.mobilewe.wemobile.presentation.screen.markets.composable.marketTypeOption


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MarketScreen(
    navigateBack: () -> Unit = {}
) {
    val cardsItems = getCardImages()
    val marketTypeOptions = marketTypeOption()
    HomeScreenHeader(
        topBar = {
            AppToolbar(
                title = "Market",
                showBackArrow = true
            )
        },
    ) {

        LazyVerticalGrid(
            columns = GridCells.Adaptive(170.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            item(span = { GridItemSpan(this.maxCurrentLineSpan) }) {
                Spacer(modifier = Modifier.height(16.dp))
            }
            items(marketTypeOptions.size) { index ->
                MarketTypeCard(
                    title = marketTypeOption()[index].title,
                    subTitle = marketTypeOption()[index].subTitle,
                    imageResourceId = marketTypeOption()[index].imageResourceId,
                    containerColor = marketTypeOption()[index].containerColor,
                    onClick = { marketTypeOption ->
                        when (marketTypeOption) {
//                                 R.string.privacy ->{}
                        }
                    },
                )
            }

            item(span = { GridItemSpan(this.maxCurrentLineSpan) }) {
                Spacer(modifier = Modifier.height(16.dp))
            }

            item(span = { GridItemSpan(this.maxCurrentLineSpan) }) {
                AnimatedCardPager(cards = cardsItems)
            }

        }

    }
}



package com.mobilewe.wemobile.presentation.screen.markets.composable

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay
import org.jetbrains.compose.resources.painterResource

@Composable
fun AnimatedCardPagerIndicator(cards: List<CardItem>) {
    val pagerState = rememberPagerState(initialPage = 0, pageCount = {3})
    val cardCount = getCardImages()
    LaunchedEffect(Unit) {
        while (true) {
            delay(2000)
            val nextPage = (pagerState.currentPage + 1) % cards.size
            pagerState.animateScrollToPage(nextPage)
        }
    }

    Column(modifier = Modifier.fillMaxWidth()) {
        HorizontalPager(
            state = pagerState,
            modifier = Modifier.weight(1f)
        ) { page ->
            AnimatedCardItemIndicator(cards[page])
        }

//        HorizontalPagerIndicator(
//            pagerState = pagerState,
//            modifier = Modifier
//                .padding(8.dp)
//                .align(Alignment.CenterHorizontally)
//        )
    }
}

@Composable
fun AnimatedCardItemIndicator(card: CardItem) {
    var isVisible by remember { mutableStateOf(false) }
    val transition = updateTransition(targetState = isVisible, label = "cardTransition")
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(180.dp)
            .animateContentSize()
            .clickable { isVisible = !isVisible }
    ) {
        Icon(
            painter = painterResource(card.image),
            contentDescription = null,
            modifier = Modifier.fillMaxSize()
                .padding(5.dp)
        )
    }

    LaunchedEffect(key1 = card) {
        isVisible = true
    }
}


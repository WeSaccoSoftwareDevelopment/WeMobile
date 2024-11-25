package com.mobilewe.wemobile.presentation.screen.markets.composable

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource
import wemobile.composeapp.generated.resources.Res
import wemobile.composeapp.generated.resources.*

@Composable
fun AnimatedCardPager(cards: List<CardItem>) {
    val pagerState = rememberPagerState(initialPage = 0, pageCount = {3})
    val cardCount = getCardImages()
    LaunchedEffect(Unit) {
        while (true) {
            delay(2000)
            val nextPage = (pagerState.currentPage + 1) % cards.size
            pagerState.animateScrollToPage(nextPage)
        }
    }
    HorizontalPager(
        state = pagerState,
        userScrollEnabled = true
    ) { page ->
        AnimatedCardItem(cards[page])

    }

}

@Composable
fun AnimatedCardItem(card: CardItem) {
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
            modifier = Modifier
                .fillMaxSize()
                .padding(5.dp)
        )
    }

    LaunchedEffect(key1 = card) {
        isVisible = true
    }
}

fun getCardImages(): List<CardItem> = listOf(
    CardItem(
        Res.drawable.sako_icon,
    ),
    CardItem(
        Res.drawable.ryde,
    ),
    CardItem(
        Res.drawable.sako_ride_icons,
    ),
    CardItem(
        Res.drawable.sako_icon,
    ),
    CardItem(Res.drawable.ryde)
)

data class CardItem(
    val image: DrawableResource
)

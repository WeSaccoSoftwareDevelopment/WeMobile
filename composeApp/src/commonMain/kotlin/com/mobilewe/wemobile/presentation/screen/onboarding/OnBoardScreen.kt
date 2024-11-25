package com.mobilewe.wemobile.presentation.screen.onboarding


import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.pulltorefresh.PullToRefreshDefaults.indicatorColor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.mobilewe.wemobile.presentation.common.composables.ImageSliderIndicator
import com.mobilewe.wemobile.presentation.common.theme.WeThemes
import com.mobilewe.wemobile.presentation.screen.onboarding.component.OnBoardingPage
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.koin.compose.viewmodel.koinViewModel


@Composable
fun OnBoardingMainScreen(
    navigator: NavController
) {
    OnBoardScreen(
        onClickAction = { /*TODO*/ }
    )
}
@OptIn(ExperimentalAnimationApi::class, ExperimentalMaterial3Api::class)
@Composable
fun OnBoardScreen(
    navigateBack:() -> Unit = {},
    onClickAction: () -> Unit,
    welcomeViewModel: OnBoardViewModel = koinViewModel()
) {
    val pages = listOf(
        OnBoardingPage.First,
        OnBoardingPage.Second,
        OnBoardingPage.Third
    )
    val pagerState = rememberPagerState(initialPage = 0, pageCount = { 2 })
    val coroutineScope = rememberCoroutineScope()
    val isOnBoardingCompleted by welcomeViewModel.isOnBoardingCompleted().collectAsState(false)

    val autoScrollEnabled = !isOnBoardingCompleted
    val autoScrollInterval = 5000L // Time in milliseconds between auto-scrolls

    LaunchedEffect(autoScrollEnabled) {
        if (autoScrollEnabled) {
            while (true) {
                delay(autoScrollInterval)
                coroutineScope.launch {
                    val nextPage = (pagerState.currentPage + 1) % pages.size
                    pagerState.animateScrollToPage(page = nextPage)
                }
            }
        }
    }

    val buttonState  = remember{
        derivedStateOf {
            when(pagerState.currentPage){
                0 -> listOf("","Next")
                1 -> listOf("","Next")
                2 -> listOf("","Get Started")
                else -> listOf("","")
            }
        }
    }

    Column(
        modifier = Modifier.fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        HorizontalPager(
            modifier = Modifier.weight(10f),
            state = pagerState,
            verticalAlignment = Alignment.Top
        ) { position ->
            PagerScreen(onBoardingPage = pages[position])
        }
        Box {
            ImageSliderIndicator(
                itemCount = 3,
                pagerState = pagerState,
                indicatorColor = indicatorColor,
                indicatorAlignment = Alignment.Center
            )
            ImageSliderIndicator(
                itemCount = 3,
                pagerState = pagerState,
                indicatorAlignment = Alignment.BottomStart
            )
        }

//        HorizontalPagerIndicator(
//            modifier = Modifier
//                .align(Alignment.CenterHorizontally)
//                .weight(1f),
//            pagerState = pagerState,
//            activeColor = PrimaryColor
//        )

        Row (
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ){
            if (buttonState.value[0].isNotEmpty()){
                OnBoardingButton(
                    text = buttonState.value[0],
                    onClick = {
                        coroutineScope.launch {
                            pagerState.animateScrollToPage(page = pagerState.currentPage-1)
                        }
                    }
                )

            }

            OnBoardingButton(
                text =  buttonState.value[1],
                onClick = {
                    coroutineScope.launch {
                        if (pagerState.currentPage == 2){
                            welcomeViewModel.isOnBoardingCompleted()
                            welcomeViewModel.saveOnBoardingState(completed = true)
                            navigateBack()
                            onClickAction()

                        } else{
                            pagerState.animateScrollToPage(page = pagerState.currentPage+1)
                        }
                    }
                }
            )

        }

    }
}

@Composable
fun PagerScreen(onBoardingPage: OnBoardingPage) {
    Column(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
//        LoaderIntro(
//            modifier = Modifier
//                .fillMaxWidth()
//                .fillMaxHeight(0.7f),
//            onBoardingPage.image
//        )
        Text(
            modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp),
            text = onBoardingPage.title.toString(),
            fontWeight = FontWeight.SemiBold,
            textAlign = TextAlign.Center,
            overflow = TextOverflow.Ellipsis,
            maxLines = 2,
            style = WeThemes.typography.titleLarge
        )
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
                .padding(top = 20.dp),
            text = onBoardingPage.description.toString(),
            textAlign = TextAlign.Center,
            overflow = TextOverflow.Ellipsis,
            style = WeThemes.typography.bodySmall
        )
    }
}


@Composable
fun OnBoardingButton(
    text: String,
    onClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center
    ){
        OutlinedButton(
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            onClick = onClick,
            colors = ButtonDefaults.buttonColors(
                contentColor = MaterialTheme.colorScheme.primary,
                containerColor = MaterialTheme.colorScheme.background
            ),
            border = BorderStroke(1.dp,MaterialTheme.colorScheme.primary),
            shape = RoundedCornerShape(8.dp)
        ) {
            Text(
                text = text,
                color = MaterialTheme.colorScheme.primary
            )
        }

    }

}
package com.mobilewe.wemobile.presentation.screen.account.help

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.EaseIn
import androidx.compose.animation.core.EaseInOut
import androidx.compose.animation.core.tween
import androidx.compose.animation.with
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TabRowDefaults.SecondaryIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.mobilewe.wemobile.presentation.common.composables.appbar.AppToolbar
import kotlinx.coroutines.launch


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HelpCenterScreen(
    navController: NavController
) {

    val tabs = listOf(
        HelpCentreTabItem.ContactCentre(navController),
        HelpCentreTabItem.FAQ(navController)

    )
    val pagerState = rememberPagerState(0, pageCount = {2})

    Scaffold(
        topBar = {
            AppToolbar(
                title = "stringResource(id = R.string.help_center)",
                showForwardArrow = false,
                showBackArrow = true,
                navigateBack = {
                    navController.popBackStack()
                }
            )
        },
    ) { padding ->
        Column(
            modifier = Modifier.padding(padding)
                .padding(horizontal = 16.dp)
        ) {
            Tabs(tabs = tabs, pagerState = pagerState)
            TabsContent(tabs = tabs, pagerState = pagerState)
        }
    }
}



@Composable
fun Tabs(tabs: List<HelpCentreTabItem>, pagerState: PagerState) {
    val coroutineScope = rememberCoroutineScope()

    androidx.compose.material.TabRow(
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
            androidx.compose.material.Tab(
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
                selectedContentColor = MaterialTheme.colorScheme.primary,
                unselectedContentColor = MaterialTheme.colorScheme.onBackground
            )
        }
    }
}

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun TabsContent(tabs: List<HelpCentreTabItem>, pagerState: PagerState) {
    AnimatedContent(
        targetState = pagerState, label = "",
        transitionSpec = {
            slideIntoContainer(
                animationSpec = tween(300, easing = EaseIn),
                towards = AnimatedContentTransitionScope.SlideDirection.Up
            ).with(
                slideOutOfContainer(
                    animationSpec = tween(300, easing = EaseInOut),
                    towards = AnimatedContentTransitionScope.SlideDirection.Down
                )
            )
        }
    ) { pagerStates ->
        HorizontalPager(state = pagerStates) { page ->
            tabs[page].screen()
        }
    }

}


typealias ComposableFun = @Composable () -> Unit

sealed class HelpCentreTabItem constructor(
    var title: String,
    var screen: ComposableFun,
) {

    data class ContactCentre(
        val navigator: NavController
    ) : HelpCentreTabItem("Contact Centre", screen = { SupportScreen(navigator) })

    data class FAQ(
        val navigator: NavController
    ) : HelpCentreTabItem(
        "FAQ",
        screen = { FaqScreen( navigator) })
}

package com.mobilewe.wemobile.presentation.screen.savings

import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable

fun NavGraphBuilder.savingsNavGraph(navController: NavHostController){
    composable(
        route =" SAVINGS_SCREEN_ROUT",
        enterTransition = {
            slideInVertically(
                animationSpec = tween(700),
                initialOffsetY = { it }
            )
        },
        exitTransition = {
            slideOutVertically (
                animationSpec = tween(700),
                targetOffsetY = { it }
            )
        }
    ) {
        SavingsScreen(
            navigateBack = { navController.navigateUp()},
            navController = navController
        )
    }
}
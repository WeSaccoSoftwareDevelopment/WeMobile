package com.mobilewe.wemobile.presentation.common.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.mobilewe.wemobile.presentation.screen.home.HomeScreen
import kotlinx.serialization.Serializable

fun NavGraphBuilder.homeGraph(navController: NavHostController){
    navigation<RootGraph.HomeGraph>(startDestination = RootGraph.Home){
        composable<RootGraph.Home> {
            HomeScreen(navController = navController)
        }
    }
}
sealed interface HomeDes {
    @Serializable
    data object Home: HomeDes
}
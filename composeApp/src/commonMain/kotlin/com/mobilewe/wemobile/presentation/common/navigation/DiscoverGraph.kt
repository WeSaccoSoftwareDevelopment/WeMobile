package com.mobilewe.wemobile.presentation.common.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.mobilewe.wemobile.presentation.screen.markets.MarketScreen
import kotlinx.serialization.Serializable

fun NavGraphBuilder.discoverGraph(navController: NavHostController){
    navigation<RootGraph.DiscoverGraph>(startDestination = RootGraph.DiscoverMain){
        composable<RootGraph.DiscoverMain> {
            MarketScreen {  }
        }
    }
}

sealed interface DiscoverDes {
    @Serializable
    data object DiscoverMain : DiscoverDes
}
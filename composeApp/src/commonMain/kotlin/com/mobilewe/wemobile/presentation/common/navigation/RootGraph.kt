package com.mobilewe.wemobile.presentation.common.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.lifecycle.ViewModel
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import kotlinx.serialization.Serializable
import org.koin.compose.viewmodel.koinViewModel


@Serializable
sealed class RootGraph {
    @Serializable
    data object AuthenticationGraph : RootGraph()

    @Serializable
    data object HomeGraph : RootGraph()

    @Serializable
    data object Home : RootGraph()

    @Serializable
    data object TransactGraph: RootGraph()

    @Serializable
    data object TransactMain: RootGraph()

    @Serializable
    data object DiscoverGraph : RootGraph()

    @Serializable
    data object DiscoverMain : RootGraph()

    @Serializable
    data object AccountGraph : RootGraph()

    @Serializable
    data object AccountMain : RootGraph()

}

@Composable
fun NavigationGraph(navController: NavHostController){
    NavHost(navController = navController, startDestination = RootGraph.AuthenticationGraph){
        authenticationGraph(navController)
        homeGraph(navController)
        transactGraph(navController)
        discoverGraph(navController)
        accountGraph(navController)
    }
}






@Composable
private inline fun <reified T: ViewModel> NavBackStackEntry.sharedKoinViewModel(
    navController: NavController
): T {
    val navGraphRoute = destination.parent?.route ?: return koinViewModel<T>()
    val parentEntry = remember(this) {
        navController.getBackStackEntry(navGraphRoute)
    }
    return koinViewModel(
        viewModelStoreOwner = parentEntry
    )
}


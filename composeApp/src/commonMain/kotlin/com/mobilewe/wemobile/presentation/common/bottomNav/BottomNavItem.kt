package com.mobilewe.wemobile.presentation.common.bottomNav

import com.mobilewe.wemobile.presentation.common.navigation.RootGraph
import org.jetbrains.compose.resources.DrawableResource
import wemobile.composeapp.generated.resources.Res
import wemobile.composeapp.generated.resources.account_circle
import wemobile.composeapp.generated.resources.home
import wemobile.composeapp.generated.resources.market_icons
import wemobile.composeapp.generated.resources.sync_alt_icon


enum class BottomNavigation(
    val title: String,
    val icon: DrawableResource?,
    val contentDescription: String?,
    val route: RootGraph
) {
    HOME("Home", Res.drawable.home,"Home", RootGraph.Home),
    TRANSACT("Transact", Res.drawable.sync_alt_icon,"Transact", RootGraph.TransactMain),
    LOAN("LOAN",null,"",RootGraph.DiscoverGraph),
    DISCOVER("Discover", Res.drawable.market_icons,"Discover", RootGraph.DiscoverMain),
    ACCOUNT("Account", Res.drawable.account_circle, "Account", RootGraph.AccountMain),

}



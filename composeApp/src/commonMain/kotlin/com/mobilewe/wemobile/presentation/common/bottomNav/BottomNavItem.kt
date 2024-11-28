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
    HOME("Home", Res.drawable.home,"Home", RootGraph.HomeGraph),
    TRANSACT("Transact", Res.drawable.sync_alt_icon,"Transact", RootGraph.TransactGraph),
    LOAN("LOAN",null,"",RootGraph.DiscoverGraph),
    DISCOVER("Discover", Res.drawable.market_icons,"Discover", RootGraph.DiscoverGraph),
    ACCOUNT("Account", Res.drawable.account_circle, "Account", RootGraph.AccountGraph),

}

data class BottomNavItem(
    val screen: Any,
    val icon: DrawableResource? = null,
    val title: String? = null,
    val contentDescription: String? = null,
    val alertCount: Int? = null,
)


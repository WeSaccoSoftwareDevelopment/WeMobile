package com.mobilewe.wemobile.presentation.common.bottomNav

import com.mobilewe.wemobile.presentation.common.navigation.Route
import org.jetbrains.compose.resources.DrawableResource
import wemobile.composeapp.generated.resources.Res
import wemobile.composeapp.generated.resources.account_circle
import wemobile.composeapp.generated.resources.home
import wemobile.composeapp.generated.resources.market_icons
import wemobile.composeapp.generated.resources.sync_alt_icon


enum class BottomNavigation(val title: String ,val icon: DrawableResource?,val contentDescription: String?,val screen: Route) {
    HOME("Home", Res.drawable.home,"Home",Route.Home),
    TRANSACT("Transact", Res.drawable.sync_alt_icon,"Transact",Route.Transact,),
    LOAN("LOAN",null,"",Route.Login),
    DISCOVER("Discover", Res.drawable.market_icons,"Discover",Route.Discover),
    ACCOUNT("Account", Res.drawable.account_circle, "Account",Route.Account),

}


package com.mobilewe.wemobile.presentation.common.bottomNav

import androidx.compose.runtime.Composable
import com.mobilewe.wemobile.presentation.common.navigation.ACCOUNTS
import com.mobilewe.wemobile.presentation.common.navigation.DISCOVER
import com.mobilewe.wemobile.presentation.common.navigation.HOME
import com.mobilewe.wemobile.presentation.common.navigation.Route
import com.mobilewe.wemobile.presentation.common.navigation.TRANSACT
import org.jetbrains.compose.resources.DrawableResource
import wemobile.composeapp.generated.resources.Res
import wemobile.composeapp.generated.resources.account_circle
import wemobile.composeapp.generated.resources.home
import wemobile.composeapp.generated.resources.market_icons
import wemobile.composeapp.generated.resources.sync_alt_icon


data class BottomNavItem(
    val screen: String,
    val icon: DrawableResource? = null,
    val title: String? = null,
    val contentDescription: String? = null,
    val alertCount: Int? = null,
)

@Composable
fun getBottomNavigation(): List<BottomNavItem> = listOf(
    BottomNavItem(
        screen = Route.Home.toString(),
        icon = Res.drawable.home,
        title = "Home",
        contentDescription = "Home"
    ),
    BottomNavItem(
        screen = Route.Transact.toString(),
        icon = Res.drawable.sync_alt_icon,
        title = "Transact",
        contentDescription = "Transact"
    ),
    BottomNavItem(screen = "Graph.LOANS_SCREEN_ROUTE"),
    BottomNavItem(
        screen = Route.Discover.toString(),
        icon = Res.drawable.market_icons,
        title = "Discover",
        contentDescription = "Discover"
    ),

    BottomNavItem(
        screen = Route.Account.toString(),
        icon = Res.drawable.account_circle,
        title = "Account",
        contentDescription = "Account"
    ),
)


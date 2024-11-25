package com.mobilewe.wemobile.presentation.common.bottomNav

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import org.jetbrains.compose.resources.painterResource
import wemobile.composeapp.generated.resources.Res
import wemobile.composeapp.generated.resources.sacco_ride



@Composable
fun StandardScaffold(
    navController: NavController,
    modifier: Modifier = Modifier,
    showBottomBar: Boolean = true,
    isLoggedIn: Boolean,
    bottomNavItems: List<BottomNavItem> = getBottomNavigation(),
    onFabClick: () -> Unit = {},
    content: @Composable () -> Unit
) {

    Scaffold(
        bottomBar = {
            if (showBottomBar) {
                NavigationBar(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                ) {
                    bottomNavItems.forEachIndexed { i, bottomNavItem ->
                        StandardBottomNavItem(
                            icon = bottomNavItem.icon,
                            title = bottomNavItem.title,
                            contentDescription = bottomNavItem.contentDescription,
                            selected = bottomNavItem.screen == navController.currentDestination?.route,
                            alertCount = bottomNavItem.alertCount,
                            enabled = bottomNavItem.icon != null
                        ) {
                            if (navController.currentDestination?.route != bottomNavItem.screen) {
                                navController.navigate(bottomNavItem.screen)
                            }
                        }
                    }
                }
            }
        },
        floatingActionButton = {
            if (showBottomBar) {
                FloatingActionButton(
                    modifier = Modifier.offset(y = (72).dp),
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    onClick = onFabClick,
                    elevation = FloatingActionButtonDefaults.elevation(
                        defaultElevation = 0.dp,
                        pressedElevation = 0.dp,
                        focusedElevation = 0.dp,
                        hoveredElevation = 0.dp
                    ),
                    shape = CircleShape
                ) {
                    Box(
                        modifier = Modifier.padding(8.dp).size(54.dp)
                            .background(MaterialTheme.colorScheme.primary, CircleShape),
                        contentAlignment = Alignment.Center
                    ) {
                        Image(
                            painter = painterResource(Res.drawable.sacco_ride),
                            contentDescription = null,
                            modifier = Modifier.size(24.dp)
                        )
                    }

                }
            }
        },
        floatingActionButtonPosition = FabPosition.Center,
        modifier = modifier
    ) { padding ->
        Box(Modifier.padding(padding)) {
            content()
        }
    }
}




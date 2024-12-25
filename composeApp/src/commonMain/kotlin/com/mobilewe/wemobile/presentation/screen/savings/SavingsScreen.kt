package com.mobilewe.wemobile.presentation.screen.savings

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.mobilewe.wemobile.presentation.common.theme.WeThemes
import org.jetbrains.compose.resources.stringResource
import wemobile.composeapp.generated.resources.Res
import wemobile.composeapp.generated.resources.*
import wemobile.composeapp.generated.resources.call_savings_title


@Composable
fun SavingMainScreen(
    navigateBack: () -> Unit
) {
    SavingsScreen(
        navigateBack = navigateBack,
        navController =  rememberNavController()
    )

}

@Composable
fun SavingsScreen(
    navigateBack: () -> Unit,
    navController: NavController
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Savings",
                        fontSize = 14.sp
                    )
                },
                backgroundColor = MaterialTheme.colorScheme.background,
                contentColor = MaterialTheme.colorScheme.onBackground,
                elevation = 0.dp,
                navigationIcon = {
                    IconButton(onClick = { navigateBack() }) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = null,
                            tint = MaterialTheme.colorScheme.onBackground,
                        )

                    }
                }
            )
        },
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(horizontal = 16.dp)
        ) {
            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(12.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                item {
                    Column(
                        verticalArrangement = Arrangement.spacedBy(12.dp),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text(
                            text = stringResource(Res.string.savings_title),
                            style = WeThemes.typography.titleLarge
                        )
                        Text(
                            text = stringResource(Res.string.savings_description),
                            fontSize = 12.sp,
                        )
                    }
                }
                item {
                    SavingsComponent(
                        savingTypeTitle = stringResource(Res.string.classic_savings_title),
                        savingTypeSubtitle = stringResource(Res.string.classic_savings_subtitle),
                        onClickLearnMore = {  },
                        onClickOpenAccount = { }
                    )
                }
                item {
                    SavingsComponent(
                        savingTypeTitle = stringResource(Res.string.goal_savings_title),
                        savingTypeSubtitle = stringResource(Res.string.goal_savings_subtitle),
                        onClickLearnMore = {  },
                        onClickOpenAccount = { }
                    )
                }
                item {
                    SavingsComponent(
                        savingTypeTitle = stringResource(Res.string.fixed_savings_title),
                        savingTypeSubtitle = stringResource(Res.string.fixed_savings_subtitle),
                        onClickLearnMore = {  },
                        onClickOpenAccount = { }
                    )
                }
                item {
                    SavingsComponent(
                        savingTypeTitle = stringResource(Res.string.call_savings_title),
                        savingTypeSubtitle = stringResource(Res.string.call_savings_subtitle),
                        onClickLearnMore = {  },
                        onClickOpenAccount = { }
                    )
                }
                item {
                    Box {}
                }
            }
        }
    }
}
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


@Composable
fun SavingMainScreen() {
    SavingsScreen(
        navigateBack = { /*TODO*/ },
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
                            text = "stringResource(id = R.string.savings_title)",
                            style = WeThemes.typography.titleLarge
                        )
                        Text(
                            text = "stringResource(id = R.string.savings_description)",
                            fontSize = 12.sp,
                        )
                    }
                }
                item {
                    SavingsComponent(
                        savingTypeTitle = "R.string.classic_savings_title",
                        savingTypeSubtitle = "R.string.classic_savings_subtitle",
                        onClickLearnMore = {  },
                        onClickOpenAccount = { }
                    )
                }
                item {
                    SavingsComponent(
                        savingTypeTitle = "R.string.goal_savings_title",
                        savingTypeSubtitle = "R.string.goal_savings_subtitle",
                        onClickLearnMore = {  },
                        onClickOpenAccount = { }
                    )
                }
                item {
                    SavingsComponent(
                        savingTypeTitle = "R.string.fixed_savings_title",
                        savingTypeSubtitle = "R.string.fixed_savings_subtitle",
                        onClickLearnMore = {  },
                        onClickOpenAccount = { }
                    )
                }
                item {
                    SavingsComponent(
                        savingTypeTitle = "R.string.call_savings_title",
                        savingTypeSubtitle = "R.string.call_savings_subtitle",
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
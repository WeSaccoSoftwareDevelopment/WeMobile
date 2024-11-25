package com.mobilewe.wemobile.presentation.screen.auth.pickLanguage

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.mobilewe.wemobile.presentation.common.composables.HeadFirstCard
import com.mobilewe.wemobile.presentation.screen.auth.pickLanguage.composable.LanguageCard
import com.mobilewe.wemobile.resources.Resources
import kotlinx.coroutines.flow.collectLatest
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun PickLanguageScreen(
    navigateToAuth: (String)->Unit
) {
    val listener: PickLanguageScreenModel = koinViewModel()
    val state by listener.state.collectAsState()

    LaunchedEffect(key1 = true) {
        listener.effect.collectLatest { effect ->
            when (effect) {
                is PickLanguageUIEffect.OnGoToPreferredLanguage -> navigateToAuth.invoke(state.languages.first().code)
            }
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
        contentAlignment = Alignment.Center
    ) {
        /*Image(

            modifier = Modifier.fillMaxSize(),
            painter = painterResource(com.wesacco.ui.R.drawable.bank),
            contentDescription = Resources.strings.backgroundDescription,
            contentScale = ContentScale.Crop
        )*/
        HeadFirstCard(
            textHeader = Resources.strings.languageAskAboutLanguage,
            textSubHeader = Resources.strings.selectLanguage
        ) {
            LazyVerticalGrid(
                contentPadding = PaddingValues(top = 16.dp),
                columns = GridCells.Adaptive(140.dp),
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp),

                ) {
                items(state.languages.size) { index ->
                    LanguageCard(
                        state = state.languages[index],
                        onClick = {
                            navigateToAuth.invoke(state.languages[index].code)
                            listener.onLanguageSelected(state.languages[index])
                        }
                    )
                }
            }
        }
    }
}


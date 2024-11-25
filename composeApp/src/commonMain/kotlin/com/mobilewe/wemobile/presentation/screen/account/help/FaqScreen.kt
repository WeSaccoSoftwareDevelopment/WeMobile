package com.mobilewe.wemobile.presentation.screen.account.help

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.mobilewe.wemobile.presentation.common.theme.WeThemes
import com.mobilewe.wemobile.presentation.screen.account.help.composable.FaqItem
import com.mobilewe.wemobile.presentation.screen.account.help.composable.FilterItem
import com.mobilewe.wemobile.presentation.screen.account.help.composable.faqs
import com.mobilewe.wemobile.presentation.screen.account.help.composable.filters
import org.koin.compose.viewmodel.koinViewModel


@Composable
fun FaqScreen(navigator: NavController) {

    val viewModel: HelpViewModel = koinViewModel()
    val searchState by viewModel.searchState.collectAsStateWithLifecycle()
    var focusState by rememberSaveable {
        mutableStateOf(false)
    }

    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(WeThemes.dimens.space10)
    ) {
        item {
            Column(modifier = Modifier.fillMaxWidth()) {

                Spacer(modifier = Modifier.height(WeThemes.dimens.space20))

                LazyRow(
                    horizontalArrangement = Arrangement.spacedBy(WeThemes.dimens.space10)
                ) {
                    items(filters, key = { it.title }) { filter ->
                        FilterItem(filter = filter, onClick = {})
                    }
                }

                Spacer(modifier = Modifier.height(WeThemes.dimens.space10))
            }
        }

        items(faqs, key = { it.title }) { faq ->
            FaqItem(faq = faq, onFaqClick = { }, modifier = Modifier.fillMaxWidth())
        }
        
        item { 
            Spacer(modifier = Modifier.height(WeThemes.dimens.space20))
        }

    }
}
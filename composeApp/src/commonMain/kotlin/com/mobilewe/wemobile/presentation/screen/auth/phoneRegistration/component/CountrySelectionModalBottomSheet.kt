package com.mobilewe.wemobile.presentation.screen.auth.phoneRegistration.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeGesturesPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.SheetState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.mobilewe.wemobile.presentation.screen.auth.country.CountrySelectionListItems
import com.mobilewe.wemobile.presentation.screen.auth.phoneRegistration.CountryTopBar
import com.mobilewe.wemobile.presentation.screen.auth.phoneRegistration.PhoneRegUiState
import com.mobilewe.wemobile.presentation.screen.auth.phoneRegistration.PhoneRegViewModel
import com.mobilewe.wemobile.utils.getNavigationBarPadding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterialApi::class, ExperimentalMaterial3Api::class)
@Composable
fun CountrySelectionModalBottomSheet(
    isSheetOpen: Boolean,
    onDismissRequest: () -> Unit,
    sheetState: SheetState,
    phoneRegUiState: PhoneRegUiState,
    viewModel: PhoneRegViewModel,
    coroutineScope: CoroutineScope
) {
    if (isSheetOpen) {
        ModalBottomSheet(
            onDismissRequest = { onDismissRequest() },
            sheetState = sheetState,
            dragHandle = null
        ) {
            Box(
                modifier = Modifier.safeGesturesPadding()
                    .padding(bottom = getNavigationBarPadding().calculateBottomPadding()),
                contentAlignment = Alignment.TopCenter
            ) {
                LazyColumn(
                    modifier = Modifier.fillMaxWidth(),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    item {
                        CountryTopBar(
                            title = "Select Country",
                            onClose = { onDismissRequest() }
                        )
                    }
                    val selectedCountry = phoneRegUiState.country
                    items(viewModel.countriesList) { country ->
                        CountrySelectionListItems(
                            country = country,
                            selectedCountry = selectedCountry == country,
                            onCountrySelected = { cry ->
                                viewModel.onCountrySelected(cry)
                                coroutineScope.launch { onDismissRequest() }
                            }
                        )
                    }
                    item {
                        Box(modifier = Modifier.size(32.dp))
                    }
                }
            }
        }
    }
}
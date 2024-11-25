package com.mobilewe.wemobile.presentation.screen.home.composable

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.safeGesturesPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.SheetState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun <T> ReusableModalSheet(
    isOpen: Boolean,
    onDismissRequest: () -> Unit,
    sheetState: SheetState,
    items: List<T>,
    itemContent: @Composable (T) -> Unit
) {
    if (isOpen) {
        ModalBottomSheet(
            onDismissRequest = onDismissRequest,
            sheetState = sheetState,
            dragHandle = null
        ) {
            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .safeGesturesPadding(),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(items) { item ->
                    itemContent(item)
                }
            }
        }
    }
}

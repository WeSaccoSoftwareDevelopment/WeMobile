package com.mobilewe.wemobile.presentation.common.composables.modalSheet

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.safeGesturesPadding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.SheetState
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier


@OptIn(ExperimentalLayoutApi::class, ExperimentalMaterial3Api::class)
@Composable
fun WeSaccoModalSheet(
    modifier: Modifier = Modifier,
    isSheetOpen: Boolean = false,
    sheetState: SheetState = rememberModalBottomSheetState(),
    onDismissRequest: () -> Unit,
    content: @Composable ColumnScope.() -> Unit,
) {

    if (isSheetOpen){
        ModalBottomSheet(
            sheetState = sheetState,
            onDismissRequest = { onDismissRequest() },
            modifier = modifier,
            dragHandle = null,
            containerColor = colorScheme.background,
        ) {
            Box(
                contentAlignment = Alignment.TopStart,
                modifier = modifier.fillMaxWidth().safeGesturesPadding()
            ) {
                Column {
                    content()
                }
            }
        }
    }

}


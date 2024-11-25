package com.mobilewe.wemobile.presentation.common.composables

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeGesturesPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.SheetState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.mobilewe.wemobile.domain.model.AccountType
import com.mobilewe.wemobile.utils.getNavigationBarPadding
import kotlinx.coroutines.launch


@OptIn(ExperimentalMaterialApi::class, ExperimentalMaterial3Api::class)
@Composable
fun AccountSelectionModalBottomSheet(
    isSheetOpen: Boolean,
    onDismissRequest: () -> Unit,
    sheetState: SheetState,
    onSelectedAccountTypeName: (String) -> Unit,
    accountList: List<AccountType>
) {
    val coroutineScope = rememberCoroutineScope()
    if (isSheetOpen) {
        ModalBottomSheet(
            onDismissRequest = { coroutineScope.launch {   onDismissRequest() } },
            sheetState = sheetState,
            dragHandle = null
        ) {
            Box(
                modifier = Modifier
                    .safeGesturesPadding()
                    .padding(bottom = getNavigationBarPadding().calculateBottomPadding()),
                contentAlignment = Alignment.TopCenter
            ) {
                LazyColumn(
                    modifier = Modifier.fillMaxWidth(),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    item {
                        Text(
                            text = "Choose Account Accc",
                        )
                    }
                    items(accountList) { country ->
                        AccountSelectionComponent(
                            accountType = country,
                            onSelectedAccountType = { cry ->
                                onSelectedAccountTypeName(cry.accountNumber)
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

@Composable
private fun AccountSelectionComponent(
    accountType: AccountType,
    onSelectedAccountType:(AccountType)->Unit
){
    Column(
        modifier = Modifier.clickable { onSelectedAccountType(accountType) }
    ) {
        Text(
            modifier = Modifier.padding(vertical = 10.dp),
            text = accountType.accountName.accountName,
            style = MaterialTheme.typography.bodySmall
        )
        Text(
            modifier = Modifier.padding(vertical = 10.dp),
            text = accountType.accountNumber,
            style = MaterialTheme.typography.bodySmall
        )

    }
}
package com.mobilewe.wemobile.presentation.common.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun AccountTypeModalSheet(
    modifier: Modifier = Modifier,
    accountList: List<String>,
    onClose:()->Unit,
    accountName: String
) {
    Column(
        modifier = modifier.fillMaxSize().background(MaterialTheme.colorScheme.surfaceVariant),
        verticalArrangement = Arrangement.Center
    ) {
        accountList.forEach { account ->
            Row(
                modifier = Modifier.fillMaxWidth().padding(16.dp)
                    .clickable { onClose() }
            ) {
                Text(
                    text = account,
                    modifier = Modifier.weight(1f)
                )
            }
        }
    }
}
package com.mobilewe.wemobile.presentation.common.list

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeGesturesPadding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.mobilewe.wemobile.domain.model.AccountType
import com.mobilewe.wemobile.presentation.common.theme.WeThemes
import com.mobilewe.wemobile.utils.getNavigationBarPadding

@Composable
fun UserAccountSelectionScreen(
    onClose: () -> Unit,
    accountList: List<AccountType>
) {
    Box(
        modifier = Modifier.safeGesturesPadding()
            .padding(bottom = getNavigationBarPadding().calculateBottomPadding()),
        contentAlignment = Alignment.TopCenter
    ) {
        Column(
            modifier = Modifier.padding(bottom = 32.dp)
                .background(MaterialTheme.colorScheme.surfaceVariant),
        ) {
            Text(text = "Account List")
            accountList.forEach { account ->
                AccountSelectionComponent(
                    accountType = account,
                    onSelectedAccountType = { onClose() }
                )
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
            style = WeThemes.typography.bodySmall
        )
        Text(
            modifier = Modifier.padding(vertical = 10.dp),
            text = accountType.accountNumber,
            style = WeThemes.typography.bodySmall
        )

    }
}

package com.mobilewe.wemobile.presentation.common.list

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.ContentAlpha
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.mobilewe.wemobile.domain.model.Bank
import com.mobilewe.wemobile.utils.getInitials
import com.mobilewe.wemobile.utils.randomColor


@Composable
fun BankListSelectionScreen(
    onClose: () -> Unit,
    bankList: List<Bank>,
    onBankItemClicked: (String) -> Unit ={}
) {

    Column(modifier = Modifier.padding()) {
        Box(
            modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
//            AppTopBar(
//                title = "Search Bank",
//                initialValue = "",
//                onSearchParamChange = {},
//                showSearchBar = true
//            )
        }
        Column(
            modifier = Modifier.background(MaterialTheme.colorScheme.surfaceVariant),
            verticalArrangement = Arrangement.Center
        ) {
            Box(modifier = Modifier.fillMaxWidth()) {
                LazyColumn(
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    items(bankList) {bank ->
                        BankComponentItem(
                            bank = bank,
                            onBankItemClicked = {
                                onClose()
                                onBankItemClicked(bank.bankName)
                            }
                        )
                    }
                }
            }
        }
    }

}

@Composable
fun BankComponentItem(
    modifier: Modifier = Modifier,
    bank: Bank,
    onBankItemClicked:()->Unit
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier.fillMaxWidth().clickable(onClick = { onBankItemClicked() }),
    ) {
        if (bank.bankImageUrl != null) {
            Box(
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape)
                    .background(randomColor()),
                contentAlignment = Alignment.Center
            ){
                AsyncImage(
                    model = bank.bankImageUrl,
                    contentDescription = "profile_image",
                    modifier = Modifier.size(24.dp),
                    placeholder = null
                )
            }

        } else {
            val accountInitials = bank.bankName
            Box(
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape)
                    .background(randomColor()),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = getInitials(accountInitials),
                    fontWeight = FontWeight.Normal,
                    textAlign = TextAlign.Center,
                    fontSize = 20.sp
                )
            }
        }
        Column(
            modifier = Modifier.padding(start = 10.dp).weight(1f)
        ) {
            Text(
                text = bank.bankName,
                modifier = Modifier.fillMaxWidth(),
                overflow = TextOverflow.Ellipsis,
                maxLines = 1,
            )
            Text(
                text = bank.bankAccountNumber,
                modifier = Modifier.fillMaxWidth(),
                overflow = TextOverflow.Ellipsis,
                maxLines = 1,
                color = LocalContentColor.current.copy(alpha = ContentAlpha.medium)
            )
        }
    }
}
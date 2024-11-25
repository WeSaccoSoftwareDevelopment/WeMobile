package com.mobilewe.wemobile.presentation.screen.reports.transaction_history

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.mobilewe.wemobile.domain.model.TransactionsItem
import com.mobilewe.wemobile.presentation.common.theme.WeThemes.typography
import com.mobilewe.wemobile.utils.formatContact
import com.mobilewe.wemobile.utils.getInitials


@Composable
fun TransactionHistoryItem(
    modifier: Modifier = Modifier,
    transactionItem: TransactionsItem,
    onTransactionClick: (TransactionsItem) -> Unit
) {
    val interactionSource = remember {
        MutableInteractionSource()
    }
    Row(
        modifier = Modifier
            .padding(top = 8.dp, bottom = 8.dp,)
            .fillMaxWidth()
            .clickable(interactionSource, null) {
                onTransactionClick(transactionItem)
            },
        verticalAlignment = Alignment.CenterVertically,
    ) {
        if (transactionItem.image != null) {
            Box(
                modifier = Modifier
                    .size(48.dp)
                    .clip(CircleShape)
                    .background(MaterialTheme.colorScheme.onSurface.copy(alpha = 0.08F)),
                contentAlignment = Alignment.Center
            ) {
                AsyncImage(
                    model = transactionItem.image,
                    contentDescription = "profile_image",
                    modifier = Modifier
                        .size(30.dp)
                        .clip(shape = CircleShape),
                    placeholder = null
                )
            }

        } else {
            val transactionInitials = transactionItem.name
            Box(
                modifier = Modifier
                    .size(48.dp)
                    .clip(CircleShape)
                    .background(MaterialTheme.colorScheme.onSurface.copy(alpha = 0.08F)),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = getInitials(transactionInitials),
                    fontWeight = FontWeight.Normal,
                    textAlign = TextAlign.Center,
                    fontSize = 20.sp
                )
            }
        }
        Column(
            modifier = Modifier
                .padding(start = 10.dp, end = 10.dp)
                .weight(1f),
        ) {
            val formattedContact = formatContact(transactionItem.contact)
            Text(
                text = transactionItem.name,
                style = typography.labelSmall,
                overflow = TextOverflow.Ellipsis,
                maxLines = 1,
                textAlign = TextAlign.Start,
            )
            Text(
                text = formattedContact,
                textAlign = TextAlign.Start,
                style = typography.labelSmall,
                overflow = TextOverflow.Ellipsis,
                maxLines = 1
            )
        }

        Column(
            modifier = Modifier.padding(start = 10.dp, end = 10.dp),
            horizontalAlignment = Alignment.End
        ) {
            val formatCurrency = transactionItem.amount

            Text(
                text = formatCurrency.toString(),
                style = typography.labelSmall,
                overflow = TextOverflow.Ellipsis,
                maxLines = 1,
                textAlign = TextAlign.End,
            )
            Text(
                text = transactionItem.time,
                textAlign = TextAlign.End,
                style = typography.labelSmall,
                overflow = TextOverflow.Ellipsis,
                maxLines = 1
            )

        }

    }

}


@Composable
fun DateHeader(date: String) {
    Text(
        text = date,
        modifier = Modifier
            .background(Color.LightGray)
            .padding(8.dp)
            .fillMaxWidth()
    )
}

@Composable
fun TransactionStickyHeader(modifier: Modifier = Modifier, date: String) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
    ) {
        Text(
            text = date, style = typography.labelSmall,
            color = MaterialTheme.colorScheme.onBackground
        )

        Spacer(modifier = Modifier.width(16.dp))

        HorizontalDivider(
            modifier = Modifier.weight(1f),
            color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.08F)
        )

    }
}



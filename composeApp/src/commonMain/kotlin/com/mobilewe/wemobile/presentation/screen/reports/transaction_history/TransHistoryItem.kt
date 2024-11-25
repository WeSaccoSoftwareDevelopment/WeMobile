package com.mobilewe.wemobile.presentation.screen.reports.transaction_history

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.mobilewe.wemobile.domain.model.TransactionsItem
import com.mobilewe.wemobile.domain.model.transactionsItem


@Composable
fun TransHistoryItem(
    modifier: Modifier = Modifier,
    transactionItem: TransactionsItem,
    onTransactionClick: (TransactionsItem) -> Unit
) {
    val interactionSource = remember {
          MutableInteractionSource()
    }
//    ConstraintLayout(
//        modifier = modifier.fillMaxWidth()
//            .padding(
//                horizontal = 16.dp,
//                vertical = 5.dp
//            )
//            .clickable(interactionSource, null) {
//                onTransactionClick(transactionItem)
//            }
//    ) {
//        val (profileImage, nameText, amountText, contactText, dateTimeText) = createRefs()
//
//        if (transactionItem.image != null) {
//            Box(
//                modifier = Modifier
//                    .size(48.dp)
//                    .clip(CircleShape)
//                    .background(MaterialTheme.colorScheme.onSurface.copy(alpha = 0.08F))
//                    .constrainAs(profileImage) {
//                        start.linkTo(parent.start)
//                        centerVerticallyTo(parent)
//                    },
//                contentAlignment = Alignment.Center
//            ) {
//                AsyncImage(
//                    model = transactionItem.image,
//                    contentDescription = "profile_image",
//                    modifier = Modifier
//                        .size(30.dp)
//                        .clip(shape = CircleShape),
//                    placeholder = null
//                )
//            }
//        } else {
//            val transactionInitials = transactionItem.name
//            Box(
//                modifier = Modifier
//                    .size(48.dp)
//                    .clip(CircleShape)
//                    .background(MaterialTheme.colorScheme.onSurface.copy(alpha = 0.08F))
//                    .constrainAs(profileImage) {
//                        start.linkTo(parent.start)
//                        centerVerticallyTo(parent)
//                    },
//                contentAlignment = Alignment.Center
//            ) {
//                Text(
//                    text = getInitials(transactionInitials),
//                    fontWeight = FontWeight.Normal,
//                    textAlign = TextAlign.Center,
//                    fontSize = 20.sp
//                )
//            }
//        }
//
//        Text(
//            text = transactionItem.name,
//            style = typography.labelSmall,
//            overflow = TextOverflow.Ellipsis,
//            maxLines = 1,
//            textAlign = TextAlign.Start,
//            modifier = Modifier
//                .padding(top = 8.dp)
//                .constrainAs(nameText) {
//                    start.linkTo(profileImage.end, margin = 10.dp)
//                    top.linkTo(amountText.top)
//                }
//        )
//        val formatCurrency = formatKenyanShillings(transactionItem.amount)
//
//        Text(
//
//            text = formatCurrency,
//            textAlign = TextAlign.End,
//            style = typography.labelSmall,
//            overflow = TextOverflow.Ellipsis,
//            maxLines = 1,
//            modifier = Modifier
//                .padding(top = 8.dp)
//                .constrainAs(amountText) {
//                    end.linkTo(parent.end)
//                    top.linkTo(parent.top)
//                }
//        )
//
//        val formattedContact = formatContact(transactionItem.contact)
//        Text(
//            text = formattedContact,
//            style = typography.labelSmall,
//            overflow = TextOverflow.Ellipsis,
//            maxLines = 1,
//            textAlign = TextAlign.Start,
//            modifier = Modifier
//                .constrainAs(contactText) {
//                    start.linkTo(nameText.start)
//                    top.linkTo(nameText.bottom)
//                }
//        )
//
//        Text(
//            text = "${formatDate(transactionItem.date)}, ${transactionItem.time}",
//            textAlign = TextAlign.End,
//            style = typography.labelSmall,
//            overflow = TextOverflow.Ellipsis,
//            maxLines = 1,
//            modifier = Modifier
//                .constrainAs(dateTimeText) {
//                    end.linkTo(amountText.end)
//                    top.linkTo(amountText.bottom)
//                }
//        )
//    }
}








@Composable
fun TransHistoryItemPreview() {
    LazyColumn {
        items(transactionsItem.size) { index ->
            TransHistoryItem(
                transactionItem = transactionsItem[index],
                onTransactionClick = {}
            )
        }
    }

}
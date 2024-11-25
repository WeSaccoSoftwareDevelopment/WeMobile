package com.mobilewe.wemobile.presentation.screen.payWithSacco.buyGoods.buyGoodsConfirm

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.mobilewe.wemobile.domain.model.Merchant


@Composable
fun BuyGoodsConfirmsComponent(
    merchant: Merchant,
    onClickDone: () -> Unit = {}
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(
            contentColor = MaterialTheme.colorScheme.onBackground
        )
    ) {
//        ConstraintLayout(
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(start = 12.dp, end = 12.dp, top = 16.dp, bottom = 10.dp)
//        ) {
//            val (payToLabel, tillNoLabel, amountLabel, dateTimeLabel,
//                tillNameValue, tillNumberValue, amountValue, transactionDateValue, button) = createRefs()
//
//            // Labels
//            Text(
//                text = "Pay to:",
//                maxLines = 1,
//                textAlign = TextAlign.Start,
//                overflow = TextOverflow.Ellipsis,
//                modifier = Modifier.constrainAs(payToLabel) {
//                    top.linkTo(parent.top)
//                    start.linkTo(parent.start)
//                }
//            )
//            Text(
//                text = "Till No",
//                maxLines = 1,
//                textAlign = TextAlign.Start,
//                overflow = TextOverflow.Ellipsis,
//                modifier = Modifier.constrainAs(tillNoLabel) {
//                    top.linkTo(payToLabel.bottom, margin = 8.dp)
//                    start.linkTo(parent.start)
//                }
//            )
//            Text(
//                text = "Amount",
//                maxLines = 1,
//                textAlign = TextAlign.Start,
//                overflow = TextOverflow.Ellipsis,
//                modifier = Modifier.constrainAs(amountLabel) {
//                    top.linkTo(tillNoLabel.bottom, margin = 8.dp)
//                    start.linkTo(parent.start)
//                }
//            )
//            Text(
//                text = "Date/Time",
//                maxLines = 1,
//                textAlign = TextAlign.Start,
//                overflow = TextOverflow.Ellipsis,
//                modifier = Modifier.constrainAs(dateTimeLabel) {
//                    top.linkTo(amountLabel.bottom, margin = 8.dp)
//                    start.linkTo(parent.start)
//                }
//            )
//
//            // Values
//            Text(
//                text = merchant.tillName,
//                maxLines = 1,
//                overflow = TextOverflow.Ellipsis,
//                modifier = Modifier.constrainAs(tillNameValue) {
//                    top.linkTo(payToLabel.top)
//                    end.linkTo(parent.end)
//                }
//            )
//            Text(
//                text = merchant.tillNumber,
//                maxLines = 1,
//                overflow = TextOverflow.Ellipsis,
//                modifier = Modifier.constrainAs(tillNumberValue) {
//                    top.linkTo(tillNoLabel.top)
//                    end.linkTo(parent.end)
//                }
//            )
//            Text(
//                text = merchant.amount.toString(),
//                maxLines = 1,
//                overflow = TextOverflow.Ellipsis,
//                modifier = Modifier.constrainAs(amountValue) {
//                    top.linkTo(amountLabel.top)
//                    end.linkTo(parent.end)
//                }
//            )
//            Text(
//                text = merchant.transactionDate.toString(),
//                maxLines = 1,
//                overflow = TextOverflow.Ellipsis,
//                modifier = Modifier.constrainAs(transactionDateValue) {
//                    top.linkTo(dateTimeLabel.top)
//                    end.linkTo(parent.end)
//                }
//            )
//
//            Button(
//                onClick = onClickDone,
//                modifier = Modifier.constrainAs(button) {
//                    top.linkTo(transactionDateValue.bottom, margin = 16.dp)
//                    start.linkTo(parent.start)
//                    end.linkTo(parent.end)
//                    width = Dimension.fillToConstraints
//                }
//            ) {
//                Text(text = "Done")
//            }
//        }
    }
}






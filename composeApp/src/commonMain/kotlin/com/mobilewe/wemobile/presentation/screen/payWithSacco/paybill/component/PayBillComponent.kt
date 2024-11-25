package com.mobilewe.wemobile.presentation.screen.payWithSacco.paybill.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.ContentAlpha
import androidx.compose.material3.LocalContentColor
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
import com.mobilewe.wemobile.domain.model.PayBill
import com.mobilewe.wemobile.utils.clickableWithoutRipple
import com.mobilewe.wemobile.utils.randomColor


@Composable
fun PayBillComponent(
    payBill: PayBill,
    onPayBillItemClick: ()->Unit
) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .clickableWithoutRipple{ onPayBillItemClick() },
        verticalAlignment = Alignment.CenterVertically
    ) {
        if (payBill.logoUrl != null) {
            Box(
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape)
                    .background(randomColor()),
                contentAlignment = Alignment.Center
            ){
                AsyncImage(
                    model = payBill.logoUrl,
                    contentDescription = "profile_image",
                    modifier = Modifier.size(24.dp),
                    placeholder = null
                )
            }

        } else {
            val names = payBill.businessName.split(" ")
            val initials = names[0].first().toString() + names[1].first().toString()
            Box(
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape)
                    .background(randomColor()),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = initials,
                    fontWeight = FontWeight.Normal,
                    textAlign = TextAlign.Center,
                    fontSize = 20.sp
                )
            }
        }
        Column(
            modifier = Modifier
                .padding(start = 10.dp)
                .weight(1f)
        ) {
            Text(
                text = payBill.businessName,
                modifier = Modifier.fillMaxWidth(),
                overflow = TextOverflow.Ellipsis,
                maxLines = 1,
                fontSize = 14.sp
            )
            Text(
                text = payBill.businessNumber,
                modifier = Modifier.fillMaxWidth(),
                overflow = TextOverflow.Ellipsis,
                maxLines = 1,
                fontSize = 14.sp,
                color = LocalContentColor.current.copy(alpha = ContentAlpha.medium)
            )
        }

    }
}

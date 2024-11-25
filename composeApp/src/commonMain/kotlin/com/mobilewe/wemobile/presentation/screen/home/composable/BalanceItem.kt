package com.mobilewe.wemobile.presentation.screen.home.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import coil3.request.CachePolicy
import coil3.request.ImageRequest
import coil3.request.crossfade
import com.mobilewe.wemobile.data.db.entity.AccountEntity
import com.mobilewe.wemobile.presentation.common.theme.WeThemes
import com.mobilewe.wemobile.utils.getPlatformContext
import org.jetbrains.compose.resources.painterResource
import wemobile.composeapp.generated.resources.Res
import wemobile.composeapp.generated.resources.img_placeholder
import wemobile.composeapp.generated.resources.keyboard_arrow_left


@Composable
fun BalanceItem(
    weSaccoAccountEntity: AccountEntity,
    balanceTapListener:(String) -> Unit,
) {
    val size34 = 34.dp
    val size13 = 13.dp
    Column {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 13.dp)
                .heightIn(min = 70.dp)
                .clickable { balanceTapListener.invoke(weSaccoAccountEntity.id.toString()) }
        ) {

            AsyncImage(
                model = weSaccoAccountEntity.logoUrl,
                contentDescription = "",
                placeholder = painterResource(Res.drawable.img_placeholder),
                error = painterResource(Res.drawable.img_placeholder),
                modifier = Modifier
                    .size(size34)
                    .clip(CircleShape)
                    .align(Alignment.CenterVertically),
                contentScale = ContentScale.Crop
            )

            weSaccoAccountEntity.userAlias?.let {
                Text(
                    text = it,
                    style = WeThemes.typography.bodyMedium,
                    modifier = Modifier
                        .weight(1f)
                        .padding(start = size13)
                        .align(Alignment.CenterVertically),
                )
            }

            Column(modifier = Modifier.align(Alignment.CenterVertically)) {
                Text(
                    text = weSaccoAccountEntity.latestBalance ?: " - ",
                    modifier = Modifier.align(Alignment.End),
                    style = WeThemes.typography.labelMedium,
                )

                Spacer(modifier = Modifier.height(2.dp))

                if (weSaccoAccountEntity.latestBalance != null)
                    Text(
                        text = "",
                        modifier = Modifier.align(Alignment.End),
                        style = WeThemes.typography.caption
                    )
            }

            Image(
                painter = painterResource(Res.drawable.keyboard_arrow_left),
                contentDescription = null,
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .padding(start = size13)
                    .clickable { balanceTapListener?.invoke(weSaccoAccountEntity.id.toString()) }
                    .size(32.dp)
            )
        }

        Divider(
            color = Color.Gray,
            modifier = Modifier.padding(horizontal = 13.dp)
        )
    }
}
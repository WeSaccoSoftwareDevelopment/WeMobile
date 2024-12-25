package com.mobilewe.wemobile.presentation.screen.account.account.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.mobilewe.wemobile.presentation.common.theme.WeThemes
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource
import wemobile.composeapp.generated.resources.Res
import wemobile.composeapp.generated.resources.account_circle
import wemobile.composeapp.generated.resources.*


@Composable
fun AccountDetailsSection(
    modifier: Modifier = Modifier,
    onQrCodeClick: () -> Unit,
    onClick: () -> Unit,
    user: User = User(name = "Stephen", email = "steve.chacha@gmail.com")
) {
    Surface(
        color = MaterialTheme.colorScheme.background,
        modifier = modifier,
        onClick = { onClick() }
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Image(
                painter = painterResource(user.picture),
                contentDescription = "avatar",
                modifier = Modifier
                    .clip(CircleShape)
                    .size(60.dp),
                contentScale = ContentScale.Crop
            )

            Column(
                modifier = Modifier
                    .padding(start = 10.dp, end = 10.dp)
                    .weight(1f)
            ) {
                Text(
                    text = user.name,
                    style = WeThemes.typography.titleMedium,
                    color = MaterialTheme.colorScheme.onBackground
                )

                Spacer(modifier = Modifier.height(5.dp))

                Text(
                    text = user.email,
                    style = WeThemes.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onBackground
                )
            }

            IconButton(onClick = { onQrCodeClick() }) {
                Icon(
                    painter = painterResource(Res.drawable.qr_code),
                    contentDescription = null,
                    modifier = Modifier.size(25.dp),
                )
            }
        }
    }
}


data class User(
    val name: String,
    val email: String,
    val picture: DrawableResource = Res.drawable.account_circle
)
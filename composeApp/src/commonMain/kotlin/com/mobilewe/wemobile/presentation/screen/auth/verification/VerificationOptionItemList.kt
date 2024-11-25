package com.mobilewe.wemobile.presentation.screen.auth.verification

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.mobilewe.wemobile.presentation.common.theme.WeThemes
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource
import wemobile.composeapp.generated.resources.Res
import wemobile.composeapp.generated.resources.outline_input_24
import wemobile.composeapp.generated.resources.outline_mail_outline_24
import wemobile.composeapp.generated.resources.outline_phone_android_24

@Composable
fun VerificationOptionItemList(
    icon: DrawableResource,
    title: String,
    descriptionValue: String,
    selected: Boolean = false,
    onSelectedOption: () -> Unit
) {
    OutlinedCard (
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.outlinedCardColors(
            containerColor = Color.Transparent
        )
    ){
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp)
        ) {
            Box(
                modifier = Modifier
                    .size(48.dp)
                    .clip(CircleShape)
                    .background(MaterialTheme.colorScheme.outline, CircleShape),
                contentAlignment = Alignment.Center
            ){
                Icon(
                    painter = painterResource(icon),
                    contentDescription =  "icon",
                    tint = MaterialTheme.colorScheme.primary,
                    modifier = Modifier.size(24.dp)
                )
            }
            Column(
                modifier = Modifier.padding(start = 5.dp),
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = title,
                    style = WeThemes.typography.titleSmall
                )
                Text(
                    text = descriptionValue,
                    style = WeThemes.typography.titleSmall

                )
            }
            Spacer(modifier = Modifier.weight(1f))
            RadioButton(
                selected = selected,
                onClick = { onSelectedOption()}
            )

        }

    }


}

data class VerificationOption(
    val icon: DrawableResource,
    val title: String,
    val description: String
)

val verificationOptions = listOf(
    VerificationOption(
        icon = Res.drawable.outline_input_24,
        title = "By Card",
        description = "ATM, debit or credit card"
    ),
    VerificationOption(
        icon = Res.drawable.outline_phone_android_24,
        title = "By Sms",
        description = "25474*****13"
    ),
    VerificationOption(
        icon = Res.drawable.outline_mail_outline_24,
        title = "By Email",
        description = "s********A4@GMAIL>COM"
    )
)

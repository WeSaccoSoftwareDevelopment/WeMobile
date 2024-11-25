package com.mobilewe.wemobile.presentation.common.list

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeGesturesPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.mobilewe.wemobile.domain.model.RecipientProvider
import com.mobilewe.wemobile.domain.model.recipientProvider
import com.mobilewe.wemobile.utils.clickableWithoutRipple

@Composable
fun SendMoneyProvider(
    recipientProviderText: RecipientProvider,
    onRecipientProvider: (RecipientProvider) -> Unit,
) {

    LazyColumn(
        modifier = Modifier.fillMaxWidth().safeGesturesPadding(),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(recipientProvider) { selectedProvider ->
            ProvidersMoney(
                sendProvider = selectedProvider,
                onProviderSelected = onRecipientProvider,
                isProviderSelected = recipientProviderText == selectedProvider
            )
        }
    }
}



@Composable
fun ProvidersMoney(
    sendProvider: RecipientProvider,
    onProviderSelected: (RecipientProvider) -> Unit,
    isProviderSelected: Boolean = false
) {
    val interactionSource = remember { MutableInteractionSource() }
    Column(
        modifier = Modifier.fillMaxWidth().clickableWithoutRipple(
                interactionSource,
                onClick = { onProviderSelected(sendProvider) }
            )
    ) {
        Row(
            modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            AsyncImage(
                model = sendProvider.icon,
                contentDescription = sendProvider.providerName,
                modifier = Modifier.size(24.dp)
            )
            Spacer(modifier = Modifier.width(12.dp))
            Text(
                text = sendProvider.providerName,
                fontSize = 14.sp
            )
            Spacer(modifier = Modifier.weight(1f))
            RadioButton(
                selected = isProviderSelected,
                onClick = { onProviderSelected(sendProvider) }
            )
        }
    }

}

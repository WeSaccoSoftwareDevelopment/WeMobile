package com.mobilewe.wemobile.presentation.screen.sendMoney.components

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBalanceWallet
import androidx.compose.material.icons.filled.AttachMoney
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.toSize
import coil3.compose.AsyncImage
import com.mobilewe.wemobile.domain.model.RecipientProvider
import com.mobilewe.wemobile.domain.model.recipientProvider
import com.mobilewe.wemobile.utils.clickableWithoutRipple
import com.mobilewe.wemobile.presentation.screen.sendMoney.sendMoney.SendMoneyScreenUiState


@Composable
fun SendMoneyRecipientDropDown(
    sendMoneyScreenUiState: SendMoneyScreenUiState,
    onRecipientProvider: (RecipientProvider)->Unit
) {
    var textfieldSize by remember { mutableStateOf(Size.Zero) }
    var expanded by remember { mutableStateOf(false) }
    val interactionSource = remember { MutableInteractionSource() }
    if (interactionSource.collectIsPressedAsState().value)
        expanded = !expanded
    val icon = if (expanded) Icons.Filled.KeyboardArrowUp else Icons.Filled.KeyboardArrowDown

    Column(modifier = Modifier.fillMaxWidth()) {
        OutlinedTextField(
            value = sendMoneyScreenUiState.recipientProvider.name,
            onValueChange = { newValue->
                val newProvider = recipientProvider.find { it.name == newValue }
                if (newProvider != null) {
                    onRecipientProvider(newProvider)
                }
            },
            trailingIcon = {
                Icon(icon, "contentDescription",
                    Modifier
                        .clickableWithoutRipple(interactionSource = MutableInteractionSource(), onClick = {expanded = !expanded})
                )
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 10.dp)
                .clickableWithoutRipple(interactionSource = MutableInteractionSource(), onClick = {expanded = !expanded})
                .onGloballyPositioned { coordinates ->
                    textfieldSize = coordinates.size.toSize()
                },
            readOnly = true,
            leadingIcon = {
                AsyncImage(
                    sendMoneyScreenUiState.recipientProvider.icon,
                    "contentDescription",
                    modifier = Modifier
                        .size(24.dp)
                        .clickableWithoutRipple(interactionSource = MutableInteractionSource(), onClick = {expanded = !expanded})
                )
            },
            interactionSource = interactionSource,
            colors = OutlinedTextFieldDefaults.colors(
                focusedContainerColor = Color.Transparent,
                focusedBorderColor = MaterialTheme.colorScheme.onBackground,
                cursorColor = Color.Transparent,
                focusedLabelColor = Color.Transparent


            )
        )
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = androidx.compose.ui.Modifier
                .width(with(LocalDensity.current) { textfieldSize.width.toDp() }),
        ) {
            recipientProvider.forEach { item ->
                DropdownMenuItem(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                        .align(Alignment.CenterHorizontally),
                    text = { Text(text = item.name) },
                    onClick = {
                        onRecipientProvider(item)
//                        sendMoneyViewModel.onSendMoneyEvent(SendMoneyEvent.RecipientProviderSelected(item))
                        expanded = false
                    },
                    leadingIcon = {
                        AsyncImage(
                            item.icon,
                            contentDescription = item.name,
                            modifier = Modifier.padding(end = 8.dp)
                        )

                    }
                )
            }

        }
    }

}


fun getRecipientProviderName(recipientProvider: String): String {
    val provider = RecipientProvider.valueOf(recipientProvider)
    return when (provider) {
        RecipientProvider.Mpesa -> "Mpesa"
        RecipientProvider.AirtelMoney -> "Airtel Money"
        RecipientProvider.Tkash -> "Tkash"
    }
}

fun getRecipientProviderIcon(recipientProvider: String): String {
    val provider = RecipientProvider.valueOf(recipientProvider)
    return when (provider) {
        RecipientProvider.Mpesa -> Icons.Default.Phone.toString()
        RecipientProvider.AirtelMoney -> Icons.Default.AttachMoney.toString()
        RecipientProvider.Tkash -> Icons.Default.AccountBalanceWallet.toString()
    }
}

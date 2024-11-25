package com.mobilewe.wemobile.presentation.screen.requestMoney.composable

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ContentAlpha
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.DialogProperties
import com.mobilewe.wemobile.domain.model.SendMoney
import com.mobilewe.wemobile.presentation.common.theme.WeThemes


@Composable
fun RequestMoneyDialog(
    onDismiss: () -> Unit,
    onClickSend: (SendMoney) -> Unit,
    sendMoney: SendMoney
) {

    AlertDialog(
        containerColor = MaterialTheme.colorScheme.background,
        onDismissRequest = { onDismiss() },
        shape = RoundedCornerShape(5.dp),
        properties = DialogProperties(usePlatformDefaultWidth = true),
        title = {},
        text = {
            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.Center
            ) {
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = "Send to",
                        style = WeThemes.typography.labelMedium,
                        color = MaterialTheme.colorScheme.primary
                    )
                    Text(
                        text = sendMoney.recipientPhoneNumber,
                        style = WeThemes.typography.labelMedium,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.height(10.dp))

                    Text(
                        text = "Amount",
                        style = WeThemes.typography.labelMedium,
                        color = LocalContentColor.current.copy(alpha = ContentAlpha.medium)
                    )
                    Text(
                        text = "Ksh${sendMoney.amount}",
                        style = WeThemes.typography.labelMedium,
                        fontWeight = FontWeight.Bold

                    )

                }

                Spacer(modifier = Modifier.height(16.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Button(
                        onClick = { onDismiss() },
                        modifier = Modifier.width(120.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = LocalContentColor.current.copy(alpha = ContentAlpha.medium),
                            contentColor = MaterialTheme.colorScheme.onBackground
                        )
                    ) {
                        Text(text = "CANCEL")

                    }
                    Spacer(modifier = Modifier.weight(1f))
                    Button(
                        onClick = {
                            onClickSend(sendMoney)
                        },
                        modifier = Modifier.width(120.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = MaterialTheme.colorScheme.primary,
                            contentColor = MaterialTheme.colorScheme.onBackground
                        )
                    ) {
                        Text(text = "SEND")
                    }
                }

            }
        },
        confirmButton = {},
        modifier = Modifier.fillMaxWidth()

    )

}

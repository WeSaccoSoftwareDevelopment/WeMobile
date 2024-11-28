package com.mobilewe.wemobile.presentation.screen.loans.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.mobilewe.wemobile.presentation.common.theme.WeThemes
import com.mobilewe.wemobile.resources.Resources


@Composable
fun LoanTextView(
    loanBalance: String,
    loanLimit: String,
    loanDueDate: String,
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight(),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.6F),
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column(
                    modifier = Modifier.padding(16.dp),
                    verticalArrangement = Arrangement.Center,
                ) {
                    Text(
                        text = Resources.strings.loan,
                        color = MaterialTheme.colorScheme.onSurface,
                        style = WeThemes.typography.labelSmall
                    )
                    Spacer(modifier = Modifier.height(12.dp))
                    Text(
                        text = Resources.strings.loanBalance,
                        style = WeThemes.typography.labelSmall
                    )
                    Spacer(modifier = Modifier.height(5.dp))

                    Text(
                        text = Resources.strings.limit,
                        style = WeThemes.typography.labelSmall
                    )
                    Spacer(modifier = Modifier.height(5.dp))

                    Text(
                        text = Resources.strings.dueDate,
                        style = WeThemes.typography.labelSmall
                    )
                    Spacer(modifier = Modifier.height(5.dp))

                }

                Spacer(modifier = Modifier.width(10.dp))

                Column(
                    modifier = Modifier.padding(16.dp),
                    verticalArrangement = Arrangement.Center,
                ) {
                    Text(
                        text = " ",
                        color = MaterialTheme.colorScheme.onSurface,
                        style = WeThemes.typography.labelSmall

                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = loanBalance,
                        style = WeThemes.typography.labelSmall
                    )
                    Spacer(modifier = Modifier.height(5.dp))
                    Text(
                        text = loanLimit,
                        style = WeThemes.typography.labelSmall

                    )
                    Spacer(modifier = Modifier.height(5.dp))

                    Text(
                        text = loanDueDate,
                        style = WeThemes.typography.labelSmall
                    )
                }


            }

        }

    }
}
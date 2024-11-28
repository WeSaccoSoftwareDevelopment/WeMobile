package com.mobilewe.wemobile.presentation.screen.loans.payLoan

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.mobilewe.wemobile.presentation.common.composables.AccountTypeDropDown
import com.mobilewe.wemobile.presentation.common.composables.LoanTypeDropDown
import com.mobilewe.wemobile.presentation.common.composables.button.ContinueButton
import com.mobilewe.wemobile.presentation.common.composables.textfield.RideOutlinedTextField
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import wemobile.composeapp.generated.resources.Res
import wemobile.composeapp.generated.resources.amount
import wemobile.composeapp.generated.resources.amount_support_text
import wemobile.composeapp.generated.resources.loan_icon


@Composable
fun PayLoans(
    expanded: Boolean,
    onExpandToggle: () -> Unit,
    amount: String,
    onAmountChanged:(String)-> Unit,
    accountTypeName: String,
    isLoading: Boolean
) {

    val extraPaddingValues by animateDpAsState(
        if (expanded) 24.dp else 0.dp,
        animationSpec = spring(
            dampingRatio = Spring.DampingRatioMediumBouncy,
            stiffness = Spring.StiffnessLow
        ),
        label = ""
    )

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(MutableInteractionSource(), null) {
                onExpandToggle()
            },
        elevation = CardDefaults.cardElevation(
            defaultElevation = 0.dp,
            pressedElevation = 0.dp,
            disabledElevation = 0.dp,
            draggedElevation = 0.dp
        ),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.6F),
        )
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(12.dp),
            contentAlignment = Alignment.Center
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable(MutableInteractionSource(), null) {
                        onExpandToggle()
                    }
                    .padding(bottom = extraPaddingValues.coerceAtLeast(0.dp)),
                verticalArrangement = Arrangement.Center
            ) {

                Row(
                    modifier = Modifier
                        .fillMaxSize(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(8.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            painter = painterResource(Res.drawable.loan_icon),
                            contentDescription = null,
                            modifier = Modifier.clickable(MutableInteractionSource(),null) {
                                onExpandToggle()
                            }
                        )
                        Text(
                            text = "Pay Loan",
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                    Icon(
                        if (expanded) Icons.Filled.KeyboardArrowUp else Icons.Filled.KeyboardArrowDown,
                        "contentDescription"
                    )
                }

                Spacer(modifier = Modifier.height(10.dp))
                AnimatedVisibility(visible = expanded) {
                    Column(
                        modifier = Modifier.fillMaxWidth(),
                        verticalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        AccountTypeDropDown(
                            value = accountTypeName,
                            isLoading = isLoading,
                            onValueChanged = {},
                            accountTypeList = emptyList()
                        )

                        LoanTypeDropDown(
                            value = accountTypeName,
                            isLoading = isLoading,
                            onValueChanged = {},
                            accountTypeList = emptyList()
                        )

                        RideOutlinedTextField(
                            value = amount,
                            onValueChange = onAmountChanged,
                            keyboardType = KeyboardType.Phone,
                            hint = stringResource(Res.string.amount),
                            supportText = stringResource(Res.string.amount_support_text)
                        )

                        ContinueButton(
                            text = "Continue",
                            onClick = { },
                            enable = true
                        )
                    }
                }

            }
        }

    }
}
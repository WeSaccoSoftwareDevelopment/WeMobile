package com.mobilewe.wemobile.presentation.common.composables

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.toSize


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoanTypeDropDown(
    modifier: Modifier = Modifier,
    value: String,
    onValueChanged: (String) -> Unit,
    accountTypeList: List<String>,
    label: String = "Choose Loan",
    isLoading: Boolean,
) {
    var expanded by remember { mutableStateOf(false) }
    var selected by remember { mutableStateOf(value) }
    var textFieldSize by remember { mutableStateOf(Size.Zero) }
    val interactionSource = remember { MutableInteractionSource() }

    val icon = if (expanded) Icons.Filled.KeyboardArrowUp else Icons.Filled.KeyboardArrowDown
    val borderColor =
        if (isLoading) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onBackground


    if (interactionSource.collectIsPressedAsState().value)
        expanded = !expanded

    Column(
        modifier = modifier
    ) {
        OutlinedTextField(
            value = value,
            onValueChange = onValueChanged,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 10.dp)
                .onGloballyPositioned { coordinates ->
                    textFieldSize = coordinates.size.toSize()
                },
            label = {
                Text(text = label, style = MaterialTheme.typography.bodyMedium)
            },
            trailingIcon = {
                Icon(
                    icon,
                    "Dropdown",
                    Modifier.clickable { expanded = !expanded },
                    tint = if (isLoading) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onBackground
                )
            },
            colors = TextFieldDefaults.colors(),
            readOnly = true,
            interactionSource = interactionSource
        )

        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = Modifier
                .width(with(LocalDensity.current) { textFieldSize.width.toDp() })
        ) {
            accountTypeList.forEach { countryCode ->
                DropdownMenuItem(
                    onClick = {
                        selected = countryCode
                        expanded = false
                        onValueChanged(countryCode)
                    },
                    text = {
                        Column {
                            Text(
                                modifier = Modifier.padding(vertical = 10.dp),
                                text = countryCode,
                                style = MaterialTheme.typography.bodySmall
                            )
                            Text(
                                modifier = Modifier.padding(vertical = 10.dp),
                                text = countryCode,
                                style = MaterialTheme.typography.bodySmall
                            )
                        }
                    },
                    interactionSource = interactionSource
                )
            }
        }

        if (isLoading)
            Text(
                modifier = Modifier.padding(vertical = 10.dp),
                text = "Filtering in Progress",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.primary
            )
    }
}



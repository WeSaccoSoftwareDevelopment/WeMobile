package com.mobilewe.wemobile.presentation.common.composables.textfield

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PhoneNumbersTextField(
    initialValue: String,
    onSearchParamChange: (searchParam: String) -> Unit,
    contacts: List<String> // Pass the list of contacts
) {
    var searchParam by remember { mutableStateOf(initialValue) }
    var filteredContacts by remember { mutableStateOf(listOf<String>()) }
    var isDropdownVisible by remember { mutableStateOf(false) }

    val focusRequester = remember { FocusRequester() }
    val focusManager = LocalFocusManager.current

    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.Start
    ) {
        Box(
            modifier = Modifier
                .padding(start = 20.dp, end = 20.dp, bottom = 4.dp)
                .background(colorScheme.onSurface.copy(alpha = .08F))
                .fillMaxWidth()
                .height(54.dp)
        ) {
            OutlinedTextField(
                value = searchParam,
                onValueChange = { newValue ->
                    searchParam = if (newValue.trim().isNotEmpty()) newValue else ""
                    onSearchParamChange(searchParam)
                    isDropdownVisible = searchParam.isNotEmpty()
                    filteredContacts =
                        contacts.filter { it.contains(searchParam, ignoreCase = true) }
                },
                modifier = Modifier
                    .fillMaxSize()
                    .focusRequester(focusRequester = focusRequester),
                singleLine = true,
                placeholder = {
                    Text(
                        text = "PhoneNumber",
                        color = colorScheme.onSurface.copy(alpha = .32F)
                    )
                },
                colors = ExposedDropdownMenuDefaults.textFieldColors(
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent
                ),
                keyboardOptions = KeyboardOptions(
                    autoCorrect = true,
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Search
                ),
                keyboardActions = KeyboardActions(
                    onSearch = {
                        onSearchParamChange(searchParam)
                        isDropdownVisible = false
                    }
                ),
                trailingIcon = {
                    Row {
                        AnimatedVisibility(visible = searchParam.trim().isNotEmpty()) {
                            IconButton(onClick = {
                                focusManager.clearFocus()
                                searchParam = ""
                                onSearchParamChange(searchParam)
                                isDropdownVisible = false
                            }) {
                                Icon(
                                    imageVector = Icons.Default.Clear,
                                    contentDescription = null
                                )
                            }
                        }
                        IconButton(onClick = {
                            onSearchParamChange(searchParam)
                            isDropdownVisible = false
                        }) {
                            Icon(
                                imageVector = Icons.Default.Search,
                                contentDescription = null
                            )
                        }
                    }
                }
            )
        }

        DropdownMenu(
            expanded = isDropdownVisible && filteredContacts.isNotEmpty(),
            onDismissRequest = { isDropdownVisible = false },
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White)
        ) {
            filteredContacts.forEach { contact ->
                DropdownMenuItem(
                    onClick = {
                        searchParam = contact
                        onSearchParamChange(contact)
                        isDropdownVisible = false
                        focusManager.clearFocus()
                    },
                    text = {
                        Text(text = contact)
                    }
                )
            }
        }
    }
}

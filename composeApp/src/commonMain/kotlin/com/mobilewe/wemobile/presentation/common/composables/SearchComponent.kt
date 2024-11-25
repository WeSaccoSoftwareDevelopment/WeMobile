package com.mobilewe.wemobile.presentation.common.composables


import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.platform.LocalTextInputService
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.mobilewe.wemobile.presentation.common.theme.WeThemes

data class SearchState(
    val query: String = ""
)
@Composable
fun SearchComponent(
    modifier: Modifier = Modifier,
    state: SearchState,
    text: String,
    focusState: Boolean,
    onSearch: (String) -> Unit,
    onTextFieldFocus: (Boolean) -> Unit,
    onClearButtonClicked: () -> Unit
) {

    val inputService  = LocalTextInputService.current
    val keyboardController = LocalSoftwareKeyboardController.current
    val focusManager = LocalFocusManager.current
    val focusRequester = remember {
        FocusRequester()
    }
    Surface(
        color = MaterialTheme.colorScheme.secondaryContainer,
        shape = RoundedCornerShape(10.dp),
        modifier = modifier.height(55.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    start = 10.dp
                ),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = "search icon",
                modifier = Modifier.size(
                    24.dp
                ),
                tint = MaterialTheme.colorScheme.onTertiary
            )

            TextField(
                value = state.query, onValueChange = { value ->
                    onSearch(value)
                },
                placeholder = {
                    Text(
                        text = text,
                        style = WeThemes.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                },
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.Transparent,
                    unfocusedContainerColor = Color.Transparent,
                    disabledContainerColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    disabledIndicatorColor = Color.Transparent,
                    cursorColor = MaterialTheme.colorScheme.inversePrimary
                ),
                modifier = Modifier
                    .weight(1f)
                    .focusRequester(focusRequester)
                    .onFocusChanged { state ->
                        onTextFieldFocus(state.hasFocus)
                        if (!state.isFocused) {
                            inputService?.hideSoftwareKeyboard()
                        }
                    },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                textStyle = WeThemes.typography.bodyMedium,
                maxLines = 1
            )

            if (state.query.isNotBlank()) {
                Spacer(modifier = Modifier.width(WeThemes.dimens.space10))

                IconButton(onClick = {
                    onClearButtonClicked()
                    focusManager.clearFocus()
                    keyboardController?.hide()
                }) {
                    Icon(
                        imageVector = Icons.Default.Close,
                        contentDescription = "close icon",
                        modifier = Modifier.size(
                            24.dp
                        ),
                        tint = MaterialTheme.colorScheme.onTertiary
                    )
                }
            }
        }
    }
}
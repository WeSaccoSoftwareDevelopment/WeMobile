package com.mobilewe.wemobile.presentation.screen.auth.phoneRegistration.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForwardIos
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.mobilewe.wemobile.presentation.common.composables.textfield.AppOutlinedTextField
import com.mobilewe.wemobile.presentation.screen.auth.country.getFlagEmojiFor
import com.mobilewe.wemobile.presentation.screen.auth.phoneRegistration.PhoneRegUiState
import com.mobilewe.wemobile.presentation.screen.auth.phoneRegistration.PhoneRegViewModel
import com.mobilewe.wemobile.utils.clickableWithoutRipple
import com.mobilewe.wemobile.utils.interactionSource


@Composable
fun CountryTextField(
    phoneRegUiState: PhoneRegUiState,
    viewModel: PhoneRegViewModel,
    onCountryClick: () -> Unit
) {
    AppOutlinedTextField(
        text = phoneRegUiState.countryFullName,
        onValueChange = viewModel::onCountryNameChanged,
        hint = "Select your country",
        label = "Country",
        leadingIconComponent = {
            Box(
                modifier = Modifier
                    .size(24.dp)
                    .clickableWithoutRipple(
                        interactionSource(), onClick = { onCountryClick() }
                    )
                    .clip(CircleShape),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = getFlagEmojiFor(phoneRegUiState.countryNameCode),
                    overflow = TextOverflow.Clip,
                    modifier = Modifier.size(24.dp)
                )
            }
        },
        trailingIcon = {
            Icon(
                imageVector = Icons.Filled.ArrowForwardIos,
                contentDescription = null,
                modifier = Modifier.clickableWithoutRipple(
                    interactionSource(), onClick = { onCountryClick() }
                )
            )
        },
        readOnly = true
    )
}
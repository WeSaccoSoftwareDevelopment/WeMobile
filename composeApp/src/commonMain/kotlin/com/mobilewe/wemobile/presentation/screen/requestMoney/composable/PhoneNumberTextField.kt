package com.mobilewe.wemobile.presentation.screen.requestMoney.composable

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.ContentAlpha
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalContentColor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.mobilewe.wemobile.presentation.common.composables.textfield.RideOutlinedTextField
import com.mobilewe.wemobile.utils.clickableWithoutRipple


@Composable
fun PhoneNumberTextField(
    phoneNumber: String,
    onPhoneNumberChanged: (String) -> Unit,
    onClickTrailingIcon: () -> Unit
) {

    RideOutlinedTextField(
            value = phoneNumber,
            onValueChange = { onPhoneNumberChanged(it) },
            keyboardType = KeyboardType.Phone,
            hint = "stringResource(id = R.string.phoneNumber)",
            trailingIcon = {
                Icon(
                    imageVector = Icons.Outlined.Search,
                    contentDescription = "Call",
                    tint = LocalContentColor.current.copy(alpha = ContentAlpha.medium),
                    modifier = Modifier
                        .padding(8.dp)
                        .size(24.dp)
                        .clickableWithoutRipple(
                            onClick = {
//                                if (permissionState.status.isGranted) {
//                                    onClickTrailingIcon()
//                                } else {
//                                    permissionState.launchPermissionRequest()
//                                }
                            }
                        )

                )
            },
        )
}
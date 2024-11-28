package com.mobilewe.wemobile.presentation.screen.payWithSacco.paybill.component

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
import org.jetbrains.compose.resources.stringResource
import wemobile.composeapp.generated.resources.Res
import wemobile.composeapp.generated.resources.businessNumber

@Composable
fun BusinessNumberTextField(
    modifier: Modifier = Modifier,
    businessNumber: String,
    businessName: String,
    error: String = "",
    isBusinessNoError: Boolean = false,
    onBusinessNumberChanged:(String)->Unit,
    onClickTrailingIcon:()->Unit
) {
    RideOutlinedTextField(
        value = businessNumber,
        onValueChange = onBusinessNumberChanged,
        keyboardType = KeyboardType.Phone,
        hint = stringResource(Res.string.businessNumber),
        supportText = businessName,
        trailingIcon = {
            Icon(
                imageVector = Icons.Outlined.Search,
                contentDescription = "Search",
                modifier = Modifier.padding(8.dp).size(24.dp)
                    .clickableWithoutRipple { onClickTrailingIcon() },
                tint = LocalContentColor.current.copy(alpha = ContentAlpha.medium)
            )
        },
        error = error,
        isError = isBusinessNoError
    )

}
package com.mobilewe.wemobile.presentation.screen.account.account.composable

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.mobilewe.wemobile.presentation.common.theme.WeThemes
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource


data class SwitchState(
    val isChecked: Boolean = false
)
@Composable
fun DarkModeItem(
    modifier: Modifier = Modifier,
    icon: DrawableResource,
    title: String,
    onState: () -> SwitchState,
    onCheckChange: (Boolean) -> Unit
) {

    Surface(
        shape = RoundedCornerShape(WeThemes.dimens.space10),
        color = MaterialTheme.colorScheme.background,
        modifier = modifier
    ) {

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(
                horizontal = WeThemes.dimens.space10,
                vertical = WeThemes.dimens.space10
            )
        ) {
            Icon(
                painter = painterResource(icon),
                contentDescription = null,
                modifier = Modifier.size(20.dp),
                tint = MaterialTheme.colorScheme.onBackground
            )

            Text(
                text = title, style = WeThemes.typography.titleMedium,
                color = MaterialTheme.colorScheme.onBackground,
                modifier = Modifier
                    .padding(horizontal = WeThemes.dimens.space16)
                    .weight(1f)
            )

            Switch(
                checked = onState().isChecked,
                onCheckedChange = { isChecked -> onCheckChange(isChecked) },
                colors = SwitchDefaults.colors(
                    uncheckedThumbColor = MaterialTheme.colorScheme.secondaryContainer,
//                    checkedThumbColor = MaterialTheme.colorScheme.onPrimary,
                    checkedTrackColor = MaterialTheme.colorScheme.primary,
                    checkedBorderColor = MaterialTheme.colorScheme.onPrimary
                )
            )

        }

    }

}
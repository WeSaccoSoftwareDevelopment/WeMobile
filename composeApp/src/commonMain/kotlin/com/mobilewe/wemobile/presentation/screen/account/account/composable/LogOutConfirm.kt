package com.mobilewe.wemobile.presentation.screen.account.account.composable

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.SheetState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import com.mobilewe.wemobile.presentation.common.composables.button.TwoButtons
import com.mobilewe.wemobile.presentation.common.theme.WeThemes


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LogoutConfirmationBottomSheet(
    modifier: Modifier = Modifier,
    cornerRadius: Dp = WeThemes.dimens.space20,
    bottomSheetState: SheetState,
    onDismiss: () -> Unit,
    onLogout: (Boolean) -> Unit,
    onCancel: () -> Unit
) {

    ModalBottomSheet(
        onDismissRequest = { onDismiss() },
        shape = RoundedCornerShape(topStart = cornerRadius, topEnd = cornerRadius),
        sheetState = bottomSheetState,
        modifier = modifier
    ) {

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(WeThemes.dimens.space16)
                .fillMaxWidth(),
        ) {

            Text(text = "stringResource(id = R.string.logout)",
                style = WeThemes.typography.titleLarge,
                color = Color.Red)

            Spacer(modifier = Modifier.height(WeThemes.dimens.space20))
            Divider(color = MaterialTheme.colorScheme.inversePrimary)
            Spacer(modifier = Modifier.height(WeThemes.dimens.space20))

            Text(text = "Are you sure you want to logout?",
                style = WeThemes.typography.titleMedium,
                color =MaterialTheme.colorScheme.onBackground,
                textAlign = TextAlign.Center)

            Spacer(modifier = Modifier.height(WeThemes.dimens.space20))

            TwoButtons(
                leftButtonText = "stringResource(R.string.cancel)",
                rightButtonText = "stringResource(R.string.yes_logout)",
                onLeftButtonClick = { onCancel() },
                onRightButtonClick = { onLogout(true) })

        }
    }

}
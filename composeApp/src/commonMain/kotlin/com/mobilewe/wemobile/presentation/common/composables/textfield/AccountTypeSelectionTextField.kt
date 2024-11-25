package com.mobilewe.wemobile.presentation.common.composables.textfield

import androidx.compose.foundation.clickable
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForwardIos
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.SheetState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.mobilewe.wemobile.domain.model.AccountType
import com.mobilewe.wemobile.presentation.common.composables.AccountSelectionModalBottomSheet

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AccountTypeSelectionTextField(
    modifier: Modifier = Modifier,
    accountTypeName: String,
    onAccountTypeNameChanged:(String)->Unit,
    isSheetOpen: Boolean = false,
    sheetState: SheetState,
    onClickTrailingIcon:()->Unit = {},
    onDisMissRequest:()-> Unit,
    accountList: List<AccountType>
) {

    AccounTextField(
        text = accountTypeName,
        onValuedChanged = onAccountTypeNameChanged,
        label = "Selected Account",
        onClickTrailingIcon = onClickTrailingIcon,
    )
    AccountSelectionModalBottomSheet(
        isSheetOpen = isSheetOpen,
        onDismissRequest = onDisMissRequest,
        sheetState = sheetState,
        onSelectedAccountTypeName = onAccountTypeNameChanged,
        accountList = accountList
    )

}

@Composable
private fun AccounTextField(
    text: String,
    onClickTrailingIcon: () -> Unit,
    onValuedChanged: (String)->Unit,
    hint: String = "",
    label: String = ""
) {
    AppOutlinedTextField(
        text = text,
        onValueChange = onValuedChanged,
        hint = hint,
        label = label,
        trailingIcon = {
            Icon(
                imageVector = Icons.AutoMirrored.Filled.ArrowForwardIos,
                contentDescription = null,
                modifier = Modifier.clickable { onClickTrailingIcon() }
            )
        },
        readOnly = true
    )
}
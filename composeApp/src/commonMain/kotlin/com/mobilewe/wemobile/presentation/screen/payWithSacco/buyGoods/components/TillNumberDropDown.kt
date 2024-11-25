package com.mobilewe.wemobile.presentation.screen.payWithSacco.buyGoods.components


import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.toSize
import com.mobilewe.wemobile.domain.model.getTillNumber
import com.mobilewe.wemobile.presentation.common.composables.textfield.RideOutlinedTextField
import com.mobilewe.wemobile.presentation.screen.payWithSacco.buyGoods.BuyGoodsUIState
import com.mobilewe.wemobile.utils.getInitials

@Composable
fun TillNumberDropDown(
    state: BuyGoodsUIState,
    onTillNumberChanged: (String) -> Unit,
    onTillNameChanged: (String) -> Unit
) {
    val buyGoods = getTillNumber()
    var textfieldSize by remember { mutableStateOf(Size.Zero) }
    var expanded by remember { mutableStateOf(false) }
    val icon = if (expanded) Icons.Filled.KeyboardArrowUp else Icons.Filled.KeyboardArrowDown
    val focusRequester = remember { FocusRequester() }

    Column(modifier = Modifier.fillMaxWidth()) {
        RideOutlinedTextField(
            value = state.tillNumber,
            onValueChange = { onTillNumberChanged(it) },
            hint = "stringResource(id = R.string.tillNumber)",
            keyboardType = KeyboardType.Phone,
            trailingIcon = {
                Icon(
                    icon,
                    "contentDescription",
                    Modifier.clickable { expanded = !expanded }
                )
            },
            modifier = Modifier.fillMaxWidth()
                .focusRequester(focusRequester)
                .onGloballyPositioned { coordinates ->
                    textfieldSize = coordinates.size.toSize()
                },
            supportText = state.tillName,
        )
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = Modifier
                .width(with(LocalDensity.current) { textfieldSize.width.toDp() }),
        ) {
            buyGoods.forEach { item ->
                DropdownMenuItem(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                        .align(Alignment.CenterHorizontally),
                    text = { Text(text = item.tillName) },
                    onClick = {
                        onTillNumberChanged(item.tillNumber)
                        item.tillName.let { onTillNameChanged(it) }
                        expanded = false
                    },
                    leadingIcon = {
                        val buyGoodsInitials = item.tillName
                        Box(
                            modifier = Modifier
                                .size(40.dp)
                                .clip(CircleShape),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = getInitials(buyGoodsInitials),
                                fontWeight = FontWeight.Normal,
                                textAlign = TextAlign.Center,
                                fontSize = 26.sp
                            )
                        }
                    }
                )
            }
        }
    }

}
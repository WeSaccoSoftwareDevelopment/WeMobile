package com.mobilewe.wemobile.presentation.screen.account.account.composable

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.SheetState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.mobilewe.wemobile.presentation.common.theme.PrimaryColor
import com.mobilewe.wemobile.presentation.common.theme.WeThemes
import kotlinx.coroutines.CoroutineScope
import org.jetbrains.compose.resources.painterResource
import wemobile.composeapp.generated.resources.Res
import wemobile.composeapp.generated.resources.*


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun QRCodeBottomSheet(
    coroutineScope: CoroutineScope,
    bottomSheetState: SheetState,
    isFullScreen: Boolean,
    cornerRadius: Dp,
    modifier: Modifier = Modifier,
    onDismiss: () -> Unit
) {

    val mf = if (isFullScreen)
        modifier.fillMaxSize()
    else modifier.fillMaxWidth()

    ModalBottomSheet(
        onDismissRequest = { onDismiss() },
        shape = RoundedCornerShape(topStart = cornerRadius, topEnd = cornerRadius),
        sheetState = bottomSheetState
    ) {

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = mf.padding(WeThemes.dimens.space16),

            ) {

            Text(
                text = "My QR Code",
                style = WeThemes.typography.titleMedium,
            )

            Spacer(modifier = Modifier.height(10.dp))

            Column(
                modifier = Modifier
                    .padding(WeThemes.dimens.space10)
                    .background(Color.White, RoundedCornerShape(WeThemes.dimens.space20)),
            ) {

                Spacer(modifier = Modifier.height(15.dp))

                Image(
                    painter = painterResource(Res.drawable.qr_code_2), contentDescription =
                    "qr code",
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp)
                )

                Spacer(modifier = Modifier.height(15.dp))
            }

//            Spacer(modifier = Modifier.height(10.dp))

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(10.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        start = 16.dp,
                        end = 16.dp,
                        top = 16.dp,
                        bottom = 20.dp
                    )
            ) {
                OutlinedButton(
                    onClick = { },
                    modifier = Modifier
                        .weight(1f)
                        .height(50.dp),
                    border = BorderStroke(1.dp, PrimaryColor)
                ) {
                    Text(
                        text = "stringResource(R.string.save)",
                        style = WeThemes.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onBackground
                    )
                }


                Button(
                    onClick = {
//                        coroutineScope.launch {
//                            bottomSheetState.hide()
//                        }
                    },
                    modifier = Modifier
                        .weight(1f)
                        .height(50.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = PrimaryColor
                    )
                ) {
                    Text(
                        text = "stringResource(R.string.share)",
                        style = WeThemes.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onBackground
                    )
                }
            }

        }

    }


}

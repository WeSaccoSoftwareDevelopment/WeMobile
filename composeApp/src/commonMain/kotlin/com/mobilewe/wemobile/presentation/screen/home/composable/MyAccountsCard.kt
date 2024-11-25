package com.mobilewe.wemobile.presentation.screen.home.composable



import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.mobilewe.wemobile.presentation.common.composables.card.StandardCard
import com.mobilewe.wemobile.utils.clickableWithoutRipple
import com.mobilewe.wemobile.utils.interactionSource
import org.jetbrains.compose.resources.painterResource
import wemobile.composeapp.generated.resources.Res
import wemobile.composeapp.generated.resources.ic_account_circle

@Composable

fun MyAccountsCard(
    navigator: NavController
) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {

        StandardCard(
            modifier = Modifier
                .fillMaxWidth()
                .height(120.dp)
                .clickableWithoutRipple(interactionSource()) {
//                    navigator.openMyAccountScreen()
                }
        ) {
            Column{
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Stephen Chacha Marwa",
                        maxLines = 1,
                        fontSize = 14.sp,
                        color = MaterialTheme.colorScheme.onBackground
                    )
                    Image(
                        painter = painterResource(Res.drawable.ic_account_circle),
                        contentDescription = null,
                        modifier = Modifier
                            .size(20.dp),
                        colorFilter = ColorFilter.tint(color = MaterialTheme.colorScheme.onBackground)
                    )

                }
                Text(
                    text = "80.55KES",
                    fontWeight = FontWeight.Bold,
                    fontSize = 22.sp
                )
            }
            Spacer(modifier = Modifier.weight(1f))
            TextButton(
                onClick = { /*TODO*/ },
                colors = ButtonDefaults.textButtonColors(
                    containerColor =Color.Transparent,
                )
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(2.dp)
                ) {
                    Text(
                        text = "0123456789",
                    )
                    Box(
                        modifier = Modifier
                            .size(5.dp)
                            .clip(CircleShape)
                            .background(Color.White)
                            .align(Alignment.CenterVertically)
                            .padding(horizontal = 2.dp)
                    )
                    Text(
                        text = "Saving",

                    )
                }
            }

        }
    }

}
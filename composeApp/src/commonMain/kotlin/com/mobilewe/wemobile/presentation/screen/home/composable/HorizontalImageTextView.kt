package com.mobilewe.wemobile.presentation.screen.home.composable


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource

@Composable
fun HorizontalImageTextView(
    drawable: DrawableResource,
    greetings: String,
    modifier: Modifier = Modifier,
    textStyle: TextStyle,
    userName: String = "Stephen"
) {
    Row(
        horizontalArrangement = Arrangement.Start,
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = painterResource(drawable),
            contentDescription = null,
            modifier = Modifier
                .size(48.dp)
                .clip(CircleShape)
                .align(Alignment.CenterVertically),
        )
        Column (
            modifier = Modifier
                .padding(start = 13.dp)
                .align(Alignment.CenterVertically)
        ){
            Text(
                text = greetings,
                style = textStyle,
                fontSize = 14.sp
            )
            Text(
                text = userName.uppercase(),
                style = textStyle,
                fontSize = 14.sp
            )
        }


    }
}
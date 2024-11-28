package com.mobilewe.wemobile.presentation.screen.home.composable


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.mobilewe.wemobile.presentation.common.theme.WeThemes
import com.mobilewe.wemobile.resources.Resources
import org.jetbrains.compose.resources.painterResource
import wemobile.composeapp.generated.resources.Res
import wemobile.composeapp.generated.resources.outline_account_circle
import wemobile.composeapp.generated.resources.sacco_logo


@Composable
fun HomeTopBar(greetings: String = "") {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.background)
            .padding(all = 13.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        HorizontalImageTextView(
            drawable = Res.drawable.outline_account_circle,
            greetings = greetings,
            modifier = Modifier.weight(1f),
            WeThemes.typography.headlineMedium
        )
        Spacer(modifier = Modifier.width(10.dp))

        Image(
            painter = painterResource(Res.drawable.sacco_logo),
            contentDescription = null,
            modifier = Modifier
                .align(Alignment.CenterVertically)
                .size(30.dp),
        )
    }
}
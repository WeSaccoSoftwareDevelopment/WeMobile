package com.mobilewe.wemobile.presentation.screen.account.help

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.mobilewe.wemobile.presentation.common.composables.card.MoreVerticalItem
import com.mobilewe.wemobile.presentation.common.theme.WeThemes
import wemobile.composeapp.generated.resources.Res
import wemobile.composeapp.generated.resources.devices_24
import wemobile.composeapp.generated.resources.ic__facebook
import wemobile.composeapp.generated.resources.ic__linkedin
import wemobile.composeapp.generated.resources.outline_mail_outline_24
import wemobile.composeapp.generated.resources.twitter
import wemobile.composeapp.generated.resources.website


@Composable
fun SupportScreen(navigator: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = WeThemes.dimens.space20)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(WeThemes.dimens.space16)
    ) {

        MoreVerticalItem(
            title = "R.string.contact_us",
            drawable = Res.drawable.devices_24,
            subtitle = "R.string.wesacco_contact"
        )
        MoreVerticalItem(
            title = "R.string.email_us",
            drawable = Res.drawable.outline_mail_outline_24,
            subtitle = "R.string.wesacco_email"
        )

        MoreVerticalItem(
            title = "R.string.website",
            drawable = Res.drawable.website,
            subtitle = "R.string.wesacco_website"
        )

        MoreVerticalItem(
            title = "R.string.twitter",
            drawable = Res.drawable.twitter,
            subtitle = "R.string.wessacco_twitter",
            showColorFilter = false
        )

        MoreVerticalItem(
            title = "R.string.facebook",
            drawable = Res.drawable.ic__facebook,
            subtitle = "R.string.wessacco_facebook",
            showColorFilter = false
        )
        MoreVerticalItem(
            title = "R.string.linkedin",
            drawable = Res.drawable.ic__linkedin,
            subtitle = "R.string.wessacco_linkedin",
            showColorFilter = false
        )


    }
}

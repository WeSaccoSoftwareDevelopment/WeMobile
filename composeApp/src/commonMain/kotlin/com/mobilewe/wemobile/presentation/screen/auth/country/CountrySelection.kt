package com.mobilewe.wemobile.presentation.screen.auth.country

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.mobilewe.wemobile.presentation.common.theme.WeThemes
import com.mobilewe.wemobile.utils.clickableWithoutRipple
import org.jetbrains.compose.resources.painterResource
import wemobile.composeapp.generated.resources.Res
import wemobile.composeapp.generated.resources.cd
import wemobile.composeapp.generated.resources.ke
import wemobile.composeapp.generated.resources.rw
import wemobile.composeapp.generated.resources.ss
import wemobile.composeapp.generated.resources.tz
import wemobile.composeapp.generated.resources.ug


@Composable
fun CountrySelectionListItems(
    country: Country,
    selectedCountry: Boolean = false,
    onCountrySelected: (Country) -> Unit
) {
    Column(
        modifier = Modifier.fillMaxWidth().padding(8.dp).clickableWithoutRipple {onCountrySelected(country)},
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier.fillMaxWidth().padding(horizontal = 12.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {

            Box(
                modifier = Modifier
                    .size(48.dp)
                    .background(Color.Transparent, CircleShape)
                    .clip(CircleShape)
            ){
                Image(
                    contentDescription = country.fullName,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize(),
                    painter = painterResource(
                        when (country.nameCode) {
                            "cd" -> Res.drawable.cd
                            "ke" -> Res.drawable.ke
                            "rw" -> Res.drawable.rw
                            "ss" -> Res.drawable.ss
                            "tz" -> Res.drawable.tz
                            "ug" -> Res.drawable.ug
                            else -> Res.drawable.ke // A placeholder image
                        }
                    )
                )

            }

            Text(
                text = country.fullName,
                style = WeThemes.typography.titleSmall,
                modifier = Modifier.padding(end = 8.dp),
                overflow = TextOverflow.Clip,
                color = MaterialTheme.colorScheme.onBackground
            )
            Spacer(modifier = Modifier.weight(1f))
            RadioButton(
                selected = selectedCountry,
                onClick = { onCountrySelected(country) },
                colors = RadioButtonDefaults.colors(
                    selectedColor = MaterialTheme.colorScheme.primary
                )
            )
        }
        Spacer(modifier = Modifier.height(8.dp))
        HorizontalDivider(
            modifier = Modifier.fillMaxWidth().padding(start = 56.dp, end = 16.dp),
            thickness = 1.dp
        )
    }
}

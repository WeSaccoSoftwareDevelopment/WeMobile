package com.mobilewe.wemobile.utils


import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.graphics.Color
import kotlin.random.Random


@Composable
fun Modifier.clickableWithoutRipple(
    interactionSource: MutableInteractionSource = interactionSource(),
    onClick:()->Unit
) = composed(
    factory = {
        this.then(
            Modifier.clickable(
                interactionSource = interactionSource,
                indication = null,
                onClick = {onClick()}
            )
        )
    }
)


@Composable
fun interactionSource() = remember {
    MutableInteractionSource()
}
fun getInitials(name: String): String {
    val names = name.split(" ")
    val initials = if (names.size >= 2) {
        names[0].trim().first().toString().trim() + names[1].trim().first().toString().trim()
    } else {
        names[0].trim().first().toString().trim()
    }
    return initials.uppercase()
}




fun formatContact(contact: String): String {
    val formattedContact: String =when {
        contact.startsWith("254") -> {
            val prefix = contact.substring(0, 6)
            val lastThreeDigits = contact.substring(contact.length - 3)
            "$prefix***$lastThreeDigits"
        }
        contact.startsWith("07") -> {
            val prefix = contact.substring(0, 4)
            val lastThreeDigits = contact.substring(contact.length - 3)
            "$prefix***$lastThreeDigits"
        }
        contact.startsWith("+254") -> {
            val prefix = contact.substring(0, 7)
            val lastThreeDigits = contact.substring(contact.length - 3)
            "$prefix***$lastThreeDigits"
        }
        contact.startsWith("01") -> {
            val prefix = contact.substring(0, 4)
            val lastThreeDigits = contact.substring(contact.length - 3)
            "$prefix***$lastThreeDigits"
        }

        else -> contact
    }
    return formattedContact
}


fun randomColor(): Color {
    val red = Random.nextInt(256)
    val green = Random.nextInt(256)
    val blue = Random.nextInt(256)
    return Color(red, green, blue)
}











package com.mobilewe.wemobile.presentation.screen.account.help.composable

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mobilewe.wemobile.presentation.common.theme.WeThemes
import org.jetbrains.compose.resources.painterResource
import wemobile.composeapp.generated.resources.Res
import wemobile.composeapp.generated.resources.chevron_down
import wemobile.composeapp.generated.resources.chevron_up


@Composable
fun FaqItem(modifier: Modifier = Modifier, faq: Faq, onFaqClick: (Faq) -> Unit) {

    var expanded by rememberSaveable {
        mutableStateOf(false)
    }
    val interaction = remember {
        MutableInteractionSource()
    }

    Surface(
        shape = RoundedCornerShape(10.dp),
        modifier = modifier,
        onClick = {
            onFaqClick(faq)
            expanded = !expanded
        },
        color = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.6F),
    ) {

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = WeThemes.dimens.space16, vertical = WeThemes.dimens.space10),
            verticalArrangement = Arrangement.Center
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,

            ) {
                Text(
                    text = faq.title,
                    modifier = Modifier
                        .weight(1f)
                        ,
                    style = WeThemes.typography.titleSmall,
                    color = MaterialTheme.colorScheme.onBackground,
                    fontSize = 14.sp
                )

                IconButton(onClick = { expanded = !expanded }) {
                    if (expanded)
                        Icon(
                            painter = painterResource(Res.drawable.chevron_up),
                            contentDescription = "up icon",
                            modifier = Modifier.size(WeThemes.dimens.space20),
                        )
                    else
                        Icon(
                            painter = painterResource(Res.drawable.chevron_down),
                            contentDescription = "up icon",
                            modifier = Modifier.size(WeThemes.dimens.space20),
                        )
                }
            }

            if (expanded) {
                AnimatedVisibility(
                    visible = expanded,
                    enter = slideInVertically(initialOffsetY = { it },
                        animationSpec = tween(3_000)
                    ),
                    exit = slideOutVertically(targetOffsetY = { it },
                        animationSpec = tween(3_000))
                ) {

                    Column(modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = WeThemes.dimens.space16)) {
                        Divider(color = MaterialTheme.colorScheme.inverseSurface)
                        Spacer(modifier = Modifier.height(WeThemes.dimens.space10))

                        Text(
                            text = faq.content,
                            style = WeThemes.typography.bodySmall,
                            color = MaterialTheme.colorScheme.onBackground
                        )
                    }

                }
            }
        }

    }
}

data class Faq(
    val title: String,
    val content: String,
)

val faqs = listOf(
    Faq(title = "What is WeSacco?", content  = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam"),
    Faq(title = "How do I set up my account?", content  = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam"),
    Faq(title = "How long does a transfer take?", content  = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam"),
    Faq(title = "Are there any fees?", content  = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam"),
    Faq(title = "How do I request money?", content  = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam"),
    Faq(title = "Can I transfer money globally?", content  = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam"),
    Faq(title = "How can I reverse a transaction?", content  = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam"),
)
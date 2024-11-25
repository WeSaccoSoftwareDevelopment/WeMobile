package com.mobilewe.wemobile.presentation.screen.onboarding.component

import com.mobilewe.wemobile.resources.DrawableResources
import org.jetbrains.compose.resources.DrawableResource
import wemobile.composeapp.generated.resources.Res
import wemobile.composeapp.generated.resources.allStringResources
import wemobile.composeapp.generated.resources.ic_edit
import wemobile.composeapp.generated.resources.info


sealed class OnBoardingPage(
    val image: DrawableResource,
    val title: String,
    val description: String
) {
    object First: OnBoardingPage(
        image = Res.drawable.info,
        title = "Lend,Save,Spend,Send and Pay Bills with Ease!",
        description = "Our app is designed to help you manage your money with ease, so sign up now and start taking control of your financial future!"
    )
    object Second: OnBoardingPage(
        image = Res.drawable.info,
        title = "Manage Your Money Better with Our Finance App!",
        description = "Welcome to our finance app! Our powerful yet easy-to-use platform is designed to help you take control of your finances and make informed decisions."
    )
    object Third: OnBoardingPage(
        image = Res.drawable.ic_edit,
        title = "Msaidizi Wako Binafsi wa Kikundi cha Sacco ",
        description = "App yetu ni kama kuwa na msaidizi binafsi wa kikundi cha Sacco, kwenye kifaa chako cha mkononi. Kwa huduma zetu zenye nguvu, utaweza kudhibiti pesa zako kwa urahisi."
    )
}
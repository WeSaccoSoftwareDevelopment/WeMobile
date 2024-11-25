package com.mobilewe.wemobile.presentation.common.navigation

import kotlinx.serialization.Serializable

sealed interface Route {

    @Serializable
    data object AuthGraph: Route

    @Serializable
    data object Onboarding: Route

    @Serializable
    data object Welcome: Route

    @Serializable
    data object ForgotPassword: Route

    @Serializable
    data object Login: Route

    @Serializable
    data object PhoneRegister: Route

    @Serializable
    data object RegisterDetails: Route

    @Serializable
    data object RegistrationSubmit: Route

    @Serializable
    data object PickLanguauge: Route

    @Serializable
    data object Verification: Route

    @Serializable
    data object Home: Route

    @Serializable
    data object Transact:  Route


    @Serializable
    data object Discover: Route


    @Serializable
    data object Account: Route

    @Serializable
    data object BookList: Route

    @Serializable
    data class BookDetail(val id: String): Route
}

const val HOME = "home"
const val TRANSACT = "transact"
const val DISCOVER = "discover"
const val ACCOUNTS = "account"
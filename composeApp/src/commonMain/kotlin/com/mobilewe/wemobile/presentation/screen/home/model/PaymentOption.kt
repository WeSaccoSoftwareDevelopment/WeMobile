package com.mobilewe.wemobile.presentation.screen.home.model

import org.jetbrains.compose.resources.DrawableResource


data class PaymentOption(
    val name: String,
    val category: String,
    val icon: String? = null,
    val onNavigate: () -> Unit = {},
)

data class HomeItem(
    val icon: DrawableResource,
    val title: String,
    val description: String? = null,
    val onNavigate: () -> Unit = {}
)
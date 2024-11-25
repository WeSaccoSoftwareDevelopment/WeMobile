package com.mobilewe.wemobile.presentation.screen.account.notificationSettings

data class NotificationSettingsState(
    var statusUpdate: Boolean = false,
    var fraudAlert: Boolean = false,
    var paymentRequest: Boolean = false,
    var cardActivity: Boolean = false,
    var supportNotifications: Boolean = false,
    var accountBalance: Boolean = false,
    var securityAlert: Boolean = false,
    var dailyWeeklySummary: Boolean = false,
    var appUpdates: Boolean = false,
    var promotionalOffers: Boolean = false,
    var survey: Boolean = false,
)
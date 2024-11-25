package com.mobilewe.wemobile.domain.model


data class SMSMessage(
    val smsId: String?,
    val message: String,
    val sender: String,
    val date: String,
    val time: String,
    val service: String
)




//
//fun Long.parsedDate(): String {
//    val date = Date(this)
//    val format = SimpleDateFormat("dd-MMM-yyyy", Locale.getDefault())
//    return format.format(date)
//
//}
//
//fun Long.parsedTime(): String {
//    val time = Date(this)
//    val timeFormat = SimpleDateFormat("HH:mm:ss", Locale.getDefault())
//    return timeFormat.format(time)
//}
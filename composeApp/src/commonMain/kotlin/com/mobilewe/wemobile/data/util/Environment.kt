package com.mobilewe.wemobile.data.util

sealed class Environment(val url: String) {
    data object Main : Environment("https://saccomanagementapis-blve76r2vq-uc.a.run.app/api/Authentication/")
//    object Main : Environment("https://api-uat.equitygroupholdings.com/noncustomer/")
}

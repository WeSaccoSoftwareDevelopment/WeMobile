package com.mobilewe.wemobile

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform
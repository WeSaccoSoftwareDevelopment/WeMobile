package com.mobilewe.wemobile.utils

import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.engine.darwin.Darwin

actual fun getClientEngine(): HttpClientEngine = Darwin.create()
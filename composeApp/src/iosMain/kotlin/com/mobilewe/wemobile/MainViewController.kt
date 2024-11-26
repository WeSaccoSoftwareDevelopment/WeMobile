package com.mobilewe.wemobile

import androidx.compose.ui.window.ComposeUIViewController
import com.mobilewe.wemobile.app.App
import com.mobilewe.wemobile.utils.initKoin


fun MainViewController() = ComposeUIViewController(
    configure = {
        initKoin()
    }
) { App() }
package com.mobilewe.wemobile.utils

import com.mobilewe.wemobile.di.appModule
import org.koin.core.context.startKoin
import org.koin.dsl.KoinAppDeclaration

fun initKoin(config: KoinAppDeclaration? = null) {
    startKoin {
        config?.invoke(this)
        modules(appModule(), platformModule)
    }
}

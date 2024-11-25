package com.mobilewe.wemobile.di

import org.koin.dsl.module

fun appModule() = module {
    includes(
        networkModule,
        localModule,
        gatewayModule,
        environmentModule,
        useCaseModule,
        screenViewModel
    )
}
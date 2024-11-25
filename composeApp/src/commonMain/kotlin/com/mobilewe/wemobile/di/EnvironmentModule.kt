package com.mobilewe.wemobile.di

import com.mobilewe.wemobile.data.util.Environment
import org.koin.dsl.module

val environmentModule = module {
    single<Environment> { Environment.Main }
}


package com.mobilewe.wemobile.di

import androidx.sqlite.driver.bundled.BundledSQLiteDriver

import com.mobilewe.wemobile.data.db.AppDatabase
import com.mobilewe.wemobile.data.db.DatabaseFactory
import org.koin.dsl.module

val localModule = module {
    single {
        get<DatabaseFactory>().create()
            .setDriver(BundledSQLiteDriver())
            .build()
    }
    single { get<AppDatabase>().paybillDao}
    single { get<AppDatabase>().merchantDao}
    single { get<AppDatabase>().accountDao}
    single { get<AppDatabase>().userConfigurationDao}

}
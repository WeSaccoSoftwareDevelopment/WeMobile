package com.mobilewe.wemobile

import android.app.Application
import com.mobilewe.wemobile.di.appModule
import com.mobilewe.wemobile.di.locationDataSourceModule
import com.mobilewe.wemobile.di.locationServiceModule
import com.mobilewe.wemobile.di.locationTrackerModule
import com.mobilewe.wemobile.utils.initKoin
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin
import org.koin.core.logger.Level


class WeApp : Application() {
    override fun onCreate() {
        super.onCreate()
        initKoin {
            androidContext(this@WeApp.applicationContext).modules(
                locationTrackerModule,
                locationServiceModule,
                locationDataSourceModule,
            )
        }
    }
}
package com.mobilewe.wemobile.di

import com.mobilewe.wemobile.data.gateway.service.ILocationService
import com.mobilewe.wemobile.data.gateway.local.LocationGateway
import com.mobilewe.wemobile.domain.gateway.local.ILocationGateway
import com.mobilewe.wemobile.location.LocationService
import dev.icerock.moko.geo.LocationTracker
import dev.icerock.moko.permissions.PermissionsController
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val locationDataSourceModule = module {
    single<ILocationGateway> { LocationGateway(get(), get()) }
}

val locationTrackerModule = module {
    single {
        LocationTracker(PermissionsController(applicationContext = androidContext().applicationContext))
    }
}
val locationServiceModule = module {
    single<ILocationService> {  LocationService(androidContext().applicationContext) }
}
package com.mobilewe.wemobile.utils

import com.mobilewe.wemobile.LocationService
import com.mobilewe.wemobile.data.db.DatabaseFactory
import com.mobilewe.wemobile.data.gateway.local.LocationGateway
import com.mobilewe.wemobile.data.gateway.service.ILocationService
import com.mobilewe.wemobile.domain.gateway.local.ILocationGateway
import dev.icerock.moko.geo.LocationTracker
import dev.icerock.moko.permissions.ios.PermissionsController
import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.engine.darwin.Darwin
import org.koin.core.module.Module
import org.koin.dsl.module

actual val platformModule: Module
    get() = module {
        single<HttpClientEngine> { Darwin.create() }
        single { DatabaseFactory() }
        single<ILocationGateway> { LocationGateway(get(), get()) }
        single<ILocationService> { LocationService() }
        single { LocationTracker(PermissionsController()) }
        //    single<IFireBaseMessageService> { FireBaseMessageService() }


    }
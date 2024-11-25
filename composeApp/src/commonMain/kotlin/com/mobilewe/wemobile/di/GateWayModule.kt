package com.mobilewe.wemobile.di

import com.mobilewe.wemobile.data.datastore.AuthDataStoreImpl
import com.mobilewe.wemobile.data.datastore.AuthDatastore
import com.mobilewe.wemobile.data.gateway.local.LocalConfigurationGateway
import com.mobilewe.wemobile.data.gateway.local.LocationGateway
import com.mobilewe.wemobile.data.gateway.remote.UserGateway
import com.mobilewe.wemobile.domain.gateway.IUserGateway
import com.mobilewe.wemobile.domain.gateway.local.ILocationGateway
import com.mobilewe.wemobile.domain.gateway.local.ILocalConfigurationGateway
import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.bind

import org.koin.dsl.module

val gatewayModule = module {
    singleOf(::LocalConfigurationGateway) { bind<ILocalConfigurationGateway>() }
    singleOf(::LocationGateway) { bind<ILocationGateway>() }
    singleOf(::UserGateway) { bind<IUserGateway>() }
    singleOf(::AuthDataStoreImpl){ bind<AuthDatastore>() }
}
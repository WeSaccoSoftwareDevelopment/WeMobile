package com.mobilewe.wemobile.di

import com.mobilewe.wemobile.domain.usecases.GetUserLocationUseCase
import com.mobilewe.wemobile.domain.usecases.IGetUserLocationUseCase
import com.mobilewe.wemobile.domain.usecases.IManageAuthenticationUseCase
import com.mobilewe.wemobile.domain.usecases.IManageSettingUseCase
import com.mobilewe.wemobile.domain.usecases.IValidationUseCase
import com.mobilewe.wemobile.domain.usecases.ManageAuthenticationUseCase
import com.mobilewe.wemobile.domain.usecases.ManageSettingUseCase
import com.mobilewe.wemobile.domain.usecases.ValidationUseCaseUseCase
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val useCaseModule = module {
    singleOf(::ManageAuthenticationUseCase) { bind<IManageAuthenticationUseCase>() }
    singleOf(::ValidationUseCaseUseCase) { bind<IValidationUseCase>() }
    singleOf(::ManageSettingUseCase) { bind<IManageSettingUseCase>() }
    singleOf(::ManageAuthenticationUseCase) { bind<IManageAuthenticationUseCase>() }
    singleOf(::GetUserLocationUseCase) { bind<IGetUserLocationUseCase>() }

}
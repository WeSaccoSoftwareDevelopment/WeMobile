package com.mobilewe.wemobile.domain.usecases

import com.mobilewe.wemobile.domain.gateway.local.ILocalConfigurationGateway
import kotlinx.coroutines.flow.Flow

interface IManageSettingUseCase {
    suspend fun saveLanguageCode(code: String)
    suspend fun getLanguageCode(): Flow<String>
    suspend fun saveIsFirstTimeUseApp(isFirstTimeUseApp: Boolean)
    suspend fun getIsFirstTimeUseApp(): Boolean
    suspend fun getUserLanguageCode(): Flow<String>
}

class ManageSettingUseCase(private val localGateway: ILocalConfigurationGateway) :
    IManageSettingUseCase {

    override suspend fun saveLanguageCode(code: String) {
        return localGateway.saveLanguageCode(code)
    }

    override suspend fun getLanguageCode(): Flow<String> {
        return localGateway.getLanguageCodeFlow()
    }


    override suspend fun saveIsFirstTimeUseApp(isFirstTimeUseApp: Boolean) {
        return localGateway.saveIsFirstTimeUseApp(isFirstTimeUseApp)
    }

    override suspend fun getIsFirstTimeUseApp(): Boolean {
        return localGateway.getIsFirstTimeUseApp()
    }

    override suspend fun getUserLanguageCode(): Flow<String> {
        return localGateway.getLanguageCodeFlow()
    }
}
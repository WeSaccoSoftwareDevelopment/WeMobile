package com.mobilewe.wemobile.data.gateway.local

import com.mobilewe.wemobile.data.db.AppDatabase
import com.mobilewe.wemobile.data.db.dao.UserConfigurationDao
import com.mobilewe.wemobile.data.db.entity.UserConfigurationEntity
import com.mobilewe.wemobile.domain.gateway.local.ILocalConfigurationGateway
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext

class LocalConfigurationGateway(
    private val userConfigurationDao: UserConfigurationDao
) : ILocalConfigurationGateway {

//    private val userConfigurationDao = database.userConfigurationDao()

    init {
        runBlocking {
            createUserConfiguration()
        }
    }

    private suspend fun createUserConfiguration() {
        withContext(Dispatchers.IO) {
            val defaultConfiguration = UserConfigurationEntity(
                id = CONFIGURATION_ID,
                accessToken = "",
                refreshToken = "",
                isKeepMeLoggedInMeChecked = false,
                languageCode = "en",
                isFirstTimeUseApp = true
            )
            if (defaultConfiguration.id == 0){
                userConfigurationDao.insertUserConfiguration(defaultConfiguration)
            } else {
                userConfigurationDao.updateUserConfiguration(defaultConfiguration)
            }
        }
    }


    override suspend fun saveLanguageCode(code: String) {
        val userConfiguration = userConfigurationDao.getUserConfiguration(CONFIGURATION_ID)?: UserConfigurationEntity(id = CONFIGURATION_ID)
        if (userConfiguration.id == 0){
            userConfigurationDao.insertUserConfiguration(userConfiguration)
        } else {
            userConfiguration.languageCode = code
            userConfigurationDao.updateUserConfiguration(userConfiguration)
        }



    }



    override suspend fun getLanguageCodeFlow(): Flow<String> {
        return userConfigurationDao.getUserConfigurationFlow(
            CONFIGURATION_ID
        ).map { userConfiguration ->
            userConfiguration?.languageCode ?: "en"
        }
    }

    override suspend fun getLanguageCode(): String {
        return userConfigurationDao.getUserConfiguration(
            CONFIGURATION_ID
        )?.languageCode ?: "en"
    }


    override suspend fun getAccessToken(): String {
        return userConfigurationDao.getUserConfiguration(
            CONFIGURATION_ID
        )?.accessToken ?: ""
    }

    override suspend fun getAccessTokenStream(): Flow<String> {
        return userConfigurationDao.getUserConfigurationFlow(
            CONFIGURATION_ID
        ).map { userConfiguration ->
            userConfiguration?.accessToken ?: ""
        }
    }

    override suspend fun saveRefreshToken(token: String) {
        val userConfiguration = userConfigurationDao.getUserConfiguration(
            CONFIGURATION_ID
        )
        if (userConfiguration != null) {
            userConfiguration.refreshToken = token
            userConfigurationDao.updateUserConfiguration(userConfiguration)
        }
    }

    override suspend fun getRefreshToken(): String {
        return userConfigurationDao.getUserConfiguration(
            CONFIGURATION_ID
        )?.refreshToken ?: ""
    }

    override suspend fun clearTokens() {
        val userConfiguration = userConfigurationDao.getUserConfiguration(
            CONFIGURATION_ID
        )
        if (userConfiguration != null) {
            userConfiguration.accessToken = ""
            userConfiguration.refreshToken = ""
            userConfigurationDao.updateUserConfiguration(userConfiguration)
        }
    }

    override suspend fun saveIsFirstTimeUseApp(isFirstTimeUseApp: Boolean) {
        val userConfiguration = userConfigurationDao.getUserConfiguration(
            CONFIGURATION_ID
        )
        if (userConfiguration != null) {
            userConfiguration.isFirstTimeUseApp = isFirstTimeUseApp
            userConfigurationDao.updateUserConfiguration(userConfiguration)
        }
    }

    override suspend fun getIsFirstTimeUseApp(): Boolean {
        return userConfigurationDao.getUserConfiguration(
            CONFIGURATION_ID
        )?.isFirstTimeUseApp ?: true
    }

    override suspend fun saveKeepMeLoggedInFlag(isChecked: Boolean) {
        val userConfiguration = userConfigurationDao.getUserConfiguration(
            CONFIGURATION_ID
        )
        if (userConfiguration != null) {
            userConfiguration.isKeepMeLoggedInMeChecked = isChecked
            userConfigurationDao.updateUserConfiguration(userConfiguration)
        }
    }

    override suspend fun getKeepMeLoggedInFlag(): Boolean {
        return userConfigurationDao.getUserConfiguration(
            CONFIGURATION_ID
        )?.isKeepMeLoggedInMeChecked ?: false
    }

    override suspend fun removeAccessToken() {
        val userConfiguration = userConfigurationDao.getUserConfiguration(
            CONFIGURATION_ID
        )
        if (userConfiguration != null) {
            userConfiguration.accessToken = ""
            userConfigurationDao.updateUserConfiguration(userConfiguration)
        }
    }

    override suspend fun removeRefreshToken() {
        val userConfiguration = userConfigurationDao.getUserConfiguration(
            CONFIGURATION_ID
        )
        if (userConfiguration != null) {
            userConfiguration.refreshToken = ""
            userConfigurationDao.updateUserConfiguration(userConfiguration)
        }
    }


    override suspend fun saveAccessToken(token: String) {

    }


    companion object {
        private const val CONFIGURATION_ID = 0
        private const val ID = "id"

    }
}
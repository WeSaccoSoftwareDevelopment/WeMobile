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
            if (userConfigurationDao.getUserConfiguration(CONFIGURATION_ID) == null) {
                userConfigurationDao.insertUserConfiguration(defaultConfiguration)
            }
        }
    }

    override suspend fun saveLanguageCode(code: String) {
        val userConfiguration = userConfigurationDao.getUserConfiguration(CONFIGURATION_ID)
        if (userConfiguration != null) {
            val updatedConfiguration = userConfiguration.copy(languageCode = code)
            userConfigurationDao.updateUserConfiguration(updatedConfiguration)
        }
    }

    override suspend fun getLanguageCodeFlow(): Flow<String> {
        return userConfigurationDao.getUserConfigurationFlow(CONFIGURATION_ID)
            .map { it?.languageCode ?: "en" }
    }

    override suspend fun getLanguageCode(): String {
        return userConfigurationDao.getUserConfiguration(CONFIGURATION_ID)?.languageCode ?: "en"
    }

    override suspend fun getAccessToken(): String {
        return userConfigurationDao.getUserConfiguration(CONFIGURATION_ID)?.accessToken ?: ""
    }

    override suspend fun getAccessTokenStream(): Flow<String> {
        return userConfigurationDao.getUserConfigurationFlow(CONFIGURATION_ID)
            .map { it?.accessToken ?: "" }
    }

    override suspend fun saveRefreshToken(token: String) {
        val userConfiguration = userConfigurationDao.getUserConfiguration(CONFIGURATION_ID)
        if (userConfiguration != null) {
            val updatedConfiguration = userConfiguration.copy(refreshToken = token)
            userConfigurationDao.updateUserConfiguration(updatedConfiguration)
        }
    }

    override suspend fun getRefreshToken(): String {
        return userConfigurationDao.getUserConfiguration(CONFIGURATION_ID)?.refreshToken ?: ""
    }

    override suspend fun clearTokens() {
        val userConfiguration = userConfigurationDao.getUserConfiguration(CONFIGURATION_ID)
        if (userConfiguration != null) {
            val updatedConfiguration = userConfiguration.copy(
                accessToken = "",
                refreshToken = ""
            )
            userConfigurationDao.updateUserConfiguration(updatedConfiguration)
        }
    }

    override suspend fun saveIsFirstTimeUseApp(isFirstTimeUseApp: Boolean) {
        val userConfiguration = userConfigurationDao.getUserConfiguration(CONFIGURATION_ID)
        if (userConfiguration != null) {
            val updatedConfiguration = userConfiguration.copy(isFirstTimeUseApp = isFirstTimeUseApp)
            userConfigurationDao.updateUserConfiguration(updatedConfiguration)
        }
    }

    override suspend fun getIsFirstTimeUseApp(): Boolean {
        return userConfigurationDao.getUserConfiguration(CONFIGURATION_ID)?.isFirstTimeUseApp ?: true
    }

    override suspend fun saveKeepMeLoggedInFlag(isChecked: Boolean) {
        val userConfiguration = userConfigurationDao.getUserConfiguration(CONFIGURATION_ID)
        if (userConfiguration != null) {
            val updatedConfiguration = userConfiguration.copy(isKeepMeLoggedInMeChecked = isChecked)
            userConfigurationDao.updateUserConfiguration(updatedConfiguration)
        }
    }

    override suspend fun getKeepMeLoggedInFlag(): Boolean {
        return userConfigurationDao.getUserConfiguration(CONFIGURATION_ID)?.isKeepMeLoggedInMeChecked
            ?: false
    }

    override suspend fun removeAccessToken() {
        val userConfiguration = userConfigurationDao.getUserConfiguration(CONFIGURATION_ID)
        if (userConfiguration != null) {
            val updatedConfiguration = userConfiguration.copy(accessToken = "")
            userConfigurationDao.updateUserConfiguration(updatedConfiguration)
        }
    }

    override suspend fun removeRefreshToken() {
        val userConfiguration = userConfigurationDao.getUserConfiguration(CONFIGURATION_ID)
        if (userConfiguration != null) {
            val updatedConfiguration = userConfiguration.copy(refreshToken = "")
            userConfigurationDao.updateUserConfiguration(updatedConfiguration)
        }
    }

    override suspend fun saveAccessToken(token: String) {
        val userConfiguration = userConfigurationDao.getUserConfiguration(CONFIGURATION_ID)
        if (userConfiguration != null) {
            val updatedConfiguration = userConfiguration.copy(accessToken = token)
            userConfigurationDao.updateUserConfiguration(updatedConfiguration)
        }
    }

    companion object {
        private const val CONFIGURATION_ID = 0
    }
}

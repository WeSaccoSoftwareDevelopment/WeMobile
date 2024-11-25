  package com.mobilewe.wemobile.data.datastore

import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import com.mobilewe.wemobile.utils.DATA_STORE_FILE_NAME
import com.mobilewe.wemobile.utils.createDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

  interface AuthDatastore {
    val isLoggedIn: Flow<Boolean?>
    suspend fun saveLoginState(isLoggedIn: Boolean)
    suspend fun clearLoginState()
}

class AuthDataStoreImpl : AuthDatastore{
    private object PreferencesKey {
        val onBoardingKey = booleanPreferencesKey(name = "isLoggedIn")
    }

    private val dataStore = createDataStore { DATA_STORE_FILE_NAME }


    override val isLoggedIn: Flow<Boolean> = dataStore.data.map { preferences ->
        preferences[IS_LOGGED_IN] ?: false
    }

    override suspend fun saveLoginState(isLoggedIn: Boolean) {
        dataStore.edit { preferences ->
            preferences[IS_LOGGED_IN] = isLoggedIn
        }
    }

    override suspend fun clearLoginState() {
        dataStore.edit { preferences ->
            preferences[IS_LOGGED_IN] = false
        }
    }

    companion object{
        private val  IS_LOGGED_IN = booleanPreferencesKey("is_logged_in")

    }

}
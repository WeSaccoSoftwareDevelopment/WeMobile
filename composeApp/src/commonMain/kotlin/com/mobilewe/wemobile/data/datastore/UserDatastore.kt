package com.mobilewe.wemobile.data.datastore

import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import com.mobilewe.wemobile.domain.model.UserData
import com.mobilewe.wemobile.utils.DATA_STORE_FILE_NAME
import com.mobilewe.wemobile.utils.createDataStore
import kotlinx.coroutines.flow.first

interface UserDataStore {
    suspend fun saveUserData(userData: UserData)
    suspend fun readUserData(): UserData?
}

class UserDataStoreImpl{
    private val dataStore = createDataStore { DATA_STORE_FILE_NAME }


    suspend fun saveUserData(userData: UserData) {
        dataStore.edit { preferences ->
            preferences[KEY_EMAIL] = userData.email
            preferences[KEY_PASSWORD] = userData.name
            // Add other fields as needed
        }
    }

    suspend fun readUserData(): UserData? {
        val preferences = dataStore.data.first()
        val email = preferences[KEY_EMAIL] ?: return null
        val password = preferences[KEY_PASSWORD] ?: return null
        // Read other fields as needed
        return UserData(email, password)
    }

    companion object {
        private val KEY_EMAIL = stringPreferencesKey("key_email")
        private val KEY_PASSWORD = stringPreferencesKey("key_password")
        // Add other keys as needed
    }
}

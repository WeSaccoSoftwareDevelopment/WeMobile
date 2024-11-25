package com.mobilewe.wemobile.data.datastore

import androidx.datastore.preferences.core.edit
import com.mobilewe.wemobile.data.util.Constants.THEME_OPTIONS
import com.mobilewe.wemobile.utils.DATA_STORE_FILE_NAME
import com.mobilewe.wemobile.utils.createDataStore

class ThemePreferences {
    private val dataStore = createDataStore { DATA_STORE_FILE_NAME }

    suspend fun saveTheme(themeValue: Int) {
        dataStore.edit { preferences ->
            preferences[THEME_OPTIONS] = themeValue
        }
    }

//    val getTheme: Flow<Int> = dataStore.data.map { preferences ->
//        preferences[THEME_OPTIONS] ?: AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM
//    }

}
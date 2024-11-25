package com.mobilewe.wemobile.utils

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import android.content.Context

fun createDataStore(context: Context): DataStore<Preferences> {
    return createDataStore {
        context.filesDir.resolve(DATA_STORE_FILE_NAME).absolutePath
    }
}
package com.mobilewe.wemobile.data.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_configuration")
data class UserConfigurationEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    var accessToken: String = "",
    var refreshToken: String = "",
    var isKeepMeLoggedInMeChecked: Boolean = false,
    var languageCode: String = "",
    var isFirstTimeUseApp: Boolean = true
)

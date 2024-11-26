package com.mobilewe.wemobile.data.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_configuration")
data class UserConfigurationEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val accessToken: String = "",
    val refreshToken: String = "",
    val isKeepMeLoggedInMeChecked: Boolean = false,
    val languageCode: String = "",
    val isFirstTimeUseApp: Boolean = true
)


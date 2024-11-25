package com.mobilewe.wemobile.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.mobilewe.wemobile.data.db.entity.UserConfigurationEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface UserConfigurationDao {
    @Insert
    suspend fun insertUserConfiguration(userConfiguration: UserConfigurationEntity)

    @Update
    suspend fun updateUserConfiguration(userConfiguration: UserConfigurationEntity)

    @Query("SELECT * FROM user_configuration WHERE id = :id")
    suspend fun getUserConfigurationById(id: Int): UserConfigurationEntity?

    @Query("SELECT * FROM user_configuration WHERE id = :id")
    fun getUserConfigurationFlowById(id: Int): Flow<UserConfigurationEntity?>

    @Query("DELETE FROM user_configuration WHERE id = :id")
    suspend fun deleteUserConfigurationById(id: Int)


    @Query("SELECT * FROM user_configuration WHERE id = :configId LIMIT 1")
    suspend fun getUserConfiguration(configId: Int): UserConfigurationEntity?

    @Query("SELECT * FROM user_configuration WHERE id = :configId LIMIT 1")
    fun getUserConfigurationFlow(configId: Int): Flow<UserConfigurationEntity?>
}
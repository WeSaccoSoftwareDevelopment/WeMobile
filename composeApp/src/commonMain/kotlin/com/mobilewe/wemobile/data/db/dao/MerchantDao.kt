package com.mobilewe.wemobile.data.db.dao

import androidx.room.Dao
import androidx.room.Query
import com.mobilewe.wemobile.data.db.entity.MerchantEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface MerchantDao : BaseDao<MerchantEntity> {

    @get:Query("SELECT * FROM merchants ORDER BY last_used_timestamp ASC")
    val all: Flow<List<MerchantEntity>>

    @Query("SELECT * FROM merchants WHERE till_no = :till AND channelId = :channelId LIMIT 1")
    suspend fun getMerchantsByNo(till: String, channelId: Int): MerchantEntity?

    @Query("SELECT * FROM merchants WHERE till_no = :till AND channelId = :channelId LIMIT 1")
    fun getLiveMerchantsByNo(till: String, channelId: Int): Flow<MerchantEntity?>

    @Query("SELECT * FROM merchants WHERE id = :id LIMIT 1")
    suspend fun getMerchant(id: Int): MerchantEntity?

    @Query("DELETE FROM merchants")
    suspend fun deleteAll()
}
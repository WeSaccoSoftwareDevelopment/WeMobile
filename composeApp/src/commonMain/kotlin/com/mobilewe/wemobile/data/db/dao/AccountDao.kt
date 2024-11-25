package com.mobilewe.wemobile.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.mobilewe.wemobile.data.db.entity.AccountEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface AccountDao : BaseDao<AccountEntity> {

    @Query("SELECT * FROM accounts WHERE institution_type != 'telecom' ORDER BY alias ASC")
    suspend fun getAllAccounts(): List<AccountEntity>

    @Query("SELECT * FROM accounts WHERE institution_type != 'telecom' ORDER BY alias ASC")
    fun getLiveAccounts(): Flow<List<AccountEntity>>

    @Query("SELECT * FROM accounts WHERE sim_subscription_id IN (:sim_subscriptionIds)")
    fun getAccountsBySubscribedSim(sim_subscriptionIds: IntArray): Flow<List<AccountEntity>>

    @Query("SELECT * FROM accounts WHERE institution_type = 'telecom' AND sim_subscription_id = (:subscriptionId)")
    suspend fun getAccountBySim(subscriptionId: Int): AccountEntity?

    @Query("SELECT * FROM accounts WHERE channelId = :channelId AND institution_type != 'telecom' ORDER BY alias ASC")
    suspend fun getAccountsByChannel(channelId: Int): List<AccountEntity>

    @Query("SELECT * FROM accounts WHERE institutionId = :institutionId AND institution_type != 'telecom' ORDER BY alias ASC")
    fun getAccountsByInstitution(institutionId: Int): Flow<List<AccountEntity>>

    @Query("SELECT * FROM accounts WHERE institution_type != 'telecom' ORDER BY alias ASC")
    fun getAccounts(): Flow<List<AccountEntity>>

    @Query("SELECT * FROM accounts where name = :name and channelId = :channelId AND institution_type != 'telecom'")
    suspend fun getAccount(name: String, channelId: Int): AccountEntity?

    @Query("SELECT * FROM accounts where id = :id")
    suspend fun getAccount(id: Int): AccountEntity?

    @Query("SELECT * FROM accounts where id = :id")
    fun getLiveAccount(id: Int?): Flow<AccountEntity>

    @Query("SELECT * FROM accounts  WHERE isDefault = 1 AND institution_type != 'telecom'")
    suspend fun getDefaultAccount(): AccountEntity?

    @Query("SELECT * FROM accounts WHERE isDefault = 1 AND institution_type != 'telecom'")
    suspend fun getDefaultAccountAsync(): AccountEntity?

    @Query("SELECT COUNT(id) FROM accounts")
    suspend fun getDataCount(): Int

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertAll(accounts: List<AccountEntity>): List<Long>

    @Query("DELETE FROM accounts")
    suspend fun deleteAll()

    @Query("DELETE FROM accounts WHERE channelId = :channelId AND name = :name")
    suspend fun delete(channelId: Int, name: String)
}
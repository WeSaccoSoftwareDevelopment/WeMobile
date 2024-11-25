package com.mobilewe.wemobile.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.mobilewe.wemobile.data.db.entity.PaybillEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface PaybillDao : BaseDao<PaybillEntity> {

    @get:Query("SELECT * FROM paybills ORDER BY name ASC")
    val allBills: Flow<List<PaybillEntity>>

    @Query("SELECT * FROM paybills WHERE accountId = :accountId ORDER BY name ASC")
    fun getPayBillsByAccount(accountId: Int): Flow<List<PaybillEntity>>

    @Query("SELECT * FROM paybills WHERE id = :id")
    suspend fun getPayBill(id: Int): PaybillEntity?

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    override suspend fun insert(vararg paybillEntity: PaybillEntity)
}
package com.mobilewe.wemobile.data.repo

import com.mobilewe.wemobile.data.db.AppDatabase
import com.mobilewe.wemobile.data.db.dao.PaybillDao
import com.mobilewe.wemobile.data.db.entity.PaybillEntity
import kotlinx.coroutines.flow.Flow

class PayBillRepo(private val payBillDao: PaybillDao) {

//    private val payBillDao: PaybillDao = db.paybillDao()

    val allBills: Flow<List<PaybillEntity>> = payBillDao.allBills


    suspend fun save(billEntity: PaybillEntity) = payBillDao.insert(billEntity)

    suspend fun update(billEntity: PaybillEntity) = payBillDao.update(billEntity)

    suspend fun delete(billEntity: PaybillEntity) = payBillDao.delete(billEntity)
}

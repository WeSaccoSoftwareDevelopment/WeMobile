package com.mobilewe.wemobile.data.repo

import com.mobilewe.wemobile.data.db.AppDatabase
import com.mobilewe.wemobile.data.db.dao.MerchantDao
import com.mobilewe.wemobile.data.db.entity.MerchantEntity
import kotlinx.coroutines.flow.Flow

class MerchantRepo(private val merchantDao: MerchantDao) {

//    private val merchantDao: MerchantDao = db.merchantDao()

    val all: Flow<List<MerchantEntity>> = merchantDao.all

    suspend fun get(id: Int): MerchantEntity? = merchantDao.getMerchant(id)

    suspend fun getMatching(tillNo: String, channelId: Int): MerchantEntity? = merchantDao.getMerchantsByNo(tillNo, channelId)

    fun getLiveMatching(tillNo: String, channelId: Int): Flow<MerchantEntity?> = merchantDao.getLiveMerchantsByNo(tillNo, channelId)

    suspend fun save(merchantEntity: MerchantEntity) = merchantDao.insert(merchantEntity)

    suspend fun update(merchantEntity: MerchantEntity) = merchantDao.update(merchantEntity)

    suspend fun delete(merchantEntity: MerchantEntity) = merchantDao.delete(merchantEntity)
}
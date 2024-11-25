package com.mobilewe.wemobile.data.repo

import com.mobilewe.wemobile.data.db.AppDatabase
import com.mobilewe.wemobile.data.db.dao.AccountDao
import com.mobilewe.wemobile.data.db.entity.AccountEntity
import kotlinx.coroutines.flow.Flow

class AccountRepo( private val accountDao: AccountDao) {

//    private val accountDao: AccountDao = db.accountDao()

    suspend fun getAllAccounts(): List<AccountEntity> = accountDao.getAllAccounts()

    fun getAllLiveAccounts(): Flow<List<AccountEntity>> = accountDao.getLiveAccounts()

    suspend fun getAccountBySim(simSubscriptionId: Int): AccountEntity? = accountDao.getAccountBySim(simSubscriptionId)

    fun getTelecomAccounts(simSubscriptionIds: IntArray): Flow<List<AccountEntity>> =
        accountDao.getAccountsBySubscribedSim(simSubscriptionIds)

    suspend fun getAccountsCount(): Int = accountDao.getDataCount()

    suspend fun getAccountsByChannel(channelId: Int): List<AccountEntity> =
        accountDao.getAccountsByChannel(channelId)

    suspend fun getDefaultAccount(): AccountEntity? = accountDao.getDefaultAccount()

    suspend fun getAccount(id: Int): AccountEntity? = accountDao.getAccount(id)

    fun getLiveAccount(id: Int?): Flow<AccountEntity> = accountDao.getLiveAccount(id)

    fun getAccounts(): Flow<List<AccountEntity>> = accountDao.getAccounts()

    suspend fun saveAccount(account: AccountEntity) {
        if (account.id == 0) {
            accountDao.insert(account)
        } else {
            accountDao.update(account)
        }
    }

    suspend fun insert(account: AccountEntity) = accountDao.insert(account)

    suspend fun insert(accounts: List<AccountEntity>): List<Long> = accountDao.insertAll(accounts)

    suspend fun update(account: AccountEntity?) = account?.let { accountDao.update(it) }

    suspend fun update(accounts: List<AccountEntity>) = accountDao.update(accounts)

    suspend fun delete(account: AccountEntity) = accountDao.delete(account)
}
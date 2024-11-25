package com.mobilewe.wemobile.data.db

import androidx.room.ConstructedBy
import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.RoomDatabaseConstructor
import androidx.room.TypeConverters
import com.mobilewe.wemobile.data.db.dao.AccountDao
import com.mobilewe.wemobile.data.db.dao.MerchantDao
import com.mobilewe.wemobile.data.db.dao.PaybillDao
import com.mobilewe.wemobile.data.db.dao.UserConfigurationDao
import com.mobilewe.wemobile.data.db.entity.*
import com.mobilewe.wemobile.data.db.utils.Converters
import com.mobilewe.wemobile.data.db.utils.StringListTypeConverter


@Database(
    entities = [
        AccountEntity::class,
        PaybillEntity::class,
        MerchantEntity::class,
        UserConfigurationEntity::class,
    ],
    version = 1,
    exportSchema = true
)
@TypeConverters(Converters::class)
@ConstructedBy(AppDatabaseConstructor::class)
abstract class AppDatabase : RoomDatabase(){
    abstract val userConfigurationDao : UserConfigurationDao
    abstract val accountDao : AccountDao
    abstract val paybillDao : PaybillDao
    abstract val merchantDao : MerchantDao

    companion object {
        const val DB_NAME = "we.db"
    }


}

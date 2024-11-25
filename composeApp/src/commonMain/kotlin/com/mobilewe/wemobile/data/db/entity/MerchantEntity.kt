package com.mobilewe.wemobile.data.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.mobilewe.wemobile.data.db.utils.Converters

@Entity(
    tableName = "merchants",
)
@TypeConverters(*[Converters::class])
data class MerchantEntity(

    @ColumnInfo(name = "business_name")
    var businessName: String?,

    @ColumnInfo(name = "till_no")
    var tillNo: String,

    @ColumnInfo(name = "action_id", defaultValue = "")
    var actionId: String? = null,

    @ColumnInfo(index = true)
    val accountId: Int = 0,

    @ColumnInfo(index = true)
    var channelId: Int = 0

) : Comparable<MerchantEntity> {

    @PrimaryKey(autoGenerate = true)
    var id: Int = 0

    @ColumnInfo(name = "last_used_timestamp")
    var lastUsedTimestamp: Long? = null

    override fun toString() = buildString {
        if (!businessName.isNullOrEmpty()) {
            append(businessName)
            append(" (")
        }
        append(tillNo)
        if (!businessName.isNullOrEmpty())
            append(")")
    }

    // 	FIXME: Is this actually used?
    override fun equals(other: Any?): Boolean {
        if (other !is MerchantEntity) return false
        return id == other.id || (channelId == other.channelId && tillNo == tillNo)
    }

    override fun compareTo(other: MerchantEntity): Int = tillNo.compareTo(other.tillNo)

    fun shortName(): String? {
        return if (hasName()) businessName else tillNo
    }

    fun hasName(): Boolean {
        return businessName != null && businessName!!.isNotEmpty()
    }
}
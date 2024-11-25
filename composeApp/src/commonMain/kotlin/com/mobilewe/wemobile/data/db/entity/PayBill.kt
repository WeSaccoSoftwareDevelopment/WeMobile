package com.mobilewe.wemobile.data.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.mobilewe.wemobile.data.db.utils.Converters


const val BUSINESS_NO = "businessNo"
const val BUSINESS_NAME = "businessName"
const val AMOUNT_KEY = "0"
const val ACCOUNT_KEY = "0"

@Entity(
    tableName = "paybills",
    foreignKeys = [
        ForeignKey(entity = AccountEntity::class, parentColumns = ["id"], childColumns = ["accountId"])
    ],
    indices = [Index(value = ["business_no", "account_no"], unique = true)]
)
@TypeConverters(*[Converters::class])
data class PaybillEntity(

    var name: String,

    @ColumnInfo(name = "business_name")
    var businessName: String?,

    @ColumnInfo(name = "business_no")
    var businessNo: String?,

    @ColumnInfo(name = "account_no")
    var accountNo: String? = null,

    @ColumnInfo(name = "action_id", defaultValue = "")
    var actionId: String? = null,

    @ColumnInfo(index = true)
    val accountId: Int = 0,

    @ColumnInfo(name = "logo_url")
    val logoUrl: String
) : Comparable<PaybillEntity> {

    @PrimaryKey(autoGenerate = true)
    var id: Int = 0

    @ColumnInfo(name = "recurring_amount")
    var recurringAmount: Int = 0

    @ColumnInfo(index = true)
    var channelId: Int = 0

    var logo: Int = 0

    @ColumnInfo(defaultValue = "0")
    var isSaved: Boolean = false

    override fun toString() = buildString {
        append(name)
        append(" (")
        append(businessNo)
        append(")")
    }

    // FIXME: is this actually used?
    override fun equals(other: Any?): Boolean {
        if (other !is PaybillEntity) return false
        return id == other.id || (channelId == other.channelId && businessNo == other.businessNo) // FIXME: should be institution id not channel id
    }

    override fun compareTo(other: PaybillEntity): Int = toString().compareTo(other.toString())

    companion object {
        /*fun extractBizNumber(action: HoverAction): String {
            return if (action.getVarValue(BUSINESS_NO) != null)
                action.getVarValue(BUSINESS_NO)
            else ""
        }*/
    }
}
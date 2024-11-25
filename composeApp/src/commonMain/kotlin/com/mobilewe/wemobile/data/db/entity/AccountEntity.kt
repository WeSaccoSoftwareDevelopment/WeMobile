package com.mobilewe.wemobile.data.db.entity

//import org.saccowemobile.wemobile.common.DateUtils.now
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.mobilewe.wemobile.data.db.utils.Converters
import kotlinx.datetime.Clock
import kotlinx.datetime.Clock.System.now

const val ACCOUNT_NAME: String = "accountName"
const val ACCOUNT_ID: String = "account_id"

@Entity(
    tableName = "accounts",
    indices = [Index(value = ["name", "sim_subscription_id"], unique = true)]
)
@TypeConverters(*[Converters::class])
data class AccountEntity(
    @ColumnInfo(name = "name")
    val institutionName: String?,

    @ColumnInfo(name = "alias")
    var userAlias: String?,

    @ColumnInfo(name = "logo_url")
    val logoUrl: String?,

    @ColumnInfo(name = "account_no")
    var accountNo: String?,

    @ColumnInfo
    var institutionId: Int,

    @ColumnInfo(name = "institution_type")
    var institutionType: String?,

    @ColumnInfo
    var countryAlpha2: String?,

    @ColumnInfo(index = true)
    var channelId: Int,

    @ColumnInfo(name = "primary_color_hex")
    val primaryColorHex: String?,

    @ColumnInfo(name = "secondary_color_hex")
    val secondaryColorHex: String?,

    @ColumnInfo(defaultValue = "0")
    var isDefault: Boolean = false,

    @ColumnInfo(name = "sim_subscription_id", defaultValue = "-1")
    var simSubscriptionId: Int = -1

) : Comparable<AccountEntity> {

    constructor(name: String) : this(name, name)
    constructor(name: String, alias: String) : this(
        institutionName = name, userAlias = alias, logoUrl = "", accountNo = "", institutionId = -1, institutionType = "", countryAlpha2 = "", channelId = -1, primaryColorHex = "#292E35", secondaryColorHex = "#1E232A"
    )


    @PrimaryKey(autoGenerate = true)
    var id: Int = 0

    var institutionAccountName: String? = null

    var latestBalance: String? = null

    @ColumnInfo(defaultValue = "CURRENT_TIMESTAMP")
    var latestBalanceTimestamp: Long = Clock.System.now().toEpochMilliseconds()

    fun updateBalance(parsed_variables: HashMap<String, String>) {
        if (parsed_variables.containsKey("balance")) latestBalance = parsed_variables["balance"]

//        Timber.e("Balance is $latestBalance")

        latestBalanceTimestamp = if (parsed_variables.containsKey("update_timestamp") && parsed_variables["update_timestamp"] != null) {
            parsed_variables["update_timestamp"]!!.toLong()
        } else {
            now().toEpochMilliseconds()
        }
    }

    fun getAccountNameExtra(): String {
        return institutionAccountName ?: "1"
    }

    override fun toString() = buildString {
        append(userAlias)

        if (!accountNo.isNullOrEmpty()) {
            append(" - ")
            append(accountNo)
        }
    }

    override fun equals(other: Any?): Boolean {
        if (other !is AccountEntity) return false
        return id == other.id ||
                (institutionName == other.institutionName && simSubscriptionId == other.simSubscriptionId && institutionAccountName == other.institutionAccountName)
    }

    override fun compareTo(other: AccountEntity): Int = toString().compareTo(other.toString())
}
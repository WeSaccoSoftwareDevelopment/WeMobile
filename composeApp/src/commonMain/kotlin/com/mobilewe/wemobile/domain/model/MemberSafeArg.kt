package com.mobilewe.wemobile.domain.model

import com.mobilewe.wemobile.domain.model.UserAccount


data class MemberSafeArg(
    val memberId: String = "",
    val firstName: String = "",
    val lastName: String = "",
    val phoneNumber: String = "",
    val emailAddress: String = "",
    val accounts: List<UserAccount> = emptyList()
)

data class DefaultAccount(
    val accountId: String = "",
    val accountBalance: Double = 0.0,
    val savingsBalance: Double = 0.0
)


data class WalletAccount(
    val walletAccountId: String = "",
    val walletBalance: Double = 0.0
)

// Account data class representing a generic account
data class Account(
    val accountId: String ="",
    var accountBalance: Double = 0.0
){
    // Method to deposit money into the account
    fun deposit(amount: Double) {
        require(amount > 0) { "Deposit amount must be greater than zero." }
        // Update the account balance
        accountBalance += amount
    }
    fun withdraw(amount: Double) {
        require(amount > 0) { "Withdrawal amount must be greater than zero." }
        require(amount <= accountBalance) { "Insufficient funds for withdrawal." }
        // Update the account balance
        accountBalance -= amount
    }
}

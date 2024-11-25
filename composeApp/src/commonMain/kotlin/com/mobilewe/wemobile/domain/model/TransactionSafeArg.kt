package com.mobilewe.wemobile.domain.model



data class TransactionSafeArg(
    val transactionId: String = "",
    val memberId: String = "",
    val transactionAmount: Double = 0.0,
    val transactionType: TransactionType = TransactionType.DEPOSIT,
    val transactionDate: Long = 0,

    )

enum class TransactionType(val typeName: String){
    DEPOSIT("Deposit"),
    WITHDRAWAL("Withdraw"),
    LOAN_PAYMENT("Loan"),
    PAY_BILL("Pay Bill"),
    BUY_GOODS("Buy Goods"),
    BUY_AIRTIME("Buy Airtime"),
    TRANSFER_TO_WALLET("Transfer to Wallent")
}
package com.mobilewe.wemobile.presentation.common.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import androidx.navigation.toRoute
import com.mobilewe.wemobile.domain.model.Merchant
import com.mobilewe.wemobile.presentation.screen.bankTransfer.BankTransferScreen
import com.mobilewe.wemobile.presentation.screen.buyAirtime.buyAirtime.BuyAirtimeScreen
import com.mobilewe.wemobile.presentation.screen.deposit.DepositScreen
import com.mobilewe.wemobile.presentation.screen.loans.loanStatement.LoanMiniStatementScreen
import com.mobilewe.wemobile.presentation.screen.loans.loan_screen.LoanScreen
import com.mobilewe.wemobile.presentation.screen.payWithSacco.buyGoods.buyGoodsConfirm.BuyGoodsConfirmationScreen
import com.mobilewe.wemobile.presentation.screen.payWithSacco.payWithSacco.PayWithSaccoScreen
import com.mobilewe.wemobile.presentation.screen.savings.SavingMainScreen
import com.mobilewe.wemobile.presentation.screen.sendMoney.sendMoney.SendMoneyMainScreen
import com.mobilewe.wemobile.presentation.screen.transactions.NewTransactionScreen
import com.mobilewe.wemobile.presentation.screen.withdraw.WithdrawScreen
import kotlinx.serialization.Serializable

fun NavGraphBuilder.transactGraph(navController: NavHostController){
    navigation<RootGraph.TransactGraph>(startDestination = RootGraph.TransactMain){
        composable<RootGraph.TransactMain> {
            NewTransactionScreen(navController = navController)
        }
        composable<TransactDes.SendMoney> {
            SendMoneyMainScreen(
                onNavigateToSendMoneyDetail = {},
                onNavigateBack = { navController.popBackStack()}
            )
        }
        composable<TransactDes.Loans> {
            LoanScreen(
                navigateToLoanMiniStatement = { navController.navigate(TransactDes.LoanStatement)},
                navigateBack = { navController.popBackStack()}
            )
        }
        composable<TransactDes.LoanStatement> {
            LoanMiniStatementScreen()
        }
        composable<TransactDes.Deposit> {
           DepositScreen {  }
        }
        composable<TransactDes.Withdraw> {
            WithdrawScreen(
                navigateBack = {
                    navController.popBackStack()
                }
            )
        }
        composable<TransactDes.BuyAirtime> {
            BuyAirtimeScreen(
                navController = navController
            )
        }

        composable<TransactDes.BankTransfer> {
            BankTransferScreen(navController)
        }

        composable<TransactDes.PayWithSacco> {
            PayWithSaccoScreen(navController)
        }

        composable<TransactDes.BuyGoodsDetailsRoute> { backStackEntry->
            val marchatId = backStackEntry.toRoute<TransactDes.BuyGoodsDetailsRoute>()
            BuyGoodsConfirmationScreen(merchantId = marchatId.id)
        }

        composable<TransactDes.Savings> {
            SavingMainScreen(navigateBack = { navController.navigateUp()})
        }
    }
}

sealed interface TransactDes {
    @Serializable
    data object TransactMain: TransactDes

    @Serializable
    data class BuyGoodsDetailsRoute(val id: String)

    @Serializable
    data object SendMoney: TransactDes

    @Serializable
    data object BuyAirtime: TransactDes

    @Serializable
    data object Loans: TransactDes

    @Serializable
    data object LoanStatement: TransactDes

    @Serializable
    data object Withdraw: TransactDes

    @Serializable
    data object Deposit: TransactDes

    @Serializable
    data object PayWithSacco: TransactDes

    @Serializable
    data object BankTransfer: TransactDes

    @Serializable
    data object Savings : TransactDes


}
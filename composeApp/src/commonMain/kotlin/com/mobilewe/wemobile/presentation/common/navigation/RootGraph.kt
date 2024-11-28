package com.mobilewe.wemobile.presentation.common.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.lifecycle.ViewModel
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.mobilewe.wemobile.presentation.screen.account.account.AccountScreen
import com.mobilewe.wemobile.presentation.screen.auth.forgotPassword.ForgotPasswordScreen
import com.mobilewe.wemobile.presentation.screen.auth.login.LoginScreen
import com.mobilewe.wemobile.presentation.screen.auth.phoneRegistration.PhoneRegScreen
import com.mobilewe.wemobile.presentation.screen.auth.register.registration.RegistrationScreen
import com.mobilewe.wemobile.presentation.screen.auth.register.registrationSubmit.RegistrationSubmitScreen
import com.mobilewe.wemobile.presentation.screen.auth.welcome.WelcomeScreen
import com.mobilewe.wemobile.presentation.screen.bankTransfer.BankTransferScreen
import com.mobilewe.wemobile.presentation.screen.buyAirtime.buyAirtime.BuyAirtimeScreen
import com.mobilewe.wemobile.presentation.screen.deposit.DepositScreen
import com.mobilewe.wemobile.presentation.screen.home.HomeScreen
import com.mobilewe.wemobile.presentation.screen.loans.loanStatement.LoanMiniStatementScreen
import com.mobilewe.wemobile.presentation.screen.loans.loan_screen.LoanScreen
import com.mobilewe.wemobile.presentation.screen.markets.MarketScreen
import com.mobilewe.wemobile.presentation.screen.payWithSacco.payWithSacco.PayWithSaccoScreen
import com.mobilewe.wemobile.presentation.screen.savings.SavingMainScreen
import com.mobilewe.wemobile.presentation.screen.sendMoney.sendMoney.SendMoneyMainScreen
import com.mobilewe.wemobile.presentation.screen.transactions.NewTransactionScreen
import com.mobilewe.wemobile.presentation.screen.withdraw.WithdrawScreen
import kotlinx.serialization.Serializable
import org.koin.compose.viewmodel.koinViewModel

sealed class RootGraph {
    @Serializable
    data object AuthenticationGraph : RootGraph()

    @Serializable
    data object HomeGraph : RootGraph()

    @Serializable
    data object TransactGraph: RootGraph()

    @Serializable
    data object DiscoverGraph : RootGraph()

    @Serializable
    data object AccountGraph : RootGraph()
}

@Composable
fun NavigationGraph(navController: NavHostController){
    NavHost(navController = navController, startDestination = RootGraph.AuthenticationGraph){
        authenticationGraph(navController)
        homeGraph(navController)
        transactGraph(navController)
        discoverGraph(navController)
        accountGraph(navController)
    }
}

fun NavGraphBuilder.authenticationGraph(navController: NavHostController){
    navigation<RootGraph.AuthenticationGraph>(startDestination = Auth.Login){
        composable<Auth.PhoneRegister> {
            PhoneRegScreen(
                onNavigate = {
                    navController.navigate(Auth.RegisterDetails)
                }
            )
        }

        composable<Auth.Welcome> {
            WelcomeScreen(onLogin = { navController.navigate(Auth.Login) },)
        }
        composable<Auth.Login>{
            LoginScreen(
                onBiometricSetUp = {
                    navController.navigate(RootGraph.HomeGraph)
                },
            )
        }

        composable<Auth.RegisterDetails>{
            RegistrationScreen(
                onNavigateUp = { navController.popBackStack()},
                onClickContinue = { navController.navigate(Auth.RegistrationSubmit)}
            )
        }
        composable<Auth.RegistrationSubmit> {
            RegistrationSubmitScreen(
                onClickContinue = {  },
                navigateBack = { navController.popBackStack()}
            )
        }

        composable<Auth.ForgotPassword> {
            ForgotPasswordScreen(navController)
        }
    }
}

sealed interface Auth {
    @Serializable
    data object Welcome: Auth

    @Serializable
    data object Login: Auth

    @Serializable
    data object PhoneRegister: Auth

    @Serializable
    data object RegisterDetails: Auth

    @Serializable
    data object RegistrationSubmit: Auth

    @Serializable
    data object ForgotPassword: Auth

}

fun NavGraphBuilder.homeGraph(navController: NavHostController){
    navigation<RootGraph.HomeGraph>(startDestination = HomeDes.Home){
        composable<HomeDes.Home> {
            HomeScreen(navController = navController)
        }
    }
}
sealed interface HomeDes {
    @Serializable
    data object Home: HomeDes
}
fun NavGraphBuilder.transactGraph(navController: NavHostController){
    navigation<RootGraph.TransactGraph>(startDestination = TransactDes.TransactMain){
        composable<TransactDes.TransactMain> {
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

        composable<TransactDes.Savings> {
            SavingMainScreen()
        }
    }
}

sealed interface TransactDes {
    @Serializable
    data object TransactMain: TransactDes

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

fun NavGraphBuilder.discoverGraph(navController: NavHostController){
    navigation<RootGraph.DiscoverGraph>(startDestination = DiscoverDes.DiscoverMain){
        composable<DiscoverDes.DiscoverMain> {
            MarketScreen {  }
        }
    }
}

sealed interface DiscoverDes {
    @Serializable
    data object DiscoverMain : DiscoverDes
}

fun NavGraphBuilder.accountGraph(navController: NavHostController){
    navigation<RootGraph.AccountGraph>(startDestination = AccountDes.AccountMain){
        composable<AccountDes.AccountMain> {
            AccountScreen(
                onNavigateToStatement = {},
                navigateToManagePin = {},
                navigateBack = {},
                navigateToSettings = {},
                navigateToAboutSaccoRide = {},
                navigateToNotification = {  },
                navigateToManagePassword = {}
            )
        }
    }
}
sealed interface AccountDes {
    @Serializable
    data object AccountMain : DiscoverDes
}


@Composable
private inline fun <reified T: ViewModel> NavBackStackEntry.sharedKoinViewModel(
    navController: NavController
): T {
    val navGraphRoute = destination.parent?.route ?: return koinViewModel<T>()
    val parentEntry = remember(this) {
        navController.getBackStackEntry(navGraphRoute)
    }
    return koinViewModel(
        viewModelStoreOwner = parentEntry
    )
}


package com.mobilewe.wemobile.presentation.common.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.mobilewe.wemobile.presentation.screen.account.account.AccountScreen
import com.mobilewe.wemobile.presentation.screen.auth.forgotPassword.ForgotPasswordScreen
import com.mobilewe.wemobile.presentation.screen.auth.login.LoginScreen
import com.mobilewe.wemobile.presentation.screen.auth.phoneRegistration.PhoneRegScreen
import com.mobilewe.wemobile.presentation.screen.auth.pickLanguage.PickLanguageScreen
import com.mobilewe.wemobile.presentation.screen.auth.register.registration.RegistrationScreen
import com.mobilewe.wemobile.presentation.screen.auth.register.registrationSubmit.RegistrationSubmitScreen
import com.mobilewe.wemobile.presentation.screen.auth.welcome.WelcomeScreen
import com.mobilewe.wemobile.presentation.screen.home.HomeScreen
import com.mobilewe.wemobile.presentation.screen.markets.MarketScreen
import com.mobilewe.wemobile.presentation.screen.onboarding.OnBoardingMainScreen
import com.mobilewe.wemobile.presentation.screen.transactions.NewTransactionScreen
import org.koin.compose.viewmodel.koinViewModel


@Composable
fun AppNavigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Route.AuthGraph){
        navigation<Route.AuthGraph>(
            startDestination = Route.Home
        ){
            composable<Route.Onboarding> {
                OnBoardingMainScreen(navController)
            }
            composable<Route.PickLanguauge> {
                PickLanguageScreen(
                    navigateToAuth = {
                        navController.navigate(Route.Welcome)
                    }
                )
            }
           composable<Route.PhoneRegister> {
                PhoneRegScreen(
                    onNavigate = {
                        navController.navigate(Route.RegisterDetails)
                    }
                )
            }

            composable<Route.Welcome> {
                WelcomeScreen(onLogin = { navController.navigate(Route.Login) },)
            }
            composable<Route.Login>{
                LoginScreen(
                    onBiometricSetUp = {
                        navController.navigate(Route.Verification)
                    },
                )
            }

          composable<Route.RegisterDetails>{
                RegistrationScreen(
                    onNavigateUp = { navController.popBackStack()},
                    onClickContinue = { navController.navigate(Route.RegistrationSubmit)}
                )
            }
            composable<Route.RegistrationSubmit> {
                RegistrationSubmitScreen(
                    onClickContinue = {  },
                    navigateBack = { navController.popBackStack()}
                )
            }

            composable<Route.ForgotPassword> {
                ForgotPasswordScreen(navController)
            }

            composable<Route.Home>{
                HomeScreen(navController)

            }

            composable<Route.Transact> {
                NewTransactionScreen(navController)
            }


            composable<Route.Discover>{
                MarketScreen()
            }
            composable<Route.Account> {
                AccountScreen(
                    onNavigateToStatement = {},
                    navigateToSettings = {},
                    navigateToNotification = {},
                    navigateToManagePin = {},
                    navigateBack = {},
                    navigateToManagePassword = {},
                    navigateToAboutSaccoRide = {}
                )
            }

        }
    }
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


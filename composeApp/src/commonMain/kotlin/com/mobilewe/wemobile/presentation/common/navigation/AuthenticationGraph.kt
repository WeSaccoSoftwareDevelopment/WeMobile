package com.mobilewe.wemobile.presentation.common.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import kotlinx.serialization.Serializable

import com.mobilewe.wemobile.presentation.screen.auth.forgotPassword.ForgotPasswordScreen
import com.mobilewe.wemobile.presentation.screen.auth.login.LoginScreen
import com.mobilewe.wemobile.presentation.screen.auth.phoneRegistration.PhoneRegScreen
import com.mobilewe.wemobile.presentation.screen.auth.register.registration.RegistrationScreen
import com.mobilewe.wemobile.presentation.screen.auth.register.registrationSubmit.RegistrationSubmitScreen
import com.mobilewe.wemobile.presentation.screen.auth.welcome.WelcomeScreen

fun NavGraphBuilder.authenticationGraph(navController: NavHostController){
    navigation<RootGraph.AuthenticationGraph>(startDestination = Auth.Welcome){

        composable<Auth.Welcome> {
            WelcomeScreen(
                onLogin = { navController.navigate(Auth.Login) }
            )
        }
        composable<Auth.PhoneRegister> {
            PhoneRegScreen(
                onNavigate = {
                    navController.navigate(Auth.RegisterDetails)
                }
            )
        }
        composable<Auth.Login>{
            LoginScreen(
                onBiometricSetUp = { navController.navigate(RootGraph.HomeGraph)},
                navigateBack = { navController.popBackStack()}
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
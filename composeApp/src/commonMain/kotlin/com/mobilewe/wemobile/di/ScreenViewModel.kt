package com.mobilewe.wemobile.di

import com.mobilewe.wemobile.app.AppViewModel
import com.mobilewe.wemobile.presentation.screen.account.account.AccountViewModel
import com.mobilewe.wemobile.presentation.screen.account.help.HelpViewModel
import com.mobilewe.wemobile.presentation.screen.account.notificationSettings.NotificationSettingsViewModel
import com.mobilewe.wemobile.presentation.screen.account.security.SecurityViewModel
import com.mobilewe.wemobile.presentation.screen.auth.login.LoginScreenModel
import com.mobilewe.wemobile.presentation.screen.auth.phoneRegistration.PhoneRegViewModel
import com.mobilewe.wemobile.presentation.screen.auth.pickLanguage.PickLanguageScreenModel
import com.mobilewe.wemobile.presentation.screen.auth.register.registration.RegistrationScreenModel
import com.mobilewe.wemobile.presentation.screen.auth.register.registrationSubmit.RegistrationSubmitScreenModel
import com.mobilewe.wemobile.presentation.screen.bankTransfer.BankTransferViewModel
import com.mobilewe.wemobile.presentation.screen.buyAirtime.buyAirtime.BuyAirtimeViewModel
import com.mobilewe.wemobile.presentation.screen.deposit.DepositScreenViewModel
import com.mobilewe.wemobile.presentation.screen.home.HomeViewModel
import com.mobilewe.wemobile.presentation.screen.main.MainViewModel
import com.mobilewe.wemobile.presentation.screen.onboarding.OnBoardViewModel
import com.mobilewe.wemobile.presentation.screen.payWithSacco.buyGoods.BuyGoodsViewModel
import com.mobilewe.wemobile.presentation.screen.payWithSacco.payWithSacco.PayWithSaccoViewModel
import com.mobilewe.wemobile.presentation.screen.payWithSacco.paybill.PayBillScreenViewModel
import com.mobilewe.wemobile.presentation.screen.payWithSacco.wesacco.WePayBillScreenViewModel
import com.mobilewe.wemobile.presentation.screen.requestMoney.requestMoney.RequestMoneyViewModel
import com.mobilewe.wemobile.presentation.screen.sendMoney.sendMoney.SendMoneyViewModel
import com.mobilewe.wemobile.presentation.screen.transactions.TransactViewModel
import com.mobilewe.wemobile.presentation.screen.withdraw.WithdrawScreenViewModel
import org.koin.core.module.dsl.factoryOf
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val screenViewModel = module {
    factoryOf(::AppViewModel)
    factoryOf(::PickLanguageScreenModel)
    factoryOf(::PhoneRegViewModel)
    factoryOf(::LoginScreenModel)
    factoryOf(::HomeViewModel)
    factoryOf(::TransactViewModel)
    factoryOf(::AccountViewModel)
    factoryOf(::RegistrationScreenModel)
    factoryOf(::RegistrationSubmitScreenModel)
    viewModelOf(::OnBoardViewModel)
    viewModelOf(::SecurityViewModel)
    viewModelOf(::NotificationSettingsViewModel)
    viewModelOf(::HelpViewModel)
    viewModelOf(::BuyAirtimeViewModel)
    viewModelOf(::BankTransferViewModel)
    viewModelOf(::DepositScreenViewModel)
    viewModelOf(::WithdrawScreenViewModel)
    viewModelOf(::PayBillScreenViewModel)
    viewModelOf(::BuyGoodsViewModel)
    viewModelOf(::WePayBillScreenViewModel)
    viewModelOf(::SendMoneyViewModel)
    viewModelOf(::RequestMoneyViewModel)
    viewModelOf(::MainViewModel)
    factoryOf(::PayWithSaccoViewModel)
}
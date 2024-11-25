package com.mobilewe.wemobile.presentation.screen.home.model

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.mobilewe.wemobile.resources.Resources
import wemobile.composeapp.generated.resources.Res
import wemobile.composeapp.generated.resources.ic_home
import wemobile.composeapp.generated.resources.icon_deposit
import wemobile.composeapp.generated.resources.loan_icon
import wemobile.composeapp.generated.resources.withdrawals_icon


@Composable
fun getHomeItems(): List<HomeItem> {
    return listOf(
        HomeItem(
            icon = Res.drawable.ic_home,
            title = Resources.strings.paySomeone,
            description = Resources.strings.paySomeoneDesc,
        ),
        HomeItem(
            icon = Res.drawable.withdrawals_icon,
            title = Resources.strings.requestMoney,
            description = Resources.strings.requestMoneyDesc
        ),
        HomeItem(
            icon = Res.drawable.icon_deposit,
            title = Resources.strings.buyAirtime,
            description = Resources.strings.buyAirtimeDesc
        ),
        HomeItem(
            icon = Res.drawable.loan_icon,
            title = Resources.strings.payBillAndBuyGoods,
            description = Resources.strings.payBillDescr
        )
    )
}

@Composable
fun getPayBillMerchants(navController: NavController): List<PaymentOption> {
    return listOf(
        PaymentOption(
            name = "Wesacco",
            category = "Send Money",
            onNavigate = { }
        ),
        PaymentOption(
            name = "Buy Goods",
            category = "Bank",
            onNavigate = {
//                navController.navigate(Graph.BUY_GOODS_ROUTE)
            }
        ),
        PaymentOption(
            name = "Pay Bill",
            category = "Bank",
            onNavigate = {
//                navController.navigate(Graph.PAY_BILL_ROUTE)
            }
        )
    )
}

@Composable
fun getBuyAirtimeOptions(navController: NavController): List<PaymentOption> {
    return listOf(
        PaymentOption(
            name = "Safaricom",
            category = "Send Money",
            onNavigate = {
//                navController.navigate(
//                    BUY_AIRTIME_ROUTE.replace("{$BUY_AIRTIME_PROVIDER_NAME}",SAFARICOM))
            }
        ),
        PaymentOption(
            name = "Airtel",
            category = "Bank",
            onNavigate = {
//                navController.navigate(
//                    BUY_AIRTIME_ROUTE.replace("{$BUY_AIRTIME_PROVIDER_NAME}", AIRTEL)
//                )
            }
        ),
        PaymentOption(
            name = "Telkom",
            category = "Bank",
            onNavigate = {
//                navController.navigate(
//                    BUY_AIRTIME_ROUTE.replace("{$BUY_AIRTIME_PROVIDER_NAME}", TELKOM)
//                )
            }
        )
    )
}


@Composable
fun getPaySomeone(navController: NavController): List<PaymentOption> {
    return listOf(
        PaymentOption(
            "Wessaco",
            "Send Money",
            onNavigate = {
//                navController.navigate(WE_PAYBILL_ROUTE)
            }
        ),
        PaymentOption(
            "Mobile",
            "Send Money",
            onNavigate = {
//                navController.navigate(REQUEST_MONEY_ROUTE)
            }
        ),
        PaymentOption(
            "Bank",
            "Bank",
            onNavigate = {
//                navController.navigate(BANK_TRANSFER_SCREEN_ROUTE)
            }
        ),
    )
}







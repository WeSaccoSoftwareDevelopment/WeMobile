package com.mobilewe.wemobile.presentation.screen.sendMoney.sendMoney

import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import com.mobilewe.wemobile.domain.model.RecipientProvider
import com.mobilewe.wemobile.presentation.common.list.SendMoneyProvider
import com.mobilewe.wemobile.presentation.common.list.UserAccountSelectionScreen

enum class SendMoneyModalSheetType{
    ACCOUNT,CONTACT,PROVIDER
}

@Composable
fun SendMoneyModalSheetLayout(
    modifier: Modifier = Modifier,
    sendMoneyModalSheetType: SendMoneyModalSheetType,
    onPhoneContactSelected: (String)-> Unit,
    onClose:()-> Unit,
    recipientProviderText: RecipientProvider,
    onRecipientProvider: (RecipientProvider) -> Unit

) {
    val coroutineScope = rememberCoroutineScope()
    when(sendMoneyModalSheetType){
        SendMoneyModalSheetType.ACCOUNT -> {
            UserAccountSelectionScreen(
                onClose = onClose,
                accountList = emptyList()
            )
        }
        SendMoneyModalSheetType.CONTACT -> {
//            ContactSelectionScreen(
//                onContactSelected = { contact ->
//                    coroutineScope.launch {
//                        onPhoneContactSelected(contact.phoneNumber)
//                    }
//                },
//            )
        }
        SendMoneyModalSheetType.PROVIDER -> {
            SendMoneyProvider(
                recipientProviderText = recipientProviderText,
                onRecipientProvider = onRecipientProvider
            )
        }
    }
}
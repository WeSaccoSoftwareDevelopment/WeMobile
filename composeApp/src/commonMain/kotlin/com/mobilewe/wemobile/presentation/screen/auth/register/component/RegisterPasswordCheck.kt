package com.mobilewe.wemobile.presentation.screen.auth.register.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Security
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.mobilewe.wemobile.domain.validation.ValidatePassword
import com.mobilewe.wemobile.presentation.common.composables.ConditionRow


@Composable
fun RegisterPasswordCheck(
    password: String,
    confirmPassword: String
) {
    val validatePassword = ValidatePassword()
    val passwordError = remember(password, confirmPassword) {
        validatePassword.execute(password, confirmPassword)
    }

    Column(
        modifier = Modifier.fillMaxWidth().padding(vertical = 24.dp),
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Icon(
                imageVector = Icons.Default.Security,
                contentDescription = null,
                modifier = Modifier.size(24.dp),
            )
            Text(
                text = "stringResource(id = R.string.validate_header)",
            )
        }
        Spacer(modifier = Modifier.height(15.dp))
        Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
            ConditionRow(
                condition = "stringResource(id = R.string.validateLetter)",
                check = passwordError.hasCapitalizedLetter
            )
            ConditionRow(
                condition = "stringResource(id = R.string.validateCharLong)",
                check = passwordError.hasMinimum
            )
            ConditionRow(
                condition = "stringResource(id = R.string.validate_specialChar)",
                check = passwordError.hasSpecialCharacter
            )
            ConditionRow(
                condition = "stringResource(id = R.string.passwordMatch)",
                check = passwordError.hasPasswordMatch
            )
        }

    }
}

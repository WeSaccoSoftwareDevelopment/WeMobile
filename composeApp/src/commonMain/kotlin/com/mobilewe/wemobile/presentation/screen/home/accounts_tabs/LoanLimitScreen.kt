package com.mobilewe.wemobile.presentation.screen.home.accounts_tabs

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

data class Loan(
    val loanId: String,
    val loanAmount: Double,
    val interestRate: Double,
    val loanTerm: Int, // in years
    val status: String
)

@Composable
fun LoanList(loans: List<Loan>) {
    LazyRow(
        modifier = Modifier.wrapContentSize(),
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        items(loans.size) { index ->
            LoanItem(loan = loans[index])
        }
    }
}

@Composable
fun LoanItem(loan: Loan) {
    Card(
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.cardElevation(4.dp),
    ) {
        Column(
            modifier = Modifier.fillMaxWidth().padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text(
                text = "Loan ID: ${loan.loanId}",
                style = TextStyle(fontSize = 16.sp, fontWeight = FontWeight.Bold)
            )
            Text(
                text = "Amount: $${loan.loanAmount}",
                style = TextStyle(fontSize = 14.sp, color = Color.Gray)
            )
            Text(
                text = "Interest Rate: ${loan.interestRate}%",
                style = TextStyle(fontSize = 14.sp, color = Color.Gray)
            )
            Text(
                text = "Term: ${loan.loanTerm} years",
                style = TextStyle(fontSize = 14.sp, color = Color.Gray)
            )
            Text(
                text = "Status: ${loan.status}",
                style = TextStyle(
                    fontSize = 14.sp,
                    color = when (loan.status) {
                        "Approved" -> Color(0xFF4CAF50) // Green
                        "Pending" -> Color(0xFFFFA000) // Amber
                        "Rejected" -> Color(0xFFF44336) // Red
                        else -> Color.Gray
                    }
                )
            )
        }
    }
}



@Composable
fun LoanLimitScreen(navController: NavController) {
    val loans = listOf(
        Loan(loanId = "L001", loanAmount = 5000.0, interestRate = 5.5, loanTerm = 5, status = "Approved"),
        Loan(loanId = "L002", loanAmount = 12000.0, interestRate = 4.2, loanTerm = 10, status = "Pending"),
        Loan(loanId = "L003", loanAmount = 7500.0, interestRate = 6.0, loanTerm = 3, status = "Rejected")
    )

    LoanList(loans = loans)
}


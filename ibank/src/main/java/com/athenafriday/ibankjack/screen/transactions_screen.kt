package com.athenafriday.ibankjack.screen

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

data class Transaction(
    val merchant: String,
    val amount: String,
    val date: String,
    val time: String,
    val merchantType: String
)

val dummyTransactions = listOf(
    Transaction("Amazon", "-$45.99", "2025-04-28", "14:35", "Electronics"),
    Transaction("Starbucks", "-$5.50", "2025-04-27", "09:15", "Groceries"),
    Transaction("Uber", "-$18.00", "2025-04-26", "22:00", "Transportation"),
    Transaction("Netflix", "-$15.99", "2025-04-25", "20:45", "Entertainment"),
    Transaction("Apple Store", "-$999.00", "2025-04-24", "16:30", "Electronics"),
    Transaction("Walmart", "-$123.45", "2025-04-23", "13:00", "Groceries"),
    Transaction("Shell Gas", "-$60.75", "2025-04-22", "08:20", "Gas"),
    Transaction("Best Buy", "-$320.00", "2025-04-21", "18:15", "Electronics"),
    Transaction("McDonald's", "-$12.40", "2025-04-20", "12:10", "Groceries"),
    Transaction("Spotify", "-$9.99", "2025-04-19", "07:30", "Entertainment"),
    Transaction("CVS Pharmacy", "-$34.20", "2025-04-18", "15:20", "Groceries"),
    Transaction("Costco", "-$250.00", "2025-04-17", "11:00", "Groceries"),
    Transaction("Target", "-$89.30", "2025-04-16", "10:45", "Groceries"),
    Transaction("Subway", "-$8.75", "2025-04-15", "13:50", "Groceries"),
    Transaction("Airbnb", "-$450.00", "2025-04-14", "19:00", "Travel"),
    Transaction("Lyft", "-$22.50", "2025-04-13", "21:30", "Transportation"),
    Transaction("Google Play", "-$2.99", "2025-04-12", "23:15", "Entertainment"),
    Transaction("eBay", "-$77.80", "2025-04-11", "17:20", "Electronics"),
    Transaction("Home Depot", "-$180.45", "2025-04-10", "14:10", "Home Improvement"),
    Transaction("Chick-fil-A", "-$11.25", "2025-04-09", "12:00", "Groceries")
)

@Composable
fun TransactionsScreen(
    modifier: Modifier = Modifier,
    onTransactionClick: (Transaction) -> Unit,
    onHomeClick: () -> Unit = {},
    onAddCardClick: () -> Unit = {},
    onShowCategoriesClick: () -> Unit = {}
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // Custom top bar using Row + Box
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp),
            contentAlignment = Alignment.Center
        ) {
            // Centered title
            Text(
                text = "Transactions",
                fontSize = 22.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color(0xFF1D1F2C)
            )

            // Left and right items
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                IconButton(onClick = onHomeClick) {
                    Icon(
                        imageVector = Icons.Default.Home,
                        contentDescription = "Home",
                        tint = Color(0xFFFF7A1A)
                    )
                }

                Text(
                    text = "Add Card",
                    color = Color(0xFFFF7A1A),
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium,
                    modifier = Modifier
                        .clickable(onClick = onAddCardClick)
                        .padding(end = 8.dp)
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .height(650.dp)
                .border(
                    width = 2.dp,
                    color = MaterialTheme.colorScheme.primary,
                    shape = MaterialTheme.shapes.medium
                )
                .padding(8.dp)
        ) {
            items(dummyTransactions) { transaction ->
                TransactionItem(transaction = transaction, onClick = onTransactionClick)
                Divider()
            }
        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 20.dp),
            contentAlignment = Alignment.Center
        ) {
            Button(
                onClick = onShowCategoriesClick,
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFF7A1A))
            ) {
                Text(
                    text = "Show Categories",
                    color = Color.White,
                    fontWeight = FontWeight.Bold
                )
            }
        }


    }
}

@Composable
fun TransactionItem(transaction: Transaction, onClick: (Transaction) -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 6.dp)
            .clickable { onClick(transaction) },

        colors = CardDefaults.cardColors(
            containerColor = Color(0xFFFFF3E0)
        ),

        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        shape = MaterialTheme.shapes.medium
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                Text(
                    text = transaction.merchant,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = transaction.date,
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.6f)
                )
            }
            Text(
                text = transaction.amount,
                style = MaterialTheme.typography.bodyLarge,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.primary
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun TransactionsScreenPreview() {
    TransactionsScreen(
        modifier = Modifier,
        onTransactionClick = {},
        onHomeClick = {},
        onAddCardClick = {}
    )
}

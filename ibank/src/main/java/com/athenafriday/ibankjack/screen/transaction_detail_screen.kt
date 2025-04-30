package com.athenafriday.ibankjack.screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

val dummyTransaction = Transaction("Amazon", "-$45.99", "2025-04-28", "14:35", "Electronics")

@Composable
fun TransactionTopBar(
    onBackClick: () -> Unit,
    onEditClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp)
            .padding(horizontal = 16.dp),
        contentAlignment = Alignment.Center
    ) {
        // Center Title
        Text(
            text = "Transaction",
            fontSize = 22.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color(0xFF1D1F2C)
        )

        // Back Arrow and Edit Button
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            IconButton(onClick = onBackClick) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Back",
                    tint = Color(0xFFFF7A1A)
                )
            }

//            Text(
//                text = "Edit",
//                color = Color(0xFFFF7A1A),
//                fontSize = 16.sp,
//                fontWeight = FontWeight.Medium,
//                modifier = Modifier
//                    .clickable(onClick = onEditClick)
//                    .padding(end = 8.dp)
//            )
        }
    }
}

@Composable
fun TransactionDetailScreen(
    transaction: Transaction = dummyTransaction,
    onBackClick: () -> Unit = {},
    onEditClick: () -> Unit = {}
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        TransactionTopBar(onBackClick, onEditClick)

        // Centered transaction details
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = transaction.merchant,
                style = MaterialTheme.typography.headlineLarge,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.primary,
                modifier = Modifier.padding(bottom = 32.dp)
            )

            DetailRow(label = "Amount", value = transaction.amount)
            Spacer(modifier = Modifier.height(20.dp))
            DetailRow(label = "Date", value = transaction.date)
            Spacer(modifier = Modifier.height(20.dp))
            DetailRow(label = "Time", value = transaction.time)
            Spacer(modifier = Modifier.height(20.dp))
            DetailRow(label = "Merchant Type", value = transaction.merchantType)
        }
    }
}

@Composable
fun DetailRow(label: String, value: String) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = label,
            style = MaterialTheme.typography.titleMedium,
            color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.7f)
        )
        Text(
            text = value,
            style = MaterialTheme.typography.headlineSmall,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier.padding(top = 6.dp)
        )
    }
}

@Preview
@Composable
fun TransactionDetailScreenPreview() {
    TransactionDetailScreen(dummyTransaction)
}

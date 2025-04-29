package ibank.transactions_screen

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.tooling.preview.Preview

data class CardDetails(
    val cardHolderName: String,
    val cardNumber: String,
    val expirationDate: String,
    val cvv: String
)

@Composable
fun AddCardScreen(
    onBackClick: () -> Unit = {},
    onAddCardClick: (CardDetails) -> Unit = {}
) {
    var cardHolderName by remember { mutableStateOf("") }
    var cardNumber by remember { mutableStateOf("") }
    var expirationDate by remember { mutableStateOf("") }
    var cvv by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        // Custom Top Bar
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp)
                .padding(horizontal = 16.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Add Card",
                fontSize = 22.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color(0xFF1D1F2C)
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(onClick = onBackClick) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = "Back",
                        tint = Color(0xFFFF7A1A)
                    )
                }
                Spacer(modifier = Modifier.weight(1f))
                // Nothing on the right (empty)
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        // Main Content
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 24.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            InputField(
                label = "Cardholder Name",
                value = cardHolderName,
                onValueChange = { cardHolderName = it }
            )

            Spacer(modifier = Modifier.height(16.dp))

            InputField(
                label = "Card Number",
                value = cardNumber,
                onValueChange = { cardNumber = it },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )

            Spacer(modifier = Modifier.height(16.dp))

            InputField(
                label = "Expiration Date (MM/YY)",
                value = expirationDate,
                onValueChange = { expirationDate = it },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )

            Spacer(modifier = Modifier.height(16.dp))

            InputField(
                label = "CVV",
                value = cvv,
                onValueChange = { cvv = it },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )

            Spacer(modifier = Modifier.height(32.dp))

            Button(
                onClick = {
                    onAddCardClick(CardDetails(cardHolderName, cardNumber, expirationDate, cvv))
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp),
                shape = RoundedCornerShape(12.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.primary
                )
            ) {
                Text(
                    text = "Add Card",
                    color = Color.White,
                    style = MaterialTheme.typography.bodyLarge
                )
            }
        }
    }
}

@Composable
fun InputField(
    label: String,
    value: String,
    onValueChange: (String) -> Unit,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default
) {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(
            text = label,
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.7f),
            modifier = Modifier.padding(bottom = 4.dp)
        )
        BasicTextField(
            value = value,
            onValueChange = onValueChange,
            keyboardOptions = keyboardOptions,
            textStyle = TextStyle(color = MaterialTheme.colorScheme.onBackground),
            modifier = Modifier
                .fillMaxWidth()
                .border(1.dp, MaterialTheme.colorScheme.primary, RoundedCornerShape(12.dp))
                .padding(start = 12.dp, end = 12.dp, top = 12.dp, bottom = 12.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun AddCardScreenPreview() {
    AddCardScreen()
}

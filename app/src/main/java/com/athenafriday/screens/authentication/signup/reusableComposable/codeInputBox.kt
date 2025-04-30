package com.athenafriday.iclickipay.signup.reusableComposable

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun VerificationCodeInput(
    modifier: Modifier = Modifier,
    digits: Int = 4, // control how many boxes
    boxSize: Dp = 56.dp, // optional: customize box size too
    spaceBetween: Dp = 8.dp // optional: customize spacing
) {
    val focusManager = LocalFocusManager.current
    val focusRequesters = remember { List(digits) { FocusRequester() } }
    val codes = remember { mutableStateListOf(*Array(digits) { "" }) }

    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(spaceBetween),
        verticalAlignment = Alignment.CenterVertically
    ) {
        codes.forEachIndexed { index, code ->
            OutlinedTextField(
                value = code,
                onValueChange = { newValue ->
                    if (newValue.length <= 1 && (newValue.isEmpty() || newValue.all { it.isDigit() })) {
                        codes[index] = newValue
                        if (newValue.isNotEmpty() && index < digits - 1) {
                            focusRequesters[index + 1].requestFocus()
                        }
                    }
                },
                singleLine = true,
                textStyle = LocalTextStyle.current.copy(
                    textAlign = TextAlign.Center
                ),
                modifier = Modifier
                    .width(boxSize)
                    .height(boxSize)
                    .focusRequester(focusRequesters[index]),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number,
                    imeAction = if (index == digits - 1) ImeAction.Done else ImeAction.Next
                )
            )
        }
    }
}

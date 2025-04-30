package com.athenafriday.iclickipay.signup.reusableComposable

import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

import androidx.compose.foundation.shape.RoundedCornerShape

@Composable
fun ConfirmButton(modifier: Modifier = Modifier, onClick: () -> Unit) {

    Button(
        modifier = modifier.width(257.dp).height(56.dp),
        shape = RoundedCornerShape(6.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(255,122,26),
            contentColor = Color.White
        )
        ,onClick = { onClick() }) {
        Text("Confirm")
    }
}

@Preview
@Composable
fun PreviewButton() {
    ConfirmButton(onClick = {})
}
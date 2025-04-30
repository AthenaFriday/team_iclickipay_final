package com.athenafriday.iclickipay.signup.reusableComposable

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.w3c.dom.Text

@Preview
@Composable
fun phoneNumberScreenTexts(modifier: Modifier = Modifier, bigText: String =  "bigText", smallText: String = "smallText"){

    Column(
        modifier = Modifier.fillMaxWidth().padding(30.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = bigText,
            style = MaterialTheme.typography.titleLarge
        )

        Spacer(Modifier.size(20.dp))

        Text(
            text = smallText,
            style = MaterialTheme.typography.bodyMedium
        )

    }


}
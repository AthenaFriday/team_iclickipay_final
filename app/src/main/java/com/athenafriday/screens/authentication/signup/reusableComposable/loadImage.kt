package com.athenafriday.iclickipay.signup.reusableComposable

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.athenafriday.iclickipay.R

@Composable
fun LoadImage(modifier: Modifier = Modifier, resource: Int) {
    Image(
        painter = painterResource(id = resource),
        contentDescription = null,
        modifier = modifier
    )
}

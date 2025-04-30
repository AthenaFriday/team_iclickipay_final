package com.athenafriday.iclickipay.signup

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.athenafriday.iclickipay.ui.theme.IclickIpayTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.remember
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.athenafriday.iclickipay.R
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.foundation.clickable
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.toSize
import com.athenafriday.iclickipay.signup.reusableComposable.ConfirmButton
import com.athenafriday.iclickipay.signup.reusableComposable.LoadImage
import com.athenafriday.iclickipay.signup.reusableComposable.Title
import com.athenafriday.iclickipay.signup.reusableComposable.VerificationCodeInput
import com.athenafriday.iclickipay.signup.reusableComposable.phoneNumberScreenTexts

@Preview
@Composable
fun phoneNumberScreen(modifier: Modifier = Modifier) {
    Column(modifier.fillMaxWidth().fillMaxHeight().padding(10.dp), horizontalAlignment = Alignment.CenterHorizontally) {
        Title()
        LoadImage(modifier.padding(20.dp).height(218.dp).width(267.dp), R.drawable.verify_phone_number)
        phoneNumberScreenTexts(modifier,"Verify your phone number", "Enter a 4-digit code to authenticate")
        VerificationCodeInput(modifier, 4)
        Spacer(modifier = Modifier.weight(1f)) // Pushes ConfirmButton to the bottom!
        ConfirmButton(modifier.padding(bottom = 30.dp), onClick = {})
    }
}

@Preview
@Composable
fun createYourCodeScreen(modifier: Modifier = Modifier) {
    Column(modifier.fillMaxWidth().fillMaxHeight().padding(10.dp), horizontalAlignment = Alignment.CenterHorizontally) {
        Title()
        LoadImage(modifier.padding(20.dp).height(218.dp).width(267.dp), R.drawable.create_your_code)
        phoneNumberScreenTexts(modifier,"Create your code", "Enter a 6-digit code to authenticate")
        VerificationCodeInput(modifier, 6)
        Spacer(modifier = Modifier.weight(1f)) // Pushes ConfirmButton to the bottom!
        ConfirmButton(modifier.padding(bottom = 30.dp), onClick = {})
    }
}

@Preview
@Composable
fun reconfirmYourCodeScreen(modifier: Modifier = Modifier) {
    Column(modifier.fillMaxWidth().fillMaxHeight().padding(10.dp), horizontalAlignment = Alignment.CenterHorizontally) {
        Title()
        LoadImage(modifier.padding(20.dp).height(218.dp).width(267.dp), R.drawable.create_your_code)
        phoneNumberScreenTexts(modifier,"Reconfirm your code", "Enter the same 6-digit code")
        VerificationCodeInput(modifier, 6)
        Spacer(modifier = Modifier.weight(1f)) // Pushes ConfirmButton to the bottom!
        ConfirmButton(modifier.padding(bottom = 30.dp), onClick = {})
    }
}

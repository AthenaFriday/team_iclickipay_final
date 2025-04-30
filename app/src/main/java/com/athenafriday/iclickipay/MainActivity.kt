package com.athenafriday.iclickipay

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.athenafriday.iclickipay.ui.login.LoginScreen
import com.athenafriday.iclickipay.ui.login.SplashScreen
import com.athenafriday.iclickipay.ui.theme.IclickIpayTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            IclickIpayTheme {
                SplashScreen() // 👈 Test SplashScreen
                //PasswordRecoveryScreen() // 👈 Uncomment to test Recovery
                //CodeVerificationScreen() // 👈 Uncomment to test Code Recovery
                LoginScreen()

            }
        }
    }
}


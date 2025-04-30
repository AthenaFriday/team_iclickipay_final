package com.athenafriday.iclickipay

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.athenafriday.iclickipay.login.LoginScreen
import com.athenafriday.iclickipay.ui.theme.IclickIpayTheme
import com.athenafriday.uberjerome.navigation.UberNavHost

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            IclickIpayTheme {
                TestChatModuleScreen()
//                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
//                    val navController = rememberNavController()
//                    Column(Modifier.padding(innerPadding)) {
//                        UberNavHost(navController)
//                    }
                }
            }
        }
    }


@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    IclickIpayTheme {
        Greeting("Android")
    }
}
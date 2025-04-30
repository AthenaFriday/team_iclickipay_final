package com.athenafriday.iclickipay

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.athenafriday.iclickipay.ui.theme.IclickIpayTheme
import com.athenafriday.navigation.AppNavGraph // ✅ Import your navigation graph

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            IclickIpayTheme {
                val navController = rememberNavController() // ✅ NavController needed
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Box(Modifier.padding(innerPadding)) {
                        AppNavGraph(navController = navController) // ✅ Use your nav graph

                    }
                }
            }

        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    IclickIpayTheme {
        Text("Dashboard Preview")
    }
}

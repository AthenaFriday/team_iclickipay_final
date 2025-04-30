package com.athenafriday.ibankjack.screen

import androidx.activity.compose.LocalOnBackPressedDispatcherOwner
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview
import com.athenafriday.ibankjack.R
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController


@Composable
fun IbankWelcomeScreen(
//    onBackClick: () -> Unit = {},
    onLetsGoClick: () -> Unit = {}
) {
    val backDispatcher = LocalOnBackPressedDispatcherOwner.current?.onBackPressedDispatcher
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 24.dp)
    ) {
        // Top Bar
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(
//                onClick = onBackClick
                onClick = { backDispatcher?.onBackPressed() }

            ) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Back",
                    tint = Color(0xFFFF7A1A)
                )
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        // Image
        Image(
            painter = painterResource(id = R.drawable.ibank_welcome),
            contentDescription = "Welcome Image",
            modifier = Modifier
                .fillMaxWidth()
                .height(250.dp),
            contentScale = ContentScale.Fit
        )

        Spacer(modifier = Modifier.height(32.dp))

        // Title
        Text(
            text = "Bank",
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF1D1F2C),
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Subtitle / Description
        Text(
            text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis lobortis sit amet odio in egestas. Pellen tesque ultricies justo.",
            fontSize = 16.sp,
            color = Color.Gray,
            lineHeight = 22.sp,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(horizontal = 8.dp),
            textAlign = androidx.compose.ui.text.style.TextAlign.Center
        )

        Spacer(modifier = Modifier.height(48.dp))

        // Let's Go Button
        Button(
            onClick = onLetsGoClick,
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFFF7A1A),
                contentColor = Color.White
            ),
            shape = RoundedCornerShape(12.dp),
            elevation = ButtonDefaults.buttonElevation(
                defaultElevation = 8.dp
            )
        ) {
            Text(
                text = "Let’s go",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun IbankWelcomeScreenPreview() {
    IbankWelcomeScreen()
}

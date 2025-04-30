package com.athenafriday.chatcarlos.chatscreens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Chat
import androidx.compose.material.icons.filled.ChatBubble
import androidx.compose.material.icons.outlined.ChatBubble
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.athenafriday.chatcarlos.R // Update this based on your package

data class ChatItem(
    val profileImage: Int,
    val name: String,
    val message: String,
    val date: String
)

@Composable
fun ChatListScreen() {
    val chatList = listOf(
        ChatItem(R.drawable.profile1, "Rebecca Moore", "Hi my love! How are you today? 😊", "Today"),
        ChatItem(R.drawable.profile2, "Franz Ferdinand", "📎 Check it out!", "02/03/2019")
    )

    Box(modifier = Modifier.fillMaxSize()) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 72.dp)
        ) {
            items(chatList) { chat ->
                ChatListItem(chat)
            }
        }

        FloatingActionButton(
            onClick = { /* TODO */ },
            containerColor = Color(0xFFFF7F2A),
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(16.dp)
        ) {
            Icon(
                imageVector = Icons.Default.ChatBubble,
                contentDescription = "New Chat",
                tint = Color.White
            )
        }
    }
}

@Composable
fun ChatListItem(chat: ChatItem) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = chat.profileImage),
            contentDescription = null,
            modifier = Modifier.size(48.dp)
        )
        Spacer(modifier = Modifier.width(12.dp))
        Column {
            Text(text = chat.name, style = MaterialTheme.typography.bodyLarge)
            Text(text = chat.message, fontSize = 14.sp, color = Color.Gray)
            Text(text = chat.date, fontSize = 12.sp, color = Color.LightGray)
        }
    }
}

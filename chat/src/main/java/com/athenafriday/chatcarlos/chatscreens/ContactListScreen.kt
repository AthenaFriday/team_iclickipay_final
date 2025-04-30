package com.athenafriday.chatcarlos.chatscreens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.athenafriday.chatcarlos.R

data class ContactItem(
    val name: String,
    val profileImage: Int,
    val status: String = ""
)

@Composable
fun ContactListScreen() {
    val contactList = listOf(
        ContactItem("Rebecca Moore", R.drawable.profile1, "online"),
        ContactItem("Franz Ferdinand", R.drawable.profile2, "last seen 1h ago"),
    )

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(vertical = 8.dp)
    ) {
        items(contactList) { contact ->
            ContactListItem(contact)
        }
    }
}

@Composable
fun ContactListItem(contact: ContactItem) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = contact.profileImage),
            contentDescription = "Profile",
            modifier = Modifier.size(48.dp)
        )

        Spacer(modifier = Modifier.width(12.dp))

        Column {
            Text(text = contact.name, style = MaterialTheme.typography.bodyLarge)
            if (contact.status.isNotBlank()) {
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = contact.status,
                    fontSize = 12.sp,
                    color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f)
                )
            }
        }
    }
}

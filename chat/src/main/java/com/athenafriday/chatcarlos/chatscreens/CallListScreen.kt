package com.athenafriday.chatcarlos.chatscreens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.athenafriday.chatcarlos.R

data class CallItem(
    val name: String,
    val profileImage: Int,
    val time: String,
    val callType: CallType // incoming, outgoing, missed
)

enum class CallType {
    INCOMING, OUTGOING, MISSED
}

@Composable
fun CallListScreen() {
    val callList = listOf(
        CallItem("Rebecca Moore", R.drawable.profile1, "Today, 11:30 AM", CallType.INCOMING),
        CallItem("Franz Ferdinand", R.drawable.profile2, "Yesterday, 9:42 PM", CallType.MISSED)
    )

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(vertical = 8.dp)
    ) {
        items(callList) { call ->
            CallListItem(call)
        }
    }
}

@Composable
fun CallListItem(call: CallItem) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = call.profileImage),
            contentDescription = "Caller Profile",
            modifier = Modifier.size(48.dp)
        )

        Spacer(modifier = Modifier.width(12.dp))

        Column(modifier = Modifier.weight(1f)) {
            Text(text = call.name, style = MaterialTheme.typography.bodyLarge)
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = call.time,
                fontSize = 12.sp,
                color = when (call.callType) {
                    CallType.MISSED -> Color.Red
                    else -> Color.Gray
                }
            )
        }

        Icon(
            imageVector = Icons.Default.Call,
            contentDescription = "Call",
            tint = Color(0xFFFF7F2A),
            modifier = Modifier.size(24.dp)
        )
    }
}

//@Preview(showBackground = true)
//@Composable
//fun CallListItemPreview() {
//    CallListItem(
//        call = CallItem(
//            name = "Jane Doe",
//            profileImage = R.drawable.profile1,
//            time = "Today, 10:45 AM",
//            callType = CallType.OUTGOING
//        )
//    )
//}

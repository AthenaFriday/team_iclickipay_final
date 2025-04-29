package ibank.transactions_screen

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview

data class Category(
    val name: String,
    val percentage: Float,
    val color: Color
)

@Composable
fun CategoriesScreen(
    onBackClick: () -> Unit = {}
) {
    val categories = listOf(
        Category("Travel", 20f, Color(0xFF42A5F5)),
        Category("Groceries", 30f, Color(0xFF66BB6A)),
        Category("Gas", 15f, Color(0xFFFFA726)),
        Category("Shopping", 35f, Color(0xFFAB47BC))
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp)
                .padding(horizontal = 16.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Categories",
                fontSize = 22.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color(0xFF1D1F2C)
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(onClick = onBackClick) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = "Back",
                        tint = Color(0xFFFF7A1A)
                    )
                }
                Spacer(modifier = Modifier.weight(1f))
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 24.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(contentAlignment = Alignment.Center) {
                PieChart(categories = categories, size = 250.dp)

                Box(
                    modifier = Modifier
                        .size(100.dp)
                        .background(Color.White, shape = CircleShape),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "$2345",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF1D1F2C)
                    )
                }
            }

            Spacer(modifier = Modifier.height(32.dp))

            categories.forEach { category ->
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .padding(vertical = 12.dp) // ⬅️ Increased vertical padding!
                ) {
                    Box(
                        modifier = Modifier
                            .size(16.dp)
                            .background(
                                color = category.color,
                                shape = MaterialTheme.shapes.small
                            )
                    )
                    Spacer(modifier = Modifier.width(12.dp)) // ⬅️ (optional) slightly wider space between dot and text
                    Text(
                        text = "${category.name}: ${category.percentage}%",
                        fontSize = 16.sp
                    )
                }
            }

        }
    }
}

@Composable
fun PieChart(categories: List<Category>, size: Dp) {
    Canvas(
        modifier = Modifier
            .size(size)
    ) {
        var startAngle = -90f

        categories.forEach { category ->
            val sweepAngle = 360 * (category.percentage / 100)

            drawArc(
                color = category.color,
                startAngle = startAngle,
                sweepAngle = sweepAngle,
                useCenter = true,
                size = Size(size.toPx(), size.toPx())
            )

            startAngle += sweepAngle
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CategoriesScreenPreview() {
    CategoriesScreen()
}

package com.techconsulting.pet.ui.theme



import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val LightColorScheme = lightColorScheme(
    primary = Color(0xFFFF7F27),
    onPrimary = Color.White,
    background = Color.White,
    onBackground = Color.Black,
)

private val DarkColorScheme = darkColorScheme(
    primary = Color(0xFFFF7F27),
    onPrimary = Color.Black,
    background = Color(0xFF121212),
    onBackground = Color.White,
)

@Composable
fun PetTheme(
    useDarkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = if (useDarkTheme) DarkColorScheme else LightColorScheme

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography(),
        shapes = Shapes(),
        content = content
    )
}

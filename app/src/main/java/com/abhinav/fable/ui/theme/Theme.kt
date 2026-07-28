package com.abhinav.fable.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable


private val DarkColorScheme = darkColorScheme(
    primary = FableGold,
    background = DarkBackground,
    surface = DarkSurface,
    onBackground = DarkText,
    onSurface = DarkText,
    onSurfaceVariant = DarkTextSecondary
)

private val LightColorScheme = lightColorScheme(
    primary = FableGold,
    background = LightBackground,
    surface = LightSurface,
    onBackground = LightText,
    onSurface = LightText,
    onSurfaceVariant = LightTextSecondary
)

@Composable
fun FableTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}
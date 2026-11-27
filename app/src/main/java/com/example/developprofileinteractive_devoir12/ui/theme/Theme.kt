package com.example.developprofileinteractive_devoir12.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val LightColorScheme = lightColorScheme(
    primary = Teal40,
    primaryContainer = TealContainerLight,
    onPrimaryContainer = OnTealContainerLight,
    secondary = SlateTeal40,
    secondaryContainer = SlateTealContainerLight,
    onSecondaryContainer = OnSlateTealContainerLight,
    tertiary = Blue40
)

private val DarkColorScheme = darkColorScheme(
    primary = Teal80,
    onPrimary = Teal20,
    primaryContainer = TealContainerDark,
    onPrimaryContainer = TealContainerLight,
    secondary = SlateTeal80,
    secondaryContainer = SlateTealContainerDark,
    onSecondaryContainer = SlateTealContainerLight,
    tertiary = Blue80,
    onTertiary = Blue20
)

@Composable
fun DeveloperProfileTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme,
        typography = DeveloperProfileTypography,
        shapes = DeveloperProfileShapes,
        content = content
    )
}

package com.example.cocktail_human_android.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import com.google.accompanist.systemuicontroller.rememberSystemUiController

private val DarkColorPalette = darkColors(
    primary = md_theme_dark_primary,
    secondary = md_theme_dark_secondary,
    onPrimary = md_theme_dark_onPrimary,
    onSecondary = md_theme_dark_onSecondary,
    surface = md_theme_dark_surface,
    onSurface = md_theme_dark_onSurface,
    background = md_theme_dark_background,
    onBackground = md_theme_dark_onBackground,
    error = md_theme_dark_error,
    onError = md_theme_dark_onError
)

private val LightColorPalette = lightColors(
    primary = md_theme_light_primary,
    secondary = md_theme_light_secondary,
    onPrimary = md_theme_light_onPrimary,
    onSecondary = md_theme_light_onSecondary,
    surface = md_theme_light_surface,
    onSurface = md_theme_light_onSurface,
    background = md_theme_light_background,
    onBackground = md_theme_light_onBackground,
    error = md_theme_light_error,
    onError = md_theme_light_onError
)

@Composable
fun COCKTAIL_HUMAN_ANDROIDTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val systemUiController = rememberSystemUiController()
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }
    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}
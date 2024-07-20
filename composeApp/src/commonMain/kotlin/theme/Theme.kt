package theme

import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier


internal val LocalThemeIsDark = compositionLocalOf { mutableStateOf(true) }

@Composable
internal fun AppTheme(
    content: @Composable() () -> Unit
) {
    val isDark = isSystemInDarkTheme()
    val isDarkState = remember { mutableStateOf(isDark) }

    CompositionLocalProvider(
        LocalThemeIsDark provides isDarkState,
        LocalColor provides darkPalette,
        content = {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Theme.colors.primaryBackground)
            ) {
                content.invoke()
            }
        }
    )
}


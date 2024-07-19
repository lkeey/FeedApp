package theme

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

val darkPalette = Colors(
    primaryBackground = Color(0xFF222222),
    primaryText = Color(0xFFFFFFFF),

    secondaryText = Color(0xFFFFFFFF),
    secondaryBackground = Color(0xFFFFFFFF),

    tintColor = Color(0xFFFFFFFF),
)

val LocalColor = staticCompositionLocalOf<Colors> { error("no default implementation for colors") }

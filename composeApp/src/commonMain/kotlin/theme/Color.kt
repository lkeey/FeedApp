package theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

val darkPalette = Colors(
    primaryBackground = Color(0xFF141217),
    primaryText = Color.White,
    secondaryBackground = Color(0xFF302938),
    secondaryText = Color.White,
    tintColor = Color(0xFFAB9EB8),
    dividerColor = Color(0xFF473D54)
)

val LocalColor = staticCompositionLocalOf<Colors> { error("no default implementation for colors") }

object Theme {
    val colors: Colors
        @Composable
        get() = LocalColor.current
}

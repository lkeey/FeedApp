package features.splash

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import theme.Theme

@Composable
fun SplashView (

) {
    Text(
        modifier = Modifier
            .fillMaxSize(),
        text = "Loading on Splash",
        color = Theme.colors.primaryText,
        fontWeight = FontWeight.Bold,
        fontSize = 52.sp
    )
}

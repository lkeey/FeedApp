import androidx.compose.runtime.*
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import feature_create.CreatePostScreen
import feature_feed.FeedScreen
import feature_login.LoginScreen
import feature_paywall.PayWallScreen
import navigation.AppScreens
import navigation.LocalNavHost
import navigation.feature_main.MainScreen

@Composable
fun App() = AppTheme {
    FeedApp()
}

@Composable
internal fun FeedApp(
    navController: NavHostController = rememberNavController()
) {
    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentScreen = backStackEntry?.destination?.route ?: AppScreens.Login

    CompositionLocalProvider(
        LocalNavHost provides navController
    ) {
        NavHost(
            navController = navController,
            startDestination = AppScreens.Login.title
        ) {
            composable(route = AppScreens.Login.title) {
                LoginScreen()
            }
            composable(route = AppScreens.Main.title) {
                MainScreen()
            }
            composable(route = AppScreens.CreatePost.title) {
                CreatePostScreen()
            }
            composable(route = AppScreens.Paywall.title) {
                PayWallScreen()
            }
        }
    }
}
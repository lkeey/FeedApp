package features.splash

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import features.splash.models.SplashAction
import navigation.AppScreens

@Composable
fun SplashScreen(
    viewModel: SplashViewModel = viewModel { SplashViewModel() },
    navController: NavController
) {
    val viewAction by viewModel.viewActions().collectAsState(null)

    SplashView(

    )

    when (viewAction) {
        SplashAction.ShowLoginScreen -> navController.navigate(AppScreens.Login.title)
        SplashAction.ShowMainScreen -> navController.navigate(AppScreens.Main.title)
        null -> { }
    }
}

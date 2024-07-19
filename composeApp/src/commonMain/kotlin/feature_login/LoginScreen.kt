package feature_login

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import feature_login.models.LoginAction
import navigation.LocalNavHost

@Composable
fun LoginScreen(
    viewModel: LoginViewModel = viewModel { LoginViewModel() }
) {
    val navHost = LocalNavHost.current
    val viewState by viewModel.viewStates().collectAsState()
    val viewAction by viewModel.viewActions().collectAsState(null)

    LoginView(
        viewState = viewState
    ) { event ->
        viewModel.obtainEvent(event)
    }

    when (viewAction) {
        LoginAction.OpenMainScreen -> {

            viewModel.clearAction()
        }
        null -> { }
    }
}

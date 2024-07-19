package feature_login

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import feature_login.models.LoginEvent
import feature_login.models.LoginViewState

@Composable
internal fun LoginView (
    viewState: LoginViewState,
    eventHandler: (LoginEvent) -> Unit
) {
    Column {
        Text(
            viewState.emailValue
        )
    }
}

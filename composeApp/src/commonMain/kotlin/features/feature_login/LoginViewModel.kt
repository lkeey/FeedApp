package features.feature_login

import base.BaseViewModel
import features.feature_login.models.LoginAction
import features.feature_login.models.LoginEvent
import features.feature_login.models.LoginViewState

class LoginViewModel : BaseViewModel<LoginViewState, LoginAction, LoginEvent> (
    initialState = LoginViewState()
) {
    override fun obtainEvent(viewEvent: LoginEvent) {
        when (viewEvent) {
            is LoginEvent.EmailChanged -> {
                viewState = viewState.copy(
                    emailValue = viewState.emailValue
                )
            }
            is LoginEvent.PasswordChanged -> {
                viewState = viewState.copy(
                    passwordValue = viewState.passwordValue
                )
            }

            LoginEvent.LoginClicked -> TODO()
            LoginEvent.SignUpClicked -> TODO()
        }
    }
}

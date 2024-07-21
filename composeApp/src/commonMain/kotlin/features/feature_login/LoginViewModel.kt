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
                    emailValue = viewEvent.newEmail
                )
            }
            is LoginEvent.PasswordChanged -> {
                viewState = viewState.copy(
                    passwordValue = viewEvent.newPassword
                )
            }

            LoginEvent.LoginClicked -> {
                viewAction = LoginAction.OpenMainScreen
            }

            LoginEvent.SignUpClicked -> {
                onSignUpClicked()
            }
        }
    }

    private fun onSignUpClicked() {

    }
}

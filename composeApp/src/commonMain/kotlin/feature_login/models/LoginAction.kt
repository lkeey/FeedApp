package feature_login.models

sealed class LoginAction {
    data object OpenMainScreen : LoginAction()
}

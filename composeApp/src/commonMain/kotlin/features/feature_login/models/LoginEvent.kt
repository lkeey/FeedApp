package features.feature_login.models

sealed class LoginEvent {
    class EmailChanged(val newEmail : String) : LoginEvent()
    class PasswordChanged(val newPassword : String) : LoginEvent()
    data object LoginClicked : LoginEvent()
    data object SignUpClicked : LoginEvent()
}

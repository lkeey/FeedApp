package feature_login

import base.BaseViewModel
import feature_login.models.LoginAction
import feature_login.models.LoginEvent
import feature_login.models.LoginViewState

class LoginViewModel : BaseViewModel<LoginViewState, LoginAction, LoginEvent> (
    initialState = LoginViewState()
) {
    override fun obtainEvent(viewEvent: LoginEvent) {
        TODO("Not yet implemented")
    }
}
package features.splash

import base.BaseViewModel
import features.feature_login.domain.IsUserAuthorizedUseCase
import features.splash.models.SplashAction

class SplashViewModel (
    private val isUserAuthorizedUseCase: IsUserAuthorizedUseCase = IsUserAuthorizedUseCase()
) : BaseViewModel<Unit, SplashAction, Unit> (
    initialState = Unit
) {

    init {
        checkUserAuthorized()
    }

    override fun obtainEvent(viewEvent: Unit) {

    }

    private fun checkUserAuthorized() {
        viewAction = if (isUserAuthorizedUseCase.execute()) {
            SplashAction.ShowMainScreen
        } else {
            SplashAction.ShowLoginScreen
        }
    }

}

package features.feature_profile.presentation

import base.BaseViewModel
import features.feature_profile.presentation.models.ProfileAction
import features.feature_profile.presentation.models.ProfileEvent
import features.feature_profile.presentation.models.ProfileViewState

class ProfileViewModel (

) : BaseViewModel<ProfileViewState, ProfileAction, ProfileEvent> (initialState =  ProfileViewState()){
    override fun obtainEvent(viewEvent: ProfileEvent) {
        when (viewEvent) {
            is ProfileEvent.TabSelected -> viewState = viewState.copy(
                selectedTabIndex = viewEvent.selectedIndex
            )
        }
    }
}

package features.feature_profile.presentation.models

sealed class ProfileEvent {
    class TabSelected(val selectedIndex: Int) : ProfileEvent()
}

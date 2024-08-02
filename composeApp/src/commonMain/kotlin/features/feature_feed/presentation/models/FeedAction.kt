package features.feature_feed.presentation.models

import features.feature_login.models.LoginAction

sealed class FeedAction {
    data object OnOpenPost : FeedAction()
}

package features.feature_feed.presentation.models

sealed class FeedEvent {
    data object OnRefresh : FeedEvent()
    data object OnSearchQueryUpdate : FeedEvent()
}

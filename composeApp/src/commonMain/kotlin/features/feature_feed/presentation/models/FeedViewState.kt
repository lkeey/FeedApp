package features.feature_feed.presentation.models

import core.util.ScreenState
import features.feature_feed.domain.models.Character

data class FeedViewState(
    val screenState: ScreenState = ScreenState.LOADING,
    val characters: List<Character> = listOf()
)
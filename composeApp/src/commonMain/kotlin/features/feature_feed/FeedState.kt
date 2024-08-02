package features.feature_feed

import core.util.ScreenState
import features.feature_feed.models.Character

data class FeedState(
    val screenState: ScreenState = ScreenState.LOADING,
    val characters: List<Character> = listOf()
)
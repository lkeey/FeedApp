package features.feature_feed.presentation

import base.BaseViewModel
import core.util.ScreenState
import features.feature_feed.domain.usecases.CharactersUseCase
import features.feature_feed.presentation.models.FeedAction
import features.feature_feed.presentation.models.FeedEvent
import features.feature_feed.presentation.models.FeedViewState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.launch

class FeedViewModel : BaseViewModel<FeedViewState, FeedAction, FeedEvent>(
    initialState = FeedViewState()
) {

    init {
        fetchCharacters()
    }

    override fun obtainEvent(viewEvent: FeedEvent) {
        when (viewEvent) {
            FeedEvent.OnRefresh -> {
                fetchCharacters()
            }
            FeedEvent.OnSearchQueryUpdate -> {

            }
        }
    }

    private fun fetchCharacters() {
        CoroutineScope(Dispatchers.IO).launch {
            viewState = viewState.copy(
                screenState = ScreenState.LOADING,
            )

            CharactersUseCase().getCharacters(
                onSuccess = { characters->
                    viewState = viewState.copy(
                        screenState = ScreenState.SUCCESS,
                        characters = characters
                    )
                },
                onError = {
                    viewState = viewState.copy(
                        screenState = ScreenState.ERROR,
                    )
                }
            )
        }
    }
}

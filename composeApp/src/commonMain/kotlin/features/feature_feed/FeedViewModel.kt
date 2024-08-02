package features.feature_feed

import androidx.lifecycle.ViewModel
import base.BaseViewModel
import core.network.Ktor
import core.util.ScreenState
import features.feature_feed.models.Character
import io.ktor.client.call.body
import io.ktor.client.request.get
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class FeedViewModel : ViewModel() {
    private val _uiState: MutableStateFlow<FeedState> = MutableStateFlow(FeedState())
    val uiState = _uiState.asStateFlow()


    init {
        fetchCharacters()
    }

    private fun fetchCharacters() {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val characters = Ktor.client.get("Characters").body<List<Character>>()
                _uiState.value = FeedState(
                    screenState = ScreenState.SUCCESS,
                    characters = characters
                )
            } catch (e: Exception) {
                _uiState.value = FeedState(
                    screenState = ScreenState.ERROR
                )
            }
        }
    }
}

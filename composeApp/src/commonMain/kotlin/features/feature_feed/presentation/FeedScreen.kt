package features.feature_feed.presentation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import features.feature_feed.presentation.models.FeedAction

@Composable
fun FeedScreen(
    viewModel: FeedViewModel = androidx.lifecycle.viewmodel.compose.viewModel { FeedViewModel() }
) {

    val viewState by viewModel.viewStates().collectAsState()
    val viewAction by viewModel.viewActions().collectAsState(null)

    FeedView(
        viewState = viewState
    ) { event ->
        viewModel.obtainEvent(event)
    }

    when (viewAction) {
        FeedAction.OnOpenPost -> {

        }
        null -> { }
    }
}



package features.feature_feed

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import core.util.ScreenState

@Composable
fun FeedScreen(
    viewModel: FeedViewModel = androidx.lifecycle.viewmodel.compose.viewModel { FeedViewModel() }
) {
    val viewState by viewModel.uiState.collectAsState()

    when (viewState.screenState) {
        ScreenState.LOADING -> {
            // handle loading animation
        }

        ScreenState.SUCCESS -> {
            LazyVerticalGrid(
                modifier = Modifier.fillMaxSize().padding(8.dp),
                columns = GridCells.Adaptive(minSize = 128.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(viewState.characters) { character ->
                    CharacterCard(character)
                }
            }
        }

        ScreenState.ERROR -> {
            Text("Request failed")
        }
    }
//    FeedView()
}



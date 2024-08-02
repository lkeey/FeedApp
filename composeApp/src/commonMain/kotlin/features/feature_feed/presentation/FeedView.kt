package features.feature_feed.presentation

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import core.util.ScreenState
import features.feature_feed.presentation.items.CharacterCard
import features.feature_feed.presentation.models.FeedEvent
import features.feature_feed.presentation.models.FeedViewState
import feedapp.composeapp.generated.resources.Res
import org.jetbrains.compose.resources.painterResource

@Composable
fun FeedView (
    viewState: FeedViewState,
    eventHandler: (FeedEvent) -> Unit
) {
    Column (
        modifier = Modifier.fillMaxSize()
    ) {
        Row (
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                modifier = Modifier
                    .height(64.dp),
                textAlign = TextAlign.Center,
                text = "Feed",
                color = Color.White,
                fontSize = 50.sp
            )


            Text(
                modifier = Modifier
                    .height(64.dp)
                    .clickable {
                        eventHandler(FeedEvent.OnRefresh)
                    },
                textAlign = TextAlign.Center,
                text = "Refresh",
                color = Color.White,
                fontSize = 50.sp
            )
        }

        when (viewState.screenState) {
            ScreenState.LOADING -> {
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(64.dp),
                    textAlign = TextAlign.Center,
                    text = "Loading",
                    color = Color.White,
                    fontSize = 50.sp
                )
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
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(64.dp),
                    textAlign = TextAlign.Center,
                    text = "Request failed",
                    color = Color.White,
                    fontSize = 50.sp
                )
            }
        }
    }
}

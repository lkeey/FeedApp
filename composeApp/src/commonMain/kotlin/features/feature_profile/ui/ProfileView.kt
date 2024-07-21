package features.feature_profile.ui

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import common.button.FSecondaryButton
import features.feature_profile.presentation.models.ProfileEvent
import features.feature_profile.presentation.models.ProfileViewState
import features.feature_profile.ui.views.ProfileTabsView
import feedapp.composeapp.generated.resources.Res
import feedapp.composeapp.generated.resources.profile_about
import feedapp.composeapp.generated.resources.profile_playlists
import feedapp.composeapp.generated.resources.profile_subscribe
import feedapp.composeapp.generated.resources.profile_subscribed
import feedapp.composeapp.generated.resources.profile_title
import feedapp.composeapp.generated.resources.profile_videos
import org.jetbrains.compose.resources.stringResource
import theme.Theme

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ProfileView(
    viewState: ProfileViewState,
    eventHandler: (ProfileEvent) -> Unit
) {
    LazyColumn {
        stickyHeader {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(72.dp)
                    .padding(start = 16.dp, end = 16.dp, top = 16.dp, bottom = 8.dp)
            ) {
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = stringResource(Res.string.profile_title),
                    color = Theme.colors.primaryText,
                    textAlign = TextAlign.Center,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            Box(
                modifier = Modifier
                    .padding(16.dp)
                    .clip(RoundedCornerShape(64.dp))
                    .size(128.dp)
                    .background(Color.White)
            )

            Column(modifier = Modifier.padding(start = 16.dp)) {
                Text(
                    text = viewState.name,
                    color = Theme.colors.primaryText,
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(text = viewState.subscribers, color = Theme.colors.tintColor, fontSize = 16.sp)
                Text(text = viewState.joinedIn, color = Theme.colors.tintColor, fontSize = 16.sp)
            }
        }

        if (viewState.isSubscribed != null) {
            item {
                FSecondaryButton(
                    modifier = Modifier.padding(16.dp).fillMaxWidth(),
                    text = stringResource(if (!viewState.isSubscribed) Res.string.profile_subscribe else Res.string.profile_subscribed)
                ) {

                }
            }
        }

        item {
            ProfileTabsView(
                items = listOf(
                    stringResource(Res.string.profile_videos),
                    stringResource(Res.string.profile_playlists),
                    stringResource(Res.string.profile_about)
                ),
                selectedIndex = viewState.selectedTabIndex
            ) {
                eventHandler.invoke(ProfileEvent.TabSelected(it))
            }
        }

        item {
            Box(modifier = Modifier.padding(16.dp).fillMaxWidth()) {
                when (viewState.selectedTabIndex) {
                    0 -> ProfileVideosView()
                    1 -> ProfilePlaylistsView()
                    2 -> ProfileAboutView()
                }
            }
        }
    }
}


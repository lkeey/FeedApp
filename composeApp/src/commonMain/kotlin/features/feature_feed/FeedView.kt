package features.feature_feed

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import features.feature_profile.presentation.models.ProfileViewState
import features.feature_profile.ui.ProfileView

@Composable
fun FeedView (

) {
    Text(
        modifier = Modifier
            .fillMaxWidth()
            .height(64.dp),
        textAlign = TextAlign.Center,
        text = "Home",
        color = Color.White,
        fontSize = 50.sp
    )

    ProfileView(
        ProfileViewState(),
        {

        }
    )
}

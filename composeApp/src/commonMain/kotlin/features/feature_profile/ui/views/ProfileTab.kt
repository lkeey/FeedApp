package features.feature_profile.ui.views

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import theme.Theme

@Composable
internal fun ProfileTab(
    title: String,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .clickable {
                onClick.invoke()
            }
            .width(IntrinsicSize.Min)
            .fillMaxHeight()
    ) {
        Text(
            modifier = Modifier
                .width(IntrinsicSize.Max)
                .align(Alignment.Center),
            text = title,
            color = if (isSelected) Theme.colors.primaryText else Theme.colors.tintColor
        )

        Divider(
            modifier = Modifier
                .height(3.dp)
                .align(Alignment.BottomStart),
            color = if (isSelected) Theme.colors.primaryText else Theme.colors.tintColor,
        )
    }
}
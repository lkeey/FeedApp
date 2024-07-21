package features.feature_profile.ui.views

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import theme.Theme

@Composable
fun ProfileTabsView(
    items: List<String>,
    selectedIndex: Int,
    onItemSelected: (Int) -> Unit
) {
    Column(modifier = Modifier.fillMaxWidth().height(54.dp)) {
        Row(modifier = Modifier.fillMaxHeight()) {
            items.forEach {
                Spacer(modifier = Modifier.width(16.dp))

                val index = items.indexOf(it)

                ProfileTab(
                    title = it,
                    isSelected = selectedIndex == index
                ) {
                    onItemSelected.invoke(index)
                }

                Spacer(modifier = Modifier.width(16.dp))
            }
        }

        Divider(
            modifier = Modifier.fillMaxWidth(),
            color = Theme.colors.dividerColor
        )
    }
}

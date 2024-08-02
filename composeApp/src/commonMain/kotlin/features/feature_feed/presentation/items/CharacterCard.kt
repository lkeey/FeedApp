package features.feature_feed.presentation.items

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import features.feature_feed.domain.models.Character

@Composable
fun CharacterCard(character: Character) {
    Card {
        Column {
//            KamelImage(
//                modifier = Modifier
//                    .width(300.dp)
//                    .height(200.dp),
//                resource = asyncPainterResource(data = character.imageUrl),
//                contentScale = ContentScale.Crop,
//                contentDescription = "A picture of ${character.fullName}"
//            )
            Text(
                modifier = Modifier.fillMaxWidth().padding(16.dp),
                text = character.fullName,
                textAlign = TextAlign.Center
            )
        }
    }
}
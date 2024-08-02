package features.feature_feed.domain.usecases

import core.network.Ktor
import features.feature_feed.domain.models.Character
import io.ktor.client.call.body
import io.ktor.client.request.get

class CharactersUseCase {
    private val instance = Ktor.client

    suspend fun getCharacters(
        onSuccess: (List<Character>) -> Unit,
        onError: (Throwable) -> Unit,
    ) {
        try {
            val result = instance.get("Characters").body<List<Character>>()
            onSuccess(result)
        } catch (e: Exception) {
            onError(e)
        }
    }
}

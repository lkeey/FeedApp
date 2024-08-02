package features.feature_drafts.domain

import features.feature_drafts.data.DraftDao
import features.feature_drafts.data.DraftEntity
import kotlinx.uuid.UUID

class SaveDraftsUseCase (
    private val draftDao: DraftDao
) {
    suspend fun execute(title: String, text: String) {
        draftDao.insert(
            DraftEntity(
                draftId = UUID().toString(false),
                text = text,
                title = title
            )
        )
    }
}

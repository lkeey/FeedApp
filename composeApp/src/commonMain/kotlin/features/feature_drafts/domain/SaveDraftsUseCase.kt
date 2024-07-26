package features.feature_drafts.domain

import features.feature_drafts.data.DraftDao
import features.feature_drafts.data.DraftEntity

class SaveDraftsUseCase (
    private val draftDao: DraftDao
) {
    suspend fun execute(title: String, text: String) {
        draftDao.insert(
            DraftEntity(
                text = text,
                title = title
            )
        )
    }
}

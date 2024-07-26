package core.database

import androidx.room.Database
import androidx.room.RoomDatabase
import features.feature_drafts.data.DraftDao
import features.feature_drafts.data.DraftEntity

@Database(entities = [DraftEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun getDraftDao(): DraftDao
}

internal const val dbFileName = "appfeed.db"

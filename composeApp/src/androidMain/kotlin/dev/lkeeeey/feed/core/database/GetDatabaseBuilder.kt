package dev.lkeeeey.feed.core.database

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import core.database.AppDatabase
import core.database.dbFileName

fun getDatabaseBuilder (
    context: Context
) : RoomDatabase.Builder<AppDatabase> {
    val appContext = context.applicationContext
    val databaseFile = appContext.getDatabasePath(dbFileName)

    return Room.databaseBuilder<AppDatabase> (
        context = appContext,
        name = databaseFile.absolutePath
    )
}

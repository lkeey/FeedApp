package dev.lkeeeey.feed.core.database

import androidx.room.Room
import androidx.room.RoomDatabase
import core.database.AppDatabase
import core.database.dbFileName
import platform.Foundation.NSHomeDirectory


//fun getDatabaseBuilder() : RoomDatabase.Builder<AppDatabase> {
//    val dbFilePath = NSHomeDirectory() + "/$dbFileName"
//
//    return Room.databaseBuilder<AppDatabase> (
//        name = dbFilePath,
//        factory = {
//            AppDatabase::class.instantiateImpl()
//        }
//    )
//}

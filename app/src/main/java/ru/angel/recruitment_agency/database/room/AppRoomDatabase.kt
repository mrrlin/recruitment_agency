package ru.angel.recruitment_agency.database.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import ru.angel.recruitment_agency.database.room.dao.JobRoomDao
import ru.angel.recruitment_agency.model.Job

@Database(entities = [Job::class], version = 1)
abstract class AppRoomDatabase : RoomDatabase(){

    abstract fun getRoomDao() : JobRoomDao

    companion object {

        @Volatile
        private var INSTANCE: AppRoomDatabase? = null

        fun getInstance(context: Context) :AppRoomDatabase {
            return if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(
                    context,
                    AppRoomDatabase::class.java,
                    "jobs_database"
                ).build()
                INSTANCE as AppRoomDatabase
            } else INSTANCE as AppRoomDatabase
        }
    }
}
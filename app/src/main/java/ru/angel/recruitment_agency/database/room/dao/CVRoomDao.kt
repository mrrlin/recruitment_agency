package ru.angel.recruitment_agency.database.room.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import ru.angel.recruitment_agency.model.CV

@Dao
interface CVRoomDao {
    @Query("SELECT * FROM cvs_table")
    fun getCV(): LiveData<List<CV>>

    @Insert
    suspend fun addCV(cv: CV)

    @Update
    suspend fun updateCV(cv: CV)

    @Delete
    suspend fun deleteCV(cv: CV)
}
package ru.angel.recruitment_agency.database.room.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import ru.angel.recruitment_agency.model.Job

@Dao
interface JobRoomDao {
    @Query("SELECT * FROM jobs_table")
    fun getAllJobs(): LiveData<List<Job>>

    @Insert
    suspend fun addJob(job: Job)

    @Update
    suspend fun updateJob(job: Job)

    @Delete
    suspend fun deleteJob(job: Job)
}
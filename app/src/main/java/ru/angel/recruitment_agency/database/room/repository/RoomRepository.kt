package ru.angel.recruitment_agency.database.room.repository

import androidx.lifecycle.LiveData
import ru.angel.recruitment_agency.database.DatabaseRepository
import ru.angel.recruitment_agency.database.room.dao.JobRoomDao
import ru.angel.recruitment_agency.model.Job

class RoomRepository(private val jobRoomDao: JobRoomDao) : DatabaseRepository {
    override val readAll: LiveData<List<Job>>
        get() = jobRoomDao.getAllJobs()

    override suspend fun create(job: Job, onSuccess: () -> Unit) {
        jobRoomDao.addJob(job = job)
        onSuccess()
    }

    override suspend fun update(job: Job, onSuccess: () -> Unit) {
        jobRoomDao.updateJob(job = job)
        onSuccess()
    }

    override suspend fun delete(job: Job, onSuccess: () -> Unit) {
        jobRoomDao.deleteJob(job = job)
        onSuccess()
    }

    override fun signOut() {}
}
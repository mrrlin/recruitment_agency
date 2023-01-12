package ru.angel.recruitment_agency.database.room.repository

import androidx.lifecycle.LiveData
import ru.angel.recruitment_agency.database.DatabaseRepository
import ru.angel.recruitment_agency.database.room.dao.CVRoomDao
import ru.angel.recruitment_agency.database.room.dao.JobRoomDao
import ru.angel.recruitment_agency.model.CV
import ru.angel.recruitment_agency.model.Job

class RoomRepository(private val jobRoomDao: JobRoomDao, private val cvRoomDao: CVRoomDao) : DatabaseRepository {
    //JOB read
    override val readAll: LiveData<List<Job>>
        get() = jobRoomDao.getAllJobs()

    //CV read
    override val readAllCV: LiveData<List<CV>>
        get() = cvRoomDao.getCV()

    //JOB create
    override suspend fun create(job: Job, onSuccess: () -> Unit) {
        jobRoomDao.addJob(job = job)
        onSuccess()
    }

    //CV create
    override suspend fun createCV(cv: CV, onSuccess: () -> Unit) {
        cvRoomDao.addCV(cv = cv)
        onSuccess()
    }

    //JOB update
    override suspend fun update(job: Job, onSuccess: () -> Unit) {
        jobRoomDao.updateJob(job = job)
        onSuccess()
    }

    //CV update
    override suspend fun updateCV(cv: CV, onSuccess: () -> Unit) {
        cvRoomDao.updateCV(cv = cv)
        onSuccess()
    }

    //JOB delete
    override suspend fun delete(job: Job, onSuccess: () -> Unit) {
        jobRoomDao.deleteJob(job = job)
        onSuccess()
    }

    //CV delete
    override suspend fun deleteCV(cv: CV, onSuccess: () -> Unit) {
        cvRoomDao.deleteCV(cv = cv)
        onSuccess()
    }

    override fun signOut() {}
}
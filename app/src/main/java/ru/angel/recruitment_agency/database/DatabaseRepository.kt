package ru.angel.recruitment_agency.database

import androidx.lifecycle.LiveData
import ru.angel.recruitment_agency.model.CV
import ru.angel.recruitment_agency.model.Job

interface DatabaseRepository {

    val readAll: LiveData<List<Job>>

    suspend fun create(job: Job, onSuccess: ()-> Unit)

    suspend fun update(job: Job, onSuccess: ()-> Unit)

    suspend fun delete(job: Job, onSuccess: ()-> Unit)

    val readAllCV: LiveData<List<CV>>

    suspend fun createCV(cv: CV, onSuccess: ()-> Unit)

    suspend fun updateCV(cv: CV, onSuccess: ()-> Unit)

    suspend fun deleteCV(cv: CV, onSuccess: ()-> Unit)

    fun signOut() {}

    fun connectToDatabase(onSuccess: () -> Unit, onFail: (String) -> Unit) {}
}
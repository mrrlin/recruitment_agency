package ru.angel.recruitment_agency.database.firebase

import androidx.lifecycle.LiveData
import com.google.firebase.auth.FirebaseAuth
import ru.angel.recruitment_agency.database.DatabaseRepository
import ru.angel.recruitment_agency.model.Job
import ru.angel.recruitment_agency.utils.LOGIN
import ru.angel.recruitment_agency.utils.PASSWORD

class AppFirebaseRepository : DatabaseRepository {

    private val mAuth = FirebaseAuth.getInstance()
    override val readAll: LiveData<List<Job>>
        get() = TODO("Not yet implemented")

    override suspend fun create(job: Job, onSuccess: () -> Unit) {
        TODO("Not yet implemented")
    }

    override suspend fun update(job: Job, onSuccess: () -> Unit) {
        TODO("Not yet implemented")
    }

    override suspend fun delete(job: Job, onSuccess: () -> Unit) {
        TODO("Not yet implemented")
    }

    override fun signOut() {
        mAuth.signOut()
    }

    override fun connectToDatabase(onSuccess: () -> Unit, onFail: (String) -> Unit) {
        mAuth.signInWithEmailAndPassword(LOGIN, PASSWORD)
            .addOnSuccessListener { onSuccess() }
            .addOnFailureListener {
                mAuth.createUserWithEmailAndPassword(LOGIN, PASSWORD)
                    .addOnSuccessListener { onSuccess() }
                    .addOnFailureListener { onFail(it.message.toString()) }
            }
    }
}
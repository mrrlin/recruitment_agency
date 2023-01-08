package ru.angel.recruitment_agency.database.firebase

import android.util.Log
import androidx.lifecycle.LiveData
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import ru.angel.recruitment_agency.database.DatabaseRepository
import ru.angel.recruitment_agency.model.Job
import ru.angel.recruitment_agency.utils.Constants
import ru.angel.recruitment_agency.utils.FIREBASE_ID
import ru.angel.recruitment_agency.utils.LOGIN
import ru.angel.recruitment_agency.utils.PASSWORD

class AppFirebaseRepository : DatabaseRepository {

    private val mAuth = FirebaseAuth.getInstance()
    private val database = FirebaseDatabase.getInstance().reference
        .child(mAuth.currentUser?.uid.toString())

    override val readAll: LiveData<List<Job>> = AllJobsLiveData()

    override suspend fun create(job: Job, onSuccess: () -> Unit) {
        val jobId = database.push().key.toString()
        val mapJobs = hashMapOf<String, Any>()

        mapJobs[FIREBASE_ID] = jobId
        mapJobs[Constants.Keys.TITLE] = job.title
        mapJobs[Constants.Keys.DESCRIPTION] = job.description

        database.child(jobId)
            .updateChildren(mapJobs)
            .addOnSuccessListener { onSuccess() }
            .addOnFailureListener { Log.d("checkData", "Failed to add new job") }
    }

    override suspend fun update(job: Job, onSuccess: () -> Unit) {
        val jobId = job.firebaseId
        val mapJobs = hashMapOf<String, Any>()

        mapJobs[FIREBASE_ID] = jobId
        mapJobs[Constants.Keys.TITLE] = job.title
        mapJobs[Constants.Keys.DESCRIPTION] = job.description

        database.child(jobId)
            .updateChildren(mapJobs)
            .addOnSuccessListener { onSuccess() }
            .addOnFailureListener { Log.d("checkData", "Failed to update job") }
    }

    override suspend fun delete(job: Job, onSuccess: () -> Unit) {
        database.child(job.firebaseId).removeValue()
            .addOnSuccessListener { onSuccess() }
            .addOnFailureListener { Log.d("checkData", "Failed to delete job") }
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
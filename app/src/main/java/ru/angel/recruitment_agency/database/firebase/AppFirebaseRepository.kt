package ru.angel.recruitment_agency.database.firebase

import android.util.Log
import androidx.lifecycle.LiveData
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import ru.angel.recruitment_agency.database.DatabaseRepository
import ru.angel.recruitment_agency.model.CV
import ru.angel.recruitment_agency.model.Job
import ru.angel.recruitment_agency.utils.Constants
import ru.angel.recruitment_agency.utils.FIREBASE_ID
import ru.angel.recruitment_agency.utils.LOGIN
import ru.angel.recruitment_agency.utils.PASSWORD

class AppFirebaseRepository : DatabaseRepository {

    private val mAuth = FirebaseAuth.getInstance()
    private val database = FirebaseDatabase.getInstance().reference
        .child(mAuth.currentUser?.uid.toString())

    //JOB read
    override val readAll: LiveData<List<Job>> = AllJobsLiveData()

    //CV read
    override val readAllCV: LiveData<List<CV>> = AllCVsLiveData()

    //JOB create
    override suspend fun create(job: Job, onSuccess: () -> Unit) {
        val jobId = database.push().key.toString()
        val mapJobs = hashMapOf<String, Any>()

        mapJobs[FIREBASE_ID] = jobId
        mapJobs[Constants.Keys.TITLE] = job.title
        mapJobs[Constants.Keys.WORK_EXPERIENCE] = job.work_experience
        mapJobs[Constants.Keys.SALARY] = job.salary
        mapJobs[Constants.Keys.CITY] = job.city
        mapJobs[Constants.Keys.COMPANY] = job.company
        mapJobs[Constants.Keys.DESCRIPTION] = job.description
        mapJobs[Constants.Keys.REQUIREMENTS] = job.requirements
        mapJobs[Constants.Keys.CONDITIONS] = job.conditions
        mapJobs[Constants.Keys.SKILLS] = job.skills
        mapJobs[Constants.Keys.CONTACTS] = job.contacts

        database.child(jobId)
            .updateChildren(mapJobs)
            .addOnSuccessListener { onSuccess() }
            .addOnFailureListener { Log.d("checkData", "Failed to add new job") }
    }

    //CV create
    override suspend fun createCV(cv: CV, onSuccess: () -> Unit) {
        val cvId = database.push().key.toString()
        val mapCVs = hashMapOf<String, Any>()

        mapCVs[FIREBASE_ID] = cvId
        mapCVs[Constants.Keys.NAME] = cv.name
        mapCVs[Constants.Keys.SURNAME] = cv.surname
        mapCVs[Constants.Keys.LAST_NAME] = cv.last_name
        mapCVs[Constants.Keys.BIRTH_DATE] = cv.birth_date
        mapCVs[Constants.Keys.MALE] = cv.male
        mapCVs[Constants.Keys.EMAIL] = cv.email
        mapCVs[Constants.Keys.PHONE_NUMBER] = cv.phone_number
        mapCVs[Constants.Keys.CITY] = cv.city
        mapCVs[Constants.Keys.CITIZENSHIP] = cv.citizenship
        mapCVs[Constants.Keys.JOB_TITLE] = cv.job_title
        mapCVs[Constants.Keys.SALARY] = cv.salary
        mapCVs[Constants.Keys.WORK_EXPERIENCE] = cv.work_experience
        mapCVs[Constants.Keys.EDUCATION] = cv.education
        mapCVs[Constants.Keys.SKILLS] = cv.skills
        mapCVs[Constants.Keys.LANGUAGES] = cv.languages
        mapCVs[Constants.Keys.ADDITIONAL_INFO] = cv.additional_info

        database.child(cvId)
            .updateChildren(mapCVs)
            .addOnSuccessListener { onSuccess() }
            .addOnFailureListener { Log.d("checkData", "Failed to add new cv") }
    }

    //JOB update
    override suspend fun update(job: Job, onSuccess: () -> Unit) {
        val jobId = job.firebaseId
        val mapJobs = hashMapOf<String, Any>()

        mapJobs[FIREBASE_ID] = jobId
        mapJobs[Constants.Keys.TITLE] = job.title
        mapJobs[Constants.Keys.WORK_EXPERIENCE] = job.work_experience
        mapJobs[Constants.Keys.SALARY] = job.salary
        mapJobs[Constants.Keys.CITY] = job.city
        mapJobs[Constants.Keys.COMPANY] = job.company
        mapJobs[Constants.Keys.DESCRIPTION] = job.description
        mapJobs[Constants.Keys.REQUIREMENTS] = job.requirements
        mapJobs[Constants.Keys.CONDITIONS] = job.conditions
        mapJobs[Constants.Keys.SKILLS] = job.skills
        mapJobs[Constants.Keys.CONTACTS] = job.contacts

        database.child(jobId)
            .updateChildren(mapJobs)
            .addOnSuccessListener { onSuccess() }
            .addOnFailureListener { Log.d("checkData", "Failed to update job") }
    }


    //CV update
    override suspend fun updateCV(cv: CV, onSuccess: () -> Unit) {
        val cvId = cv.firebaseId
        val mapCVs = hashMapOf<String, Any>()

        mapCVs[FIREBASE_ID] = cvId
        mapCVs[Constants.Keys.NAME] = cv.name
        mapCVs[Constants.Keys.SURNAME] = cv.surname
        mapCVs[Constants.Keys.LAST_NAME] = cv.last_name
        mapCVs[Constants.Keys.BIRTH_DATE] = cv.birth_date
        mapCVs[Constants.Keys.MALE] = cv.male
        mapCVs[Constants.Keys.EMAIL] = cv.email
        mapCVs[Constants.Keys.PHONE_NUMBER] = cv.phone_number
        mapCVs[Constants.Keys.CITY] = cv.city
        mapCVs[Constants.Keys.CITIZENSHIP] = cv.citizenship
        mapCVs[Constants.Keys.JOB_TITLE] = cv.job_title
        mapCVs[Constants.Keys.SALARY] = cv.salary
        mapCVs[Constants.Keys.WORK_EXPERIENCE] = cv.work_experience
        mapCVs[Constants.Keys.EDUCATION] = cv.education
        mapCVs[Constants.Keys.SKILLS] = cv.skills
        mapCVs[Constants.Keys.LANGUAGES] = cv.languages
        mapCVs[Constants.Keys.ADDITIONAL_INFO] = cv.additional_info

        database.child(cvId)
            .updateChildren(mapCVs)
            .addOnSuccessListener { onSuccess() }
            .addOnFailureListener { Log.d("checkData", "Failed to update cv") }
    }

    //JOB delete
    override suspend fun delete(job: Job, onSuccess: () -> Unit) {
        database.child(job.firebaseId).removeValue()
            .addOnSuccessListener { onSuccess() }
            .addOnFailureListener { Log.d("checkData", "Failed to delete job") }
    }

    //CV delete
    override suspend fun deleteCV(cv: CV, onSuccess: () -> Unit) {
        database.child(cv.firebaseId).removeValue()
            .addOnSuccessListener { onSuccess() }
            .addOnFailureListener { Log.d("checkData", "Failed to delete cv") }
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
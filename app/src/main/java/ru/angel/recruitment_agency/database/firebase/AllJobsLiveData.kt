package ru.angel.recruitment_agency.database.firebase

import androidx.lifecycle.LiveData
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import ru.angel.recruitment_agency.model.Job

class AllJobsLiveData: LiveData<List<Job>>() {
    private val mAuth = FirebaseAuth.getInstance() //Get the current authorized user
    private val database = FirebaseDatabase.getInstance().reference
        .child(mAuth.currentUser?.uid.toString())

    private val listener = object : ValueEventListener {
        override fun onDataChange(snapshot: DataSnapshot) {
            val jobs = mutableListOf<Job>()
            snapshot.children.map {
                jobs.add(it.getValue(Job::class.java) ?: Job())
            }
            value = jobs
        }

        override fun onCancelled(error: DatabaseError) {}

    }

    override fun onActive() {
        database.addValueEventListener(listener)
        super.onActive()
    }

    override fun onInactive() {
        database.removeEventListener(listener)
        super.onInactive()
    }
}
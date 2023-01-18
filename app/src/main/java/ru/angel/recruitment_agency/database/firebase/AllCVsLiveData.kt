package ru.angel.recruitment_agency.database.firebase

import androidx.lifecycle.LiveData
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import ru.angel.recruitment_agency.model.CV

class AllCVsLiveData: LiveData<List<CV>>() {
    private val mAuth = FirebaseAuth.getInstance() //Get the current authorized user
    private val database = FirebaseDatabase.getInstance().reference
        .child(mAuth.currentUser?.uid.toString()).child("cvs")

    private val listener = object : ValueEventListener {
        override fun onDataChange(snapshot: DataSnapshot) {
            val cvs = mutableListOf<CV>()
            snapshot.children.map {
                cvs.add(it.getValue(CV::class.java) ?: CV())
            }
            value = cvs
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
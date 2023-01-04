package ru.angel.recruitment_agency

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import ru.angel.recruitment_agency.model.Job
import ru.angel.recruitment_agency.utils.TYPE_DATABASE
import ru.angel.recruitment_agency.utils.TYPE_FIREBASE
import ru.angel.recruitment_agency.utils.TYPE_ROOM

class MainViewModel (application: Application) : AndroidViewModel(application) {

    val readTest: MutableLiveData<List<Job>> by lazy {
        MutableLiveData<List<Job>>()
    }

    val dbType: MutableLiveData<String> by lazy {
        MutableLiveData<String>(TYPE_ROOM)
    }

    init {
        readTest.value =
            when(dbType.value) {
                TYPE_ROOM -> {
                    listOf<Job>(
                        Job(title = "First Job", description = "First description"),
                        Job(title = "Second Job", description = "Second description"),
                        Job(title = "Third Job", description = "Third description"),
                        Job(title = "Fourth Job", description = "Fourth description"),
                    )
                }
                TYPE_FIREBASE -> listOf()
                else -> listOf()
            }
    }

    fun initDatabase(type: String) {
        dbType.value = type
        Log.d("checkData", "MainViewModel initDatabase with type: $type")
    }
}

class MainViewModelFactory(private val application: Application) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel(application = application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel Class")
    }
}
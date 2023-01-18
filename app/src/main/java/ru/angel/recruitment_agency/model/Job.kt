package ru.angel.recruitment_agency.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import ru.angel.recruitment_agency.utils.Constants.Keys.JOBS_TABLE

@Entity(tableName = JOBS_TABLE)
data class Job(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    @ColumnInfo
    val title: String = "",
    @ColumnInfo
    val work_experience: String = "",
    @ColumnInfo
    val salary: String = "",
    @ColumnInfo
    val city: String = "",
    @ColumnInfo
    val company: String = "",
    @ColumnInfo
    val description: String = "",
    @ColumnInfo
    val requirements: String = "",
    @ColumnInfo
    val conditions: String = "",
    @ColumnInfo
    val skills: String = "",
    @ColumnInfo
    val contacts: String = "",
    val firebaseId: String = ""
)

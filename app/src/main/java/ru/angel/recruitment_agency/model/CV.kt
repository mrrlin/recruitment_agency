package ru.angel.recruitment_agency.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import ru.angel.recruitment_agency.utils.Constants.Keys.CVS_TABLE

@Entity(tableName = CVS_TABLE)
data class CV(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    @ColumnInfo
    val photo: String = "",
    @ColumnInfo
    val name: String = "",
    @ColumnInfo
    val surname: String = "",
    @ColumnInfo
    val last_name: String = "",
    @ColumnInfo
    val birth_date: String = "",
    @ColumnInfo
    val male: String = "",
    @ColumnInfo
    val email: String = "",
    @ColumnInfo
    val phone_number: String = "",
    @ColumnInfo
    val city: String = "",
    @ColumnInfo
    val citizenship: String = "",
    @ColumnInfo
    val job_title: String = "",
    @ColumnInfo
    val salary: String = "",
    @ColumnInfo
    val work_experience: String = "",
    @ColumnInfo
    val education: String = "",
    @ColumnInfo
    val skills: String = "",
    @ColumnInfo
    val languages: String = "",
    @ColumnInfo
    val additional_info: String = "",
    val firebaseId: String = ""
)


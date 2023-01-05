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
    val title: String,
    @ColumnInfo
    val description: String
)

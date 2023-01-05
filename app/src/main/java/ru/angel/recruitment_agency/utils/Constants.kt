package ru.angel.recruitment_agency.utils

import ru.angel.recruitment_agency.database.DatabaseRepository

const val TYPE_DATABASE = "type_database"
const val TYPE_ROOM = "type_room"
const val TYPE_FIREBASE = "type_firebase"

lateinit var REPOSITORY: DatabaseRepository

object Constants {
    object Keys {
        const val JOB_DATABASE = "jobs_database"
        const val JOBS_TABLE = "jobs_table"
        const val ADD_NEW_JOB = "Add new job" //Label
        const val JOB_TITLE = "Job title"
        const val JOB_DESCRIPTION = "Job description"
        const val ADD_JOB = "Add Job" //Button's text
        const val ADD_ICONS = "Add Icons" //Button's description
        const val TITLE = "Title"
        const val DESCRIPTION = "Description"
        const val WHAT_WILL_WE_USE = "What will we use?"
        const val ROOM_DATABASE = "Room Database"
        const val FIREBASE_DATABASE = "Firebase Database"
        const val ID = "Id"
        const val NONE = "none"
        const val UPDATE = "Update"
        const val DELETE = "Delete"
        const val NAV_BACK = "Nav back"
        const val EDIT_JOB = "Edit job"
        const val EMPTY = ""
        const val UPDATE_JOB = "Update job"
    }

    object Screens {
        const val START_SCREEN = "start_screen"
        const val LOGIN_SCREEN = "login_screen"
        const val REGISTRATION_SCREEN = "registration_screen"
        const val MAIN_SCREEN = "main_screen"
        const val ADD_SCREEN = "add_screen"
        const val JOB_SCREEN = "job_screen"
        const val CV_SCREEN = "cv_screen"
        const val RESPONSES_SCREEN = "responses_screen"
    }
}
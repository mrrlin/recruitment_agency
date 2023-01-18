package ru.angel.recruitment_agency.utils

import androidx.compose.runtime.mutableStateOf
import ru.angel.recruitment_agency.database.DatabaseRepository

const val TYPE_DATABASE = "type_database"
const val TYPE_ROOM = "type_room"
const val TYPE_FIREBASE = "type_firebase"
const val FIREBASE_ID = "firebaseId"


lateinit var REPOSITORY: DatabaseRepository
lateinit var LOGIN: String
lateinit var PASSWORD: String
var DB_TYPE = mutableStateOf("")

object Constants {
    object Keys {
        const val JOB_DATABASE = "jobs_database"
        const val JOBS_TABLE = "jobs_table"
        const val CVS_TABLE = "cvs_table"

        const val ADD_NEW_JOB = "Add new job" //Label
        const val ADD_NEW_CV = "Add new CV" //Label

        const val JOB_TITLE = "Job title"
        const val JOB_DESCRIPTION = "Job description"
        const val ADD_JOB = "Add Job" //Button's text
        const val ADD_CV = "Add CV" //Button's text
        const val ADD_ICONS = "Add Icons" //Button's description
        const val TITLE = "title"
        const val DESCRIPTION = "description"
        const val WORK_EXPERIENCE = "work_experience"
        const val REQUIREMENTS = "requirements"
        const val SALARY = "salary"
        const val CITY = "city"
        const val COMPANY = "company"
        const val CONDITIONS = "conditions"
        const val SKILLS = "skills"
        const val CONTACTS = "contacts"
        const val WHAT_WILL_WE_USE = "What will we use?"
        const val ROOM_DATABASE = "Room Database"
        const val FIREBASE_DATABASE = "Firebase Database"
        const val ID = "Id"
        const val UPDATE = "Update"
        const val DELETE = "Delete"
        const val NAV_BACK = "Back to list"
        const val EDIT_JOB = "Edit job"
        const val EDIT_CV = "Edit CV"
        const val EMPTY = ""
        const val UPDATE_JOB = "Update job"
        const val UPDATE_CV = "Update cv"
        const val SIGN_IN = "Sing in"
        const val LOG_IN = "Log In"
        const val LOGIN_TEXT = "Login"
        const val PASSWORD_TEXT = "Password"

        const val NAME = "name"
        const val SURNAME = "surname"
        const val LAST_NAME = "last_name"
        const val BIRTH_DATE = "birth_date"
        const val MALE = "male"
        const val EMAIL = "email"
        const val PHONE_NUMBER = "phone_number"
        const val CITIZENSHIP = "citizenship"
        const val EDUCATION = "education"
        const val LANGUAGES = "languages"
        const val ADDITIONAL_INFO = "additional_info"

        //Labels
        const val PERSON_NAME = "Name"
        const val PERSON_SURNAME = "Surname"
        const val PERSON_LAST_NAME = "Last name"
        const val PERSON_BIRTH_DATE = "Date of birth"
        const val PERSON_MALE = "Male"
        const val PERSON_EMAIL = "Email"
        const val PERSON_PHONE_NUMBER = "Phone number"
        const val PERSON_CITY = "City"
        const val PERSON_CITIZENSHIP = "Citizenship"
        const val PERSON_JOB_TITLE = "Job"
        const val PERSON_SALARY = "Salary"
        const val PERSON_WORK_EXPERIENCE = "Work experience"
        const val PERSON_EDUCATION = "Education"
        const val PERSON_SKILLS = "Skills"
        const val PERSON_LANGUAGES = "Languages"
        const val PERSON_ADDITIONAL_INFO = "Additional information"
    }

    object Screens {
        const val START_SCREEN = "start_screen"
        const val MAIN_SCREEN = "main_screen"
        const val ADD_SCREEN = "add_screen"
        const val JOB_SCREEN = "job_screen"
        const val CV_SCREEN = "cv_screen"
        const val CVS_SCREEN = "cvs_screen"
        const val ADD_CV_SCREEN = "add_cv_screen"
        const val RESPONSES_SCREEN = "responses_screen"
    }
}
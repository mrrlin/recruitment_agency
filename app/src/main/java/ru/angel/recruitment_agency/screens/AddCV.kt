package ru.angel.recruitment_agency.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import ru.angel.recruitment_agency.MainViewModel
import ru.angel.recruitment_agency.model.CV
import ru.angel.recruitment_agency.model.Job
import ru.angel.recruitment_agency.navigation.NavRoute
import ru.angel.recruitment_agency.utils.Constants

@Composable
fun AddCVScreen(navController: NavController, viewModel: MainViewModel) {
    var name by remember { mutableStateOf("") }
    var surname by remember { mutableStateOf("") }
    var last_name by remember { mutableStateOf("") }
    var birth_date by remember { mutableStateOf("") }
    var male by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var phone_number by remember { mutableStateOf("") }
    var city by remember { mutableStateOf("") }
    var citizenship by remember { mutableStateOf("") }
    var job_title by remember { mutableStateOf("") }
    var salary by remember { mutableStateOf("") }
    var work_experience by remember { mutableStateOf("") }
    var education by remember { mutableStateOf("") }
    var skills by remember { mutableStateOf("") }
    var languages by remember { mutableStateOf("") }
    var additional_info by remember { mutableStateOf("") }
    var isButtonEnabled by remember { mutableStateOf(false) }
    Scaffold() {
        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = Constants.Keys.ADD_NEW_CV,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(8.dp)
            )
            OutlinedTextField(
                value = name,
                onValueChange = {
                    name = it
                    isButtonEnabled = name.isNotEmpty()
                            && surname.isNotEmpty()
                            && last_name.isNotEmpty()
                            && birth_date.isNotEmpty()
                            && male.isNotEmpty()
                            && email.isNotEmpty()
                            && phone_number.isNotEmpty()
                            && city.isNotEmpty()
                            && citizenship.isNotEmpty()
                            && job_title.isNotEmpty()
                            && salary.isNotEmpty()
                            && work_experience.isNotEmpty()
                            && education.isNotEmpty()
                            && skills.isNotEmpty()
                            && languages.isNotEmpty()
                            && additional_info.isNotEmpty()
                },
                label = { Text(text = Constants.Keys.PERSON_NAME) },
                isError = name.isEmpty()
            )
            OutlinedTextField(
                value = surname,
                onValueChange = {
                    surname = it
                    isButtonEnabled = name.isNotEmpty()
                            && surname.isNotEmpty()
                            && last_name.isNotEmpty()
                            && birth_date.isNotEmpty()
                            && male.isNotEmpty()
                            && email.isNotEmpty()
                            && phone_number.isNotEmpty()
                            && city.isNotEmpty()
                            && citizenship.isNotEmpty()
                            && job_title.isNotEmpty()
                            && salary.isNotEmpty()
                            && work_experience.isNotEmpty()
                            && education.isNotEmpty()
                            && skills.isNotEmpty()
                            && languages.isNotEmpty()
                            && additional_info.isNotEmpty()
                },
                label = { Text(text = Constants.Keys.PERSON_SURNAME) },
                isError = surname.isEmpty()
            )
            OutlinedTextField(
                value = last_name,
                onValueChange = {
                    last_name = it
                    isButtonEnabled = name.isNotEmpty()
                            && surname.isNotEmpty()
                            && last_name.isNotEmpty()
                            && birth_date.isNotEmpty()
                            && male.isNotEmpty()
                            && email.isNotEmpty()
                            && phone_number.isNotEmpty()
                            && city.isNotEmpty()
                            && citizenship.isNotEmpty()
                            && job_title.isNotEmpty()
                            && salary.isNotEmpty()
                            && work_experience.isNotEmpty()
                            && education.isNotEmpty()
                            && skills.isNotEmpty()
                            && languages.isNotEmpty()
                            && additional_info.isNotEmpty()
                },
                label = { Text(text = Constants.Keys.PERSON_LAST_NAME) },
                isError = last_name.isEmpty()
            )
            OutlinedTextField(
                value = birth_date,
                onValueChange = {
                    birth_date = it
                    isButtonEnabled = name.isNotEmpty()
                            && surname.isNotEmpty()
                            && last_name.isNotEmpty()
                            && birth_date.isNotEmpty()
                            && male.isNotEmpty()
                            && email.isNotEmpty()
                            && phone_number.isNotEmpty()
                            && city.isNotEmpty()
                            && citizenship.isNotEmpty()
                            && job_title.isNotEmpty()
                            && salary.isNotEmpty()
                            && work_experience.isNotEmpty()
                            && education.isNotEmpty()
                            && skills.isNotEmpty()
                            && languages.isNotEmpty()
                            && additional_info.isNotEmpty()
                },
                label = { Text(text = Constants.Keys.PERSON_BIRTH_DATE) },
                isError = birth_date.isEmpty()
            )
            OutlinedTextField(
                value = male,
                onValueChange = {
                    male = it
                    isButtonEnabled = name.isNotEmpty()
                            && surname.isNotEmpty()
                            && last_name.isNotEmpty()
                            && birth_date.isNotEmpty()
                            && male.isNotEmpty()
                            && email.isNotEmpty()
                            && phone_number.isNotEmpty()
                            && city.isNotEmpty()
                            && citizenship.isNotEmpty()
                            && job_title.isNotEmpty()
                            && salary.isNotEmpty()
                            && work_experience.isNotEmpty()
                            && education.isNotEmpty()
                            && skills.isNotEmpty()
                            && languages.isNotEmpty()
                            && additional_info.isNotEmpty()
                },
                label = { Text(text = Constants.Keys.PERSON_MALE) },
                isError = male.isEmpty()
            )
            OutlinedTextField(
                value = email,
                onValueChange = {
                    email = it
                    isButtonEnabled = name.isNotEmpty()
                            && surname.isNotEmpty()
                            && last_name.isNotEmpty()
                            && birth_date.isNotEmpty()
                            && male.isNotEmpty()
                            && email.isNotEmpty()
                            && phone_number.isNotEmpty()
                            && city.isNotEmpty()
                            && citizenship.isNotEmpty()
                            && job_title.isNotEmpty()
                            && salary.isNotEmpty()
                            && work_experience.isNotEmpty()
                            && education.isNotEmpty()
                            && skills.isNotEmpty()
                            && languages.isNotEmpty()
                            && additional_info.isNotEmpty()
                },
                label = { Text(text = Constants.Keys.PERSON_EMAIL) },
                isError = email.isEmpty()
            )
            OutlinedTextField( //Requirements
                value = phone_number,
                onValueChange = {
                    phone_number = it
                    isButtonEnabled = name.isNotEmpty()
                            && surname.isNotEmpty()
                            && last_name.isNotEmpty()
                            && birth_date.isNotEmpty()
                            && male.isNotEmpty()
                            && email.isNotEmpty()
                            && phone_number.isNotEmpty()
                            && city.isNotEmpty()
                            && citizenship.isNotEmpty()
                            && job_title.isNotEmpty()
                            && salary.isNotEmpty()
                            && work_experience.isNotEmpty()
                            && education.isNotEmpty()
                            && skills.isNotEmpty()
                            && languages.isNotEmpty()
                            && additional_info.isNotEmpty()
                },
                label = { Text(text = Constants.Keys.PERSON_PHONE_NUMBER) },
                isError = phone_number.isEmpty()
            )
            OutlinedTextField(
                value = city,
                onValueChange = {
                    city = it
                    isButtonEnabled = name.isNotEmpty()
                            && surname.isNotEmpty()
                            && last_name.isNotEmpty()
                            && birth_date.isNotEmpty()
                            && male.isNotEmpty()
                            && email.isNotEmpty()
                            && phone_number.isNotEmpty()
                            && city.isNotEmpty()
                            && citizenship.isNotEmpty()
                            && job_title.isNotEmpty()
                            && salary.isNotEmpty()
                            && work_experience.isNotEmpty()
                            && education.isNotEmpty()
                            && skills.isNotEmpty()
                            && languages.isNotEmpty()
                            && additional_info.isNotEmpty()
                },
                label = { Text(text = Constants.Keys.PERSON_CITY) },
                isError = city.isEmpty()
            )
            OutlinedTextField(
                value = citizenship,
                onValueChange = {
                    citizenship = it
                    isButtonEnabled = name.isNotEmpty()
                            && surname.isNotEmpty()
                            && last_name.isNotEmpty()
                            && birth_date.isNotEmpty()
                            && male.isNotEmpty()
                            && email.isNotEmpty()
                            && phone_number.isNotEmpty()
                            && city.isNotEmpty()
                            && citizenship.isNotEmpty()
                            && job_title.isNotEmpty()
                            && salary.isNotEmpty()
                            && work_experience.isNotEmpty()
                            && education.isNotEmpty()
                            && skills.isNotEmpty()
                            && languages.isNotEmpty()
                            && additional_info.isNotEmpty()
                },
                label = { Text(text = Constants.Keys.PERSON_CITIZENSHIP) },
                isError = citizenship.isEmpty()
            )
            OutlinedTextField(
                value = job_title,
                onValueChange = {
                    job_title = it
                    isButtonEnabled = name.isNotEmpty()
                            && surname.isNotEmpty()
                            && last_name.isNotEmpty()
                            && birth_date.isNotEmpty()
                            && male.isNotEmpty()
                            && email.isNotEmpty()
                            && phone_number.isNotEmpty()
                            && city.isNotEmpty()
                            && citizenship.isNotEmpty()
                            && job_title.isNotEmpty()
                            && salary.isNotEmpty()
                            && work_experience.isNotEmpty()
                            && education.isNotEmpty()
                            && skills.isNotEmpty()
                            && languages.isNotEmpty()
                            && additional_info.isNotEmpty()
                },
                label = { Text(text = Constants.Keys.PERSON_JOB_TITLE) },
                isError = job_title.isEmpty()
            )
            OutlinedTextField(
                value = salary,
                onValueChange = {
                    salary = it
                    isButtonEnabled = name.isNotEmpty()
                            && surname.isNotEmpty()
                            && last_name.isNotEmpty()
                            && birth_date.isNotEmpty()
                            && male.isNotEmpty()
                            && email.isNotEmpty()
                            && phone_number.isNotEmpty()
                            && city.isNotEmpty()
                            && citizenship.isNotEmpty()
                            && job_title.isNotEmpty()
                            && salary.isNotEmpty()
                            && work_experience.isNotEmpty()
                            && education.isNotEmpty()
                            && skills.isNotEmpty()
                            && languages.isNotEmpty()
                            && additional_info.isNotEmpty()
                },
                label = { Text(text = Constants.Keys.PERSON_SALARY) },
                isError = salary.isEmpty()
            )
            OutlinedTextField(
                value = work_experience,
                onValueChange = {
                    work_experience = it
                    isButtonEnabled = name.isNotEmpty()
                            && surname.isNotEmpty()
                            && last_name.isNotEmpty()
                            && birth_date.isNotEmpty()
                            && male.isNotEmpty()
                            && email.isNotEmpty()
                            && phone_number.isNotEmpty()
                            && city.isNotEmpty()
                            && citizenship.isNotEmpty()
                            && job_title.isNotEmpty()
                            && salary.isNotEmpty()
                            && work_experience.isNotEmpty()
                            && education.isNotEmpty()
                            && skills.isNotEmpty()
                            && languages.isNotEmpty()
                            && additional_info.isNotEmpty()
                },
                label = { Text(text = Constants.Keys.PERSON_WORK_EXPERIENCE) },
                isError = work_experience.isEmpty()
            )
            OutlinedTextField(
                value = education,
                onValueChange = {
                    education = it
                    isButtonEnabled = name.isNotEmpty()
                            && surname.isNotEmpty()
                            && last_name.isNotEmpty()
                            && birth_date.isNotEmpty()
                            && male.isNotEmpty()
                            && email.isNotEmpty()
                            && phone_number.isNotEmpty()
                            && city.isNotEmpty()
                            && citizenship.isNotEmpty()
                            && job_title.isNotEmpty()
                            && salary.isNotEmpty()
                            && work_experience.isNotEmpty()
                            && education.isNotEmpty()
                            && skills.isNotEmpty()
                            && languages.isNotEmpty()
                            && additional_info.isNotEmpty()
                },
                label = { Text(text = Constants.Keys.PERSON_EDUCATION) },
                isError = education.isEmpty()
            )
            OutlinedTextField(
                value = skills,
                onValueChange = {
                    skills = it
                    isButtonEnabled = name.isNotEmpty()
                            && surname.isNotEmpty()
                            && last_name.isNotEmpty()
                            && birth_date.isNotEmpty()
                            && male.isNotEmpty()
                            && email.isNotEmpty()
                            && phone_number.isNotEmpty()
                            && city.isNotEmpty()
                            && citizenship.isNotEmpty()
                            && job_title.isNotEmpty()
                            && salary.isNotEmpty()
                            && work_experience.isNotEmpty()
                            && education.isNotEmpty()
                            && skills.isNotEmpty()
                            && languages.isNotEmpty()
                            && additional_info.isNotEmpty()
                },
                label = { Text(text = Constants.Keys.PERSON_SKILLS) },
                isError = skills.isEmpty()
            )
            OutlinedTextField(
                value = languages,
                onValueChange = {
                    languages = it
                    isButtonEnabled = name.isNotEmpty()
                            && surname.isNotEmpty()
                            && last_name.isNotEmpty()
                            && birth_date.isNotEmpty()
                            && male.isNotEmpty()
                            && email.isNotEmpty()
                            && phone_number.isNotEmpty()
                            && city.isNotEmpty()
                            && citizenship.isNotEmpty()
                            && job_title.isNotEmpty()
                            && salary.isNotEmpty()
                            && work_experience.isNotEmpty()
                            && education.isNotEmpty()
                            && skills.isNotEmpty()
                            && languages.isNotEmpty()
                            && additional_info.isNotEmpty()
                },
                label = { Text(text = Constants.Keys.PERSON_LANGUAGES) },
                isError = languages.isEmpty()
            )
            OutlinedTextField(
                value = additional_info,
                onValueChange = {
                    additional_info = it
                    isButtonEnabled = name.isNotEmpty()
                            && surname.isNotEmpty()
                            && last_name.isNotEmpty()
                            && birth_date.isNotEmpty()
                            && male.isNotEmpty()
                            && email.isNotEmpty()
                            && phone_number.isNotEmpty()
                            && city.isNotEmpty()
                            && citizenship.isNotEmpty()
                            && job_title.isNotEmpty()
                            && salary.isNotEmpty()
                            && work_experience.isNotEmpty()
                            && education.isNotEmpty()
                            && skills.isNotEmpty()
                            && languages.isNotEmpty()
                            && additional_info.isNotEmpty()
                },
                label = { Text(text = Constants.Keys.PERSON_ADDITIONAL_INFO) },
                isError = additional_info.isEmpty()
            )
            Button(
                modifier = Modifier.padding(top = 16.dp, bottom = 70.dp),
                enabled = isButtonEnabled,
                onClick = {
                    viewModel.addCV(cv = CV(
                        name = name,
                        surname = surname,
                        last_name = last_name,
                        birth_date = birth_date,
                        male = male,
                        email = email,
                        phone_number = phone_number,
                        city = city,
                        citizenship = citizenship,
                        job_title = job_title,
                        salary = salary,
                        work_experience = work_experience,
                        education = education,
                        skills = skills,
                        languages = languages,
                        additional_info = additional_info,
                    )
                    ) {
                        navController.navigate(NavRoute.CVS.route)
                    }
                }
            ) {
                Text(text = Constants.Keys.ADD_CV)
            }
        }
    }
}
package ru.angel.recruitment_agency.screens

import android.app.Application
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import ru.angel.recruitment_agency.MainViewModel
import ru.angel.recruitment_agency.MainViewModelFactory
import ru.angel.recruitment_agency.model.Job
import ru.angel.recruitment_agency.navigation.NavRoute
import ru.angel.recruitment_agency.ui.theme.Recruitment_agencyTheme
import ru.angel.recruitment_agency.utils.Constants

@Composable
fun AddScreen(navController: NavHostController, viewModel: MainViewModel) {
    var title by remember { mutableStateOf("")}
    var work_experience by remember { mutableStateOf("")}
    var salary by remember { mutableStateOf("") }
    var city by remember { mutableStateOf("") }
    var company by remember { mutableStateOf("") }
    var description by remember { mutableStateOf("")}
    var requirements by remember { mutableStateOf("") }
    var conditions by remember { mutableStateOf("") }
    var skills by remember { mutableStateOf("") }
    var contacts by remember { mutableStateOf("") }
    var isButtonEnabled by remember { mutableStateOf(false)}
    Scaffold() {
        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = Constants.Keys.ADD_NEW_JOB,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(8.dp)
            )
            OutlinedTextField( //Job Title
                value = title,
                onValueChange = {
                    title = it
                    isButtonEnabled = title.isNotEmpty()
                            && work_experience.isNotEmpty()
                            && salary.isNotEmpty()
                            && city.isNotEmpty()
                            && company.isNotEmpty()
                            && description.isNotEmpty()
                            && requirements.isNotEmpty()
                            && conditions.isNotEmpty()
                            && skills.isNotEmpty()
                            && contacts.isNotEmpty()
                },
                label = { Text(text = Constants.Keys.JOB_TITLE) },
                isError = title.isEmpty()
            )
            OutlinedTextField( //Work experience
                value = work_experience,
                onValueChange = {
                    work_experience = it
                    isButtonEnabled = title.isNotEmpty()
                            && work_experience.isNotEmpty()
                            && salary.isNotEmpty()
                            && city.isNotEmpty()
                            && company.isNotEmpty()
                            && description.isNotEmpty()
                            && requirements.isNotEmpty()
                            && conditions.isNotEmpty()
                            && skills.isNotEmpty()
                            && contacts.isNotEmpty()
                },
                label = { Text(text = "Work experience")},
                isError = work_experience.isEmpty()
            )
            OutlinedTextField( //Salary
                value = salary,
                onValueChange = {
                    salary = it
                    isButtonEnabled = title.isNotEmpty()
                            && work_experience.isNotEmpty()
                            && salary.isNotEmpty()
                            && city.isNotEmpty()
                            && company.isNotEmpty()
                            && description.isNotEmpty()
                            && requirements.isNotEmpty()
                            && conditions.isNotEmpty()
                            && skills.isNotEmpty()
                            && contacts.isNotEmpty()
                },
                label = { Text(text = "Salary")},
                isError = salary.isEmpty()
            )
            OutlinedTextField( //City
                value = city,
                onValueChange = {
                    city = it
                    isButtonEnabled = title.isNotEmpty()
                            && work_experience.isNotEmpty()
                            && salary.isNotEmpty()
                            && city.isNotEmpty()
                            && company.isNotEmpty()
                            && description.isNotEmpty()
                            && requirements.isNotEmpty()
                            && conditions.isNotEmpty()
                            && skills.isNotEmpty()
                            && contacts.isNotEmpty()
                },
                label = { Text(text = "City")},
                isError = city.isEmpty()
            )
            OutlinedTextField( //Company
                value = company,
                onValueChange = {
                    company = it
                    isButtonEnabled = title.isNotEmpty()
                            && work_experience.isNotEmpty()
                            && salary.isNotEmpty()
                            && city.isNotEmpty()
                            && company.isNotEmpty()
                            && description.isNotEmpty()
                            && requirements.isNotEmpty()
                            && conditions.isNotEmpty()
                            && skills.isNotEmpty()
                            && contacts.isNotEmpty()
                },
                label = { Text(text = "Company")},
                isError = company.isEmpty()
            )
            OutlinedTextField( //Description
                value = description,
                onValueChange = {
                    description = it
                    isButtonEnabled = title.isNotEmpty()
                            && work_experience.isNotEmpty()
                            && salary.isNotEmpty()
                            && city.isNotEmpty()
                            && company.isNotEmpty()
                            && description.isNotEmpty()
                            && requirements.isNotEmpty()
                            && conditions.isNotEmpty()
                            && skills.isNotEmpty()
                            && contacts.isNotEmpty()
                },
                label = { Text(text = Constants.Keys.JOB_DESCRIPTION) },
                isError = description.isEmpty()
            )
            OutlinedTextField( //Requirements
                value = requirements,
                onValueChange = {
                    requirements = it
                    isButtonEnabled = title.isNotEmpty()
                            && work_experience.isNotEmpty()
                            && salary.isNotEmpty()
                            && city.isNotEmpty()
                            && company.isNotEmpty()
                            && description.isNotEmpty()
                            && requirements.isNotEmpty()
                            && conditions.isNotEmpty()
                            && skills.isNotEmpty()
                            && contacts.isNotEmpty()
                },
                label = { Text(text = "Requirements")},
                isError = requirements.isEmpty()
            )
            OutlinedTextField( //Conditions
                value = conditions,
                onValueChange = {
                    conditions = it
                    isButtonEnabled = title.isNotEmpty()
                            && work_experience.isNotEmpty()
                            && salary.isNotEmpty()
                            && city.isNotEmpty()
                            && company.isNotEmpty()
                            && description.isNotEmpty()
                            && requirements.isNotEmpty()
                            && conditions.isNotEmpty()
                            && skills.isNotEmpty()
                            && contacts.isNotEmpty()
                },
                label = { Text(text = "Conditions")},
                isError = conditions.isEmpty()
            )
            OutlinedTextField( //Skills
                value = skills,
                onValueChange = {
                    skills = it
                    isButtonEnabled = title.isNotEmpty()
                            && work_experience.isNotEmpty()
                            && salary.isNotEmpty()
                            && city.isNotEmpty()
                            && company.isNotEmpty()
                            && description.isNotEmpty()
                            && requirements.isNotEmpty()
                            && conditions.isNotEmpty()
                            && skills.isNotEmpty()
                            && contacts.isNotEmpty()
                },
                label = { Text(text = "Skills")},
                isError = skills.isEmpty()
            )
            OutlinedTextField( //Contacts
                value = contacts,
                onValueChange = {
                    contacts = it
                    isButtonEnabled = title.isNotEmpty()
                            && work_experience.isNotEmpty()
                            && salary.isNotEmpty()
                            && city.isNotEmpty()
                            && company.isNotEmpty()
                            && description.isNotEmpty()
                            && requirements.isNotEmpty()
                            && conditions.isNotEmpty()
                            && skills.isNotEmpty()
                            && contacts.isNotEmpty()
                },
                label = { Text(text = "Contacts")},
                isError = contacts.isEmpty()
            )
            Button(
                modifier = Modifier.padding(top = 16.dp, bottom = 70.dp),
                enabled = isButtonEnabled,
                onClick = {
                    viewModel.addJob(job = Job(
                        title = title,
                        work_experience = work_experience,
                        salary = salary,
                        city = city,
                        company = company,
                        description = description,
                        requirements = requirements,
                        conditions = conditions,
                        skills = skills,
                        contacts = contacts)
                    ) {
                        navController.navigate(NavRoute.Main.route)
                    }
                }
            ) {
                Text(text = Constants.Keys.ADD_JOB)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun prevAddScreen() {
    Recruitment_agencyTheme() {
        val context = LocalContext.current
        val mViewModel: MainViewModel =
            viewModel(factory = MainViewModelFactory(context.applicationContext as Application))
        AddScreen(navController = rememberNavController(), viewModel = mViewModel)
    }
}
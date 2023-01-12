package ru.angel.recruitment_agency.screens

import android.app.Application
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
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
import kotlinx.coroutines.launch
import ru.angel.recruitment_agency.MainViewModel
import ru.angel.recruitment_agency.MainViewModelFactory
import ru.angel.recruitment_agency.model.Job
import ru.angel.recruitment_agency.navigation.NavRoute
import ru.angel.recruitment_agency.ui.theme.Recruitment_agencyTheme
import ru.angel.recruitment_agency.utils.Constants
import ru.angel.recruitment_agency.utils.DB_TYPE
import ru.angel.recruitment_agency.utils.TYPE_FIREBASE
import ru.angel.recruitment_agency.utils.TYPE_ROOM

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun JobScreen(navController: NavHostController, viewModel: MainViewModel, jobId: String?) {
    val jobs = viewModel.readAllJobs().observeAsState(listOf()).value
    val job = when(DB_TYPE.value) {
        TYPE_ROOM -> {
            jobs.firstOrNull { it.id == jobId?.toInt() } ?: Job()
        }
        TYPE_FIREBASE -> {
            jobs.firstOrNull { it.firebaseId == jobId } ?: Job()
        }
        else -> Job()
    }
    val bottomSheetState = rememberModalBottomSheetState(initialValue = ModalBottomSheetValue.Hidden)
    val coroutineScope = rememberCoroutineScope()
    var title by remember { mutableStateOf(Constants.Keys.EMPTY)}
    var work_experience by remember { mutableStateOf(Constants.Keys.EMPTY)}
    var salary by remember { mutableStateOf(Constants.Keys.EMPTY) }
    var city by remember { mutableStateOf(Constants.Keys.EMPTY) }
    var company by remember { mutableStateOf(Constants.Keys.EMPTY) }
    var description by remember { mutableStateOf(Constants.Keys.EMPTY)}
    var requirements by remember { mutableStateOf(Constants.Keys.EMPTY) }
    var conditions by remember { mutableStateOf(Constants.Keys.EMPTY) }
    var skills by remember { mutableStateOf(Constants.Keys.EMPTY) }
    var contacts by remember { mutableStateOf(Constants.Keys.EMPTY) }

    ModalBottomSheetLayout(
        sheetState = bottomSheetState,
        sheetElevation = 5.dp,
        sheetShape = RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp),
        sheetContent = {
            Surface {
                Column(
                    modifier = Modifier
                        .verticalScroll(rememberScrollState())
                        .fillMaxSize()
                        .padding(all = 32.dp),
                ) {
                    Text(
                        text = Constants.Keys.EDIT_JOB,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(vertical = 8.dp)
                    )
                    OutlinedTextField( //Job Title
                        value = title,
                        onValueChange = { title = it },
                        label = { Text(text = Constants.Keys.TITLE) },
                        isError = title.isEmpty()
                    )
                    OutlinedTextField( //Work experience
                        value = work_experience,
                        onValueChange = { work_experience = it },
                        label = { Text(text = Constants.Keys.WORK_EXPERIENCE) },
                        isError = work_experience.isEmpty()
                    )
                    OutlinedTextField(
                        value = salary,
                        onValueChange = { salary = it },
                        label = { Text(text = Constants.Keys.SALARY)},
                        isError = salary.isEmpty()
                    )
                    OutlinedTextField(
                        value = city,
                        onValueChange = { city = it },
                        label = { Text(text = Constants.Keys.CITY)},
                        isError = city.isEmpty()
                    )
                    OutlinedTextField(
                        value = company,
                        onValueChange = { company = it },
                        label = { Text(text = Constants.Keys.COMPANY)},
                        isError = company.isEmpty()
                    )
                    OutlinedTextField( //Job Description
                        value = description,
                        onValueChange = { description = it },
                        label = { Text(text = Constants.Keys.DESCRIPTION) },
                        isError = description.isEmpty()
                    )
                    OutlinedTextField(
                        value = requirements,
                        onValueChange = { requirements = it },
                        label = { Text(text = Constants.Keys.REQUIREMENTS)},
                        isError = requirements.isEmpty()
                    )
                    OutlinedTextField(
                        value = conditions,
                        onValueChange = { conditions = it },
                        label = { Text(text = Constants.Keys.CONDITIONS)},
                        isError = conditions.isEmpty()
                    )
                    OutlinedTextField(
                        value = skills,
                        onValueChange = { skills = it },
                        label = { Text(text = Constants.Keys.SKILLS)},
                        isError = skills.isEmpty()
                    )
                    OutlinedTextField(
                        value = contacts,
                        onValueChange = { contacts = it },
                        label = { Text(text = Constants.Keys.CONTACTS)},
                        isError = contacts.isEmpty()
                    )
                    Button(
                        modifier = Modifier.padding(top = 16.dp, bottom = 30.dp),
                        onClick = {
                            viewModel.updateJob(
                                job =
                                Job(
                                    id = job.id,
                                    firebaseId = job.firebaseId,
                                    title = title,
                                    work_experience = work_experience,
                                    salary = salary,
                                    city = city,
                                    company = company,
                                    description = description,
                                    requirements = requirements,
                                    conditions = conditions,
                                    skills = skills,
                                    contacts = contacts
                                )
                            ) {
                                navController.navigate(NavRoute.Main.route)
                            }
                        }
                    ) {
                        Text(text = Constants.Keys.UPDATE_JOB)
                    }
                }
            }
        }
    ) {
        Scaffold(
            modifier = Modifier.padding(bottom = 60.dp).fillMaxSize()
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(32.dp)
                ) {
                    Column(
                        modifier = Modifier.padding(vertical = 8.dp, horizontal = 10.dp),
                        horizontalAlignment = Alignment.Start
                    ) {
                        Text(
                            text = job.title,
                            fontSize = 24.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(top = 10.dp)
                        )
                        Text(
                            text = job.work_experience,
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Light,
                            modifier = Modifier.padding(top = 16.dp)
                        )
                        Text(
                            text = job.salary,
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Light,
                            modifier = Modifier.padding(top = 16.dp)
                        )
                        Text(
                            text = job.city,
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Light,
                            modifier = Modifier.padding(top = 16.dp)
                        )
                        Text(
                            text = job.company,
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Light,
                            modifier = Modifier.padding(top = 16.dp)
                        )
                        Text(
                            text = job.description,
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Light,
                            modifier = Modifier.padding(top = 16.dp)
                        )
                        Text(
                            text = job.requirements,
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Light,
                            modifier = Modifier.padding(top = 16.dp)
                        )
                        Text(
                            text = job.conditions,
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Light,
                            modifier = Modifier.padding(top = 16.dp)
                        )
                        Text(
                            text = job.skills,
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Light,
                            modifier = Modifier.padding(top = 16.dp)
                        )
                        Text(
                            text = job.contacts,
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Light,
                            modifier = Modifier.padding(top = 16.dp, bottom = 15.dp)
                        )
                    }
                }
                Row(
                    modifier = Modifier
                        .padding(horizontal = 32.dp)
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceAround
                ) {
                    Button(onClick = {
                        coroutineScope.launch {
                            title = job.title
                            work_experience = job.work_experience
                            salary = job.salary
                            city = job.city
                            company = job.company
                            description = job.description
                            requirements = job.requirements
                            conditions = job.conditions
                            skills = job.skills
                            contacts = job.contacts
                            bottomSheetState.show()
                        }
                    }) {
                        Text(text = Constants.Keys.UPDATE)
                    }
                    Button(onClick = {
                        viewModel.deleteJob(job = job) {
                            navController.navigate(NavRoute.Main.route)
                        }
                    }) {
                        Text(text = Constants.Keys.DELETE)
                    }
                }
                Button(
                    modifier = Modifier
                        .padding(top = 16.dp)
                        .padding(horizontal = 32.dp)
                        .fillMaxWidth(),
                    onClick = {
                        navController.navigate(NavRoute.Main.route)
                    }
                ) {
                    Text(text = Constants.Keys.NAV_BACK)
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun prevJobScreen() {
    Recruitment_agencyTheme() {
        val context = LocalContext.current
        val mViewModel: MainViewModel =
            viewModel(factory = MainViewModelFactory(context.applicationContext as Application))
        JobScreen(
            navController = rememberNavController(),
            viewModel = mViewModel,
            jobId = "1"
        )
    }
}
package ru.angel.recruitment_agency.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import kotlinx.coroutines.launch
import ru.angel.recruitment_agency.MainViewModel
import ru.angel.recruitment_agency.model.CV
import ru.angel.recruitment_agency.navigation.NavRoute
import ru.angel.recruitment_agency.utils.Constants
import ru.angel.recruitment_agency.utils.DB_TYPE
import ru.angel.recruitment_agency.utils.TYPE_FIREBASE
import ru.angel.recruitment_agency.utils.TYPE_ROOM

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun CVScreen(navController: NavHostController, viewModel: MainViewModel, cvId: String?) {
    val cvs = viewModel.readAllCVs().observeAsState(listOf()).value
    val cv = when(DB_TYPE.value) {
        TYPE_ROOM -> {
            cvs.firstOrNull { it.id == cvId?.toInt() } ?: CV()
        }
        TYPE_FIREBASE -> {
            cvs.firstOrNull { it.firebaseId == cvId } ?: CV()
        }
        else -> CV()
    }
    val bottomSheetState = rememberModalBottomSheetState(initialValue = ModalBottomSheetValue.Hidden)
    val coroutineScope = rememberCoroutineScope()
    var name by remember { mutableStateOf(Constants.Keys.EMPTY) }
    var surname by remember { mutableStateOf(Constants.Keys.EMPTY) }
    var last_name by remember { mutableStateOf(Constants.Keys.EMPTY) }
    var birth_date by remember { mutableStateOf(Constants.Keys.EMPTY) }
    var male by remember { mutableStateOf(Constants.Keys.EMPTY) }
    var email by remember { mutableStateOf(Constants.Keys.EMPTY) }
    var phone_number by remember { mutableStateOf(Constants.Keys.EMPTY) }
    var city by remember { mutableStateOf(Constants.Keys.EMPTY) }
    var citizenship by remember { mutableStateOf(Constants.Keys.EMPTY) }
    var job_title by remember { mutableStateOf(Constants.Keys.EMPTY) }
    var salary by remember { mutableStateOf(Constants.Keys.EMPTY) }
    var work_experience by remember { mutableStateOf(Constants.Keys.EMPTY) }
    var education by remember { mutableStateOf(Constants.Keys.EMPTY) }
    var skills by remember { mutableStateOf(Constants.Keys.EMPTY) }
    var languages by remember { mutableStateOf(Constants.Keys.EMPTY) }
    var additional_info by remember { mutableStateOf(Constants.Keys.EMPTY) }

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
                        text = Constants.Keys.EDIT_CV,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(vertical = 8.dp)
                    )
                    OutlinedTextField(
                        value = name,
                        onValueChange = { name = it },
                        label = { Text(text = Constants.Keys.NAME) },
                        isError = name.isEmpty()
                    )
                    OutlinedTextField(
                        value = surname,
                        onValueChange = { surname = it },
                        label = { Text(text = Constants.Keys.SURNAME) },
                        isError = surname.isEmpty()
                    )
                    OutlinedTextField(
                        value = last_name,
                        onValueChange = { last_name = it },
                        label = { Text(text = Constants.Keys.LAST_NAME)},
                        isError = last_name.isEmpty()
                    )
                    OutlinedTextField(
                        value = birth_date,
                        onValueChange = { birth_date = it },
                        label = { Text(text = Constants.Keys.BIRTH_DATE) },
                        isError = birth_date.isEmpty()
                    )
                    OutlinedTextField(
                        value = male,
                        onValueChange = { male = it },
                        label = { Text(text = Constants.Keys.MALE)},
                        isError = male.isEmpty()
                    )
                    OutlinedTextField(
                        value = email,
                        onValueChange = { email = it },
                        label = { Text(text = Constants.Keys.EMAIL)},
                        isError = email.isEmpty()
                    )
                    OutlinedTextField(
                        value = phone_number,
                        onValueChange = { phone_number = it },
                        label = { Text(text = Constants.Keys.PHONE_NUMBER)},
                        isError = phone_number.isEmpty()
                    )
                    OutlinedTextField(
                        value = city,
                        onValueChange = { city = it },
                        label = { Text(text = Constants.Keys.CITY)},
                        isError = city.isEmpty()
                    )
                    OutlinedTextField(
                        value = citizenship,
                        onValueChange = { citizenship = it },
                        label = { Text(text = Constants.Keys.CITIZENSHIP)},
                        isError = citizenship.isEmpty()
                    )
                    OutlinedTextField(
                        value = job_title,
                        onValueChange = { job_title = it },
                        label = { Text(text = Constants.Keys.JOB_TITLE)},
                        isError = job_title.isEmpty()
                    )
                    OutlinedTextField(
                        value = salary,
                        onValueChange = { salary = it },
                        label = { Text(text = Constants.Keys.SALARY)},
                        isError = salary.isEmpty()
                    )
                    OutlinedTextField(
                        value = work_experience,
                        onValueChange = { work_experience = it },
                        label = { Text(text = Constants.Keys.WORK_EXPERIENCE)},
                        isError = work_experience.isEmpty()
                    )
                    OutlinedTextField(
                        value = education,
                        onValueChange = { education = it },
                        label = { Text(text = Constants.Keys.EDUCATION)},
                        isError = education.isEmpty()
                    )
                    OutlinedTextField(
                        value = skills,
                        onValueChange = { skills = it },
                        label = { Text(text = Constants.Keys.SKILLS)},
                        isError = skills.isEmpty()
                    )
                    OutlinedTextField(
                        value = languages,
                        onValueChange = { languages = it },
                        label = { Text(text = Constants.Keys.LANGUAGES)},
                        isError = languages.isEmpty()
                    )
                    OutlinedTextField(
                        value = additional_info,
                        onValueChange = { additional_info = it },
                        label = { Text(text = Constants.Keys.ADDITIONAL_INFO)},
                        isError = additional_info.isEmpty()
                    )
                    Button(
                        modifier = Modifier.padding(top = 16.dp, bottom = 30.dp),
                        onClick = {
                            viewModel.updateCV(
                                cv =
                                CV(
                                    id = cv.id,
                                    firebaseId = cv.firebaseId,
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
                                    additional_info = additional_info
                                )
                            ) {
                                navController.navigate(NavRoute.CVS.route)
                            }
                        }
                    ) {
                        Text(text = Constants.Keys.UPDATE_CV)
                    }
                }
            }
        }
    ) {
        Scaffold(
            modifier = Modifier
                .padding(bottom = 60.dp)
                .fillMaxSize()
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState()),
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
                            text = cv.name,
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Light,
                            modifier = Modifier.padding(top = 10.dp)
                        )
                        Text(
                            text = cv.surname,
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Light,
                            modifier = Modifier.padding(top = 16.dp)
                        )
                        Text(
                            text = cv.last_name,
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Light,
                            modifier = Modifier.padding(top = 16.dp)
                        )
                        Text(
                            text = cv.birth_date,
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Light,
                            modifier = Modifier.padding(top = 16.dp)
                        )
                        Text(
                            text = cv.male,
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Light,
                            modifier = Modifier.padding(top = 16.dp)
                        )
                        Text(
                            text = cv.email,
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Light,
                            modifier = Modifier.padding(top = 16.dp)
                        )
                        Text(
                            text = cv.phone_number,
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Light,
                            modifier = Modifier.padding(top = 16.dp)
                        )
                        Text(
                            text = cv.city,
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Light,
                            modifier = Modifier.padding(top = 16.dp)
                        )
                        Text(
                            text = cv.citizenship,
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Light,
                            modifier = Modifier.padding(top = 16.dp)
                        )
                        Text(
                            text = cv.job_title,
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Light,
                            modifier = Modifier.padding(top = 16.dp)
                        )
                        Text(
                            text = cv.salary,
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Light,
                            modifier = Modifier.padding(top = 16.dp)
                        )
                        Text(
                            text = cv.work_experience,
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Light,
                            modifier = Modifier.padding(top = 16.dp)
                        )
                        Text(
                            text = cv.education,
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Light,
                            modifier = Modifier.padding(top = 16.dp)
                        )
                        Text(
                            text = cv.skills,
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Light,
                            modifier = Modifier.padding(top = 16.dp)
                        )
                        Text(
                            text = cv.languages,
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Light,
                            modifier = Modifier.padding(top = 16.dp)
                        )
                        Text(
                            text = cv.additional_info,
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Light,
                            modifier = Modifier.padding(top = 16.dp)
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
                            name = cv.name
                            surname = cv.surname
                            last_name = cv.last_name
                            birth_date = cv.birth_date
                            male = cv.male
                            email = cv.email
                            phone_number = cv.phone_number
                            city = cv.city
                            citizenship = cv.citizenship
                            job_title = cv.job_title
                            salary = cv.salary
                            work_experience = cv.work_experience
                            education = cv.education
                            skills = cv.skills
                            languages = cv.languages
                            additional_info = cv.additional_info
                            bottomSheetState.show()
                        }
                    }) {
                        Text(text = Constants.Keys.UPDATE)
                    }
                }
                Button(
                    modifier = Modifier
                        .padding(top = 16.dp)
                        .padding(horizontal = 32.dp)
                        .fillMaxWidth(),
                    onClick = {
                        navController.navigate(NavRoute.CVS.route)
                    }
                ) {
                    Text(text = Constants.Keys.NAV_BACK)
                }
            }
        }
    }
}
package ru.angel.recruitment_agency.screens

import android.app.Application
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
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
    var description by remember { mutableStateOf(Constants.Keys.EMPTY)}

    ModalBottomSheetLayout(
        sheetState = bottomSheetState,
        sheetElevation = 5.dp,
        sheetShape = RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp),
        sheetContent = {
            Surface {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(all = 32.dp)
                ) {
                    Text(
                        text = Constants.Keys.EDIT_JOB,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(vertical = 8.dp)
                    )
                    OutlinedTextField(
                        value = title,
                        onValueChange = { title = it },
                        label = { Text(text = Constants.Keys.TITLE) },
                        isError = title.isEmpty()
                    )
                    OutlinedTextField(
                        value = description,
                        onValueChange = { description = it },
                        label = { Text(text = Constants.Keys.DESCRIPTION) },
                        isError = description.isEmpty()
                    )
                    Button(
                        modifier = Modifier.padding(top = 16.dp),
                        onClick = {
                            viewModel.updateJob(
                                job =
                                Job(id = job.id, title = title, description = description, firebaseId = job.firebaseId)
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
            modifier = Modifier.fillMaxSize()
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
                        modifier = Modifier.padding(vertical = 8.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = job.title,
                            fontSize = 24.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(top = 32.dp)
                        )
                        Text(
                            text = job.description,
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
                            title = job.title
                            description = job.description
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
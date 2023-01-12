package ru.angel.recruitment_agency.screens

import android.app.Application
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
import ru.angel.recruitment_agency.utils.DB_TYPE
import ru.angel.recruitment_agency.utils.TYPE_FIREBASE
import ru.angel.recruitment_agency.utils.TYPE_ROOM

@Composable
fun MainScreen(navController: NavHostController, viewModel: MainViewModel) {
    val jobs = viewModel.readAllJobs().observeAsState(listOf()).value
    Scaffold(
        floatingActionButton = {
            FloatingActionButton( //Button for adding a new job
                onClick = {
                    navController.navigate(route = NavRoute.Add.route)
                }
            ) {
                Icon(imageVector = Icons.Filled.Add, contentDescription = Constants.Keys.ADD_ICONS, tint = Color.White)
            }
        },
        modifier = Modifier.padding(bottom = 60.dp)
    ) {
        LazyColumn {
            items(jobs) { job ->
                JobItem(job = job, navController = navController)
            }
        }
    }
}

@Composable
fun JobItem(job: Job, navController: NavHostController) {
    val jobId = when(DB_TYPE.value) {
        TYPE_FIREBASE -> job.firebaseId
        TYPE_ROOM -> job.id
        else -> Constants.Keys.EMPTY
    }
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp, horizontal = 24.dp)
            .clickable {
                navController.navigate(NavRoute.Job.route + "/${jobId}")
            },
        elevation = 6.dp
    ) {
        Column(
            modifier = Modifier.padding(vertical = 8.dp, horizontal = 15.dp),
            horizontalAlignment = Alignment.Start
        ) {
            Text(
                text = job.title, //Job Title
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )
            Text(text = job.salary)
            Text(text = job.city)
            Text(text = job.company)
            Text(text = job.description)
            Box(
                modifier = Modifier
                    .padding(vertical = 10.dp)
                    .fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                Button(
                    onClick = {
                    /*TODO*/ 
                    }) {
                    Text(text = "Respond")
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun prevMainScreen() {
    Recruitment_agencyTheme {
        val context = LocalContext.current
        val mViewModel: MainViewModel =
            viewModel(factory = MainViewModelFactory(context.applicationContext as Application))
        MainScreen(navController = rememberNavController(), viewModel = mViewModel)
    }
}
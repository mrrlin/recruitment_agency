package ru.angel.recruitment_agency.screens

import android.app.Application
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
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

@Composable
fun MainScreen(navController: NavHostController) {
    val context = LocalContext.current
    val mViewModel: MainViewModel =
        viewModel(factory = MainViewModelFactory(context.applicationContext as Application))

    val jobs = mViewModel.readTest.observeAsState(listOf()).value
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    navController.navigate(route = NavRoute.Add.route)
                }) {
                Icon(imageVector = Icons.Filled.Add, contentDescription = "Add Icons", tint = Color.White)
            }
        }
    ) {
//        Column() {
//            JobItem(title = "First Job", subtitle = "Description", navController = navController)
//            JobItem(title = "Second Job", subtitle = "Description", navController = navController)
//            JobItem(title = "Third Job", subtitle = "Description", navController = navController)
//            JobItem(title = "Fourth Job", subtitle = "Description", navController = navController)
//            JobItem(title = "Fifth Job", subtitle = "Description", navController = navController)
//        }
        LazyColumn {
            items(jobs) { job ->
                JobItem(job = job, navController = navController)

            }
        }
    }
}

@Composable
fun JobItem(job: Job, navController: NavHostController) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp, horizontal = 24.dp)
            .clickable {
                navController.navigate(route = NavRoute.Job.route)
            },
        elevation = 6.dp
    ) {
        Column(
            modifier = Modifier.padding(vertical = 8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(
                text = job.title,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )
            Text(text = job.description)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun prevMainScreen() {
    Recruitment_agencyTheme {
        MainScreen(navController = rememberNavController())
    }
}
package ru.angel.recruitment_agency.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import ru.angel.recruitment_agency.MainViewModel
import ru.angel.recruitment_agency.model.CV
import ru.angel.recruitment_agency.navigation.NavRoute
import ru.angel.recruitment_agency.utils.Constants
import ru.angel.recruitment_agency.utils.DB_TYPE
import ru.angel.recruitment_agency.utils.TYPE_FIREBASE
import ru.angel.recruitment_agency.utils.TYPE_ROOM

@Composable
fun ResponsesScreen(navController: NavHostController, viewModel: MainViewModel) {
    Column {
        Text(text = "Hey, this is responses")
        ResponseItemAccepted()
        ResponseItemRejected()
        ResponseItemWaiting()
    }
    //val cvs = viewModel.readAllCVs().observeAsState(listOf()).value
//    Scaffold() {
//        LazyColumn {
//            items(cvs) { cv ->
//                CVItem(cv = cv, navController = navController)
//            }
            
//        }
//    }
}

@Composable
fun ResponseItemAccepted() {
//    val cvId = when(DB_TYPE.value) {
//        TYPE_FIREBASE -> cv.firebaseId
//        TYPE_ROOM -> cv.id
//        else -> Constants.Keys.EMPTY
//    }
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp, horizontal = 24.dp),
        elevation = 6.dp,
        backgroundColor = Color(139, 195, 74, 90)
    ) {
        Column(
            modifier = Modifier.padding(vertical = 8.dp, horizontal = 15.dp),
            horizontalAlignment = Alignment.Start
        ) {
            Text(
                text = "Job Title",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )
            Text(text = "Company")
            Text(text = "Salary")
        }
    }
}

@Composable
fun ResponseItemRejected() {
//    val cvId = when(DB_TYPE.value) {
//        TYPE_FIREBASE -> cv.firebaseId
//        TYPE_ROOM -> cv.id
//        else -> Constants.Keys.EMPTY
//    }
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp, horizontal = 24.dp),
        elevation = 6.dp,
        backgroundColor = Color(244, 57, 64, 90)
    ) {
        Column(
            modifier = Modifier.padding(vertical = 8.dp, horizontal = 15.dp),
            horizontalAlignment = Alignment.Start
        ) {
            Text(
                text = "Job Title",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )
            Text(text = "Company")
            Text(text = "Salary")
        }
    }
}

@Composable
fun ResponseItemWaiting() {
//    val cvId = when(DB_TYPE.value) {
//        TYPE_FIREBASE -> cv.firebaseId
//        TYPE_ROOM -> cv.id
//        else -> Constants.Keys.EMPTY
//    }
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp, horizontal = 24.dp),
        elevation = 6.dp,
        backgroundColor = Color(255, 235, 59, 90)
    ) {
        Column(
            modifier = Modifier.padding(vertical = 8.dp, horizontal = 15.dp),
            horizontalAlignment = Alignment.Start
        ) {
            Text(
                text = "Job Title",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )
            Text(text = "Company")
            Text(text = "Salary")
        }
    }
}

package ru.angel.recruitment_agency.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import ru.angel.recruitment_agency.MainViewModel

@Composable
fun ResponsesScreen() {
    Column {
        Text(text = "Hey, this is responses")
        ResponseItemAccepted()
        ResponseItemRejected()
        ResponseItemWaiting()
    }
}

@Composable
fun ResponseItemAccepted() {
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

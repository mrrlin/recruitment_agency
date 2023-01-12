package ru.angel.recruitment_agency.screens

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import ru.angel.recruitment_agency.MainViewModel

@Composable
fun ResponsesScreen(navController: NavHostController, viewModel: MainViewModel) {
    Text(text = "Hey, this is responses")
}
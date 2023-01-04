package ru.angel.recruitment_agency.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import ru.angel.recruitment_agency.MainViewModel
import ru.angel.recruitment_agency.screens.*

sealed class NavRoute(val route: String) {
    object Start: NavRoute("start_screen") //Choose registration/log in
    object Login: NavRoute("login_screen") //Log in
    object Registration: NavRoute("registration_screen") //Registration
    object Main: NavRoute("main_screen") //List of jobs
    object Add: NavRoute("add_screen") //Add job
    object Job: NavRoute("job_screen") //Job
    object CV: NavRoute("cv_screen") //CV
    object Responses: NavRoute("responses_screen") //Responses
}

@Composable
fun AgencyNavHost(mViewModel: MainViewModel) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = NavRoute.Start.route) {
        composable(NavRoute.Start.route) { StartScreen(navController = navController, viewModel = mViewModel) }
        composable(NavRoute.Login.route) { LoginScreen(navController = navController, viewModel = mViewModel) }
        composable(NavRoute.Registration.route) { RegistrationScreen(navController = navController, viewModel = mViewModel) }
        composable(NavRoute.Main.route) { MainScreen(navController = navController, viewModel = mViewModel) }
        composable(NavRoute.Add.route) { AddScreen(navController = navController, viewModel = mViewModel) }
        composable(NavRoute.Job.route) { JobScreen(navController = navController, viewModel = mViewModel) }
        composable(NavRoute.CV.route) { CVScreen(navController = navController, viewModel = mViewModel) }
        composable(NavRoute.Responses.route) { ResponsesScreen(navController = navController, viewModel = mViewModel) }
    }
}
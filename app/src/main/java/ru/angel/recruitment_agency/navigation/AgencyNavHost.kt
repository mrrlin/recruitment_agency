package ru.angel.recruitment_agency.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
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
fun AgencyNavHost() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = NavRoute.Start.route) {
        composable(NavRoute.Start.route) { Start(navController = navController) }
        composable(NavRoute.Login.route) { Login(navController = navController) }
        composable(NavRoute.Registration.route) { Registration(navController = navController) }
        composable(NavRoute.Main.route) { Main(navController = navController) }
        composable(NavRoute.Add.route) { Add(navController = navController) }
        composable(NavRoute.Job.route) { Job(navController = navController) }
        composable(NavRoute.CV.route) { CV(navController = navController) }
        composable(NavRoute.Responses.route) { Responses(navController = navController) }
    }
}
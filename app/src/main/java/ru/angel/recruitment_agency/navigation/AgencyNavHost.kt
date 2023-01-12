package ru.angel.recruitment_agency.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import ru.angel.recruitment_agency.MainViewModel
import ru.angel.recruitment_agency.screens.*
import ru.angel.recruitment_agency.utils.Constants

sealed class NavRoute(val route: String) {
    object Start: NavRoute(Constants.Screens.START_SCREEN) //Choose registration/log in
    object Main: NavRoute(Constants.Screens.MAIN_SCREEN) //List of jobs
    object Add: NavRoute(Constants.Screens.ADD_SCREEN) //Add job
    object Job: NavRoute(Constants.Screens.JOB_SCREEN) //Job
    object CV: NavRoute(Constants.Screens.CV_SCREEN) //CV
    object CVS: NavRoute(Constants.Screens.CVS_SCREEN) //List of CVs
    object AddCV: NavRoute(Constants.Screens.ADD_CV_SCREEN) //Add cv
    object Responses: NavRoute(Constants.Screens.RESPONSES_SCREEN) //Responses
}

@Composable
fun AgencyNavHost(mViewModel: MainViewModel, navController: NavHostController) {
    NavHost(navController = navController, startDestination = NavRoute.Start.route) {
        composable(NavRoute.Start.route) { StartScreen(navController = navController, viewModel = mViewModel) }
        composable(NavRoute.Main.route) { MainScreen(navController = navController, viewModel = mViewModel) }
        composable(NavRoute.Add.route) { AddScreen(navController = navController, viewModel = mViewModel) }
        composable(NavRoute.Job.route + "/{${Constants.Keys.ID}}") { backStackEntry ->
            JobScreen(navController = navController, viewModel = mViewModel, jobId = backStackEntry.arguments?.getString(Constants.Keys.ID))
        }
        composable(NavRoute.CV.route + "/{${Constants.Keys.ID}}") { backStackEntry ->
            CVScreen(navController = navController, viewModel = mViewModel, cvId = backStackEntry.arguments?.getString(Constants.Keys.ID))
        }
        composable(NavRoute.CVS.route) { CVsScreen(navController = navController, viewModel = mViewModel) }
        composable(NavRoute.AddCV.route) { AddCVScreen(navController = navController, viewModel = mViewModel) }
        composable(NavRoute.Responses.route) { ResponsesScreen(navController = navController, viewModel = mViewModel) }
    }
}
package ru.angel.recruitment_agency

import android.app.Application
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import ru.angel.recruitment_agency.elements.BottomNavigationBar
import ru.angel.recruitment_agency.navigation.AgencyNavHost
import ru.angel.recruitment_agency.navigation.NavRoute
import ru.angel.recruitment_agency.ui.theme.Recruitment_agencyTheme
import ru.angel.recruitment_agency.utils.DB_TYPE

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Recruitment_agencyTheme {
                val context = LocalContext.current
                val mViewModel: MainViewModel =
                    viewModel(factory = MainViewModelFactory(context.applicationContext as Application))
                val navController = rememberNavController()

                Scaffold(
                    topBar = {
                         TopAppBar (
                             title = {
                                 Row(
                                     modifier = Modifier
                                         .fillMaxWidth()
                                         .padding(horizontal = 16.dp),
                                     horizontalArrangement = Arrangement.SpaceBetween
                                 ) {
                                     Text(text = "Dream Job") //App Title
                                     if (DB_TYPE.value.isNotEmpty()) {
                                         Icon(
                                             imageVector = Icons.Default.ExitToApp,
                                             contentDescription = "",
                                             modifier = Modifier.clickable {
                                                 mViewModel.singOut {
                                                     navController.navigate(NavRoute.Start.route) {
                                                         popUpTo(NavRoute.Start.route) {
                                                             inclusive = true
                                                         }
                                                     }
                                                 }
                                             }
                                         )
                                     }
                                 }
                             },
                             backgroundColor = Color.DarkGray,
                             contentColor = Color.White,
                             elevation = 12.dp
                         )
                    },
                    bottomBar = {
                        BottomNavigationBar(
                            items = listOf(
                                BottomNavItem(
                                    name = "Job",
                                    route = NavRoute.Main.route,
                                    icon = Icons.Default.Search
                                ),
                                BottomNavItem(
                                    name = "Responses",
                                    route = NavRoute.Responses.route,
                                    icon = Icons.Default.Notifications,
                                    badgeCount = 23
                                ),
                                BottomNavItem(
                                    name = "CV",
                                    route = NavRoute.CVS.route,
                                    icon = Icons.Default.Settings,
                                )
                            ),
                            navController = navController,
                            onItemClick = {
                                navController.navigate(it.route)
                            }
                        )
                    },
                    content = {
                        Surface(
                            modifier = Modifier.fillMaxSize(),
                            color = MaterialTheme.colors.background
                        ) {
                            AgencyNavHost(mViewModel, navController)
                        }
                    }
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Recruitment_agencyTheme {

    }
}
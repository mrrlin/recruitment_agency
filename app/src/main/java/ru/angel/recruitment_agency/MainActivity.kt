package ru.angel.recruitment_agency

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.angel.recruitment_agency.navigation.AgencyNavHost
import ru.angel.recruitment_agency.ui.theme.Recruitment_agencyTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Recruitment_agencyTheme {
                Scaffold(
                    topBar = {
                         TopAppBar (
                             title = {
                                 Text(text = "DreamJob")
                             },
                             backgroundColor = Color.DarkGray,
                             contentColor = Color.White,
                             elevation = 12.dp
                         )
                    },
                    content = {
                        Surface(
                            modifier = Modifier.fillMaxSize(),
                            color = MaterialTheme.colors.background
                        ) {
                            AgencyNavHost()
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
package edu.iau.cshj.csc402.lab3

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import edu.iau.cshj.csc402.lab3.ui.theme.CSC402_Lab3Theme


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen(
    modifier: Modifier = Modifier
) {

    Scaffold(
        modifier = modifier,

        topBar = {
            TopAppBar(
                title = {
                    Text("My Profile")
                }
            )
        },

        floatingActionButton = {
            FloatingActionButton(
                onClick = { }
            ) {
                Text("+")
            }
        }

    ) { innerPadding ->

        Column(
            modifier = Modifier.padding(innerPadding)
        ) {

            StudentCard(
                student = Student(
                    name = "Reem AlShehab",
                    program = "Computer Science - Level 7",
                    gpa = "5.0",
                    email = "2240005189@iau.edu.sa",
                    city = "Qatif, EP"
                ),
                modifier = Modifier.padding(16.dp)
            )

        }
    }
}


@Preview(showBackground = true)
@Composable
fun ProfileScreenPreview() {

    CSC402_Lab3Theme {
        ProfileScreen()
    }

}
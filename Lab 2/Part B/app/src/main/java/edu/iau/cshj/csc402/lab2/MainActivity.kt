package edu.iau.cshj.csc402.lab2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import edu.iau.cshj.csc402.lab2.ui.theme.PartBTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PartBTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    TeamTaskScreen()
                }
            }
        }
    }
}

//WelcomeScreen()      Task 6
//StudentIdScreen()    Task 7
//AttendanceCounter()  Task 8
//GreetingCard()       Task 9
//CourseListScreen()   Task 10
//TeamTaskScreen()  Task 11 //d
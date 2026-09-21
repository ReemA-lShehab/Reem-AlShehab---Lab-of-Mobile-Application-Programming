package edu.iau.cshj.csc402.lab2

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import edu.iau.cshj.csc402.lab2.ui.theme.*


data class TeamTask(
    val id: Int,
    val title: String,
    val owner: String,
    val isDone: Boolean = false
)



@Composable
fun TeamTaskScreen() {


    val tasks = remember {

        mutableStateListOf(
            TeamTask(1, "Create GitHub repository", "Fatimah", true),
            TeamTask(2, "Write project proposal", "Omar", true),
            TeamTask(3, "Design the login screen", "Noura"),
            TeamTask(4, "Set up Android Studio", "Yousef")
        )
    }



    val doneCount = tasks.count {
        it.isDone
    }

    val openCount = tasks.size - doneCount



    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(ScreenBackground)
    ) {



        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(Navy)
                .padding(15.dp)
        ) {

            Text(
                text = "Team Task Tracker",
                color = Color.White,
                fontWeight = FontWeight.Bold
            )


            Text(
                text = "Task 11 - Challenge",
                color = Color.White,
                fontSize = 12.sp
            )
        }



        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp)
                .background(
                    Navy,
                    RoundedCornerShape(15.dp)
                )
                .padding(20.dp),
            horizontalArrangement = Arrangement.SpaceAround
        ) {


            Text(
                text = "$doneCount\nDone",
                color = AndroidGreen,
                fontWeight = FontWeight.Bold
            )


            Text(
                text = "$openCount\nOpen",
                color = Color.White
            )


            Text(
                text = "${tasks.size}\nTotal",
                color = Color.White
            )
        }



        LazyColumn(
            modifier = Modifier.weight(1f),
            contentPadding = PaddingValues(15.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {


            items(tasks) { task ->


                TaskRow(
                    task = task,
                    onToggle = {

                        val index = tasks.indexOf(task)

                        tasks[index] =
                            task.copy(
                                isDone = !task.isDone
                            )
                    }
                )
            }
        }




        Button(
            onClick = {

                tasks.add(
                    TeamTask(
                        tasks.size + 1,
                        "New task",
                        "Reem"
                    )
                )

            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = AndroidGreen
            )
        ) {

            Text("+ Add task")
        }

    }
}




@Composable
fun TaskRow(
    task: TeamTask,
    onToggle: () -> Unit
) {


    Card(
        modifier = Modifier.fillMaxWidth()
    ) {


        Row(
            modifier = Modifier
                .padding(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {


            Checkbox(
                checked = task.isDone,
                onCheckedChange = {
                    onToggle()
                }
            )



            Column {

                Text(
                    text = task.title,
                    fontWeight = FontWeight.Bold,
                    textDecoration =
                        if (task.isDone)
                            TextDecoration.LineThrough
                        else
                            TextDecoration.None,
                    color =
                        if (task.isDone)
                            Color.Gray
                        else
                            Color.Black
                )


                Text(
                    text = task.owner,
                    color = Color.Gray,
                    fontSize = 12.sp
                )
            }

        }
    }
}




@Preview(showBackground = true)
@Composable
fun TeamTaskPreview() {

    TeamTaskScreen()

}
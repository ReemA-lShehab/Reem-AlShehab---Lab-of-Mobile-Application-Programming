package edu.iau.cshj.csc402.lab2

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.text.font.FontWeight
import edu.iau.cshj.csc402.lab2.ui.theme.*


data class Course(
    val code: String,
    val title: String,
    val credits: Int,
    val days: String
)


@Composable
fun CourseListScreen() {

    val courses = remember {
        listOf(
            Course("CSC 402", "Mobile Application Programming", 3, "Mon / Wed"),
            Course("CSC 311", "Database Systems", 4, "Sun / Tue"),
            Course("CSC 340", "Operating Systems", 3, "Mon / Wed"),
            Course("MATH 202", "Discrete Mathematics", 3, "Sun / Thu"),
            Course("ENG 214", "Technical Writing", 2, "Tue"),
            Course("PHYS 105", "General Physics II", 4, "Sun / Tue"),
            Course("ISLM 101", "Islamic Culture", 2, "Thu")
        )
    }


    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(ScreenBackground)
    ) {


        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(Navy)
                .padding(12.dp)
        ) {

            Text(
                text = "My Courses",
                color = Color.White,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = "Task 10 - LazyColumn & data class",
                color = Color.White,
                fontSize = 12.sp
            )
        }


        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(12.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {

            items(courses) { course ->

                CourseRow(course)

            }
        }
    }
}



@Composable
fun CourseRow(course: Course) {


    Card(
        modifier = Modifier
            .fillMaxWidth(),
        shape = RoundedCornerShape(10.dp)
    ) {


        Row(
            modifier = Modifier
                .height(80.dp)
        ) {


            Box(
                modifier = Modifier
                    .width(5.dp)
                    .fillMaxHeight()
                    .background(AndroidGreen)
            )


            Column(
                modifier = Modifier
                    .padding(12.dp)
                    .weight(1f)
            ) {


                Text(
                    text = course.code,
                    fontSize = 14.sp
                )


                Text(
                    text = course.title,
                    fontWeight = FontWeight.Bold,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )


                Text(
                    text = course.days,
                    color = Color.Gray,
                    fontSize = 12.sp
                )
            }



            Text(
                text = "${course.credits} cr",
                color = AndroidGreen,
                modifier = Modifier
                    .padding(15.dp)
                    .background(
                        AndroidGreen.copy(alpha = 0.15f),
                        RoundedCornerShape(20.dp)
                    )
                    .padding(
                        horizontal = 10.dp,
                        vertical = 5.dp
                    )
            )
        }
    }
}



@Preview(showBackground = true)
@Composable
fun CourseListPreview() {
    CourseListScreen()
}
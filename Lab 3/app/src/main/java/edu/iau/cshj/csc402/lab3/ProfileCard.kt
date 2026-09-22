package edu.iau.cshj.csc402.lab3

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import android.content.res.Configuration
import androidx.compose.ui.tooling.preview.Preview
import edu.iau.cshj.csc402.lab3.ui.theme.CSC402_Lab3Theme


data class Student(
    val name: String,
    val program: String,
    val gpa: String,
    val email: String,
    val city: String
)


@Composable
fun StudentCard(
    student: Student,
    modifier: Modifier = Modifier
) {

    Card(
        modifier = modifier.fillMaxWidth()
    ) {

        Column(
            modifier = Modifier.padding(16.dp)
        ) {

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {

                Box(
                    modifier = Modifier
                        .size(52.dp)
                        .clip(CircleShape)
                        .background(MaterialTheme.colorScheme.primary),
                    contentAlignment = Alignment.Center
                ) {

                    Text(
                        text = student.name.first().toString(),
                        color = MaterialTheme.colorScheme.onPrimary
                    )
                }


                Spacer(
                    modifier = Modifier.width(12.dp)
                )


                Column(
                    modifier = Modifier.weight(1f)
                ) {

                    Text(
                        text = student.name,
                        style = MaterialTheme.typography.titleLarge,
                        color = MaterialTheme.colorScheme.onSurface
                    )


                    Text(
                        text = student.program,
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }


                Text(
                    text = student.gpa,
                    style = MaterialTheme.typography.titleLarge,
                    color = MaterialTheme.colorScheme.primary
                )
            }


            Spacer(
                modifier = Modifier.height(8.dp)
            )


            Text(
                text = student.email,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )


            Text(
                text = student.city,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    }
}
@Preview(
    name = "Light",
    showBackground = true
)
@Composable
private fun StudentCardLightPreview() {
    CSC402_Lab3Theme {
        StudentCard(
            student = Student(
                name = "Reem AlShehab",
                program = "Computer Science - Level 7",
                gpa = "5.0",
                email = "2240005189@iau.edu.sa",
                city = "Qatif, EP"
            )
        )
    }
}


@Preview(
    name = "Dark",
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
@Composable
private fun StudentCardDarkPreview() {
    CSC402_Lab3Theme {
        StudentCard(
            student = Student(
                name = "Reem AlShehab",
                program = "Computer Science - Level 7",
                gpa = "5.0",
                email = "2240005189@iau.edu.sa",
                city = "Qatif, EP"
            )
        )
    }
}
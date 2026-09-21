package edu.iau.cshj.csc402.lab2

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import edu.iau.cshj.csc402.lab2.ui.theme.*


@Composable
fun StudentIdScreen(modifier: Modifier = Modifier) {

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(ScreenBackground)
    ) {

        // Top bar
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(Navy)
                .padding(12.dp)
        ) {
            Text(
                text = "Student ID",
                color = Color.White
            )

            Text(
                text = "Task 7 - Row & Column",
                color = Color.White,
                fontSize = 12.sp
            )
        }


        Spacer(modifier = Modifier.height(15.dp))


        // First Card
        Card(
            modifier = Modifier
                .padding(20.dp)
                .fillMaxWidth(),
            shape = RoundedCornerShape(10.dp)
        ) {

            Row(
                modifier = Modifier.padding(15.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {

                Box(
                    modifier = Modifier
                        .size(55.dp)
                        .clip(CircleShape)
                        .background(Navy),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "NA",
                        color = AndroidGreen
                    )
                }


                Spacer(modifier = Modifier.width(15.dp))


                Column {
                    Text(
                        text = "Reem AlShehab",
                        fontWeight = FontWeight.Bold
                    )

                    Text(
                        text = "Computer Science",
                        fontSize = 12.sp,
                        color = Color.Gray
                    )

                    Text(
                        text = "2240005189",
                        fontSize = 12.sp,
                        color = Color.Gray
                    )


                    Row {
                        Text(
                            text = "Level 7",
                            color = AndroidGreen,
                            fontSize = 10.sp,
                            modifier = Modifier
                                .background(
                                    AndroidGreen.copy(alpha = 0.2f),
                                    RoundedCornerShape(10.dp)
                                )
                                .padding(5.dp)
                        )

                        Spacer(modifier = Modifier.width(5.dp))

                        Text(
                            text = "CS",
                            color = AndroidGreen,
                            fontSize = 10.sp,
                            modifier = Modifier
                                .background(
                                    AndroidGreen.copy(alpha = 0.2f),
                                    RoundedCornerShape(10.dp)
                                )
                                .padding(5.dp)
                        )
                    }
                }
            }
        }


        HorizontalDivider(
            modifier = Modifier.padding(horizontal = 20.dp)
        )


        // Second Card
        Card(
            modifier = Modifier
                .padding(20.dp)
                .fillMaxWidth(),
            shape = RoundedCornerShape(10.dp)
        ) {

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(15.dp),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                StatItem("5.00", "GPA")
                StatItem("78", "Credits")
                StatItem("Active", "Status")
            }
        }
    }
}



@Composable
fun StatItem(value: String, label: String) {

    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = value,
            fontWeight = FontWeight.Bold
        )

        Text(
            text = label,
            color = Color.Gray,
            fontSize = 12.sp
        )
    }
}



@Preview(showBackground = true)
@Composable
fun StudentIdScreenPreview() {
    StudentIdScreen()
}
package edu.iau.cshj.csc402.lab2

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import edu.iau.cshj.csc402.lab2.ui.theme.*
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.material3.ButtonDefaults

@Composable
fun AttendanceCounter() {

    var count by remember {
        mutableStateOf(0)
    }


    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(ScreenBackground),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {


        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(Navy)
                .padding(12.dp)
        ) {

            Text(
                text = "Attendance Counter",
                color = Color.White
            )

            Text(
                text = "Task 8 - State & mutableState",
                color = Color.White,
                fontSize = 12.sp
            )
        }


        Spacer(modifier = Modifier.height(30.dp))


        Text(
            text = "STUDENTS PRESENT",
            color = Color.Gray,
            fontSize = 12.sp
        )


        Spacer(modifier = Modifier.height(10.dp))


        Box(
            modifier = Modifier
                .size(120.dp, 80.dp)
                .background(Color.White, RoundedCornerShape(10.dp)),
            contentAlignment = Alignment.Center
        ) {

            Text(
                text = "$count",
                fontSize = 52.sp,
                fontWeight = FontWeight.Bold,
                color = Navy
            )
        }


        Spacer(modifier = Modifier.height(20.dp))


        Row {

            Button(
                onClick = {
                    count--
                },
                enabled = count > 0,
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.LightGray
                )
            ) {
                Text("-")
            }


            Spacer(modifier = Modifier.width(20.dp))


            Button(
                onClick = {
                    count++
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = AndroidGreen
                )
            ) {
                Text("+")
            }
        }


        Spacer(modifier = Modifier.height(15.dp))


        Button(
            onClick = {
                count = 0
            },
            enabled = count > 0,
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.LightGray
            )
        ) {
            Text("Reset")
        }


        Spacer(modifier = Modifier.height(15.dp))


        Text(
            text = if (count == 0)
                "Tap + to check a student in."
            else
                "$count of 30 students checked in.",
            color = Color.Gray,
            fontSize = 12.sp
        )
    }
}


@Preview(showBackground = true)
@Composable
fun AttendanceCounterPreview() {
    AttendanceCounter()
}
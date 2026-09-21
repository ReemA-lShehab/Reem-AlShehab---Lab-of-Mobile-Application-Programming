package edu.iau.cshj.csc402.lab2

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.font.FontWeight
import edu.iau.cshj.csc402.lab2.ui.theme.*


@Composable
fun GreetingCard() {

    var name by remember {
        mutableStateOf("")
    }

    var submittedName by remember {
        mutableStateOf("")
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
                text = "Greeting Card",
                color = Color.White
            )

            Text(
                text = "Task 9 - TextField & State",
                color = Color.White,
                fontSize = 12.sp
            )
        }


        Spacer(modifier = Modifier.height(30.dp))


        OutlinedTextField(
            value = name,
            onValueChange = {
                name = it
            },
            label = {
                Text("Your name")
            },
            singleLine = true
        )


        Spacer(modifier = Modifier.height(15.dp))


        Button(
            onClick = {
                submittedName = name.trim()
            },
            enabled = name.isNotBlank(),
            modifier = Modifier.fillMaxWidth(0.8f)
        ) {

            Text("Show greeting")
        }


        Spacer(modifier = Modifier.height(20.dp))


        Card(
            modifier = Modifier
                .fillMaxWidth(0.8f),
            shape = RoundedCornerShape(12.dp)
        ) {

            Column(
                modifier = Modifier.padding(20.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {


                if (submittedName.isBlank()) {

                    Text(
                        text = "Type your name above\nto see the greeting.",
                        color = Color.Gray
                    )

                } else {

                    Text(
                        text = "Marhaba, $submittedName!",
                        fontSize = 22.sp,
                        fontWeight = FontWeight.Bold
                    )


                    Text(
                        text = "Your name has ${submittedName.length} letters.",
                        color = Color.Gray
                    )


                    Text(
                        text = "CSC 402 - Lab 2",
                        color = AndroidGreen,
                        modifier = Modifier
                            .background(
                                AndroidGreen.copy(alpha = 0.2f),
                                RoundedCornerShape(20.dp)
                            )
                            .padding(8.dp)
                    )
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    GreetingCard()
}
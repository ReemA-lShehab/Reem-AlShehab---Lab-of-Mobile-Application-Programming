package edu.iau.cshj.csc402.lab3

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview


@Composable
fun ChainA() {
    Text(
        text = "content",
        modifier = Modifier
            .background(Color(0xFF3DDC84))
            .padding(24.dp)
    )
}


@Composable
fun ChainB() {
    Text(
        text = "content",
        modifier = Modifier
            .padding(24.dp)
            .background(Color(0xFF3DDC84))
    )
}


@Composable
fun ChainC() {
    Text(
        text = "content",
        modifier = Modifier
            .clip(RoundedCornerShape(20.dp))
            .background(Color(0xFF3DDC84))
            .padding(24.dp)
    )
}

@Preview(showBackground = true)
@Composable
fun OrderPuzzlePreview() {
    Column(
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        ChainA()
        ChainB()
        ChainC()
    }
}
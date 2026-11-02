package sa.edu.iau.cshj.studyplanner.ui

import android.content.Intent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import sa.edu.iau.cshj.studyplanner.ui.theme.StudyPlannerTheme

data class TaskDetailUiState(
    val title: String = ""
)

@Composable
fun TaskDetailScreen(
    uiState: TaskDetailUiState,
    onShareClick: () -> Unit,
    onBackClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(uiState.title, style = MaterialTheme.typography.headlineMedium)
        Button(onClick = onShareClick) {
            Text("Share")
        }
        OutlinedButton(onClick = onBackClick) {
            Text("Back")
        }
    }
}

@Composable
fun TaskDetailRoute(
    title: String,
    onBackClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current
    TaskDetailScreen(
        uiState = TaskDetailUiState(title = title),
        onShareClick = {
            val send = Intent(Intent.ACTION_SEND).apply {
                putExtra(Intent.EXTRA_TEXT, "Today I'm studying: $title")
                type = "text/plain"
            }
            context.startActivity(Intent.createChooser(send, "Share via"))
        },
        onBackClick = onBackClick,
        modifier = modifier.safeDrawingPadding()
    )
}

@Preview(showBackground = true, name = "Lab report task")
@Composable
private fun LabReportTaskPreview() {
    StudyPlannerTheme {
        TaskDetailScreen(
            uiState = TaskDetailUiState(title = "Lab 5 report"),
            onShareClick = {},
            onBackClick = {}
        )
    }
}

@Preview(showBackground = true, name = "Quiz revision task")
@Composable
private fun QuizRevisionTaskPreview() {
    StudyPlannerTheme {
        TaskDetailScreen(
            uiState = TaskDetailUiState(title = "Revise for quiz 2"),
            onShareClick = {},
            onBackClick = {}
        )
    }
}

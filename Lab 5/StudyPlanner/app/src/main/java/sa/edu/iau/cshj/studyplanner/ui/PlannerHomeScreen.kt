package sa.edu.iau.cshj.studyplanner.ui

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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import sa.edu.iau.cshj.studyplanner.ui.theme.StudyPlannerTheme

data class PlannerUiState(
    val greeting: String = "",
    val totalTasks: Int = 0,
    val doneCount: Int = 0,
    val tasks: List<String> = emptyList()
)

@Composable
fun PlannerHomeScreen(
    uiState: PlannerUiState,
    onMarkDoneClick: () -> Unit,
    onTaskClick: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(uiState.greeting, style = MaterialTheme.typography.headlineMedium)
        Text("${uiState.doneCount} of ${uiState.totalTasks} done")
        Button(
            onClick = onMarkDoneClick,
            enabled = uiState.doneCount < uiState.totalTasks
        ) {
            Text("Mark one done")
        }
        Text("My tasks")
        uiState.tasks.forEach { title ->
            OutlinedButton(onClick = { onTaskClick(title) }) {
                Text(title)
            }
        }
    }
}

@Composable
fun PlannerHomeRoute(
    onTaskClick: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    var uiState by remember {
        mutableStateOf(
            PlannerUiState(
                greeting = "Hello, Reem",
                tasks = listOf("Lab 5 report", "Read chapter 4", "Revise for quiz 2"),
                totalTasks = 3,
                doneCount = 0
            )
        )
    }
    PlannerHomeScreen(
        uiState = uiState,
        onMarkDoneClick = {
            uiState = uiState.copy(doneCount = uiState.doneCount + 1)
        },
        onTaskClick = onTaskClick,
        modifier = modifier.safeDrawingPadding()
    )
}

@Preview(showBackground = true, name = "Nothing done yet")
@Composable
private fun NothingDoneYetPreview() {
    StudyPlannerTheme {
        PlannerHomeScreen(
            uiState = PlannerUiState(
                greeting = "Hello, Reem",
                totalTasks = 3,
                doneCount = 0,
                tasks = listOf("Lab 5 report", "Read chapter 4", "Revise for quiz 2")
            ),
            onMarkDoneClick = {},
            onTaskClick = {}
        )
    }
}

@Preview(showBackground = true, name = "Everything done")
@Composable
private fun EverythingDonePreview() {
    StudyPlannerTheme {
        PlannerHomeScreen(
            uiState = PlannerUiState(
                greeting = "Hello, Reem",
                totalTasks = 3,
                doneCount = 3,
                tasks = listOf("Lab 5 report", "Read chapter 4", "Revise for quiz 2")
            ),
            onMarkDoneClick = {},
            onTaskClick = {}
        )
    }
}

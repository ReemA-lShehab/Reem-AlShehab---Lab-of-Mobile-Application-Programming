package sa.edu.iau.cshj.studyplanner.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import sa.edu.iau.cshj.studyplanner.model.StudyTask
import sa.edu.iau.cshj.studyplanner.model.sampleTasks
import sa.edu.iau.cshj.studyplanner.ui.theme.StudyPlannerTheme

data class PlannerUiState(
    val greeting: String = "",
    val tasks: List<StudyTask> = emptyList()
)

@Composable
fun PlannerHomeScreen(
    uiState: PlannerUiState,
    onTaskClick: (Int) -> Unit,
    onDoneChange: (Int, Boolean) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(uiState.greeting, style = MaterialTheme.typography.headlineMedium)
        Text("${uiState.tasks.count { it.isDone }} of ${uiState.tasks.size} done")
        LazyColumn {
            items(uiState.tasks, key = { it.id }) { task ->
                TaskItem(
                    task = task,
                    onTaskClick = onTaskClick,
                    onDoneChange = onDoneChange
                )
            }
        }
    }
}

@Composable
fun PlannerHomeRoute(
    onTaskClick: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    var uiState by remember {
        mutableStateOf(
            PlannerUiState(
                greeting = "Hello, Reem",
                tasks = sampleTasks
            )
        )
    }
    PlannerHomeScreen(
        uiState = uiState,
        onTaskClick = onTaskClick,
        onDoneChange = { id, done ->
            uiState = uiState.copy(
                tasks = uiState.tasks.map { if (it.id == id) it.copy(isDone = done) else it }
            )
        },
        modifier = modifier.safeDrawingPadding()
    )
}

@Preview(showBackground = true, name = "Home with five tasks")
@Composable
private fun HomeWithFiveTasksPreview() {
    StudyPlannerTheme {
        PlannerHomeScreen(
            uiState = PlannerUiState(
                greeting = "Hello, Reem",
                tasks = sampleTasks.map { task ->
                    if (task.id == 1 || task.id == 3) task.copy(isDone = true) else task
                }
            ),
            onTaskClick = {},
            onDoneChange = { _, _ -> }
        )
    }
}

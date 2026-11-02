package sa.edu.iau.cshj.studyplanner.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import sa.edu.iau.cshj.studyplanner.model.StudyTask
import sa.edu.iau.cshj.studyplanner.ui.theme.StudyPlannerTheme

@Composable
fun TaskItem(
    task: StudyTask,
    onTaskClick: (Int) -> Unit,
    onDoneChange: (Int, Boolean) -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .clickable { onTaskClick(task.id) }
            .padding(vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Checkbox(
            checked = task.isDone,
            onCheckedChange = { checked -> onDoneChange(task.id, checked) }
        )
        Spacer(Modifier.width(8.dp))
        Column {
            Text(task.title, style = MaterialTheme.typography.bodyLarge)
            Text(task.course, style = MaterialTheme.typography.bodySmall)
        }
    }
}

@Preview(showBackground = true, widthDp = 360, name = "TaskItem not done")
@Composable
private fun TaskItemNotDonePreview() {
    StudyPlannerTheme {
        TaskItem(
            task = StudyTask(1, "Lab 7 report", "CSC 402", isDone = false),
            onTaskClick = {},
            onDoneChange = { _, _ -> }
        )
    }
}

@Preview(showBackground = true, widthDp = 360, name = "TaskItem done")
@Composable
private fun TaskItemDonePreview() {
    StudyPlannerTheme {
        TaskItem(
            task = StudyTask(2, "Read chapter 4", "CSC 311", isDone = true),
            onTaskClick = {},
            onDoneChange = { _, _ -> }
        )
    }
}

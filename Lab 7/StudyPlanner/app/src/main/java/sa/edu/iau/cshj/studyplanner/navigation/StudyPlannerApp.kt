package sa.edu.iau.cshj.studyplanner.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import sa.edu.iau.cshj.studyplanner.model.sampleTasks
import sa.edu.iau.cshj.studyplanner.ui.PlannerHomeRoute
import sa.edu.iau.cshj.studyplanner.ui.TaskDetailRoute

@Composable
fun StudyPlannerApp() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = PlannerHome) {
        composable<PlannerHome> {
            PlannerHomeRoute(
                onTaskClick = { id ->
                    navController.navigate(TaskDetail(id))
                }
            )
        }
        composable<TaskDetail> { backStackEntry ->
            val detail: TaskDetail = backStackEntry.toRoute()
            val task = sampleTasks.first { it.id == detail.id }
            TaskDetailRoute(
                title = task.title,
                onBackClick = {
                    navController.popBackStack()
                }
            )
        }
    }
}

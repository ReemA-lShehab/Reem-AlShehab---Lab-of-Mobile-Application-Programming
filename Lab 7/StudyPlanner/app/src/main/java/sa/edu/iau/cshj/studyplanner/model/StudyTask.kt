package sa.edu.iau.cshj.studyplanner.model

data class StudyTask(
    val id: Int,
    val title: String,
    val course: String,
    val isDone: Boolean = false
)

val sampleTasks = listOf(
    StudyTask(1, "Lab 7 report", "CSC 402"),
    StudyTask(2, "Read chapter 4", "CSC 311"),
    StudyTask(3, "Revise for quiz 2", "CSC 231"),
    StudyTask(4, "Finish assignment 3", "CSC 402"),
    StudyTask(5, "Practice SQL queries", "CSC 380")
)

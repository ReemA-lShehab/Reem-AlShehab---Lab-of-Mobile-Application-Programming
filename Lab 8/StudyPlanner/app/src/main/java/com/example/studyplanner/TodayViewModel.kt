package com.example.studyplanner

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class TodayViewModel : ViewModel() {
    private val repository = FakeTaskRepository()

    private val _uiState = MutableStateFlow(TodayUiState())
    val uiState: StateFlow<TodayUiState> =
        _uiState.asStateFlow()

    init {                                          // slide 42
        viewModelScope.launch {
            val tasks = repository.loadTodayTasks()
            _uiState.update {
                it.copy(isLoading = false, tasks = tasks)
            }
        }
    }

    fun onTaskCheckedChange(task: StudyTask, done: Boolean) {   // slide 43
        viewModelScope.launch {
            repository.setDone(task.id, done)
            _uiState.update { state ->
                state.copy(
                    tasks = state.tasks.map {
                        if (it.id == task.id) it.copy(isDone = done)
                        else it
                    },
                    message = if (done) "Marked as done" else null
                )
            }
        }
    }

    fun onMessageShown() {                          // slide 43
        _uiState.update { it.copy(message = null) }
    }
}
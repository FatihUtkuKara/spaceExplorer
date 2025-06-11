package com.example.spaceexplorer.ui.details

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.spaceexplorer.data.model.SpaceLaunch
import com.example.spaceexplorer.data.model.Rocket
import com.example.spaceexplorer.data.repository.SpaceXRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LaunchDetailsViewModel @Inject constructor(
    private val repository: SpaceXRepository,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _uiState = MutableStateFlow<LaunchDetailsUiState>(LaunchDetailsUiState.Loading)
    val uiState: StateFlow<LaunchDetailsUiState> = _uiState

    init {
        val launchId = savedStateHandle.get<String>("launchId")
        if (launchId != null) {
            loadLaunchDetails(launchId)
        } else {
            _uiState.value = LaunchDetailsUiState.Error("Launch ID not found")
        }
    }

    private fun loadLaunchDetails(launchId: String) {
        viewModelScope.launch {
            _uiState.value = LaunchDetailsUiState.Loading
            try {
                val launch = repository.getLaunchById(launchId)
                if (launch != null) {
                    val rocket = repository.getRocketById(launch.rocketId)
                    _uiState.value = LaunchDetailsUiState.Success(launch, rocket)
                } else {
                    _uiState.value = LaunchDetailsUiState.Error("Launch not found")
                }
            } catch (e: Exception) {
                _uiState.value = LaunchDetailsUiState.Error(e.message ?: "Unknown error occurred")
            }
        }
    }
}

sealed class LaunchDetailsUiState {
    data object Loading : LaunchDetailsUiState()
    data class Success(val launch: SpaceLaunch, val rocket: Rocket?) : LaunchDetailsUiState()
    data class Error(val message: String) : LaunchDetailsUiState()
} 
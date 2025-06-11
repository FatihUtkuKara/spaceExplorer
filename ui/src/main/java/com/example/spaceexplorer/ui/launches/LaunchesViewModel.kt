package com.example.spaceexplorer.ui.launches

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.spaceexplorer.data.model.SpaceLaunch
import com.example.spaceexplorer.data.repository.SpaceXRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LaunchesViewModel @Inject constructor(
    private val repository: SpaceXRepository
) : ViewModel() {

    private val TAG = "SpaceExplorer"
    private val _uiState = MutableStateFlow<LaunchesUiState>(LaunchesUiState.Loading)
    val uiState: StateFlow<LaunchesUiState> = _uiState

    init {
        Log.d(TAG, "[ViewModel] Initializing ViewModel")
        refreshLaunches()
    }

    fun loadLaunches() {
        Log.d(TAG, "[ViewModel] Loading launches from database")
        viewModelScope.launch {
            _uiState.value = LaunchesUiState.Loading
            repository.getAllLaunches()
                .catch { e ->
                    Log.e(TAG, "[ViewModel] Error loading launches", e)
                    _uiState.value = LaunchesUiState.Error(e.message ?: "Unknown error occurred")
                }
                .collect { launches ->
                    Log.d(TAG, "[ViewModel] Received ${launches.size} launches from database")
                    _uiState.value = LaunchesUiState.Success(launches)
                }
        }
    }

    fun refreshLaunches() {
        Log.d(TAG, "[ViewModel] Refreshing launches from API")
        viewModelScope.launch {
            try {
                repository.refreshLaunches()
                Log.d(TAG, "[ViewModel] Successfully refreshed launches, loading from database")
                loadLaunches()
            } catch (e: Exception) {
                Log.e(TAG, "[ViewModel] Error refreshing launches", e)
                _uiState.value = LaunchesUiState.Error(e.message ?: "Unknown error occurred")
            }
        }
    }
}

sealed class LaunchesUiState {
    data object Loading : LaunchesUiState()
    data class Success(val launches: List<SpaceLaunch>) : LaunchesUiState()
    data class Error(val message: String) : LaunchesUiState()
} 
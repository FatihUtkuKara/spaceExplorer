package com.example.spaceexplorer.ui.launches

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.spaceexplorer.data.model.SpaceLaunch
import com.example.spaceexplorer.data.usecase.GetLaunchesUseCase
import com.example.spaceexplorer.data.usecase.RefreshLaunchesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LaunchesViewModel @Inject constructor(
    private val getLaunchesUseCase: GetLaunchesUseCase,
    private val refreshLaunchesUseCase: RefreshLaunchesUseCase
) : ViewModel() {

    private val TAG = "SpaceExplorer"
    private val _uiState = MutableStateFlow<LaunchesUiState>(LaunchesUiState.Loading)
    val uiState: StateFlow<LaunchesUiState> = _uiState

    private val _searchQuery = MutableStateFlow("")
    val searchQuery: StateFlow<String> = _searchQuery

    private val _statusFilter = MutableStateFlow<StatusFilter>(StatusFilter.ALL)
    val statusFilter: StateFlow<StatusFilter> = _statusFilter

    private var allLaunches: List<SpaceLaunch> = emptyList()

    init {
        Log.d(TAG, "[ViewModel] Initializing ViewModel")
        refreshLaunches()
    }

    fun loadLaunches() {
        Log.d(TAG, "[ViewModel] Loading launches from database")
        viewModelScope.launch {
            _uiState.value = LaunchesUiState.Loading
            getLaunchesUseCase()
                .catch { e ->
                    Log.e(TAG, "[ViewModel] Error loading launches", e)
                    _uiState.value = LaunchesUiState.Error(e.message ?: "Unknown error occurred")
                }
                .collect { launches ->
                    Log.d(TAG, "[ViewModel] Received ${launches.size} launches from database")
                    allLaunches = launches
                    filterLaunches()
                }
        }
    }

    fun refreshLaunches() {
        Log.d(TAG, "[ViewModel] Refreshing launches from API")
        viewModelScope.launch {
            try {
                refreshLaunchesUseCase()
                Log.d(TAG, "[ViewModel] Successfully refreshed launches, loading from database")
                loadLaunches()
            } catch (e: Exception) {
                Log.e(TAG, "[ViewModel] Error refreshing launches", e)
                _uiState.value = LaunchesUiState.Error(e.message ?: "Unknown error occurred")
                loadLaunches()
            }
        }
    }

    fun setSearchQuery(query: String) {
        _searchQuery.value = query
        filterLaunches()
    }

    fun setStatusFilter(filter: StatusFilter) {
        Log.d(TAG, "[ViewModel] Setting status filter to: $filter")
        viewModelScope.launch {
            _statusFilter.value = filter
            if (filter == StatusFilter.ALL) {
                Log.d(TAG, "[ViewModel] ALL filter selected, resetting search and showing all launches")
                _searchQuery.value = ""
                _uiState.value = LaunchesUiState.Success(allLaunches)
                Log.d(TAG, "[ViewModel] Showing ${allLaunches.size} launches")
            } else {
                Log.d(TAG, "[ViewModel] Other filter selected, applying filters")
                filterLaunches()
            }
        }
    }

    private fun filterLaunches() {
        val query = _searchQuery.value.trim().lowercase()
        val filter = _statusFilter.value
        Log.d(TAG, "[ViewModel] Filtering launches with query: '$query' and filter: $filter")
        val filtered = allLaunches.filter { launch ->
            val matchesQuery = launch.name.lowercase().contains(query)
            val matchesStatus = when (filter) {
                StatusFilter.ALL -> true
                StatusFilter.SUCCESSFUL -> launch.success == true
                StatusFilter.FAILED -> launch.success == false
                StatusFilter.PENDING -> launch.success == null
            }
            matchesQuery && matchesStatus
        }
        Log.d(TAG, "[ViewModel] Filtered to ${filtered.size} launches")
        _uiState.value = LaunchesUiState.Success(filtered)
    }
}

sealed class LaunchesUiState {
    data object Loading : LaunchesUiState()
    data class Success(val launches: List<SpaceLaunch>) : LaunchesUiState()
    data class Error(val message: String) : LaunchesUiState()
} 

enum class StatusFilter { ALL, SUCCESSFUL, FAILED, PENDING } 
package com.example.spaceexplorer.ui.launches

import ErrorAction
import android.net.http.HttpException
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.spaceexplorer.data.model.Rocket
import com.example.spaceexplorer.data.model.SpaceLaunch
import com.example.spaceexplorer.data.usecase.GetLaunchesUseCase
import com.example.spaceexplorer.data.usecase.RefreshLaunchesUseCase
import com.example.spaceexplorer.data.repository.SpaceXRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import java.net.UnknownHostException
import javax.inject.Inject

@HiltViewModel
class LaunchesViewModel @Inject constructor(
    private val getLaunchesUseCase: GetLaunchesUseCase,
    private val refreshLaunchesUseCase: RefreshLaunchesUseCase,
    private val repository: SpaceXRepository
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
                    val (errorType, title, message, icon) = when (e) {
                        is UnknownHostException -> ErrorInfo(
                            ErrorType.NETWORK_ERROR,
                            "No Internet Connection",
                            "Please check your internet connection and try again",
                            android.R.drawable.ic_menu_help
                        )
                        is HttpException -> ErrorInfo(
                            ErrorType.API_ERROR,
                            "Server Error",
                            "Unable to fetch data from server. Please try again later.",
                            android.R.drawable.ic_dialog_alert
                        )
                        else -> ErrorInfo(
                            ErrorType.UNKNOWN_ERROR,
                            "Something Went Wrong",
                            "An unexpected error occurred. Please try again.",
                            android.R.drawable.ic_dialog_alert
                        )
                    }
                    _uiState.value = LaunchesUiState.Error(
                        title = title,
                        message = message,
                        errorType = errorType,
                        icon = icon,
                        action = ErrorAction(
                            buttonText = "Retry",
                            action = { loadLaunches() }
                        ),
                        retryAction = { loadLaunches() }
                    )
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
                val (errorType, title, message, icon) = when (e) {
                    is UnknownHostException -> ErrorInfo(
                        ErrorType.NETWORK_ERROR,
                        "No Internet Connection",
                        "Please check your internet connection and try again",
                        android.R.drawable.ic_menu_help
                    )
                    is HttpException -> ErrorInfo(
                        ErrorType.API_ERROR,
                        "Server Error",
                        "Unable to fetch data from server. Please try again later.",
                        android.R.drawable.ic_dialog_alert
                    )
                    else -> ErrorInfo(
                        ErrorType.UNKNOWN_ERROR,
                        "Something Went Wrong",
                        "An unexpected error occurred. Please try again.",
                        android.R.drawable.ic_dialog_alert
                    )
                }
                
                _uiState.value = LaunchesUiState.Error(
                    title = title,
                    message = message,
                    errorType = errorType,
                    icon = icon,
                    action = ErrorAction(
                        buttonText = "Retry",
                        action = { refreshLaunches() }
                    ),
                    retryAction = { refreshLaunches() }
                )
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

    suspend fun getRocketById(rocketId: String): Rocket? {
        return repository.getRocketById(rocketId)
    }
}

sealed class LaunchesUiState {
    data object Loading : LaunchesUiState()
    data class Success(val launches: List<SpaceLaunch>) : LaunchesUiState()
    data class Error(val title: String, val message: String, val errorType: ErrorType, val icon: Int, val action: ErrorAction, val retryAction: () -> Unit) : LaunchesUiState()
}

enum class StatusFilter { ALL, SUCCESSFUL, FAILED, PENDING }

enum class ErrorType { NETWORK_ERROR, API_ERROR, UNKNOWN_ERROR }

private data class ErrorInfo(
    val type: ErrorType,
    val title: String,
    val message: String,
    val icon: Int
) 
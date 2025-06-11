import com.example.spaceexplorer.data.model.SpaceLaunch

sealed class LaunchesUiState {
    data object Loading : LaunchesUiState()
    data class Success(val launches: List<SpaceLaunch>) : LaunchesUiState()
    data class Error(
        val title: String,
        val message: String,
        val errorType: ErrorType,
        val icon: Int,
        val action: ErrorAction,
        val retryAction: () -> Unit
    ) : LaunchesUiState()
}

enum class ErrorType {
    NETWORK_ERROR,
    API_ERROR,
    DATABASE_ERROR,
    EMPTY_DATA,
    UNKNOWN_ERROR
}

data class ErrorAction(
    val buttonText: String,
    val action: () -> Unit
) 
package com.example.spaceexplorer.ui.details;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\bH\u0002R\u000e\u0010\u0007\u001a\u00020\bX\u0082D\u00a2\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0013"}, d2 = {"Lcom/example/spaceexplorer/ui/details/LaunchDetailsViewModel;", "Landroidx/lifecycle/ViewModel;", "repository", "Lcom/example/spaceexplorer/data/repository/SpaceXRepository;", "savedStateHandle", "Landroidx/lifecycle/SavedStateHandle;", "(Lcom/example/spaceexplorer/data/repository/SpaceXRepository;Landroidx/lifecycle/SavedStateHandle;)V", "TAG", "", "_uiState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/example/spaceexplorer/ui/details/LaunchDetailsUiState;", "uiState", "Lkotlinx/coroutines/flow/StateFlow;", "getUiState", "()Lkotlinx/coroutines/flow/StateFlow;", "loadLaunchDetails", "", "launchId", "ui_release"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class LaunchDetailsViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.example.spaceexplorer.data.repository.SpaceXRepository repository = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String TAG = "LaunchDetailsViewModel";
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<com.example.spaceexplorer.ui.details.LaunchDetailsUiState> _uiState = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<com.example.spaceexplorer.ui.details.LaunchDetailsUiState> uiState = null;
    
    @javax.inject.Inject()
    public LaunchDetailsViewModel(@org.jetbrains.annotations.NotNull()
    com.example.spaceexplorer.data.repository.SpaceXRepository repository, @org.jetbrains.annotations.NotNull()
    androidx.lifecycle.SavedStateHandle savedStateHandle) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<com.example.spaceexplorer.ui.details.LaunchDetailsUiState> getUiState() {
        return null;
    }
    
    private final void loadLaunchDetails(java.lang.String launchId) {
    }
}
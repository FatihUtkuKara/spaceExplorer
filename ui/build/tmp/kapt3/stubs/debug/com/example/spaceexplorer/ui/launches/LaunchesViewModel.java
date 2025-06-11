package com.example.spaceexplorer.ui.launches;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010\u000e\u001a\u00020\u000fJ\u0006\u0010\u0010\u001a\u00020\u000fR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082D\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lcom/example/spaceexplorer/ui/launches/LaunchesViewModel;", "Landroidx/lifecycle/ViewModel;", "repository", "Lcom/example/spaceexplorer/data/repository/SpaceXRepository;", "(Lcom/example/spaceexplorer/data/repository/SpaceXRepository;)V", "TAG", "", "_uiState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/example/spaceexplorer/ui/launches/LaunchesUiState;", "uiState", "Lkotlinx/coroutines/flow/StateFlow;", "getUiState", "()Lkotlinx/coroutines/flow/StateFlow;", "loadLaunches", "", "refreshLaunches", "ui_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class LaunchesViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.example.spaceexplorer.data.repository.SpaceXRepository repository = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String TAG = "SpaceExplorer";
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<com.example.spaceexplorer.ui.launches.LaunchesUiState> _uiState = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<com.example.spaceexplorer.ui.launches.LaunchesUiState> uiState = null;
    
    @javax.inject.Inject()
    public LaunchesViewModel(@org.jetbrains.annotations.NotNull()
    com.example.spaceexplorer.data.repository.SpaceXRepository repository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<com.example.spaceexplorer.ui.launches.LaunchesUiState> getUiState() {
        return null;
    }
    
    public final void loadLaunches() {
    }
    
    public final void refreshLaunches() {
    }
}
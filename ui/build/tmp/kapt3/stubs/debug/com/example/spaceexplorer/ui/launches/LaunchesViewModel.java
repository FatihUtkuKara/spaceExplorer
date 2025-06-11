package com.example.spaceexplorer.ui.launches;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\b\u0010\u001a\u001a\u00020\u001bH\u0002J\u0006\u0010\u001c\u001a\u00020\u001bJ\u0006\u0010\u001d\u001a\u00020\u001bJ\u000e\u0010\u001e\u001a\u00020\u001b2\u0006\u0010\u001f\u001a\u00020\bJ\u000e\u0010 \u001a\u00020\u001b2\u0006\u0010!\u001a\u00020\fR\u000e\u0010\u0007\u001a\u00020\bX\u0082D\u00a2\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\b0\u0013\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\f0\u0013\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0015R\u0017\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0013\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0015\u00a8\u0006\""}, d2 = {"Lcom/example/spaceexplorer/ui/launches/LaunchesViewModel;", "Landroidx/lifecycle/ViewModel;", "getLaunchesUseCase", "Lcom/example/spaceexplorer/data/usecase/GetLaunchesUseCase;", "refreshLaunchesUseCase", "Lcom/example/spaceexplorer/data/usecase/RefreshLaunchesUseCase;", "(Lcom/example/spaceexplorer/data/usecase/GetLaunchesUseCase;Lcom/example/spaceexplorer/data/usecase/RefreshLaunchesUseCase;)V", "TAG", "", "_searchQuery", "Lkotlinx/coroutines/flow/MutableStateFlow;", "_statusFilter", "Lcom/example/spaceexplorer/ui/launches/StatusFilter;", "_uiState", "Lcom/example/spaceexplorer/ui/launches/LaunchesUiState;", "allLaunches", "", "Lcom/example/spaceexplorer/data/model/SpaceLaunch;", "searchQuery", "Lkotlinx/coroutines/flow/StateFlow;", "getSearchQuery", "()Lkotlinx/coroutines/flow/StateFlow;", "statusFilter", "getStatusFilter", "uiState", "getUiState", "filterLaunches", "", "loadLaunches", "refreshLaunches", "setSearchQuery", "query", "setStatusFilter", "filter", "ui_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class LaunchesViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.example.spaceexplorer.data.usecase.GetLaunchesUseCase getLaunchesUseCase = null;
    @org.jetbrains.annotations.NotNull()
    private final com.example.spaceexplorer.data.usecase.RefreshLaunchesUseCase refreshLaunchesUseCase = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String TAG = "SpaceExplorer";
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<com.example.spaceexplorer.ui.launches.LaunchesUiState> _uiState = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<com.example.spaceexplorer.ui.launches.LaunchesUiState> uiState = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.String> _searchQuery = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.lang.String> searchQuery = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<com.example.spaceexplorer.ui.launches.StatusFilter> _statusFilter = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<com.example.spaceexplorer.ui.launches.StatusFilter> statusFilter = null;
    @org.jetbrains.annotations.NotNull()
    private java.util.List<com.example.spaceexplorer.data.model.SpaceLaunch> allLaunches;
    
    @javax.inject.Inject()
    public LaunchesViewModel(@org.jetbrains.annotations.NotNull()
    com.example.spaceexplorer.data.usecase.GetLaunchesUseCase getLaunchesUseCase, @org.jetbrains.annotations.NotNull()
    com.example.spaceexplorer.data.usecase.RefreshLaunchesUseCase refreshLaunchesUseCase) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<com.example.spaceexplorer.ui.launches.LaunchesUiState> getUiState() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.lang.String> getSearchQuery() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<com.example.spaceexplorer.ui.launches.StatusFilter> getStatusFilter() {
        return null;
    }
    
    public final void loadLaunches() {
    }
    
    public final void refreshLaunches() {
    }
    
    public final void setSearchQuery(@org.jetbrains.annotations.NotNull()
    java.lang.String query) {
    }
    
    public final void setStatusFilter(@org.jetbrains.annotations.NotNull()
    com.example.spaceexplorer.ui.launches.StatusFilter filter) {
    }
    
    private final void filterLaunches() {
    }
}
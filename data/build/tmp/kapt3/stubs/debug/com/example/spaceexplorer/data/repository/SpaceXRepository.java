package com.example.spaceexplorer.data.repository;

@javax.inject.Singleton()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u001f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u0012\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\fJ\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0010\u001a\u00020\nH\u0086@\u00a2\u0006\u0002\u0010\u0011J\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\nH\u0086@\u00a2\u0006\u0002\u0010\u0011J\u000e\u0010\u0015\u001a\u00020\u0016H\u0086@\u00a2\u0006\u0002\u0010\u0017R\u000e\u0010\t\u001a\u00020\nX\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0018"}, d2 = {"Lcom/example/spaceexplorer/data/repository/SpaceXRepository;", "", "apiService", "Lcom/example/spaceexplorer/data/api/SpaceXApiService;", "launchDao", "Lcom/example/spaceexplorer/data/local/LaunchDao;", "rocketDao", "Lcom/example/spaceexplorer/data/local/RocketDao;", "(Lcom/example/spaceexplorer/data/api/SpaceXApiService;Lcom/example/spaceexplorer/data/local/LaunchDao;Lcom/example/spaceexplorer/data/local/RocketDao;)V", "TAG", "", "getAllLaunches", "Lkotlinx/coroutines/flow/Flow;", "", "Lcom/example/spaceexplorer/data/model/SpaceLaunch;", "getLaunchById", "launchId", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getRocketById", "Lcom/example/spaceexplorer/data/model/Rocket;", "rocketId", "refreshLaunches", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "data_debug"})
public final class SpaceXRepository {
    @org.jetbrains.annotations.NotNull()
    private final com.example.spaceexplorer.data.api.SpaceXApiService apiService = null;
    @org.jetbrains.annotations.NotNull()
    private final com.example.spaceexplorer.data.local.LaunchDao launchDao = null;
    @org.jetbrains.annotations.NotNull()
    private final com.example.spaceexplorer.data.local.RocketDao rocketDao = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String TAG = "SpaceXRepository";
    
    @javax.inject.Inject()
    public SpaceXRepository(@org.jetbrains.annotations.NotNull()
    com.example.spaceexplorer.data.api.SpaceXApiService apiService, @org.jetbrains.annotations.NotNull()
    com.example.spaceexplorer.data.local.LaunchDao launchDao, @org.jetbrains.annotations.NotNull()
    com.example.spaceexplorer.data.local.RocketDao rocketDao) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.example.spaceexplorer.data.model.SpaceLaunch>> getAllLaunches() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object refreshLaunches(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getLaunchById(@org.jetbrains.annotations.NotNull()
    java.lang.String launchId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.example.spaceexplorer.data.model.SpaceLaunch> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getRocketById(@org.jetbrains.annotations.NotNull()
    java.lang.String rocketId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.example.spaceexplorer.data.model.Rocket> $completion) {
        return null;
    }
}
package com.example.spaceexplorer.data.local;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\bg\u0018\u00002\u00020\u0001J\u000e\u0010\u0002\u001a\u00020\u0003H\u00a7@\u00a2\u0006\u0002\u0010\u0004J\u0014\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006H\'J\u0018\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\n\u001a\u00020\u000bH\u00a7@\u00a2\u0006\u0002\u0010\fJ\u001c\u0010\r\u001a\u00020\u00032\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u00a7@\u00a2\u0006\u0002\u0010\u000f\u00a8\u0006\u0010"}, d2 = {"Lcom/example/spaceexplorer/data/local/LaunchDao;", "", "deleteAllLaunches", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllLaunches", "Lkotlinx/coroutines/flow/Flow;", "", "Lcom/example/spaceexplorer/data/model/SpaceLaunch;", "getLaunchById", "launchId", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertLaunches", "launches", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "data_debug"})
@androidx.room.Dao()
public abstract interface LaunchDao {
    
    @androidx.room.Query(value = "SELECT * FROM launches ORDER BY dateUtc DESC")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.example.spaceexplorer.data.model.SpaceLaunch>> getAllLaunches();
    
    @androidx.room.Query(value = "SELECT * FROM launches WHERE id = :launchId")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getLaunchById(@org.jetbrains.annotations.NotNull()
    java.lang.String launchId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.example.spaceexplorer.data.model.SpaceLaunch> $completion);
    
    @androidx.room.Insert(onConflict = 1)
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object insertLaunches(@org.jetbrains.annotations.NotNull()
    java.util.List<com.example.spaceexplorer.data.model.SpaceLaunch> launches, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "DELETE FROM launches")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object deleteAllLaunches(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
}
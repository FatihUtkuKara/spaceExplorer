package com.example.spaceexplorer.data.local;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\bg\u0018\u00002\u00020\u0001J\u000e\u0010\u0002\u001a\u00020\u0003H\u00a7@\u00a2\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\bH\u00a7@\u00a2\u0006\u0002\u0010\tJ\u0016\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u0006H\u00a7@\u00a2\u0006\u0002\u0010\f\u00a8\u0006\r"}, d2 = {"Lcom/example/spaceexplorer/data/local/RocketDao;", "", "deleteAllRockets", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getRocketById", "Lcom/example/spaceexplorer/data/model/Rocket;", "rocketId", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertRocket", "rocket", "(Lcom/example/spaceexplorer/data/model/Rocket;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "data_debug"})
@androidx.room.Dao()
public abstract interface RocketDao {
    
    @androidx.room.Query(value = "SELECT * FROM rockets WHERE id = :rocketId")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getRocketById(@org.jetbrains.annotations.NotNull()
    java.lang.String rocketId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.example.spaceexplorer.data.model.Rocket> $completion);
    
    @androidx.room.Insert(onConflict = 1)
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object insertRocket(@org.jetbrains.annotations.NotNull()
    com.example.spaceexplorer.data.model.Rocket rocket, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "DELETE FROM rockets")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object deleteAllRockets(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
}
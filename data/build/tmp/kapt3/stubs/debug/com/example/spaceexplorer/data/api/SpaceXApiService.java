package com.example.spaceexplorer.data.api;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u00a7@\u00a2\u0006\u0002\u0010\u0005J\u0018\u0010\u0006\u001a\u00020\u00072\b\b\u0001\u0010\b\u001a\u00020\tH\u00a7@\u00a2\u0006\u0002\u0010\n\u00a8\u0006\u000b"}, d2 = {"Lcom/example/spaceexplorer/data/api/SpaceXApiService;", "", "getLaunches", "", "Lcom/example/spaceexplorer/data/model/SpaceLaunch;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getRocket", "Lcom/example/spaceexplorer/data/model/Rocket;", "rocketId", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "data_debug"})
public abstract interface SpaceXApiService {
    
    @retrofit2.http.GET(value = "launches")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getLaunches(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.example.spaceexplorer.data.model.SpaceLaunch>> $completion);
    
    @retrofit2.http.GET(value = "rockets/{id}")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getRocket(@retrofit2.http.Path(value = "id")
    @org.jetbrains.annotations.NotNull()
    java.lang.String rocketId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.example.spaceexplorer.data.model.Rocket> $completion);
}
package com.example.spaceexplorer.data.local;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\'\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&J\b\u0010\u0005\u001a\u00020\u0006H&\u00a8\u0006\u0007"}, d2 = {"Lcom/example/spaceexplorer/data/local/SpaceExplorerDatabase;", "Landroidx/room/RoomDatabase;", "()V", "launchDao", "Lcom/example/spaceexplorer/data/local/LaunchDao;", "rocketDao", "Lcom/example/spaceexplorer/data/local/RocketDao;", "data_debug"})
@androidx.room.Database(entities = {com.example.spaceexplorer.data.model.SpaceLaunch.class, com.example.spaceexplorer.data.model.Rocket.class}, version = 3, exportSchema = false)
@androidx.room.TypeConverters(value = {com.example.spaceexplorer.data.local.Converters.class})
public abstract class SpaceExplorerDatabase extends androidx.room.RoomDatabase {
    
    public SpaceExplorerDatabase() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.example.spaceexplorer.data.local.LaunchDao launchDao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.example.spaceexplorer.data.local.RocketDao rocketDao();
}
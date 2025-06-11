package com.example.spaceexplorer.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

import com.example.spaceexplorer.data.model.Rocket
import com.example.spaceexplorer.data.model.SpaceLaunch

@Database(
    entities = [SpaceLaunch::class, Rocket::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(Converters::class)
abstract class SpaceExplorerDatabase : RoomDatabase() {
    abstract fun launchDao(): LaunchDao
    abstract fun rocketDao(): RocketDao
} 
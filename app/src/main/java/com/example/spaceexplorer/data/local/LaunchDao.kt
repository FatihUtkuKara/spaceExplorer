package com.example.spaceexplorer.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.spaceexplorer.data.model.SpaceLaunch
import kotlinx.coroutines.flow.Flow

@Dao
interface LaunchDao {
    @Query("SELECT * FROM launches ORDER BY dateUtc DESC")
    fun getAllLaunches(): Flow<List<SpaceLaunch>>

    @Query("SELECT * FROM launches WHERE id = :launchId")
    suspend fun getLaunchById(launchId: String): SpaceLaunch?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertLaunches(launches: List<SpaceLaunch>)

    @Query("DELETE FROM launches")
    suspend fun deleteAllLaunches()
} 
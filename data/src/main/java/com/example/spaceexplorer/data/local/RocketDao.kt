package com.example.spaceexplorer.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.spaceexplorer.data.model.Rocket
import kotlinx.coroutines.flow.Flow

@Dao
interface RocketDao {
    @Query("SELECT * FROM rockets WHERE id = :rocketId")
    suspend fun getRocketById(rocketId: String): Rocket?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertRocket(rocket: Rocket)

    @Query("DELETE FROM rockets")
    suspend fun deleteAllRockets()
} 
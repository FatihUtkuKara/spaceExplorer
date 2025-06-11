package com.example.spaceexplorer.data.repository

import android.util.Log
import com.example.spaceexplorer.data.api.SpaceXApiService
import com.example.spaceexplorer.data.local.LaunchDao
import com.example.spaceexplorer.data.local.RocketDao
import com.example.spaceexplorer.data.model.SpaceLaunch
import com.example.spaceexplorer.data.model.Rocket
import kotlinx.coroutines.flow.Flow
import java.net.UnknownHostException
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SpaceXRepository @Inject constructor(
    private val apiService: SpaceXApiService,
    private val launchDao: LaunchDao,
    private val rocketDao: RocketDao
) {
    private val TAG = "SpaceExplorer"

    fun getAllLaunches(): Flow<List<SpaceLaunch>> {
        Log.d(TAG, "[Repository] Getting all launches from database")
        return launchDao.getAllLaunches()
    }

    suspend fun refreshLaunches() {
        try {
            Log.d(TAG, "[Repository] Starting to refresh launches from API")
            val launches = apiService.getLaunches()
            Log.d(TAG, "[Repository] Received ${launches.size} launches from API")
            
            Log.d(TAG, "[Repository] Deleting all existing launches from database")
            launchDao.deleteAllLaunches()
            
            Log.d(TAG, "[Repository] Inserting new launches into database")
            launchDao.insertLaunches(launches)
            Log.d(TAG, "[Repository] Successfully refreshed launches")
        } catch (e: Exception) {
            Log.e(TAG, "[Repository] Error refreshing launches", e)
            when (e) {
                is UnknownHostException -> throw Exception("Please check your internet connection")
                else -> throw Exception("An error occurred while loading data: ${e.message}")
            }
        }
    }

    suspend fun getLaunchById(launchId: String): SpaceLaunch? {
        Log.d(TAG, "[Repository] Getting launch by ID: $launchId")
        return launchDao.getLaunchById(launchId)
    }

    suspend fun getRocketById(rocketId: String): Rocket? {
        Log.d(TAG, "[Repository] Getting rocket by ID: $rocketId")
        var rocket = rocketDao.getRocketById(rocketId)
        if (rocket == null) {
            try {
                Log.d(TAG, "[Repository] Rocket not found in database, fetching from API")
                rocket = apiService.getRocket(rocketId)
                Log.d(TAG, "[Repository] Received rocket from API: ${rocket.name}")
                rocketDao.insertRocket(rocket)
                Log.d(TAG, "[Repository] Inserted rocket into database")
            } catch (e: Exception) {
                Log.e(TAG, "[Repository] Error fetching rocket from API", e)
                when (e) {
                    is UnknownHostException -> throw Exception("Please check your internet connection")
                    else -> throw Exception("An error occurred while loading rocket information: ${e.message}")
                }
            }
        } else {
            Log.d(TAG, "[Repository] Found rocket in database: ${rocket.name}")
        }
        return rocket
    }
} 
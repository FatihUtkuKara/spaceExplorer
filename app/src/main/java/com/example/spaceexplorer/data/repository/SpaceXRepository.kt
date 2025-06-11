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
    private val TAG = "SpaceXRepository"

    fun getAllLaunches(): Flow<List<SpaceLaunch>> {
        Log.e(TAG, "Getting all launches from database")
        return launchDao.getAllLaunches()
    }

    suspend fun refreshLaunches() {
        try {
            Log.e(TAG, "Starting to refresh launches from API")
            val launches = apiService.getLaunches()
            Log.e(TAG, "Received ${launches.size} launches from API")
            
            Log.e(TAG, "Deleting all existing launches from database")
            launchDao.deleteAllLaunches()
            
            Log.e(TAG, "Inserting new launches into database")
            launchDao.insertLaunches(launches)
            Log.e(TAG, "Successfully refreshed launches")
        } catch (e: Exception) {
            Log.e(TAG, "Error refreshing launches", e)
            when (e) {
                is UnknownHostException -> throw Exception("Please check your internet connection")
                else -> throw Exception("An error occurred while loading data: ${e.message}")
            }
        }
    }

    suspend fun getLaunchById(launchId: String): SpaceLaunch? {
        Log.e(TAG, "Getting launch by ID: $launchId")
        val launch = launchDao.getLaunchById(launchId)
        Log.e(TAG, "Launch from database: $launch")
        return launch
    }

    suspend fun getRocketById(rocketId: String): Rocket? {
        Log.e(TAG, "Getting rocket by ID: $rocketId")
        var rocket = rocketDao.getRocketById(rocketId)
        Log.e(TAG, "Rocket from database: $rocket")
        
        if (rocket == null) {
            try {
                Log.e(TAG, "Rocket not found in database, fetching from API")
                rocket = apiService.getRocket(rocketId)
                Log.e(TAG, "Received rocket from API: $rocket")
                rocketDao.insertRocket(rocket)
                Log.e(TAG, "Inserted rocket into database")
            } catch (e: Exception) {
                Log.e(TAG, "Error fetching rocket from API", e)
                when (e) {
                    is UnknownHostException -> throw Exception("Please check your internet connection")
                    else -> throw Exception("An error occurred while loading rocket information: ${e.message}")
                }
            }
        } else {
            Log.e(TAG, "Found rocket in database: $rocket")
        }
        return rocket
    }
} 
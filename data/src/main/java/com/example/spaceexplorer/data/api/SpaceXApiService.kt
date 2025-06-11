package com.example.spaceexplorer.data.api

import com.example.spaceexplorer.data.model.SpaceLaunch
import com.example.spaceexplorer.data.model.Rocket
import retrofit2.http.GET
import retrofit2.http.Path

interface SpaceXApiService {
    @GET("launches")
    suspend fun getLaunches(): List<SpaceLaunch>

    @GET("rockets/{id}")
    suspend fun getRocket(@Path("id") rocketId: String): Rocket
} 
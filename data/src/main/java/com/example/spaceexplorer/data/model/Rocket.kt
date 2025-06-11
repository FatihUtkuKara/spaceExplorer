package com.example.spaceexplorer.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "rockets")
data class Rocket(
    @PrimaryKey
    val id: String,
    val name: String,
    val description: String,
    val active: Boolean,
    val company: String,
    val costPerLaunch: Long,
    val successRatePct: Int,
    val firstFlight: String?,
    val country: String,
    val wikipedia: String?
) 
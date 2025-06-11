package com.example.spaceexplorer.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import java.util.Date

@Entity(tableName = "launches")
data class SpaceLaunch(
    @PrimaryKey
    val id: String,
    val name: String,
    @SerializedName("date_utc")
    val dateUtc: Date,
    @SerializedName("rocket")
    val rocketId: String,
    val success: Boolean?,
    val details: String?,
    @SerializedName("links")
    val links: Links?
)

data class Links(
    val webcast: String?,
    val article: String?,
    val wikipedia: String?
) 
package com.example.spaceexplorer.data.local

import androidx.room.TypeConverter
import com.example.spaceexplorer.data.model.Links
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.util.Date

class Converters {
    private val gson = Gson()

    @TypeConverter
    fun fromTimestamp(value: Long?): Date? {
        return value?.let { Date(it) }
    }

    @TypeConverter
    fun dateToTimestamp(date: Date?): Long? {
        return date?.time
    }

    @TypeConverter
    fun fromLinks(links: Links?): String? {
        return links?.let { gson.toJson(it) }
    }

    @TypeConverter
    fun toLinks(linksString: String?): Links? {
        if (linksString == null) return null
        val type = object : TypeToken<Links>() {}.type
        return gson.fromJson(linksString, type)
    }
} 
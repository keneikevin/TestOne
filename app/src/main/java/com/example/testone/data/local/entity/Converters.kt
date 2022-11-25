package com.example.testone.data.local.entity
import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.example.testone.data.remote.response.Thumbnail
import com.example.testone.util.JsonParser
import com.google.gson.reflect.TypeToken

@ProvidedTypeConverter
class Converters(
    private val jsonParser: JsonParser
) {
    @TypeConverter
    fun fromMeaningsJson(json: String): List<Thumbnail> {
        return jsonParser.fromJson<ArrayList<Thumbnail>>(
            json,
            object : TypeToken<ArrayList<Thumbnail>>(){}.type
        ) ?: emptyList()
    }

    @TypeConverter
    fun toMeaningsJson(meanings: List<Thumbnail>): String {
        return jsonParser.toJson(
            meanings,
            object : TypeToken<ArrayList<Thumbnail>>(){}.type
        ) ?: "[]"
    }
}
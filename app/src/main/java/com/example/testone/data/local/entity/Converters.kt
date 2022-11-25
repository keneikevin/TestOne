package com.example.testone.data.local.entity
import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.example.testone.data.remote.response.ThumbnailDto
import com.example.testone.util.JsonParser
import com.google.gson.reflect.TypeToken

@ProvidedTypeConverter
class Converters(
    private val jsonParser: JsonParser
) {
    @TypeConverter
    fun fromMThumbnailDtoJson(json: String): Thumbnaill{
        return jsonParser.fromJson<Thumbnaill>(
            json,
            object : TypeToken<Thumbnaill>(){}.type
        ) ?: Thumbnaill("","")
    }

    @TypeConverter
    fun toThumbnailDtoJson(thumbnaill: Thumbnaill?): String {
        return jsonParser.toJson(
            thumbnaill,
            object : TypeToken<Thumbnaill>(){}.type
        ) ?: ""
    }
}
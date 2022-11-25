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
    fun fromMThumbnailDtoJson(json: String): ThumbnailDto{
        return jsonParser.fromJson<ThumbnailDto>(
            json,
            object : TypeToken<ThumbnailDto>(){}.type
        ) ?: ThumbnailDto("","")
    }

    @TypeConverter
    fun toThumbnailDtoJson(meanings: ThumbnailDto): String {
        return jsonParser.toJson(
            meanings,
            object : TypeToken<ThumbnailDto>(){}.type
        ) ?: ""
    }
}
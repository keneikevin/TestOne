package com.example.testone.data.remote.response

import com.example.testone.data.local.entity.Thumbnaill
import com.example.testone.data.local.entity.WordInfoEntity

data class ThumbnailDto(
    val extension: String,
    val path: String
){
    fun toThumbnail(): Thumbnaill {
        return Thumbnaill(
           extension, path
        )
    }
}
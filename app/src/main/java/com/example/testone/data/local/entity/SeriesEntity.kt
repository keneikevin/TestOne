package com.example.testone.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.testone.domain.mappers.CharacterInfo
import kotlinx.android.parcel.RawValue

@Entity(tableName = "seriesentity")
class SeriesEntity (
    val title:String,
    val description:String?,
    @PrimaryKey val id:Int? =null
){
    fun toWordInfo(): CharacterInfo{
        return CharacterInfo(
            title, description =description
        )
    }
}

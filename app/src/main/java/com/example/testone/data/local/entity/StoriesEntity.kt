package com.example.testone.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.testone.domain.mappers.CharacterInfo
import kotlinx.android.parcel.RawValue


@Entity(tableName = "storiesentity")
data class StoriesEntity (
    val title:String,
    val description:String?,
    val thumbnaill: Thumbnaill?=null,
    @PrimaryKey val id:Int? =null
){
    fun toWordInfo(): CharacterInfo{
        return CharacterInfo(
            title, description =description,thumbnaill=thumbnaill
        )
    }
}
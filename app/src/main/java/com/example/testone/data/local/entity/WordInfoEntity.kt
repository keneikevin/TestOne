package com.example.testone.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.testone.domain.mappers.CharacterInfo

@Entity(tableName = "wordinfoentity")
class WordInfoEntity (
    val title:String,
    val description:String,
    val thumbnaill: Thumbnaill?=null,
   @PrimaryKey val id:Int? =null
    ){
    fun toWordInfo(): CharacterInfo{
        return CharacterInfo(
            title, description,thumbnaill
        )
    }
}


package com.example.testone.data.local


import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.testone.data.local.entity.SeriesEntity
import com.example.testone.data.local.entity.StoriesEntity
import com.example.testone.data.local.entity.WordInfoEntity

@Database(
    entities = [WordInfoEntity::class,SeriesEntity::class,StoriesEntity::class,],
    version = 4
)
//@TypeConverters(Converters::class)
abstract class CharacterInfoDatabase: RoomDatabase() {

    abstract fun dao(): CharacterInfoDao
}
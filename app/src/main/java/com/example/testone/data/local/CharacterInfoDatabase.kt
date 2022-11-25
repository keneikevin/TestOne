package com.example.testone.data.local


import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.testone.data.local.entity.Converters
import com.example.testone.data.local.entity.SeriesEntity
import com.example.testone.data.local.entity.StoriesEntity
import com.example.testone.data.local.entity.WordInfoEntity

@Database(
    entities = [WordInfoEntity::class,SeriesEntity::class,StoriesEntity::class,],
    version = 7
)
@TypeConverters(Converters::class)
abstract class CharacterInfoDatabase: RoomDatabase() {

    abstract fun dao(): CharacterInfoDao
}
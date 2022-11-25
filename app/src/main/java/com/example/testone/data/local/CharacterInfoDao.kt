package com.example.testone.data.local
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.testone.data.local.entity.SeriesEntity
import com.example.testone.data.local.entity.StoriesEntity
import com.example.testone.data.local.entity.WordInfoEntity

@Dao
interface CharacterInfoDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveCharacters(list: List<WordInfoEntity>)

    @Query("SELECT * FROM wordinfoentity")
    suspend fun getCharacters(): List<WordInfoEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveSeries(list: List<SeriesEntity>)

    @Query("SELECT * FROM seriesentity")
    suspend fun getSeries(): List<SeriesEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveStories(list: List<StoriesEntity>)

    @Query("SELECT * FROM storiesentity")
    suspend fun getStories(): List<StoriesEntity>
}
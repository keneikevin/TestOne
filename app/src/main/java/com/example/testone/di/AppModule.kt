package com.example.testone.di


import android.content.Context
import androidx.room.Room
import com.example.testone.data.MarvelApi
import com.example.testone.data.local.CharacterInfoDatabase
import com.example.testone.domain.WordInfoRepository
import com.example.testone.domain.WordInfoRepositoryImpl
import com.example.testone.util.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providePezeshaApi(): MarvelApi {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(MarvelApi::class.java)
    }

    @Singleton
    @Provides
    fun provideWordInfoDatabase(
        @ApplicationContext context: Context
    )= Room.databaseBuilder(context, CharacterInfoDatabase::class.java, "word_db")
        .fallbackToDestructiveMigration()
        .build()

    @Singleton
    @Provides
    fun provideWordDao(
        database:CharacterInfoDatabase
    ) = database.dao()

    @Provides
    @Singleton
    fun provideWordInfoRepository(
        db: CharacterInfoDatabase,
        api: MarvelApi
    ): WordInfoRepository {
        return WordInfoRepositoryImpl(api,db.dao())
    }



}
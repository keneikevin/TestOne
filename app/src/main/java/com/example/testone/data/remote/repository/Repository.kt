package com.example.testone.domain

import com.example.testone.data.MarvelApi
import com.example.testone.data.local.CharacterInfoDao
import com.example.testone.domain.mappers.CharacterInfo
import javax.inject.Inject

class WordInfoRepositoryImpl @Inject constructor(
    private val api: MarvelApi,
    private val dao: CharacterInfoDao
) : WordInfoRepository{

    override suspend fun getAllCharacters(): List<CharacterInfo> {
        val characters = dao.getCharacters()

        if (characters.size > 1) {
            return characters.map { it.toWordInfo() }
        } else {
            val characters = api.getComics(
                apikey = "4fac92aa42cc19d34c1d12a52c89ae65",
                hash = "6449ebca941eb3cf8aedf4c378e1be9e",
                ts = "2"
            )
            dao.saveCharacters(characters.data.results.map { it.toWordInfoEntity() })
            return characters.data.results.map { it.toWordInfoEntity().toWordInfo() }
        }
    }

    override suspend fun getSeriesCharacters(): List<CharacterInfo> {
        val characters = dao.getSeries()

        if (characters.size > 1) {
            return characters.map { it.toWordInfo() }
        } else {
            val characters = api.getSeries(
                apikey = "4fac92aa42cc19d34c1d12a52c89ae65",
                hash = "6449ebca941eb3cf8aedf4c378e1be9e",
                ts = "2"
            )
            dao.saveSeries(characters.data.results.map { it.toSeriesEntity() })
            return characters.data.results.map { it.toSeriesEntity().toWordInfo() }
        }
    }

    override suspend fun getStoriesCharacters(): List<CharacterInfo> {
        val characters = dao.getStories()

        if (characters.size > 1) {
            return characters.map { it.toWordInfo() }
        } else {
            val characters = api.getStories(
                apikey = "4fac92aa42cc19d34c1d12a52c89ae65",
                hash = "6449ebca941eb3cf8aedf4c378e1be9e",
                ts = "2"
            )
            dao.saveStories(characters.data.results.map { it.toStoriesEntity() })
            return characters.data.results.map { it.toStoriesEntity().toWordInfo() }
        }
    }




}
package com.example.testone.domain


import com.example.testone.data.remote.response.ComicsResponse
import com.example.testone.domain.mappers.CharacterInfo
import com.example.testone.util.Resource

interface WordInfoRepository {
    suspend fun getAllCharacters(): List<CharacterInfo>
    suspend fun getSeriesCharacters(): List<CharacterInfo>
    suspend fun getStoriesCharacters(): List<CharacterInfo>
}
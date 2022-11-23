package com.example.testone.domain

import android.util.Log
import com.example.testone.data.MarvelApi
import com.example.testone.data.remote.response.CharacterDetail.CharacterDetailResponse
import com.example.testone.data.remote.response.comics.ComicsResponse
import com.example.testone.util.Resource
import retrofit2.HttpException
import javax.inject.Inject

class HomeRepository @Inject constructor(
    private val marvelApi: MarvelApi
) {
    suspend fun getComics(): Resource<ComicsResponse>{
        return try {

            val response= marvelApi.getComics(
                apikey = "4fac92aa42cc19d34c1d12a52c89ae65",
                hash = "6449ebca941eb3cf8aedf4c378e1be9e",
                ts = "2"
            )
            Log.d("PayHistory","${response.data.results.forEach { it.description }}")
            Resource.success(response)

        } catch (e: Exception){
            return if (e is HttpException) {
                Log.d("ERRROR",e.response().toString())
                Resource.error(e.message(), null)
            } else {
                Resource.error(
                    "Couldn't connect to the servers. Check your internet connection, $e",
                    null
                )
            }
        }
    }
    suspend fun getComicDetails(comicId:String): Resource<CharacterDetailResponse>{
        return try {
            val response= marvelApi.getComicDetails(
                comicId = 82967,
                apikey = "4fac92aa42cc19d34c1d12a52c89ae65",
                hash = "6449ebca941eb3cf8aedf4c378e1be9e",
                ts = "2"
            )
            Log.d("PayHistoryy","${response}")
            Resource.success(response)

        } catch (e: Exception){
            return if (e is HttpException) {
                Log.d("ERRRORR",e.response().toString())
                Resource.error(e.message(), null)

            } else {
                Resource.error(
                    "Couldn't connect to the servers. Check your internet connection, $e",
                    null
                )
            }
        }
    }
    suspend fun getSeries(): Resource<ComicsResponse>{
        return try {

            val response= marvelApi.getSeries(
                apikey = "4fac92aa42cc19d34c1d12a52c89ae65",
                hash = "6449ebca941eb3cf8aedf4c378e1be9e",
                ts = "2"
            )
            Log.d("PayHistory","${response}")
            Resource.success(response)

        } catch (e: Exception){
            return if (e is HttpException) {
                Log.d("ERRROR",e.response().toString())
                Resource.error(e.message(), null)

            } else {
                Resource.error(
                    "Couldn't connect to the servers. Check your internet connection, $e",
                    null
                )
            }
        }
    }
    suspend fun getStories(): Resource<ComicsResponse>{
        return try {

            val response= marvelApi.getStories(
                apikey = "4fac92aa42cc19d34c1d12a52c89ae65",
                hash = "6449ebca941eb3cf8aedf4c378e1be9e",
                ts = "2"
            )
            Log.d("PayHistory","${response}")
            Resource.success(response)

        } catch (e: Exception){
            return if (e is HttpException) {
                Log.d("ERRROR",e.response().toString())
                Resource.error(e.message(), null)

            } else {
                Resource.error(
                    "Couldn't connect to the servers. Check your internet connection, $e",
                    null
                )
            }
        }
    }
}
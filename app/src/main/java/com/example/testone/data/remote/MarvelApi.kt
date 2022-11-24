package com.example.testone.data

import com.example.testone.data.remote.response.CharacterDetail.CharacterDetailResponse
import com.example.testone.data.remote.response.comics.ComicsResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MarvelApi {

    // List all comics from api
    @GET("v1/public/comics")
    suspend fun getComics(
        @Query("apikey") apikey:String,
        @Query("ts") ts:String,
        @Query("hash") hash:String
    ): ComicsResponse

    // List all comics from api
    @GET("/v1/public/comics/{comicId}")
    suspend fun getComicDetails(
        @Path("comicId") comicId:Int,
        @Query("apikey") apikey:String,
        @Query("ts") ts:String,
        @Query("hash") hash:String
    ): CharacterDetailResponse

    // List all comics from api
    @GET("v1/public/series")
    suspend fun getSeries(
        @Query("apikey") apikey:String,
        @Query("ts") ts:String,
        @Query("hash") hash:String
    ): ComicsResponse

    // List all comics from api
    @GET("v1/public/stories")
    suspend fun getStories(
        @Query("apikey") apikey:String,
        @Query("ts") ts:String,
        @Query("hash") hash:String
    ): ComicsResponse

}
package com.example.testone.data.remote.response.CharacterDetail

data class CharacterDetailResponse(
    val attributionHTML: String,
    val attributionText: String,
    val code: Int,
    val copyright: String,
    val `data`: DataDetail,
    val etag: String,
    val status: String
)
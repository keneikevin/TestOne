package com.example.testone.data.remote.response.CharacterDetail

data class DataDetail(
    val count: Int,
    val limit: Int,
    val offset: Int,
    val results: List<ResultDetail>,
    val total: Int
)
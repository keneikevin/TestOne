package com.example.testone.data.remote.response

data class Data(
    val count: Int,
    val limit: Int,
    val offset: Int,
    val results: List<WordInfoDto>,
    val total: Int
)
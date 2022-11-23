package com.example.testone.data.remote.response.CharacterDetail

data class Events(
    val available: Int,
    val collectionURI: String,
    val items: List<Any>,
    val returned: Int
)
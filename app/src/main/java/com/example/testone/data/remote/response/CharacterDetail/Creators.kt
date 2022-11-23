package com.example.testone.data.remote.response.CharacterDetail

data class Creators(
    val available: Int,
    val collectionURI: String,
    val items: List<Item>,
    val returned: Int
)
package com.example.testone.data.remote.response.CharacterDetail

data class Stories(
    val available: Int,
    val collectionURI: String,
    val items: List<ItemX>,
    val returned: Int
)
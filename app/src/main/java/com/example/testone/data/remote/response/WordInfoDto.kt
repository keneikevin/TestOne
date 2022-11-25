package com.example.testone.data.remote.response

import com.example.testone.data.local.entity.SeriesEntity
import com.example.testone.data.local.entity.StoriesEntity
import com.example.testone.data.local.entity.WordInfoEntity
import com.google.gson.annotations.SerializedName

data class WordInfoDto(
    val characters: Characters,
    val collectedIssues: List<CollectedIssue>,
    val collections: List<Any>,
    val creators: Creators,
    val dates: List<Date>,
    @SerializedName("description")
    val description: String,
    val diamondCode: String,
    val digitalId: Int,
    val ean: String,
    val events: Events,
    val format: String,
    val id: Int,
    val images: List<Image>,
    val isbn: String,
    val issn: String,
    val issueNumber: Int,
    val modified: String,
    val pageCount: Int,
    val prices: List<Price>,
    val resourceURI: String,
    val series: Series,
    val stories: Stories,
    val textObjects: List<TextObject>,
    val thumbnail: Thumbnail,
    val title: String,
    val upc: String,
    val urls: List<Url>,
    val variantDescription: String,
    val variants: List<Variant>
)
{
    fun toWordInfoEntity(): WordInfoEntity {
        return WordInfoEntity(
         //   meanings = meanings.map { it.toMeaning() },
            title, description
        )
    }
    fun toSeriesEntity(): SeriesEntity {
        return SeriesEntity(
            //   meanings = meanings.map { it.toMeaning() },
            title, description
        )
    }
    fun toStoriesEntity(): StoriesEntity {
        return StoriesEntity(
            //   meanings = meanings.map { it.toMeaning() },
            title, description
        )
    }

}

package com.example.testone.domain.mappers

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
@Parcelize
data class CharacterInfo(
    val title:String,
    val description: String?
): Parcelable